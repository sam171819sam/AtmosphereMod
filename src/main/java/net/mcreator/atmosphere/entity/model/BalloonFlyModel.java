package net.mcreator.atmosphere.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.atmosphere.entity.BalloonFlyEntity;

public class BalloonFlyModel extends AnimatedGeoModel<BalloonFlyEntity> {
	@Override
	public ResourceLocation getAnimationResource(BalloonFlyEntity entity) {
		return new ResourceLocation("atmosphere", "animations/balloonfly.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BalloonFlyEntity entity) {
		return new ResourceLocation("atmosphere", "geo/balloonfly.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BalloonFlyEntity entity) {
		return new ResourceLocation("atmosphere", "textures/entities/" + entity.getTexture() + ".png");
	}

}
