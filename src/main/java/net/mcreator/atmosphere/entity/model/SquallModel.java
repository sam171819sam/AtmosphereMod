package net.mcreator.atmosphere.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.atmosphere.entity.SquallEntity;

public class SquallModel extends AnimatedGeoModel<SquallEntity> {
	@Override
	public ResourceLocation getAnimationResource(SquallEntity entity) {
		return new ResourceLocation("atmosphere", "animations/squall.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SquallEntity entity) {
		return new ResourceLocation("atmosphere", "geo/squall.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SquallEntity entity) {
		return new ResourceLocation("atmosphere", "textures/entities/" + entity.getTexture() + ".png");
	}

}
