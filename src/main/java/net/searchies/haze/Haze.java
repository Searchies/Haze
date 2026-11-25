package net.searchies.haze;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.Identifier;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.level.block.Blocks;
import net.searchies.haze.init.ModEntityTypes;
import net.searchies.haze.init.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Haze implements ModInitializer {
	public static final String MOD_ID = "haze";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.init();
		ModEntityTypes.init();

		DefaultItemComponentEvents.MODIFY.register(listener -> {
			listener.modify(Items.SCULK, (builder) -> {
				builder.set(DataComponents.CONSUMABLE, Consumables.DEFAULT_FOOD);
			});
		});
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
