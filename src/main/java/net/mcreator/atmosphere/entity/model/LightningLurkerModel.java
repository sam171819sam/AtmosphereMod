package net.mcreator.atmosphere.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.atmosphere.entity.LightningLurkerEntity;

public class LightningLurkerModel extends AnimatedGeoModel<LightningLurkerEntity> {
	@Override
	public ResourceLocation getAnimationResource(LightningLurkerEntity entity) {
		return new ResourceLocation("atmosphere", "animations/lightning_lurker.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LightningLurkerEntity entity) {
		return new ResourceLocation("atmosphere", "geo/lightning_lurker.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LightningLurkerEntity entity) {
		return new ResourceLocation("atmosphere", "textures/entities/" + entity.getTexture() + "_" + entity.getVariant() + ".png");
	}

}
