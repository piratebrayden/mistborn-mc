package net.mcreator.mistborn.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.mistborn.item.SteelSpikeItem;
import net.mcreator.mistborn.MistbornMod;

import java.util.Map;

public class SteelSpikeEmptyToolInHandTickProcedure {
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MistbornMod.LOGGER.warn("Failed to load dependency entity for procedure SteelSpikeEmptyToolInHandTick!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				MistbornMod.LOGGER.warn("Failed to load dependency itemstack for procedure SteelSpikeEmptyToolInHandTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MistbornMod.LOGGER.warn("Failed to load dependency x for procedure SteelSpikeEmptyToolInHandTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MistbornMod.LOGGER.warn("Failed to load dependency y for procedure SteelSpikeEmptyToolInHandTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MistbornMod.LOGGER.warn("Failed to load dependency z for procedure SteelSpikeEmptyToolInHandTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MistbornMod.LOGGER.warn("Failed to load dependency world for procedure SteelSpikeEmptyToolInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double RemainingHealth = 0;
		RemainingHealth = (double) ((((itemstack)).getDamage()) - ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1));
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("" + (RemainingHealth))), (true));
		}
		MistbornMod.LOGGER.info(("" + (RemainingHealth)));
		if ((RemainingHealth < 5)) {
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(SteelSpikeItem.block));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
			}
		}
	}
}
