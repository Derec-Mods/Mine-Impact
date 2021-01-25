package net.minecraftimpact.procedures;

import net.minecraftimpact.potion.PyroPotion;
import net.minecraftimpact.potion.HydroPotion;
import net.minecraftimpact.potion.GeoPotion;
import net.minecraftimpact.potion.ElectroPotion;
import net.minecraftimpact.potion.AnemoPotion;
import net.minecraftimpact.MinecraftImpactModElements;
import net.minecraftimpact.MinecraftImpactMod;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Map;

@MinecraftImpactModElements.ModElement.Tag
public class ClearEffectsProcedure extends MinecraftImpactModElements.ModElement {
	public ClearEffectsProcedure(MinecraftImpactModElements instance) {
		super(instance, 2);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftImpactMod.LOGGER.warn("Failed to load dependency entity for procedure ClearEffects!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(ElectroPotion.potion);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(GeoPotion.potion);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(HydroPotion.potion);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(AnemoPotion.potion);
		}
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).removePotionEffect(PyroPotion.potion);
		}
	}
}
