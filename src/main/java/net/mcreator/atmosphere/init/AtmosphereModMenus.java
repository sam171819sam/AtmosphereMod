
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.atmosphere.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.atmosphere.world.inventory.WitchPoolGUIMenu;
import net.mcreator.atmosphere.world.inventory.WitchCrushingGUIMenu;
import net.mcreator.atmosphere.AtmosphereMod;

public class AtmosphereModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, AtmosphereMod.MODID);
	public static final RegistryObject<MenuType<WitchPoolGUIMenu>> WITCH_POOL_GUI = REGISTRY.register("witch_pool_gui", () -> IForgeMenuType.create(WitchPoolGUIMenu::new));
	public static final RegistryObject<MenuType<WitchCrushingGUIMenu>> WITCH_CRUSHING_GUI = REGISTRY.register("witch_crushing_gui", () -> IForgeMenuType.create(WitchCrushingGUIMenu::new));
}
