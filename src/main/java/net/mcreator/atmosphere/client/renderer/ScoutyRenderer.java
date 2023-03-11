
package net.mcreator.atmosphere.client.renderer;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import net.mcreator.atmosphere.entity.model.ScoutyModel;
import net.mcreator.atmosphere.entity.ScoutyEntity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class ScoutyRenderer extends GeoEntityRenderer<ScoutyEntity> {
	public ScoutyRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new ScoutyModel());
		this.shadowRadius = 0f;
	}

	@Override
	public RenderType getRenderType(ScoutyEntity entity, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
		stack.scale(1f, 1f, 1f);
		return RenderType.entityTranslucent(getTextureLocation(entity));
	}
}
