package net.mcreator.atmosphere.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.atmosphere.init.AtmosphereModBlocks;
import net.mcreator.atmosphere.AtmosphereMod;

public class BlosoreaVinesUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == AtmosphereModBlocks.BLOSOREA_VINES.get()) {
			if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == Blocks.AIR) {
				AtmosphereMod.queueServerWork(Mth.nextInt(RandomSource.create(), 2000, 10000), () -> {
					world.setBlock(new BlockPos(x, y - 1, z), AtmosphereModBlocks.BLOSOREA_VINES.get().defaultBlockState(), 3);
				});
			}
		}
	}
}
