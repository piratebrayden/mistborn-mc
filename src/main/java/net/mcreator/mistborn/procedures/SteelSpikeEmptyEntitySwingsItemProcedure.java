package net.mcreator.mistborn.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mistborn.item.SteelSpikeItem;
import net.mcreator.mistborn.item.SteelSpikeEmptyItem;
import net.mcreator.mistborn.MistbornMod;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class SteelSpikeEmptyEntitySwingsItemProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onItemDestroyed(PlayerDestroyItemEvent event) {
			Entity entity = event.getPlayer();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			ItemStack itemstack = event.getOriginal();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", entity.world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			dependencies.put("itemstack", itemstack);
			executeProcedure(dependencies);
		}
	}
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MistbornMod.LOGGER.warn("Failed to load dependency entity for procedure SteelSpikeEmptyEntitySwingsItem!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				MistbornMod.LOGGER.warn("Failed to load dependency itemstack for procedure SteelSpikeEmptyEntitySwingsItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double RemainingHealth = 0;
		RemainingHealth = (double) ((((itemstack)).getMaxDamage()) - (((itemstack)).getDamage()));
		MistbornMod.LOGGER.info(((RemainingHealth) + "" + (" remaining health")));
		if ((((itemstack).getItem() == SteelSpikeEmptyItem.block) && (RemainingHealth <= 1))) {
			{
				ItemStack _ist = (itemstack);
				if (_ist.attemptDamageItem((int) 1000, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(SteelSpikeItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("A bloody spike has been made"), (true));
			}
		}
	}
}
