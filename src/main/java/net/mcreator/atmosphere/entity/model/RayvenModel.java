package net.mcreator.atmosphere.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.atmosphere.entity.RayvenEntity;

public class RayvenModel extends AnimatedGeoModel<RayvenEntity> {
	@Override
	public ResourceLocation getAnimationResource(RayvenEntity entity) {
		return new ResourceLocation("atmosphere", "animations/rayven.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RayvenEntity entity) {
		return new ResourceLocation("atmosphere", "geo/rayven.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RayvenEntity entity) {
		return new ResourceLocation("atmosphere", "textures/entities/" + entity.getTexture() + ".png");
	}

}
