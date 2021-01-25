
package net.minecraftimpact.enchantment;

import net.minecraftimpact.MinecraftImpactModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

@MinecraftImpactModElements.ModElement.Tag
public class ElectroEnchantEnchantment extends MinecraftImpactModElements.ModElement {
	@ObjectHolder("minecraft_impact:electro_enchant")
	public static final Enchantment enchantment = null;
	public ElectroEnchantEnchantment(MinecraftImpactModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("electro_enchant"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.UNCOMMON, EnchantmentType.WEAPON, slots);
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
			return false;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}
	}
}
