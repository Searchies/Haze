package net.searchies.haze;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import net.searchies.haze.init.ModEntityTypes;
import net.searchies.haze.init.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Haze implements ModInitializer {
	public static final String MOD_ID = "haze";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.init();
		ModEntityTypes.init();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
