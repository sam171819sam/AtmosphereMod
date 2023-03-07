package net.mcreator.atmosphere.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

import net.mcreator.atmosphere.network.AtmosphereModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SecureAmuletTpProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(AtmosphereModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AtmosphereModVariables.PlayerVariables())).HasSecureShield) {
			entity.setDeltaMovement(new Vec3(0, 0, 0));
		}
	}
}
