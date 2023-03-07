package net.mcreator.atmosphere.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.atmosphere.entity.CroakerEntity;

public class CroakerModel extends AnimatedGeoModel<CroakerEntity> {
	@Override
	public ResourceLocation getAnimationResource(CroakerEntity entity) {
		return new ResourceLocation("atmosphere", "animations/croaker.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(CroakerEntity entity) {
		return new ResourceLocation("atmosphere", "geo/croaker.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(CroakerEntity entity) {
		return new ResourceLocation("atmosphere", "textures/entities/" + entity.getTexture() + ".png");
	}

}
