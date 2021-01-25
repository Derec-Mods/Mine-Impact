package net.minecraftimpact.procedures;

import net.minecraftimpact.potion.CryoPotion;
import net.minecraftimpact.MinecraftImpactModElements;
import net.minecraftimpact.MinecraftImpactMod;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@MinecraftImpactModElements.ModElement.Tag
public class ApplyCryoProcedure extends MinecraftImpactModElements.ModElement {
	public ApplyCryoProcedure(MinecraftImpactModElements instance) {
		super(instance, 40);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftImpactMod.LOGGER.warn("Failed to load dependency entity for procedure ApplyCryo!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(CryoPotion.potion, (int) 100, (int) 1, (false), (false)));
	}
}
