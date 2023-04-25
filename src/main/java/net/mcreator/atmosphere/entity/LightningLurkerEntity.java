
package net.mcreator.atmosphere.entity;

import software.bernie.geckolib3.util.GeckoLibUtil;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.builder.ILoopType.EDefaultLoopTypes;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.IAnimatable;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.Packet;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.nbt.CompoundTag;
import java.util.Arrays;
import java.util.Comparator;
import net.minecraft.Util;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.MobSpawnType;
import javax.annotation.Nullable;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.mcreator.atmosphere.init.AtmosphereModParticleTypes;
import net.mcreator.atmosphere.init.AtmosphereModParticles;

import net.mcreator.atmosphere.init.AtmosphereModEntities;


public class LightningLurkerEntity extends PathfinderMob implements IAnimatable {
	public static final EntityDataAccessor<Boolean> SHOOT = SynchedEntityData.defineId(LightningLurkerEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<String> ANIMATION = SynchedEntityData.defineId(LightningLurkerEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> TEXTURE = SynchedEntityData.defineId(LightningLurkerEntity.class, EntityDataSerializers.STRING);
	private static final EntityDataAccessor<Integer> DATA_VARIANT = SynchedEntityData.defineId(LightningLurkerEntity.class, EntityDataSerializers.INT);
	private AnimationFactory factory = GeckoLibUtil.createFactory(this);
	public float xBodyRot;
    public float xBodyRotO;
    public float zBodyRot;
    public float zBodyRotO;
	private boolean swinging;
	private boolean lastloop;
	private long lastSwing;
	private float tx;
    private float ty;
    private float tz;
    private float rotateSpeed;
    private float speed;
    public static final String VARIANT_TAG = "Variant";
	public String animationprocedure = "empty";

	public LightningLurkerEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(AtmosphereModEntities.LIGHTNING_LURKER.get(), world);
	}

	public LightningLurkerEntity(EntityType<LightningLurkerEntity> type, Level world) {
		super(type, world);
		xpReward = 1;
		setNoAi(false);
		//this.moveControl = new LightningLurkerMoveControl(this, 10, false);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(SHOOT, false);
		this.entityData.define(ANIMATION, "undefined");
		this.entityData.define(TEXTURE, "lightning_lurker");
		this.entityData.define(DATA_VARIANT, 0);
	}

	public void addAdditionalSaveData(CompoundTag p_149158_) {
      super.addAdditionalSaveData(p_149158_);
      p_149158_.putInt("Variant", this.getVariant().getId());
   }

   public void readAdditionalSaveData(CompoundTag p_149145_) {
      super.readAdditionalSaveData(p_149145_);
      this.setVariant(LightningLurkerEntity.Variant.BY_ID[p_149145_.getInt("Variant")]);
   }

	public void setTexture(String texture) {
		this.entityData.set(TEXTURE, texture);
	}

	public String getTexture() {
		return this.entityData.get(TEXTURE);
	}

	public LightningLurkerEntity.Variant getVariant() {
      return LightningLurkerEntity.Variant.BY_ID[this.entityData.get(DATA_VARIANT)];
   }

   private void setVariant(LightningLurkerEntity.Variant p_149118_) {
      this.entityData.set(DATA_VARIANT, p_149118_.getId());
   }

   private void spawnParticles() {
      //this.playSound(this.getSquirtSound(), this.getSoundVolume(), this.getVoicePitch());
      Vec3 vec3 = this.rotateVector(new Vec3(0.0D, -1.0D, 0.0D)).add(this.getX(), this.getY(), this.getZ());

      for(int i = 0; i < 3; ++i) {
         Vec3 vec31 = this.rotateVector(new Vec3((double)this.random.nextFloat() * 0.6D - 0.3D, -1.0D, (double)this.random.nextFloat() * 0.6D - 0.3D));
         Vec3 vec32 = vec31.scale(0.3D + (double)(this.random.nextFloat() * 2.0F));
         ((ServerLevel)this.level).sendParticles(this.getElectricParticle(), vec3.x, vec3.y + 0.1D, vec3.z, 0, vec32.x, vec32.y, vec32.z, (double)0.1F);
      }

   }

   protected ParticleOptions getElectricParticle() {
      return AtmosphereModParticleTypes.STARDUST_1.get();
   }

   public void tick() {
      super.tick();
      if (!this.level.isClientSide) {
      	spawnParticles();
      }  
   }

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new FlyingPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(0, new LightningLurkerRandomMovementGoal(this));
	}

	private Vec3 rotateVector(Vec3 p_29986_) {
      Vec3 vec3 = p_29986_.xRot(this.xBodyRotO * ((float)Math.PI / 180F));
      return vec3.yRot(-this.yBodyRotO * ((float)Math.PI / 180F));
   }

   public void setMovementVector(float p_29959_, float p_29960_, float p_29961_) {
      this.tx = p_29959_;
      this.ty = p_29960_;
      this.tz = p_29961_;
   }

   public void travel(Vec3 p_29984_) {
      this.move(MoverType.SELF, this.getDeltaMovement());
   }

   public boolean hasMovementVector() {
      return this.tx != 0.0F || this.ty != 0.0F || this.tz != 0.0F;
   }

   public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_149132_, DifficultyInstance p_149133_, MobSpawnType p_149134_, @Nullable SpawnGroupData p_149135_, @Nullable CompoundTag p_149136_) {
      boolean flag = false;
         RandomSource randomsource = p_149132_.getRandom();
         if (p_149135_ instanceof LightningLurkerEntity.LightningLurkerEntityGroupData) {
            if (((LightningLurkerEntity.LightningLurkerEntityGroupData)p_149135_).getGroupSize() >= 2) {
               flag = true;
            }
         } else {
            p_149135_ = new LightningLurkerEntity.LightningLurkerEntityGroupData(LightningLurkerEntity.Variant.getCommonSpawnVariant(randomsource), LightningLurkerEntity.Variant.getCommonSpawnVariant(randomsource));
         }

         this.setVariant(((LightningLurkerEntity.LightningLurkerEntityGroupData)p_149135_).getVariant(randomsource));

         return super.finalizeSpawn(p_149132_, p_149133_, p_149134_, p_149135_, p_149136_);
   }

   public static class LightningLurkerEntityGroupData extends AgeableMob.AgeableMobGroupData {
      public final LightningLurkerEntity.Variant[] types;

      public LightningLurkerEntityGroupData(LightningLurkerEntity.Variant... p_149204_) {
         super(false);
         this.types = p_149204_;
      }

      public LightningLurkerEntity.Variant getVariant(RandomSource p_218447_) {
         return this.types[p_218447_.nextInt(this.types.length)];
      }
   }

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
	}

	@Override
	public boolean causeFallDamage(float l, float d, DamageSource source) {
		return false;
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source == DamageSource.LIGHTNING_BOLT)
			return false;
		if (source.isExplosion())
			return false;
		return super.hurt(source, amount);
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
	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	@Override
	public void setNoGravity(boolean ignored) {
		super.setNoGravity(true);
	}

	@Override
	public void aiStep() {
      super.aiStep();
      this.xBodyRotO = this.xBodyRot;
      this.zBodyRotO = this.zBodyRot;

      if (!this.isInWaterOrBubble()) {
        // if (this.tentacleMovement < (float)Math.PI) {
            //float f = this.tentacleMovement / (float)Math.PI;
            //this.tentacleAngle = Mth.sin(f * f * (float)Math.PI) * (float)Math.PI * 0.25F;
          //  if ((double)f > 0.75D) {
          //     this.speed = 1.0F;
          //    this.rotateSpeed = 1.0F;
          //  } else {
          //     this.rotateSpeed *= 0.8F;
          //  }
       //  } else {
       //     this.tentacleAngle = 0.0F;
            this.speed = 0.7F;
            this.rotateSpeed = 0.8F;
        // }

         if (!this.level.isClientSide) {
            this.setDeltaMovement((double)(this.tx * this.speed), (double)(this.ty * this.speed), (double)(this.tz * this.speed));
         }

         Vec3 vec3 = this.getDeltaMovement();
         double d0 = vec3.horizontalDistance();
         this.yBodyRot += (-((float)Mth.atan2(vec3.x, vec3.z)) * (180F / (float)Math.PI) - this.yBodyRot) * 0.1F;
         this.setYRot(this.yBodyRot);
         this.zBodyRot += (float)Math.PI * this.rotateSpeed * 1.5F;
         this.xBodyRot += (-((float)Mth.atan2(d0, vec3.y)) * (180F / (float)Math.PI) - this.xBodyRot) * 0.1F;
      } else {
         //this.tentacleAngle = Mth.abs(Mth.sin(this.tentacleMovement)) * (float)Math.PI * 0.25F;
         if (!this.level.isClientSide) {
            double d1 = this.getDeltaMovement().y;
            if (this.hasEffect(MobEffects.LEVITATION)) {
               d1 = 0.05D * (double)(this.getEffect(MobEffects.LEVITATION).getAmplifier() + 1);
            } else if (!this.isNoGravity()) {
               d1 -= 0.08D;
            }

            this.setDeltaMovement(0.0D, d1 * (double)0.98F, 0.0D);
         }

         this.xBodyRot += (-90.0F - this.xBodyRot) * 0.02F;
      }
   }

	public static void init() {
		SpawnPlacements.register(AtmosphereModEntities.LIGHTNING_LURKER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getDifficulty() != Difficulty.PEACEFUL && Monster.isDarkEnoughToSpawn(world, pos, random) && Mob.checkMobSpawnRules(entityType, world, reason, pos, random)));
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 12);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.FLYING_SPEED, 0.3);
		return builder;
	}

	private <E extends IAnimatable> PlayState movementPredicate(AnimationEvent<E> event) {
		if (this.animationprocedure.equals("empty")) {
			if ((event.isMoving() || !(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F))

			) {
				event.getController().setAnimation(new AnimationBuilder().addAnimation("walk", EDefaultLoopTypes.LOOP));
				return PlayState.CONTINUE;
			}
			event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", EDefaultLoopTypes.LOOP));
			return PlayState.CONTINUE;
		}
		return PlayState.STOP;
	}

	private <E extends IAnimatable> PlayState procedurePredicate(AnimationEvent<E> event) {
		Entity entity = this;
		Level world = entity.level;
		boolean loop = false;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		if (!loop && this.lastloop) {
			this.lastloop = false;
			event.getController().setAnimation(new AnimationBuilder().addAnimation(this.animationprocedure, EDefaultLoopTypes.PLAY_ONCE));
			event.getController().clearAnimationCache();
			return PlayState.STOP;
		}
		if (!this.animationprocedure.equals("empty") && event.getController().getAnimationState().equals(software.bernie.geckolib3.core.AnimationState.Stopped)) {
			if (!loop) {
				event.getController().setAnimation(new AnimationBuilder().addAnimation(this.animationprocedure, EDefaultLoopTypes.PLAY_ONCE));
				if (event.getController().getAnimationState().equals(software.bernie.geckolib3.core.AnimationState.Stopped)) {
					this.animationprocedure = "empty";
					event.getController().markNeedsReload();
				}
			} else {
				event.getController().setAnimation(new AnimationBuilder().addAnimation(this.animationprocedure, EDefaultLoopTypes.LOOP));
				this.lastloop = true;
			}
		}
		return PlayState.CONTINUE;
	}

	@Override
	protected void tickDeath() {
		++this.deathTime;
		if (this.deathTime == 20) {
			this.remove(LightningLurkerEntity.RemovalReason.KILLED);
			this.dropExperience();
		}
	}

	public String getSyncedAnimation() {
		return this.entityData.get(ANIMATION);
	}

	public void setAnimation(String animation) {
		this.entityData.set(ANIMATION, animation);
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<>(this, "movement", 4, this::movementPredicate));
		data.addAnimationController(new AnimationController<>(this, "procedure", 4, this::procedurePredicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	class LightningLurkerRandomMovementGoal extends Goal {
      private final LightningLurkerEntity lightninglurker;

      public LightningLurkerRandomMovementGoal(LightningLurkerEntity p_30004_) {
         this.lightninglurker = p_30004_;
      }

      public boolean canUse() {
         return true;
      }

      public void tick() {
         int i = this.lightninglurker.getNoActionTime();
         if (i > 80) {
            this.lightninglurker.setMovementVector(0.0F, 0.0F, 0.0F);
         } else if (this.lightninglurker.getRandom().nextInt(reducedTickDelay(50)) == 0 || !this.lightninglurker.hasMovementVector()) {
            float f = this.lightninglurker.getRandom().nextFloat() * ((float)Math.PI * 2F);
            float f1 = Mth.cos(f) * 0.2F;
            float f2 = -0.1F + this.lightninglurker.getRandom().nextFloat() * 0.2F;
            float f3 = Mth.sin(f) * 0.2F;
            this.lightninglurker.setMovementVector(f1, f2, f3);
         }

      }
   }

   public static enum Variant {
      yellow(0, "0", true),
      blue(1, "1", true);

      public static final LightningLurkerEntity.Variant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(LightningLurkerEntity.Variant::getId)).toArray((p_149255_) -> {
         return new LightningLurkerEntity.Variant[p_149255_];
      });
      private final int id;
      private final String name;
      private final boolean common;

      private Variant(int p_149239_, String p_149240_, boolean p_149241_) {
         this.id = p_149239_;
         this.name = p_149240_;
         this.common = p_149241_;
      }

      public int getId() {
         return this.id;
      }

      public String getName() {
         return this.name;
      }

      public static LightningLurkerEntity.Variant getCommonSpawnVariant(RandomSource p_218449_) {
         return getSpawnVariant(p_218449_, true);
      }

      public static LightningLurkerEntity.Variant getRareSpawnVariant(RandomSource p_218454_) {
         return getSpawnVariant(p_218454_, false);
      }

      private static LightningLurkerEntity.Variant getSpawnVariant(RandomSource p_218451_, boolean p_218452_) {
         LightningLurkerEntity.Variant[] alightninglurker$variant = Arrays.stream(BY_ID).filter((p_149252_) -> {
            return p_149252_.common == p_218452_;
         }).toArray((p_149244_) -> {
            return new LightningLurkerEntity.Variant[p_149244_];
         });
         return Util.getRandom(alightninglurker$variant, p_218451_);
      }
   }
}

