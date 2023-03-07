
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.atmosphere.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.atmosphere.block.entity.WitchPoolBlockEntity;
import net.mcreator.atmosphere.block.entity.BlosoreaFlowerTileEntity;
import net.mcreator.atmosphere.AtmosphereMod;

public class AtmosphereModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AtmosphereMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> WITCH_POOL = register("witch_pool", AtmosphereModBlocks.WITCH_POOL, WitchPoolBlockEntity::new);
	public static final RegistryObject<BlockEntityType<BlosoreaFlowerTileEntity>> BLOSOREA_FLOWER = REGISTRY.register("blosorea_flower",
			() -> BlockEntityType.Builder.of(BlosoreaFlowerTileEntity::new, AtmosphereModBlocks.BLOSOREA_FLOWER.get()).build(null));

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
