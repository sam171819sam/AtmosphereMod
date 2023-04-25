
package net.mcreator.atmosphere.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.atmosphere.entity.model.SaintModel;
import net.mcreator.atmosphere.entity.layer.SaintLayer;
import net.mcreator.atmosphere.entity.SaintEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class SaintRenderer extends GeoEntityRenderer<SaintEntity> {
	public SaintRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new SaintModel());
		this.shadowRadius = 0.19999999999999998f;
		this.addLayer(new SaintLayer(this));
	}

	@Override
	public RenderType getRenderType(SaintEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}

	@Override
	protected float getDeathMaxRotation(SaintEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
