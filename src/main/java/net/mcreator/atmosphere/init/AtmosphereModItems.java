
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.atmosphere.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.ForgeSpawnEggItem;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.atmosphere.item.StardustItem;
import net.mcreator.atmosphere.item.SoftAmuletItem;
import net.mcreator.atmosphere.item.ShatterSwordItem;
import net.mcreator.atmosphere.item.ShatterShovelItem;
import net.mcreator.atmosphere.item.ShatterPickaxeItem;
import net.mcreator.atmosphere.item.ShatterHoeItem;
import net.mcreator.atmosphere.item.ShatterAxeItem;
import net.mcreator.atmosphere.item.SecureAmuletItem;
import net.mcreator.atmosphere.item.ScrollOnAStickItem;
import net.mcreator.atmosphere.item.SaintRibItem;
import net.mcreator.atmosphere.item.SaintAItem;
import net.mcreator.atmosphere.item.RawLuminumItem;
import net.mcreator.atmosphere.item.LuminumIngotItem;
import net.mcreator.atmosphere.item.FireAmuletItem;
import net.mcreator.atmosphere.item.CroakerSpittleItem;
import net.mcreator.atmosphere.item.AtmosphereDimensionItem;
import net.mcreator.atmosphere.block.display.BlosoreaFlowerDisplayItem;
import net.mcreator.atmosphere.AtmosphereMod;

public class AtmosphereModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, AtmosphereMod.MODID);
	public static final RegistryObject<Item> LUMINUM_INGOT = REGISTRY.register("luminum_ingot", () -> new LuminumIngotItem());
	public static final RegistryObject<Item> RAW_LUMINUM_BLOCK = block(AtmosphereModBlocks.RAW_LUMINUM_BLOCK, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> LUMINUM_BLOCK = block(AtmosphereModBlocks.LUMINUM_BLOCK, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> RAW_LUMINUM = REGISTRY.register("raw_luminum", () -> new RawLuminumItem());
	public static final RegistryObject<Item> TUB = block(AtmosphereModBlocks.TUB, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> WITCH_POOL = block(AtmosphereModBlocks.WITCH_POOL, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> WITCH_CRUSHING_STONE = block(AtmosphereModBlocks.WITCH_CRUSHING_STONE, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> SHATTER_STONE = block(AtmosphereModBlocks.SHATTER_STONE, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> COBBLED_SHATTER_STONE = block(AtmosphereModBlocks.COBBLED_SHATTER_STONE, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> FIRE_AMULET = REGISTRY.register("fire_amulet", () -> new FireAmuletItem());
	public static final RegistryObject<Item> SOFT_AMULET = REGISTRY.register("soft_amulet", () -> new SoftAmuletItem());
	public static final RegistryObject<Item> SECURE_AMULET = REGISTRY.register("secure_amulet", () -> new SecureAmuletItem());
	public static final RegistryObject<Item> GUSTY_GRASS = block(AtmosphereModBlocks.GUSTY_GRASS, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> ATMOSPHERE_DIMENSION = REGISTRY.register("atmosphere_dimension", () -> new AtmosphereDimensionItem());
	public static final RegistryObject<Item> LUMINUM_ORE = block(AtmosphereModBlocks.LUMINUM_ORE, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> BLOSOREA_FLOWER = REGISTRY.register(AtmosphereModBlocks.BLOSOREA_FLOWER.getId().getPath(),
			() -> new BlosoreaFlowerDisplayItem(AtmosphereModBlocks.BLOSOREA_FLOWER.get(), new Item.Properties().tab(AtmosphereModTabs.TAB_ATMOSPHERE)));
	public static final RegistryObject<Item> BOREA_WOOD = block(AtmosphereModBlocks.BOREA_WOOD, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> BOREA_LOG = block(AtmosphereModBlocks.BOREA_LOG, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> BOREA_PLANKS = block(AtmosphereModBlocks.BOREA_PLANKS, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> BOREA_LEAVES = block(AtmosphereModBlocks.BOREA_LEAVES, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> BOREA_STAIRS = block(AtmosphereModBlocks.BOREA_STAIRS, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> BOREA_SLAB = block(AtmosphereModBlocks.BOREA_SLAB, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> BOREA_FENCE = block(AtmosphereModBlocks.BOREA_FENCE, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> BOREA_FENCE_GATE = block(AtmosphereModBlocks.BOREA_FENCE_GATE, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> BOREA_PRESSURE_PLATE = block(AtmosphereModBlocks.BOREA_PRESSURE_PLATE, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> BOREA_BUTTON = block(AtmosphereModBlocks.BOREA_BUTTON, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> BLOSOREA_VINES = block(AtmosphereModBlocks.BLOSOREA_VINES, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> HUMUS_SOIL = block(AtmosphereModBlocks.HUMUS_SOIL, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> HUMUS_GRASS_BLOCK = block(AtmosphereModBlocks.HUMUS_GRASS_BLOCK, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> CLOUD_FLUFF = block(AtmosphereModBlocks.CLOUD_FLUFF, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> ZORRO_WOOD = block(AtmosphereModBlocks.ZORRO_WOOD, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> ZORRO_LOG = block(AtmosphereModBlocks.ZORRO_LOG, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> BOREA_DOOR = doubleBlock(AtmosphereModBlocks.BOREA_DOOR, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> ZORRO_PLANKS = block(AtmosphereModBlocks.ZORRO_PLANKS, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> BOREA_TRAPDOOR = block(AtmosphereModBlocks.BOREA_TRAPDOOR, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> ZORRO_LEAVES = block(AtmosphereModBlocks.ZORRO_LEAVES, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> ZORRO_STAIRS = block(AtmosphereModBlocks.ZORRO_STAIRS, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> ZORRO_SLAB = block(AtmosphereModBlocks.ZORRO_SLAB, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> ZORRO_FENCE = block(AtmosphereModBlocks.ZORRO_FENCE, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> ZORRO_FENCE_GATE = block(AtmosphereModBlocks.ZORRO_FENCE_GATE, CreativeModeTab.TAB_REDSTONE);
	public static final RegistryObject<Item> ZORRO_PRESSURE_PLATE = block(AtmosphereModBlocks.ZORRO_PRESSURE_PLATE, CreativeModeTab.TAB_REDSTONE);
	public static final RegistryObject<Item> ZORRO_BUTTON = block(AtmosphereModBlocks.ZORRO_BUTTON, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> FLOWERING_ZORRO_LEAVES = block(AtmosphereModBlocks.FLOWERING_ZORRO_LEAVES, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> ZORRO_DOOR = doubleBlock(AtmosphereModBlocks.ZORRO_DOOR, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> ZORRO_TRAPDOOR = block(AtmosphereModBlocks.ZORRO_TRAPDOOR, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> HORNA_WOOD = block(AtmosphereModBlocks.HORNA_WOOD, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> HORNA_LOG = block(AtmosphereModBlocks.HORNA_LOG, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> HORNA_PLANKS = block(AtmosphereModBlocks.HORNA_PLANKS, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> LUMINESCENT_LODE = block(AtmosphereModBlocks.LUMINESCENT_LODE, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> HORNA_LEAVES = block(AtmosphereModBlocks.HORNA_LEAVES, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> HORNA_STAIRS = block(AtmosphereModBlocks.HORNA_STAIRS, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> HORNA_SLAB = block(AtmosphereModBlocks.HORNA_SLAB, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> HORNA_FENCE = block(AtmosphereModBlocks.HORNA_FENCE, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> CROAKER_SPITTLE = REGISTRY.register("croaker_spittle", () -> new CroakerSpittleItem());
	public static final RegistryObject<Item> HORNA_FENCE_GATE = block(AtmosphereModBlocks.HORNA_FENCE_GATE, CreativeModeTab.TAB_REDSTONE);
	public static final RegistryObject<Item> HORNA_PRESSURE_PLATE = block(AtmosphereModBlocks.HORNA_PRESSURE_PLATE, CreativeModeTab.TAB_REDSTONE);
	public static final RegistryObject<Item> HORNA_BUTTON = block(AtmosphereModBlocks.HORNA_BUTTON, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> SCROLL_ON_A_STICK = REGISTRY.register("scroll_on_a_stick", () -> new ScrollOnAStickItem());
	public static final RegistryObject<Item> HORNA_DOOR = doubleBlock(AtmosphereModBlocks.HORNA_DOOR, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> HORNA_TRAPDOOR = block(AtmosphereModBlocks.HORNA_TRAPDOOR, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> FROSTED_HUMUS_SOIL = block(AtmosphereModBlocks.FROSTED_HUMUS_SOIL, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> FROSTED_SHATTER_STONE = block(AtmosphereModBlocks.FROSTED_SHATTER_STONE, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> FROSTED_COBBLED_SHATTER_STONE = block(AtmosphereModBlocks.FROSTED_COBBLED_SHATTER_STONE, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> FROSTED_ICE_BLOCK = block(AtmosphereModBlocks.FROSTED_ICE_BLOCK, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> FROZEN_ICE_BLOCK = block(AtmosphereModBlocks.FROZEN_ICE_BLOCK, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> SAINT_A_CHESTPLATE = REGISTRY.register("saint_a_chestplate", () -> new SaintAItem.Chestplate());
	public static final RegistryObject<Item> SAINT_RIB = REGISTRY.register("saint_rib", () -> new SaintRibItem());
	public static final RegistryObject<Item> COBBLED_SHATTER_STONE_STAIRS = block(AtmosphereModBlocks.COBBLED_SHATTER_STONE_STAIRS, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> COBBLED_SHATTER_STONE_SLAB = block(AtmosphereModBlocks.COBBLED_SHATTER_STONE_SLAB, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> SHATTER_PICKAXE = REGISTRY.register("shatter_pickaxe", () -> new ShatterPickaxeItem());
	public static final RegistryObject<Item> SHATTER_AXE = REGISTRY.register("shatter_axe", () -> new ShatterAxeItem());
	public static final RegistryObject<Item> SHATTER_SWORD = REGISTRY.register("shatter_sword", () -> new ShatterSwordItem());
	public static final RegistryObject<Item> SHATTER_SHOVEL = REGISTRY.register("shatter_shovel", () -> new ShatterShovelItem());
	public static final RegistryObject<Item> SHATTER_HOE = REGISTRY.register("shatter_hoe", () -> new ShatterHoeItem());
	public static final RegistryObject<Item> STARDUST_SAND = block(AtmosphereModBlocks.STARDUST_SAND, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> SPARKLING_STARSTONE = block(AtmosphereModBlocks.SPARKLING_STARSTONE, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> STARDUST = REGISTRY.register("stardust", () -> new StardustItem());
	public static final RegistryObject<Item> VANILLYA = block(AtmosphereModBlocks.VANILLYA, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> VANILLYA_BRICKS = block(AtmosphereModBlocks.VANILLYA_BRICKS, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> VANILLYA_PILLAR = block(AtmosphereModBlocks.VANILLYA_PILLAR, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> VANILLYA_STAIRS = block(AtmosphereModBlocks.VANILLYA_STAIRS, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> VANILLYA_SLAB = block(AtmosphereModBlocks.VANILLYA_SLAB, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> VANILLYA_BRICK_STAIRS = block(AtmosphereModBlocks.VANILLYA_BRICK_STAIRS, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> VANILLYA_BRICK_SLAB = block(AtmosphereModBlocks.VANILLYA_BRICK_SLAB, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> VANILLYA_WALL = block(AtmosphereModBlocks.VANILLYA_WALL, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> VANILLYA_BRICK_WALL = block(AtmosphereModBlocks.VANILLYA_BRICK_WALL, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> ZORRO_MOSS = block(AtmosphereModBlocks.ZORRO_MOSS, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> HUMUS_WEED = block(AtmosphereModBlocks.HUMUS_WEED, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> BALLOON_FLY_SPAWN_EGG = REGISTRY.register("balloon_fly_spawn_egg",
			() -> new ForgeSpawnEggItem(AtmosphereModEntities.BALLOON_FLY, -13738158, -13974358, new Item.Properties().tab(AtmosphereModTabs.TAB_ATMOSPHERE)));
	public static final RegistryObject<Item> RAYVEN_SPAWN_EGG = REGISTRY.register("rayven_spawn_egg", () -> new ForgeSpawnEggItem(AtmosphereModEntities.RAYVEN, -14770315, -9344992, new Item.Properties().tab(AtmosphereModTabs.TAB_ATMOSPHERE)));
	public static final RegistryObject<Item> SAINT_SPAWN_EGG = REGISTRY.register("saint_spawn_egg", () -> new ForgeSpawnEggItem(AtmosphereModEntities.SAINT, -1118482, -7570904, new Item.Properties().tab(AtmosphereModTabs.TAB_ATMOSPHERE)));
	public static final RegistryObject<Item> WINDCALLER_SPAWN_EGG = REGISTRY.register("windcaller_spawn_egg",
			() -> new ForgeSpawnEggItem(AtmosphereModEntities.WINDCALLER, -6369803, -12230982, new Item.Properties().tab(AtmosphereModTabs.TAB_ATMOSPHERE)));
	public static final RegistryObject<Item> SQUALL_SPAWN_EGG = REGISTRY.register("squall_spawn_egg", () -> new ForgeSpawnEggItem(AtmosphereModEntities.SQUALL, -10520361, -13092806, new Item.Properties().tab(AtmosphereModTabs.TAB_ATMOSPHERE)));
	public static final RegistryObject<Item> CROAKER_SPAWN_EGG = REGISTRY.register("croaker_spawn_egg", () -> new ForgeSpawnEggItem(AtmosphereModEntities.CROAKER, -14647716, -3004002, new Item.Properties().tab(AtmosphereModTabs.TAB_ATMOSPHERE)));
	public static final RegistryObject<Item> VIRONY = doubleBlock(AtmosphereModBlocks.VIRONY, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> SCOUTY_SPAWN_EGG = REGISTRY.register("scouty_spawn_egg", () -> new ForgeSpawnEggItem(AtmosphereModEntities.SCOUTY, -1173581, -693311, new Item.Properties().tab(AtmosphereModTabs.TAB_ATMOSPHERE)));
	public static final RegistryObject<Item> SADDLER_SPAWN_EGG = REGISTRY.register("saddler_spawn_egg", () -> new ForgeSpawnEggItem(AtmosphereModEntities.SADDLER, -9022074, -7703141, new Item.Properties().tab(AtmosphereModTabs.TAB_ATMOSPHERE)));
	public static final RegistryObject<Item> ERUPTITE = block(AtmosphereModBlocks.ERUPTITE, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> POLISHED_ERUPTITE = block(AtmosphereModBlocks.POLISHED_ERUPTITE, AtmosphereModTabs.TAB_ATMOSPHERE);
	public static final RegistryObject<Item> EMBER = block(AtmosphereModBlocks.EMBER, AtmosphereModTabs.TAB_ATMOSPHERE);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}

	private static RegistryObject<Item> doubleBlock(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
