
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.atmosphere.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

import net.mcreator.atmosphere.entity.WindcallerEntity;
import net.mcreator.atmosphere.entity.WindEntity;
import net.mcreator.atmosphere.entity.SquallEntity;
import net.mcreator.atmosphere.entity.SecureShieldEntity;
import net.mcreator.atmosphere.entity.ScoutyEntity;
import net.mcreator.atmosphere.entity.SaintEntity;
import net.mcreator.atmosphere.entity.SaddlerEntity;
import net.mcreator.atmosphere.entity.RayvenEntity;
import net.mcreator.atmosphere.entity.FireburstEntity;
import net.mcreator.atmosphere.entity.CroakerEntity;
import net.mcreator.atmosphere.entity.BalloonFlyEntity;
import net.mcreator.atmosphere.AtmosphereMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AtmosphereModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AtmosphereMod.MODID);
	public static final RegistryObject<EntityType<BalloonFlyEntity>> BALLOON_FLY = register("balloon_fly",
			EntityType.Builder.<BalloonFlyEntity>of(BalloonFlyEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BalloonFlyEntity::new)

					.sized(1.2999999999999998f, 1.2999999999999998f));
	public static final RegistryObject<EntityType<RayvenEntity>> RAYVEN = register("rayven",
			EntityType.Builder.<RayvenEntity>of(RayvenEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RayvenEntity::new)

					.sized(4.6f, 1.5999999999999999f));
	public static final RegistryObject<EntityType<SaintEntity>> SAINT = register("saint",
			EntityType.Builder.<SaintEntity>of(SaintEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SaintEntity::new)

					.sized(0.7999999999999999f, 3.8f));
	public static final RegistryObject<EntityType<WindcallerEntity>> WINDCALLER = register("windcaller",
			EntityType.Builder.<WindcallerEntity>of(WindcallerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(WindcallerEntity::new)

					.sized(0.6f, 2.1999999999999997f));
	public static final RegistryObject<EntityType<SquallEntity>> SQUALL = register("squall", EntityType.Builder.<SquallEntity>of(SquallEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(70).setUpdateInterval(3)
			.setCustomClientFactory(SquallEntity::new).fireImmune().sized(0.6f, 1.0999999999999999f));
	public static final RegistryObject<EntityType<WindEntity>> WIND = register("wind",
			EntityType.Builder.<WindEntity>of(WindEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(WindEntity::new).fireImmune().sized(0.1f, 2f));
	public static final RegistryObject<EntityType<CroakerEntity>> CROAKER = register("croaker",
			EntityType.Builder.<CroakerEntity>of(CroakerEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CroakerEntity::new)

					.sized(1.5999999999999999f, 0.9f));
	public static final RegistryObject<EntityType<FireburstEntity>> FIREBURST = register("fireburst",
			EntityType.Builder.<FireburstEntity>of(FireburstEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FireburstEntity::new)

					.sized(0.19999999999999998f, 1f));
	public static final RegistryObject<EntityType<SecureShieldEntity>> SECURE_SHIELD = register("secure_shield", EntityType.Builder.<SecureShieldEntity>of(SecureShieldEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SecureShieldEntity::new).fireImmune().sized(0.1f, 2f));
	public static final RegistryObject<EntityType<ScoutyEntity>> SCOUTY = register("scouty",
			EntityType.Builder.<ScoutyEntity>of(ScoutyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ScoutyEntity::new)

					.sized(0.6f, 0.7999999999999999f));
	public static final RegistryObject<EntityType<SaddlerEntity>> SADDLER = register("saddler",
			EntityType.Builder.<SaddlerEntity>of(SaddlerEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SaddlerEntity::new)

					.sized(1.2f, 2.1999999999999997f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			BalloonFlyEntity.init();
			RayvenEntity.init();
			SaintEntity.init();
			WindcallerEntity.init();
			SquallEntity.init();
			WindEntity.init();
			CroakerEntity.init();
			FireburstEntity.init();
			SecureShieldEntity.init();
			ScoutyEntity.init();
			SaddlerEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(BALLOON_FLY.get(), BalloonFlyEntity.createAttributes().build());
		event.put(RAYVEN.get(), RayvenEntity.createAttributes().build());
		event.put(SAINT.get(), SaintEntity.createAttributes().build());
		event.put(WINDCALLER.get(), WindcallerEntity.createAttributes().build());
		event.put(SQUALL.get(), SquallEntity.createAttributes().build());
		event.put(WIND.get(), WindEntity.createAttributes().build());
		event.put(CROAKER.get(), CroakerEntity.createAttributes().build());
		event.put(FIREBURST.get(), FireburstEntity.createAttributes().build());
		event.put(SECURE_SHIELD.get(), SecureShieldEntity.createAttributes().build());
		event.put(SCOUTY.get(), ScoutyEntity.createAttributes().build());
		event.put(SADDLER.get(), SaddlerEntity.createAttributes().build());
	}
}
