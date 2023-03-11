
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.atmosphere.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.atmosphere.client.model.Modelsaddler;
import net.mcreator.atmosphere.client.model.ModelSaint;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class AtmosphereModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(ModelSaint.LAYER_LOCATION, ModelSaint::createBodyLayer);
		event.registerLayerDefinition(Modelsaddler.LAYER_LOCATION, Modelsaddler::createBodyLayer);
	}
}
