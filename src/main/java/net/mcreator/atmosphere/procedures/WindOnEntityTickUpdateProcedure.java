package net.mcreator.atmosphere.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

import java.util.Comparator;

public class WindOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		Entity WindTester = null;
		WindTester = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 6, 6, 6), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null);
		if (WindTester instanceof LivingEntity _entity)
			_entity.hurt(new DamageSource("blow").bypassArmor(), 8);
		WindTester.setDeltaMovement(new Vec3((WindTester.getDeltaMovement().x() * 2), (WindTester.getDeltaMovement().y()), (WindTester.getDeltaMovement().z() * 2)));
	}
}
