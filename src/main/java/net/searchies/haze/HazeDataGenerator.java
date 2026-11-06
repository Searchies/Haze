package net.searchies.haze;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.searchies.haze.datagen.ModLangProvider;
import net.searchies.haze.datagen.ModModelProvider;
import net.searchies.haze.datagen.ModRecipeProvider;

public class HazeDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModLangProvider::new);
		pack.addProvider(ModRecipeProvider::new);
	}
}
