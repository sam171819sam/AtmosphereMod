package net.mcreator.atmosphere.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Registry;

import net.mcreator.atmosphere.init.AtmosphereModItems;

import javax.annotation.Nullable;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class SecureAmuletProjectileRejectionProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == AtmosphereModItems.SECURE_AMULET.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == AtmosphereModItems.SECURE_AMULET.get()) {
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(7 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("minecraft:impact_projectiles")))) {
						if (entityiterator.getXRot() <= 90) {
							entityiterator.setDeltaMovement(new Vec3((entityiterator.getLookAngle().x), (entityiterator.getLookAngle().y), (0 - entityiterator.getLookAngle().z)));
							{
								Entity _ent = entityiterator;
								_ent.setYRot(0);
								_ent.setXRot((float) (180 - entityiterator.getXRot()));
								_ent.setYBodyRot(_ent.getYRot());
								_ent.setYHeadRot(_ent.getYRot());
								_ent.yRotO = _ent.getYRot();
								_ent.xRotO = _ent.getXRot();
								if (_ent instanceof LivingEntity _entity) {
									_entity.yBodyRotO = _entity.getYRot();
									_entity.yHeadRotO = _entity.getYRot();
								}
							}
						} else if (entityiterator.getXRot() <= 0) {
							entityiterator.setDeltaMovement(new Vec3((0 - entityiterator.getLookAngle().x), (entityiterator.getLookAngle().y), (entityiterator.getLookAngle().z)));
							{
								Entity _ent = entityiterator;
								_ent.setYRot(0);
								_ent.setXRot((float) (180 - entityiterator.getXRot()));
								_ent.setYBodyRot(_ent.getYRot());
								_ent.setYHeadRot(_ent.getYRot());
								_ent.yRotO = _ent.getYRot();
								_ent.xRotO = _ent.getXRot();
								if (_ent instanceof LivingEntity _entity) {
									_entity.yBodyRotO = _entity.getYRot();
									_entity.yHeadRotO = _entity.getYRot();
								}
							}
						} else if (entityiterator.getXRot() <= -90) {
							entityiterator.setDeltaMovement(new Vec3((entityiterator.getLookAngle().x), (entityiterator.getLookAngle().y), (0 - entityiterator.getLookAngle().z)));
							{
								Entity _ent = entityiterator;
								_ent.setYRot(0);
								_ent.setXRot((float) (-180 + entityiterator.getXRot()));
								_ent.setYBodyRot(_ent.getYRot());
								_ent.setYHeadRot(_ent.getYRot());
								_ent.yRotO = _ent.getYRot();
								_ent.xRotO = _ent.getXRot();
								if (_ent instanceof LivingEntity _entity) {
									_entity.yBodyRotO = _entity.getYRot();
									_entity.yHeadRotO = _entity.getYRot();
								}
							}
						} else {
							entityiterator.setDeltaMovement(new Vec3((0 - entityiterator.getLookAngle().x), (entityiterator.getLookAngle().y), (entityiterator.getLookAngle().z)));
							{
								Entity _ent = entityiterator;
								_ent.setYRot(0);
								_ent.setXRot((float) (180 + entityiterator.getXRot()));
								_ent.setYBodyRot(_ent.getYRot());
								_ent.setYHeadRot(_ent.getYRot());
								_ent.yRotO = _ent.getYRot();
								_ent.xRotO = _ent.getXRot();
								if (_ent instanceof LivingEntity _entity) {
									_entity.yBodyRotO = _entity.getYRot();
									_entity.yHeadRotO = _entity.getYRot();
								}
							}
						}
						world.addParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 0, 1, 0);
					}
				}
			}
		}
	}
}
