package net.mcreator.atmosphere.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.atmosphere.AtmosphereMod;

public class WindOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		AtmosphereMod.queueServerWork(10, () -> {
			if (!entity.level.isClientSide())
				entity.discard();
		});
	}
}
