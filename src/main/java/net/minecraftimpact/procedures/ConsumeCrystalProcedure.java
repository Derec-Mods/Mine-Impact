package net.minecraftimpact.procedures;

import net.minecraftimpact.entity.GeoCrystalEntity;
import net.minecraftimpact.MinecraftImpactModElements;
import net.minecraftimpact.MinecraftImpactMod;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@MinecraftImpactModElements.ModElement.Tag
public class ConsumeCrystalProcedure extends MinecraftImpactModElements.ModElement {
	public ConsumeCrystalProcedure(MinecraftImpactModElements instance) {
		super(instance, 26);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftImpactMod.LOGGER.warn("Failed to load dependency entity for procedure ConsumeCrystal!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				MinecraftImpactMod.LOGGER.warn("Failed to load dependency sourceentity for procedure ConsumeCrystal!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if ((entity instanceof GeoCrystalEntity.CustomEntity)) {
			if (!entity.world.isRemote())
				entity.remove();
			if (sourceentity instanceof LivingEntity)
				((LivingEntity) sourceentity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 60, (int) 1, (false), (false)));
		}
	}
}
