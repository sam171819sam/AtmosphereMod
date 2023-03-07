
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.atmosphere.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.atmosphere.client.gui.WitchPoolGUIScreen;
import net.mcreator.atmosphere.client.gui.WitchCrushingGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AtmosphereModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(AtmosphereModMenus.WITCH_POOL_GUI.get(), WitchPoolGUIScreen::new);
			MenuScreens.register(AtmosphereModMenus.WITCH_CRUSHING_GUI.get(), WitchCrushingGUIScreen::new);
		});
	}
}
