package net.mcreator.atmosphere.item.model;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.atmosphere.item.ScrollOnAStickItem;

public class ScrollOnAStickItemModel extends AnimatedGeoModel<ScrollOnAStickItem> {
	@Override
	public ResourceLocation getAnimationResource(ScrollOnAStickItem animatable) {
		return new ResourceLocation("atmosphere", "animations/scroll_on_a_stick.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ScrollOnAStickItem animatable) {
		return new ResourceLocation("atmosphere", "geo/scroll_on_a_stick.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ScrollOnAStickItem animatable) {
		return new ResourceLocation("atmosphere", "textures/items/scroll_on_a_stick.png");
	}
}
