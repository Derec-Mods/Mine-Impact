package net.minecraftimpact.procedures;

import net.minecraftimpact.particle.CryoParticleParticle;
import net.minecraftimpact.MinecraftImpactModElements;
import net.minecraftimpact.MinecraftImpactMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;

import java.util.Map;

@MinecraftImpactModElements.ModElement.Tag
public class CryoParticlesProcedure extends MinecraftImpactModElements.ModElement {
	public CryoParticlesProcedure(MinecraftImpactModElements instance) {
		super(instance, 41);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MinecraftImpactMod.LOGGER.warn("Failed to load dependency x for procedure CryoParticles!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MinecraftImpactMod.LOGGER.warn("Failed to load dependency y for procedure CryoParticles!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MinecraftImpactMod.LOGGER.warn("Failed to load dependency z for procedure CryoParticles!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftImpactMod.LOGGER.warn("Failed to load dependency world for procedure CryoParticles!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			((ServerWorld) world).spawnParticle(CryoParticleParticle.particle, x, y, z, (int) 3, 1, 1, 1, 1);
		}
	}
}
