
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.atmosphere.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.levelgen.feature.Feature;

import net.mcreator.atmosphere.world.features.plants.VironyFeature;
import net.mcreator.atmosphere.world.features.plants.HumusWeedFeature;
import net.mcreator.atmosphere.world.features.ores.ShatterStoneFeature;
import net.mcreator.atmosphere.world.features.ores.RawLuminumBlockFeature;
import net.mcreator.atmosphere.world.features.ores.LuminumOreFeature;
import net.mcreator.atmosphere.world.features.ores.CobbledShatterStoneFeature;
import net.mcreator.atmosphere.world.features.ZorroForestDirtPatchesFeature;
import net.mcreator.atmosphere.world.features.LuminescentLodeGenerationFeature;
import net.mcreator.atmosphere.world.features.FrozenIceFeature;
import net.mcreator.atmosphere.world.features.FrostedShatterStonePlacementFeature;
import net.mcreator.atmosphere.world.features.BoreaTree3Feature;
import net.mcreator.atmosphere.world.features.BoreaTree2Feature;
import net.mcreator.atmosphere.world.features.BoreaTree1Feature;
import net.mcreator.atmosphere.world.features.BlosoreaFlowerSpawningFeature;
import net.mcreator.atmosphere.AtmosphereMod;

@Mod.EventBusSubscriber
public class AtmosphereModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, AtmosphereMod.MODID);
	public static final RegistryObject<Feature<?>> RAW_LUMINUM_BLOCK = REGISTRY.register("raw_luminum_block", RawLuminumBlockFeature::feature);
	public static final RegistryObject<Feature<?>> SHATTER_STONE = REGISTRY.register("shatter_stone", ShatterStoneFeature::feature);
	public static final RegistryObject<Feature<?>> COBBLED_SHATTER_STONE = REGISTRY.register("cobbled_shatter_stone", CobbledShatterStoneFeature::feature);
	public static final RegistryObject<Feature<?>> LUMINUM_ORE = REGISTRY.register("luminum_ore", LuminumOreFeature::feature);
	public static final RegistryObject<Feature<?>> BOREA_TREE_1 = REGISTRY.register("borea_tree_1", BoreaTree1Feature::feature);
	public static final RegistryObject<Feature<?>> BOREA_TREE_2 = REGISTRY.register("borea_tree_2", BoreaTree2Feature::feature);
	public static final RegistryObject<Feature<?>> BOREA_TREE_3 = REGISTRY.register("borea_tree_3", BoreaTree3Feature::feature);
	public static final RegistryObject<Feature<?>> HUMUS_WEED = REGISTRY.register("humus_weed", HumusWeedFeature::feature);
	public static final RegistryObject<Feature<?>> FROZEN_ICE = REGISTRY.register("frozen_ice", FrozenIceFeature::new);
	public static final RegistryObject<Feature<?>> BLOSOREA_FLOWER_SPAWNING = REGISTRY.register("blosorea_flower_spawning", BlosoreaFlowerSpawningFeature::new);
	public static final RegistryObject<Feature<?>> LUMINESCENT_LODE_GENERATION = REGISTRY.register("luminescent_lode_generation", LuminescentLodeGenerationFeature::new);
	public static final RegistryObject<Feature<?>> VIRONY = REGISTRY.register("virony", VironyFeature::feature);
	public static final RegistryObject<Feature<?>> ZORRO_FOREST_DIRT_PATCHES = REGISTRY.register("zorro_forest_dirt_patches", ZorroForestDirtPatchesFeature::new);
	public static final RegistryObject<Feature<?>> FROSTED_SHATTER_STONE_PLACEMENT = REGISTRY.register("frosted_shatter_stone_placement", FrostedShatterStonePlacementFeature::new);
}
