
package net.mcreator.atmosphere.world.biome;

import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.AmbientParticleSettings;
import net.minecraft.world.level.biome.AmbientMoodSettings;
import net.minecraft.world.level.biome.AmbientAdditionsSettings;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.Music;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.atmosphere.init.AtmosphereModParticleTypes;

public class StardustValleyBiome {
	public static Biome createBiome() {
		BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder().fogColor(-5911411).waterColor(-12923758).waterFogColor(-12923758).skyColor(-5911411).foliageColorOverride(-1713845).grassColorOverride(-9919677)
				.ambientLoopSound(new SoundEvent(new ResourceLocation("ambient.soul_sand_valley.loop"))).ambientMoodSound(new AmbientMoodSettings(new SoundEvent(new ResourceLocation("atmosphere:death_whistle")), 6000, 8, 2))
				.ambientAdditionsSound(new AmbientAdditionsSettings(new SoundEvent(new ResourceLocation("ambient.basalt_deltas.additions")), 0.0111D))
				.backgroundMusic(new Music(new SoundEvent(new ResourceLocation("ambient.soul_sand_valley.mood")), 12000, 24000, true))
				.ambientParticle(new AmbientParticleSettings((SimpleParticleType) (AtmosphereModParticleTypes.STARDUST_1.get()), 0.004f)).build();
		BiomeGenerationSettings.Builder biomeGenerationSettings = new BiomeGenerationSettings.Builder();
		MobSpawnSettings.Builder mobSpawnInfo = new MobSpawnSettings.Builder();
		return new Biome.BiomeBuilder().precipitation(Biome.Precipitation.RAIN).temperature(1f).downfall(0.5f).specialEffects(effects).mobSpawnSettings(mobSpawnInfo.build()).generationSettings(biomeGenerationSettings.build()).build();
	}
}
