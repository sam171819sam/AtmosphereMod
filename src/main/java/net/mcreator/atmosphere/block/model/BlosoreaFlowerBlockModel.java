package net.mcreator.atmosphere.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.atmosphere.block.entity.BlosoreaFlowerTileEntity;

public class BlosoreaFlowerBlockModel extends AnimatedGeoModel<BlosoreaFlowerTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(BlosoreaFlowerTileEntity animatable) {
		return new ResourceLocation("atmosphere", "animations/blosorea_flower.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BlosoreaFlowerTileEntity animatable) {
		return new ResourceLocation("atmosphere", "geo/blosorea_flower.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BlosoreaFlowerTileEntity entity) {
		return new ResourceLocation("atmosphere", "textures/blocks/blosorea_flower.png");
	}
}
