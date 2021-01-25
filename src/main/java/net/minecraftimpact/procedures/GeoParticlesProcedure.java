package net.minecraftimpact.procedures;

import net.minecraftimpact.particle.GeoParticleParticle;
import net.minecraftimpact.MinecraftImpactModElements;
import net.minecraftimpact.MinecraftImpactMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;

import java.util.Map;

@MinecraftImpactModElements.ModElement.Tag
public class GeoParticlesProcedure extends MinecraftImpactModElements.ModElement {
	public GeoParticlesProcedure(MinecraftImpactModElements instance) {
		super(instance, 30);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MinecraftImpactMod.LOGGER.warn("Failed to load dependency x for procedure GeoParticles!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MinecraftImpactMod.LOGGER.warn("Failed to load dependency y for procedure GeoParticles!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MinecraftImpactMod.LOGGER.warn("Failed to load dependency z for procedure GeoParticles!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftImpactMod.LOGGER.warn("Failed to load dependency world for procedure GeoParticles!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(GeoParticleParticle.particle, x, y, z, (int) 3, 1, 1, 1, 0.5);
		}
	}
}
