
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.atmosphere.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class AtmosphereModTabs {
	public static CreativeModeTab TAB_ATMOSPHERE;

	public static void load() {
		TAB_ATMOSPHERE = new CreativeModeTab("tabatmosphere") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(AtmosphereModItems.LUMINUM_INGOT.get());
			}

			@Override
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
