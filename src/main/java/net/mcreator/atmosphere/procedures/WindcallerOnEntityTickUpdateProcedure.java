package net.mcreator.atmosphere.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.atmosphere.init.AtmosphereModEntities;
import net.mcreator.atmosphere.entity.WindcallerEntity;
import net.mcreator.atmosphere.entity.SquallEntity;

public class WindcallerOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!(!world.getEntitiesOfClass(SquallEntity.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 20, 20, 20), e -> true).isEmpty())) {
			if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 8, 8, 8), e -> true).isEmpty()) {
				if (Mth.nextInt(RandomSource.create(), 1, 1000) >= 1) {
					{
						Entity _ent = entity;
						Scoreboard _sc = _ent.getLevel().getScoreboard();
						Objective _so = _sc.getObjective("windcaller_summon");
						if (_so == null)
							_so = _sc.addObjective("windcaller_summon", ObjectiveCriteria.DUMMY, Component.literal("windcaller_summon"), ObjectiveCriteria.RenderType.INTEGER);
						_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(1);
					}
					if (entity instanceof WindcallerEntity) {
						((WindcallerEntity) entity).setAnimation("summon");
					}
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new SquallEntity(AtmosphereModEntities.SQUALL.get(), _level);
						entityToSpawn.moveTo((entity.getX() - Mth.nextInt(RandomSource.create(), 1, 3)), (entity.getY() + 1), (entity.getZ() - Mth.nextInt(RandomSource.create(), 1, 3)), 0, 0);
						entityToSpawn.setYBodyRot(0);
						entityToSpawn.setYHeadRot(0);
						entityToSpawn.setDeltaMovement(0, 0, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(entityToSpawn);
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.WHITE_ASH, (entity.getX() - Mth.nextInt(RandomSource.create(), 1, 3)), (entity.getY() + 1), (entity.getZ() - Mth.nextInt(RandomSource.create(), 1, 3)), 20, 1, 1, 1, 1);
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new SquallEntity(AtmosphereModEntities.SQUALL.get(), _level);
						entityToSpawn.moveTo((entity.getX() - Mth.nextInt(RandomSource.create(), 2, 4)), (entity.getY() + 1), (entity.getZ() - Mth.nextInt(RandomSource.create(), 1, 5)), 0, 0);
						entityToSpawn.setYBodyRot(0);
						entityToSpawn.setYHeadRot(0);
						entityToSpawn.setDeltaMovement(0, 0, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(entityToSpawn);
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.WHITE_ASH, (entity.getX() - Mth.nextInt(RandomSource.create(), 2, 4)), (entity.getY() + 1), (entity.getZ() - Mth.nextInt(RandomSource.create(), 1, 5)), 20, 1, 1, 1, 1);
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new SquallEntity(AtmosphereModEntities.SQUALL.get(), _level);
						entityToSpawn.moveTo((entity.getX() - Mth.nextInt(RandomSource.create(), 1, 5)), (entity.getY() + 1), (entity.getZ() - Mth.nextInt(RandomSource.create(), 2, 4)), 0, 0);
						entityToSpawn.setYBodyRot(0);
						entityToSpawn.setYHeadRot(0);
						entityToSpawn.setDeltaMovement(0, 0, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(entityToSpawn);
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.WHITE_ASH, (entity.getX() - Mth.nextInt(RandomSource.create(), 1, 5)), (entity.getY() + 1), (entity.getZ() - Mth.nextInt(RandomSource.create(), 2, 5)), 20, 1, 1, 1, 1);
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new SquallEntity(AtmosphereModEntities.SQUALL.get(), _level);
						entityToSpawn.moveTo((entity.getX() - Mth.nextInt(RandomSource.create(), 1, 5)), (entity.getY() + 1), (entity.getZ() - Mth.nextInt(RandomSource.create(), 2, 4)), 0, 0);
						entityToSpawn.setYBodyRot(0);
						entityToSpawn.setYHeadRot(0);
						entityToSpawn.setDeltaMovement(0, 0, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(entityToSpawn);
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.WHITE_ASH, (entity.getX() - Mth.nextInt(RandomSource.create(), 1, 5)), (entity.getY() + 1), (entity.getZ() - Mth.nextInt(RandomSource.create(), 2, 5)), 20, 1, 1, 1, 1);
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new SquallEntity(AtmosphereModEntities.SQUALL.get(), _level);
						entityToSpawn.moveTo((entity.getX() - Mth.nextInt(RandomSource.create(), 1, 3)), (entity.getY() + 1), (entity.getZ() - Mth.nextInt(RandomSource.create(), 1, 3)), 0, 0);
						entityToSpawn.setYBodyRot(0);
						entityToSpawn.setYHeadRot(0);
						entityToSpawn.setDeltaMovement(0, 0, 0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(entityToSpawn);
					}
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.WHITE_ASH, (entity.getX() - Mth.nextInt(RandomSource.create(), 1, 3)), (entity.getY() + 1), (entity.getZ() - Mth.nextInt(RandomSource.create(), 1, 3)), 20, 1, 1, 1, 1);
					{
						Entity _ent = entity;
						Scoreboard _sc = _ent.getLevel().getScoreboard();
						Objective _so = _sc.getObjective("windcaller_summon");
						if (_so == null)
							_so = _sc.addObjective("windcaller_summon", ObjectiveCriteria.DUMMY, Component.literal("windcaller_summon"), ObjectiveCriteria.RenderType.INTEGER);
						_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(0);
					}
				}
			}
		}
	}
}
