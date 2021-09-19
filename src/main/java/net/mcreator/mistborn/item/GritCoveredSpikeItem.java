
package net.mcreator.mistborn.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.mistborn.MistbornModElements;

@MistbornModElements.ModElement.Tag
public class GritCoveredSpikeItem extends MistbornModElements.ModElement {
	@ObjectHolder("mistborn:grit_covered_spike")
	public static final Item block = null;
	public GritCoveredSpikeItem(MistbornModElements instance) {
		super(instance, 19);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(4).rarity(Rarity.COMMON));
			setRegistryName("grit_covered_spike");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
