package net.searchies.haze.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.searchies.haze.init.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLangProvider extends FabricLanguageProvider {
    public ModLangProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.BAMBOOM, "Bamboom");

//        translationBuilder.add(ModItems.HAZE_ARMOR_TRIM_SMITHING_TEMPLATE, "Haze Armor Trim Smithing Template");
        translationBuilder.add("trim_material.haze.haze_trim_material", "Haze Trim Material");
        translationBuilder.add("trim_pattern.haze.haze_trim_pattern", "Haze Trim Pattern");
    }
}
