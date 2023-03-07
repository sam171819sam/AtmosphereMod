package net.mcreator.atmosphere.block.listener;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.mcreator.atmosphere.init.AtmosphereModBlockEntities;
import net.mcreator.atmosphere.block.renderer.BlosoreaFlowerTileRenderer;
import net.mcreator.atmosphere.AtmosphereMod;

@Mod.EventBusSubscriber(modid = AtmosphereMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(AtmosphereModBlockEntities.BLOSOREA_FLOWER.get(), BlosoreaFlowerTileRenderer::new);
	}
}
