
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.atmosphere.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.atmosphere.client.renderer.WindcallerRenderer;
import net.mcreator.atmosphere.client.renderer.WindRenderer;
import net.mcreator.atmosphere.client.renderer.SquallRenderer;
import net.mcreator.atmosphere.client.renderer.SecureShieldRenderer;
import net.mcreator.atmosphere.client.renderer.ScoutyRenderer;
import net.mcreator.atmosphere.client.renderer.SaintRenderer;
import net.mcreator.atmosphere.client.renderer.SaddlerRenderer;
import net.mcreator.atmosphere.client.renderer.RayvenRenderer;
import net.mcreator.atmosphere.client.renderer.LightningLurkerRenderer;
import net.mcreator.atmosphere.client.renderer.FireburstRenderer;
import net.mcreator.atmosphere.client.renderer.CroakerRenderer;
import net.mcreator.atmosphere.client.renderer.BalloonFlyRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AtmosphereModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(AtmosphereModEntities.BALLOON_FLY.get(), BalloonFlyRenderer::new);
		event.registerEntityRenderer(AtmosphereModEntities.RAYVEN.get(), RayvenRenderer::new);
		event.registerEntityRenderer(AtmosphereModEntities.SAINT.get(), SaintRenderer::new);
		event.registerEntityRenderer(AtmosphereModEntities.WINDCALLER.get(), WindcallerRenderer::new);
		event.registerEntityRenderer(AtmosphereModEntities.SQUALL.get(), SquallRenderer::new);
		event.registerEntityRenderer(AtmosphereModEntities.WIND.get(), WindRenderer::new);
		event.registerEntityRenderer(AtmosphereModEntities.CROAKER.get(), CroakerRenderer::new);
		event.registerEntityRenderer(AtmosphereModEntities.FIREBURST.get(), FireburstRenderer::new);
		event.registerEntityRenderer(AtmosphereModEntities.SECURE_SHIELD.get(), SecureShieldRenderer::new);
		event.registerEntityRenderer(AtmosphereModEntities.SCOUTY.get(), ScoutyRenderer::new);
		event.registerEntityRenderer(AtmosphereModEntities.SADDLER.get(), SaddlerRenderer::new);
		event.registerEntityRenderer(AtmosphereModEntities.LIGHTNING_LURKER.get(), LightningLurkerRenderer::new);
	}
}
