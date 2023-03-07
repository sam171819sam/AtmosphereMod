package net.mcreator.atmosphere.entity.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.atmosphere.entity.WindEntity;

public class WindModel extends AnimatedGeoModel<WindEntity> {
	@Override
	public ResourceLocation getAnimationResource(WindEntity entity) {
		return new ResourceLocation("atmosphere", "animations/wind.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WindEntity entity) {
		return new ResourceLocation("atmosphere", "geo/wind.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WindEntity entity) {
		return new ResourceLocation("atmosphere", "textures/entities/" + entity.getTexture() + ".png");
	}

}
