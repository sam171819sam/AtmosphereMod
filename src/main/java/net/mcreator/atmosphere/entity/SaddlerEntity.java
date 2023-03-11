
package net.mcreator.atmosphere.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.Packet;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Saddleable;
import net.minecraft.world.entity.ItemBasedSteering;
import net.minecraft.world.entity.ItemSteerable;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.LevelReader;
import javax.annotation.Nullable;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import com.google.common.collect.Sets;
import java.util.Set;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.vehicle.DismountHelper;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;


import net.mcreator.atmosphere.init.AtmosphereModEntities;
import net.mcreator.atmosphere.init.AtmosphereModBlocks;

import java.util.List;

public class SaddlerEntity extends Animal implements ItemSteerable, Saddleable {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(SaddlerEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(SaddlerEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(SaddlerEntity.class, EntityDataSerializers.STRING);
	private static final EntityDataAccessor<Integer> DATA_BOOST_TIME = SynchedEntityData.defineId(SaddlerEntity.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Boolean> DATA_SUFFOCATING = SynchedEntityData.defineId(SaddlerEntity.class, EntityDataSerializers.BOOLEAN);
  	private static final EntityDataAccessor<Boolean> DATA_SADDLE_ID = SynchedEntityData.defineId(SaddlerEntity.class, EntityDataSerializers.BOOLEAN);
  	private static final Ingredient TEMPT_ITEMS = Ingredient.of(AtmosphereModBlocks.HUMUS_WEED.get().asItem(), Items.WARPED_FUNGUS_ON_A_STICK);
	private static final float SUFFOCATE_STEERING_MODIFIER = 0.23F;
  	private static final float SUFFOCATE_SPEED_MODIFIER = 0.66F;
  	private static final float STEERING_MODIFIER = 0.55F;
  	private final ItemBasedSteering steering = new ItemBasedSteering(this.entityData, DATA_BOOST_TIME, DATA_SADDLE_ID);
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	public String animationprocedure = "empty";
	@Nullable
	private TemptGoal temptGoal;

	public SaddlerEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(AtmosphereModEntities.SADDLER.get(), world);
	}

	public SaddlerEntity(EntityType<SaddlerEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "saddler");
		this.entityData.define(DATA_BOOST_TIME, 0);
   	 this.entityData.define(DATA_SUFFOCATING, false);
  	   this.entityData.define(DATA_SADDLE_ID, false);
	}

	public void setTexture(String texture) {
		this.entityData.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.entityData.get(TEXTURE);
	}

	public void onSyncedDataUpdated(EntityDataAccessor<?> p_33900_) {
      if (DATA_BOOST_TIME.equals(p_33900_) && this.level.isClientSide) {
         this.steering.onSynced();
      }

      super.onSyncedDataUpdated(p_33900_);
   }

   public void addAdditionalSaveData(CompoundTag p_33918_) {
      super.addAdditionalSaveData(p_33918_);
      this.steering.addAdditionalSaveData(p_33918_);
   }

   public void readAdditionalSaveData(CompoundTag p_33898_) {
      super.readAdditionalSaveData(p_33898_);
      this.steering.readAdditionalSaveData(p_33898_);
   }

   public boolean isSaddled() {
      return this.steering.hasSaddle();
   }

   public boolean isSaddleable() {
      return this.isAlive() && !this.isBaby();
   }

   public void equipSaddle(@Nullable SoundSource p_33878_) {
      this.steering.setSaddle(true);
      if (p_33878_ != null) {
         this.level.playSound((Player)null, this, SoundEvents.STRIDER_SADDLE, p_33878_, 0.5F, 1.0F);
      }

   }

   public void setSuffocating(boolean p_33952_) {
      this.entityData.set(DATA_SUFFOCATING, p_33952_);
   }

   public boolean canStandOnFluid(FluidState p_204067_) {
      return p_204067_.is(FluidTags.LAVA);
   }

   public double getPassengersRidingOffset() {
      float f = Math.min(0.25F, this.animationSpeed);
      float f1 = this.animationPosition;
      return (double)this.getBbHeight() - 0.19D + (double)(0.12F * Mth.cos(f1 * 1.5F) * 2.0F * f);
   }

   public boolean checkSpawnObstruction(LevelReader p_33880_) {
      return p_33880_.isUnobstructed(this);
   }

   @Nullable
   public Entity getControllingPassenger() {
      Entity entity = this.getFirstPassenger();
      return entity != null && this.canBeControlledBy(entity) ? entity : null;
   }

   private boolean canBeControlledBy(Entity p_219127_) {
      if (!(p_219127_ instanceof Player player)) {
         return false;
      } else {
         return player.getMainHandItem().is(AtmosphereModBlocks.HUMUS_WEED.get().asItem()) || player.getOffhandItem().is(AtmosphereModBlocks.HUMUS_WEED.get().asItem());
      }
   }

   public Vec3 getDismountLocationForPassenger(LivingEntity p_33908_) {
      Vec3[] avec3 = new Vec3[]{getCollisionHorizontalEscapeVector((double)this.getBbWidth(), (double)p_33908_.getBbWidth(), p_33908_.getYRot()), getCollisionHorizontalEscapeVector((double)this.getBbWidth(), (double)p_33908_.getBbWidth(), p_33908_.getYRot() - 22.5F), getCollisionHorizontalEscapeVector((double)this.getBbWidth(), (double)p_33908_.getBbWidth(), p_33908_.getYRot() + 22.5F), getCollisionHorizontalEscapeVector((double)this.getBbWidth(), (double)p_33908_.getBbWidth(), p_33908_.getYRot() - 45.0F), getCollisionHorizontalEscapeVector((double)this.getBbWidth(), (double)p_33908_.getBbWidth(), p_33908_.getYRot() + 45.0F)};
      Set<BlockPos> set = Sets.newLinkedHashSet();
      double d0 = this.getBoundingBox().maxY;
      double d1 = this.getBoundingBox().minY - 0.5D;
      BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

      for(Vec3 vec3 : avec3) {
         blockpos$mutableblockpos.set(this.getX() + vec3.x, d0, this.getZ() + vec3.z);

         for(double d2 = d0; d2 > d1; --d2) {
            set.add(blockpos$mutableblockpos.immutable());
            blockpos$mutableblockpos.move(Direction.DOWN);
         }
      }

      for(BlockPos blockpos : set) {
         if (!this.level.getFluidState(blockpos).is(FluidTags.LAVA)) {
            double d3 = this.level.getBlockFloorHeight(blockpos);
            if (DismountHelper.isBlockFloorValid(d3)) {
               Vec3 vec31 = Vec3.upFromBottomCenterOf(blockpos, d3);

               for(Pose pose : p_33908_.getDismountPoses()) {
                  AABB aabb = p_33908_.getLocalBoundsForPose(pose);
                  if (DismountHelper.canDismountTo(this.level, p_33908_, aabb.move(vec31))) {
                     p_33908_.setPose(pose);
                     return vec31;
                  }
               }
            }
         }
      }

      return new Vec3(this.getX(), this.getBoundingBox().maxY, this.getZ());
   }

   protected void dropEquipment() {
      super.dropEquipment();
      if (this.isSaddled()) {
         this.spawnAtLocation(Items.SADDLE);
      }

   }
   
	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(5, new FloatGoal(this));
		this.temptGoal = new TemptGoal(this, 1.4D, TEMPT_ITEMS, false);
		this.goalSelector.addGoal(6, this.temptGoal);
		this.goalSelector.addGoal(7, new FollowParentGoal(this, 1.1D));
		this.goalSelector.addGoal(8, new BreedGoal(this, 1.0D));
		this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 8.0F));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.strider.ambient"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.strider.step")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.strider.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.strider.death"));
	}

   public InteractionResult mobInteract(Player p_33910_, InteractionHand p_33911_) {
      boolean flag = this.isFood(p_33910_.getItemInHand(p_33911_));
      if (!flag && this.isSaddled() && !this.isVehicle() && !p_33910_.isSecondaryUseActive()) {
         if (!this.level.isClientSide) {
            p_33910_.startRiding(this);
         }

         return InteractionResult.sidedSuccess(this.level.isClientSide);
      } else {
         InteractionResult interactionresult = super.mobInteract(p_33910_, p_33911_);
         if (!interactionresult.consumesAction()) {
            ItemStack itemstack = p_33910_.getItemInHand(p_33911_);
            return itemstack.is(Items.SADDLE) ? itemstack.interactLivingEntity(p_33910_, this, p_33911_) : InteractionResult.PASS;
         } else {
            if (flag && !this.isSilent()) {
               this.level.playSound((Player)null, this.getX(), this.getY(), this.getZ(), SoundEvents.STRIDER_EAT, this.getSoundSource(), 1.0F, 1.0F + (this.random.nextFloat() - this.random.nextFloat()) * 0.2F);
            }

            return interactionresult;
         }
      }
   }
     
         
	@Override
	public void baseTick() {
		super.baseTick();
		this.refreshDimensions();
	}

	@Override
	public EntityDimensions getDimensions(Pose p_33597_) {
		return super.getDimensions(p_33597_).scale((float) 1);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		SaddlerEntity retval = AtmosphereModEntities.SADDLER.get().create(serverWorld);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), MobSpawnType.BREEDING, null, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return List.of(AtmosphereModBlocks.HUMUS_WEED.get().asItem()).contains(stack.getItem());
	}

	@Override
	public void travel(Vec3 p_33943_) {
		this.setSpeed(this.getMoveSpeed());
      this.travel(this, this.steering, p_33943_);
	}

	public boolean isSuffocating() {
      return this.getVehicle() instanceof SaddlerEntity ? ((SaddlerEntity)this.getVehicle()).isSuffocating() : this.entityData.get(DATA_SUFFOCATING);
   }

	public float getMoveSpeed() {
      return (float)this.getAttributeValue(Attributes.MOVEMENT_SPEED) * (this.isSuffocating() ? 0.66F : 1.0F);
   }

   public float getSteeringSpeed() {
      return (float)this.getAttributeValue(Attributes.MOVEMENT_SPEED) * (this.isSuffocating() ? 0.23F : 0.55F);
   }

   public void travelWithInput(Vec3 p_33902_) {
      super.travel(p_33902_);
   }

   public boolean boost() {
      return this.steering.boost(this.getRandom());
   }
   
	@Override
	public void aiStep() {
		super.aiStep();
		this.updateSwingTime();
	}
	
	public static void init() {
		SpawnPlacements.register(AtmosphereModEntities.SADDLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getBlockState(pos.below()).getMaterial() == Material.GRASS && world.getRawBrightness(pos, 0) > 8));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.19999999999999998);
		builder = builder.add(Attributes.MAX_HEALTH, 15);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		return builder;
	}

	@Override
	protected void tickDeath() {
		++this.deathTime;
		if (this.deathTime == 20) {
			this.remove(SaddlerEntity.RemovalReason.KILLED);
			this.dropExperience();
		}
	}

	public String getSyncedAnimation() {
		return this.entityData.get(ANIMATION);
	}

	public void setAnimation(String animation) {
		this.entityData.set(ANIMATION, animation);
	}
}


