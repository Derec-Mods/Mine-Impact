package net.minecraftimpact.procedures;

import net.minecraftimpact.potion.PyroPotion;
import net.minecraftimpact.potion.GeoPotion;
import net.minecraftimpact.potion.ElectroPotion;
import net.minecraftimpact.potion.AnemoPotion;
import net.minecraftimpact.particle.GeoParticleParticle;
import net.minecraftimpact.particle.ElectroParticleParticle;
import net.minecraftimpact.particle.AnemoParticleParticle;
import net.minecraftimpact.enchantment.GeoEnchantEnchantment;
import net.minecraftimpact.enchantment.ElectroEnchantEnchantment;
import net.minecraftimpact.enchantment.AnemoEnchantEnchantment;
import net.minecraftimpact.MinecraftImpactModElements;
import net.minecraftimpact.MinecraftImpactMod;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.potion.EffectInstance;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;

import java.util.Map;
import java.util.HashMap;

@MinecraftImpactModElements.ModElement.Tag
public class CheckEnchantsProcedure extends MinecraftImpactModElements.ModElement {
	public CheckEnchantsProcedure(MinecraftImpactModElements instance) {
		super(instance, 18);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MinecraftImpactMod.LOGGER.warn("Failed to load dependency entity for procedure CheckEnchants!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				MinecraftImpactMod.LOGGER.warn("Failed to load dependency sourceentity for procedure CheckEnchants!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MinecraftImpactMod.LOGGER.warn("Failed to load dependency x for procedure CheckEnchants!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MinecraftImpactMod.LOGGER.warn("Failed to load dependency y for procedure CheckEnchants!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MinecraftImpactMod.LOGGER.warn("Failed to load dependency z for procedure CheckEnchants!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MinecraftImpactMod.LOGGER.warn("Failed to load dependency world for procedure CheckEnchants!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((EnchantmentHelper.getEnchantmentLevel(ElectroEnchantEnchantment.enchantment,
				((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) > 0)) {
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ElectroParticleParticle.particle, x, y, z, (int) 3, 1, 1, 1, 0.5);
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(ElectroPotion.potion, (int) 100, (int) 1, (false), (false)));
		}
		if (((EnchantmentHelper.getEnchantmentLevel(Enchantments.FIRE_ASPECT,
				((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) > 0)) {
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, x, y, z, (int) 3, 1, 1, 1, 0.5);
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(PyroPotion.potion, (int) 100, (int) 1, (false), (false)));
		}
		if ((entity.isBurning())) {
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, x, y, z, (int) 3, 1, 1, 1, 0.5);
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(PyroPotion.potion, (int) 100, (int) 1, (false), (false)));
		}
		if (((EnchantmentHelper.getEnchantmentLevel(GeoEnchantEnchantment.enchantment,
				((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) > 0)) {
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(GeoParticleParticle.particle, x, y, z, (int) 3, 1, 1, 1, 0.5);
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(GeoPotion.potion, (int) 100, (int) 1, (false), (false)));
		}
		if (((EnchantmentHelper.getEnchantmentLevel(AnemoEnchantEnchantment.enchantment,
				((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) > 0)) {
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(AnemoParticleParticle.particle, x, y, z, (int) 3, 1, 1, 1, 0.5);
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(AnemoPotion.potion, (int) 100, (int) 1, (false), (false)));
		}
	}

	@SubscribeEvent
	public void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			Entity sourceentity = event.getSource().getTrueSource();
			Entity imediatesourceentity = event.getSource().getImmediateSource();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			double amount = event.getAmount();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("amount", amount);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("imediatesourceentity", imediatesourceentity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
