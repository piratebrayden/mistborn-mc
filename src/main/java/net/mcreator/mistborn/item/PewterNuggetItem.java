
package net.mcreator.mistborn.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.mistborn.procedures.PewterNuggetFoodEatenProcedure;
import net.mcreator.mistborn.MistbornModElements;

import java.util.Map;
import java.util.HashMap;

@MistbornModElements.ModElement.Tag
public class PewterNuggetItem extends MistbornModElements.ModElement {
	@ObjectHolder("mistborn:pewter_nugget")
	public static final Item block = null;
	public PewterNuggetItem(MistbornModElements instance) {
		super(instance, 12);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(8).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(0).saturation(0.3f).build()));
			setRegistryName("pewter_nugget");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				PewterNuggetFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
