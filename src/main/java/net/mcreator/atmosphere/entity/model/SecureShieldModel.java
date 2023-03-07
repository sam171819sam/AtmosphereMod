package net.mcreator.atmosphere.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.atmosphere.entity.SecureShieldEntity;

public class SecureShieldModel extends AnimatedGeoModel<SecureShieldEntity> {
	@Override
	public ResourceLocation getAnimationResource(SecureShieldEntity entity) {
		return new ResourceLocation("atmosphere", "animations/secure_shield.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SecureShieldEntity entity) {
		return new ResourceLocation("atmosphere", "geo/secure_shield.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SecureShieldEntity entity) {
		return new ResourceLocation("atmosphere", "textures/entities/" + entity.getTexture() + ".png");
	}

}
