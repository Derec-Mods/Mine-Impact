package net.minecraftimpact.procedures;

import net.minecraftimpact.MinecraftImpactModVariables;
import net.minecraftimpact.MinecraftImpactModElements;
import net.minecraftimpact.MinecraftImpactMod;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;

import java.util.Map;

@MinecraftImpactModElements.ModElement.Tag
public class ToggleBattleTextCommandProcedure extends MinecraftImpactModElements.ModElement {
	public ToggleBattleTextCommandProcedure(MinecraftImpactModElements instance) {
		super(instance, 42);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftImpactMod.LOGGER.warn("Failed to load dependency world for procedure ToggleBattleTextCommand!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		MinecraftImpactModVariables.MapVariables
				.get(world).BattleText = (boolean) (!(MinecraftImpactModVariables.MapVariables.get(world).BattleText));
		MinecraftImpactModVariables.MapVariables.get(world).syncData(world);
		if ((MinecraftImpactModVariables.MapVariables.get(world).BattleText)) {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent("Battle text has been \u00A74enabled"), ChatType.SYSTEM,
							Util.DUMMY_UUID);
			}
		}
		if ((!(MinecraftImpactModVariables.MapVariables.get(world).BattleText))) {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent("Battle text has been \u00A73disabled"), ChatType.SYSTEM,
							Util.DUMMY_UUID);
			}
		}
	}
}
