package net.mcreator.atmosphere.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class SecureShieldOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		Entity user = null;
		user = (Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((entity.getX()), (entity.getY()), (entity.getZ())), 3, 3, 3), e -> true).stream().sorted(new Object() {
			Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
				return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
			}
		}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null);
		if (!(user == null)) {
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == user)) {
						if (entityiterator.getXRot() <= 90) {
							entityiterator.setDeltaMovement(new Vec3((entityiterator.getLookAngle().x), (entityiterator.getLookAngle().y + 1), ((0 - entityiterator.getLookAngle().z) * 1.2)));
						} else if (entityiterator.getXRot() <= 0) {
							entityiterator.setDeltaMovement(new Vec3(((0 - entityiterator.getLookAngle().x) * 1.2), (entityiterator.getLookAngle().y + 1), (entityiterator.getLookAngle().z)));
						} else if (entityiterator.getXRot() <= -90) {
							entityiterator.setDeltaMovement(new Vec3((entityiterator.getLookAngle().x), (entityiterator.getLookAngle().y + 1), ((0 - entityiterator.getLookAngle().z) * 1.2)));
						} else {
							entityiterator.setDeltaMovement(new Vec3(((0 - entityiterator.getLookAngle().x) * 1.2), (entityiterator.getLookAngle().y + 1), (entityiterator.getLookAngle().z)));
						}
					}
				}
			}
		}
	}
}
