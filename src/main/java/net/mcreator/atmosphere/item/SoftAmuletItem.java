
package net.mcreator.atmosphere.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

import net.mcreator.atmosphere.procedures.SoftAmuletItemInInventoryTickProcedure;
import net.mcreator.atmosphere.init.AtmosphereModTabs;

public class SoftAmuletItem extends Item {
	public SoftAmuletItem() {
		super(new Item.Properties().tab(AtmosphereModTabs.TAB_ATMOSPHERE).stacksTo(1).rarity(Rarity.UNCOMMON));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		SoftAmuletItemInInventoryTickProcedure.execute(world, entity);
	}
}
