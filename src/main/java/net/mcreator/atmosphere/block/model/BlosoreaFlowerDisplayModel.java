package net.mcreator.atmosphere.block.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.atmosphere.block.display.BlosoreaFlowerDisplayItem;

public class BlosoreaFlowerDisplayModel extends AnimatedGeoModel<BlosoreaFlowerDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(BlosoreaFlowerDisplayItem animatable) {
		return new ResourceLocation("atmosphere", "animations/blosorea_flower.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BlosoreaFlowerDisplayItem animatable) {
		return new ResourceLocation("atmosphere", "geo/blosorea_flower.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BlosoreaFlowerDisplayItem entity) {
		return new ResourceLocation("atmosphere", "textures/blocks/blosorea_flower.png");
	}
}
