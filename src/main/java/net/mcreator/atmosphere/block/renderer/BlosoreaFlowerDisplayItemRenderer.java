package net.mcreator.atmosphere.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.atmosphere.block.model.BlosoreaFlowerDisplayModel;
import net.mcreator.atmosphere.block.display.BlosoreaFlowerDisplayItem;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class BlosoreaFlowerDisplayItemRenderer extends GeoItemRenderer<BlosoreaFlowerDisplayItem> {
	public BlosoreaFlowerDisplayItemRenderer() {
		super(new BlosoreaFlowerDisplayModel());
	}

	@Override
	public RenderType getRenderType(BlosoreaFlowerDisplayItem animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
