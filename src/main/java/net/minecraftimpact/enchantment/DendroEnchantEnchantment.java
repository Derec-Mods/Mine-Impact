
package net.minecraftimpact.enchantment;

import net.minecraftimpact.MinecraftImpactModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

@MinecraftImpactModElements.ModElement.Tag
public class DendroEnchantEnchantment extends MinecraftImpactModElements.ModElement {
	@ObjectHolder("minecraft_impact:dendro_enchant")
	public static final Enchantment enchantment = null;
	public DendroEnchantEnchantment(MinecraftImpactModElements instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("dendro_enchant"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.VERY_RARE, EnchantmentType.WEAPON, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 1;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return true;
		}

		@Override
		public boolean isCurse() {
			return true;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}
	}
}
