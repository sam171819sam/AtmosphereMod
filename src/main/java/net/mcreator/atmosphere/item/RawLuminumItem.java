
package net.mcreator.atmosphere.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import net.mcreator.atmosphere.init.AtmosphereModTabs;

public class RawLuminumItem extends Item {
	public RawLuminumItem() {
		super(new Item.Properties().tab(AtmosphereModTabs.TAB_ATMOSPHERE).stacksTo(64).rarity(Rarity.COMMON));
	}
}
