
package net.mcreator.atmosphere.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.atmosphere.entity.model.SecureShieldModel;
import net.mcreator.atmosphere.entity.SecureShieldEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SecureShieldRenderer extends GeoEntityRenderer<SecureShieldEntity> {
	public SecureShieldRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new SecureShieldModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(SecureShieldEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
