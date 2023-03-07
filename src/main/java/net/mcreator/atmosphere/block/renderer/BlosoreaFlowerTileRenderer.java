package net.mcreator.atmosphere.block.renderer;

import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.atmosphere.block.model.BlosoreaFlowerBlockModel;
import net.mcreator.atmosphere.block.entity.BlosoreaFlowerTileEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class BlosoreaFlowerTileRenderer extends GeoBlockRenderer<BlosoreaFlowerTileEntity> {
	public BlosoreaFlowerTileRenderer(BlockEntityRendererProvider.Context rendererDispatcherIn) {
		super(rendererDispatcherIn, new BlosoreaFlowerBlockModel());
	}

	@Override
	public RenderType getRenderType(BlosoreaFlowerTileEntity animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, VertexConsumer buffer, int packedLight, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
