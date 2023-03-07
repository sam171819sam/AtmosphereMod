
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.atmosphere.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.biome.Biome;

import net.mcreator.atmosphere.world.biome.ZorroForestBiome;
import net.mcreator.atmosphere.world.biome.WavyMeadowBiome;
import net.mcreator.atmosphere.world.biome.StardustValleyBiome;
import net.mcreator.atmosphere.world.biome.PetalParadiseBiome;
import net.mcreator.atmosphere.world.biome.HornaForestBiome;
import net.mcreator.atmosphere.AtmosphereMod;

public class AtmosphereModBiomes {
	public static final DeferredRegister<Biome> REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, AtmosphereMod.MODID);
	public static final RegistryObject<Biome> WAVY_MEADOW = REGISTRY.register("wavy_meadow", WavyMeadowBiome::createBiome);
	public static final RegistryObject<Biome> PETAL_PARADISE = REGISTRY.register("petal_paradise", PetalParadiseBiome::createBiome);
	public static final RegistryObject<Biome> ZORRO_FOREST = REGISTRY.register("zorro_forest", ZorroForestBiome::createBiome);
	public static final RegistryObject<Biome> STARDUST_VALLEY = REGISTRY.register("stardust_valley", StardustValleyBiome::createBiome);
	public static final RegistryObject<Biome> HORNA_FOREST = REGISTRY.register("horna_forest", HornaForestBiome::createBiome);
}
