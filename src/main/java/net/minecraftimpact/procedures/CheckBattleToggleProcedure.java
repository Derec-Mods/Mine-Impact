package net.minecraftimpact.procedures;

import net.minecraftimpact.MinecraftImpactModVariables;
import net.minecraftimpact.MinecraftImpactModElements;
import net.minecraftimpact.MinecraftImpactMod;

import net.minecraft.world.IWorld;

import java.util.Map;

@MinecraftImpactModElements.ModElement.Tag
public class CheckBattleToggleProcedure extends MinecraftImpactModElements.ModElement {
	public CheckBattleToggleProcedure(MinecraftImpactModElements instance) {
		super(instance, 43);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftImpactMod.LOGGER.warn("Failed to load dependency world for procedure CheckBattleToggle!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		return (MinecraftImpactModVariables.MapVariables.get(world).BattleText);
	}
}
