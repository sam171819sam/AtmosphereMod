package net.mcreator.atmosphere.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.atmosphere.entity.FireburstEntity;

public class FireburstModel extends AnimatedGeoModel<FireburstEntity> {
	@Override
	public ResourceLocation getAnimationResource(FireburstEntity entity) {
		return new ResourceLocation("atmosphere", "animations/fireburst.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FireburstEntity entity) {
		return new ResourceLocation("atmosphere", "geo/fireburst.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FireburstEntity entity) {
		return new ResourceLocation("atmosphere", "textures/entities/" + entity.getTexture() + ".png");
	}

}
