
package net.mcreator.atmosphere.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.layers.SaddleLayer;
import com.mojang.blaze3d.vertex.PoseStack;

import net.mcreator.atmosphere.entity.SaddlerEntity;
import net.mcreator.atmosphere.client.model.Modelsaddler;

public class SaddlerRenderer extends MobRenderer<SaddlerEntity, Modelsaddler<SaddlerEntity>> {
	public SaddlerRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelsaddler(context.bakeLayer(Modelsaddler.LAYER_LOCATION)), 0.4f);
		this.addLayer(new SaddleLayer<>(this, new Modelsaddler<>(context.bakeLayer(Modelsaddler.LAYER_LOCATION)), new ResourceLocation("atmosphere:textures/entities/saddler_saddle.png")));
	}

	@Override
	public ResourceLocation getTextureLocation(SaddlerEntity entity) {
		return new ResourceLocation("atmosphere:textures/entities/saddler.png");
	}

	
   protected void scale(SaddlerEntity p_116066_, PoseStack p_116067_, float p_116068_) {
      if (p_116066_.isBaby()) {
         p_116067_.scale(0.5F, 0.5F, 0.5F);
         this.shadowRadius = 0.25F;
      } else {
         this.shadowRadius = 0.5F;
      }

   }

}
