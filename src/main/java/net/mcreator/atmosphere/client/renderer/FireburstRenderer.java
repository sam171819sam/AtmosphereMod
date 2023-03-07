
package net.mcreator.atmosphere.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.atmosphere.entity.model.FireburstModel;
import net.mcreator.atmosphere.entity.FireburstEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FireburstRenderer extends GeoEntityRenderer<FireburstEntity> {
	public FireburstRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new FireburstModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(FireburstEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
