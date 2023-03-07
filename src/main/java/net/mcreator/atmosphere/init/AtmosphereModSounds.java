
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.atmosphere.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.atmosphere.AtmosphereMod;

public class AtmosphereModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, AtmosphereMod.MODID);
	public static final RegistryObject<SoundEvent> DEATH_WHISTLE = REGISTRY.register("death_whistle", () -> new SoundEvent(new ResourceLocation("atmosphere", "death_whistle")));
	public static final RegistryObject<SoundEvent> FIRE_BURST = REGISTRY.register("fire_burst", () -> new SoundEvent(new ResourceLocation("atmosphere", "fire_burst")));
}
