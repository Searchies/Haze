package net.searchies.haze.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);

                SimpleCookingRecipeBuilder.smelting(
                    Ingredient.of(Items.NETHERITE_PICKAXE, Items.NETHERITE_SHOVEL, Items.NETHERITE_AXE, Items.NETHERITE_HOE, Items.NETHERITE_SWORD, Items.NETHERITE_SPEAR, Items.NETHERITE_HELMET, Items.NETHERITE_CHESTPLATE, Items.NETHERITE_LEGGINGS, Items.NETHERITE_BOOTS, Items.NETHERITE_HORSE_ARMOR, Items.NETHERITE_NAUTILUS_ARMOR),
                    RecipeCategory.MISC,
                    Items.NETHERITE_SCRAP,
                    0.1F,
                    200
                )
                .unlockedBy("has_netherite_pickaxe", has(Items.NETHERITE_PICKAXE))
                .unlockedBy("has_netherite_shovel", has(Items.NETHERITE_SHOVEL))
                .unlockedBy("has_netherite_axe", has(Items.NETHERITE_AXE))
                .unlockedBy("has_netherite_hoe", has(Items.NETHERITE_HOE))
                .unlockedBy("has_netherite_sword", has(Items.NETHERITE_SWORD))
                .unlockedBy("has_netherite_spear", has(Items.NETHERITE_SPEAR))
                .unlockedBy("has_netherite_helmet", has(Items.NETHERITE_HELMET))
                .unlockedBy("has_netherite_chestplate", has(Items.NETHERITE_CHESTPLATE))
                .unlockedBy("has_netherite_leggings", has(Items.NETHERITE_LEGGINGS))
                .unlockedBy("has_netherite_boots", has(Items.NETHERITE_BOOTS))
                .unlockedBy("has_netherite_horse_armor", has(Items.NETHERITE_HORSE_ARMOR))
                .unlockedBy("has_netherite_nautilus_armor", has(Items.NETHERITE_NAUTILUS_ARMOR))
                .save(exporter, getSmeltingRecipeName(Items.NETHERITE_SCRAP));

                SimpleCookingRecipeBuilder.smelting(
                    Ingredient.of(Items.DIAMOND_PICKAXE, Items.DIAMOND_SHOVEL, Items.DIAMOND_AXE, Items.DIAMOND_HOE, Items.DIAMOND_SWORD, Items.DIAMOND_SPEAR, Items.DIAMOND_HELMET, Items.DIAMOND_CHESTPLATE, Items.DIAMOND_LEGGINGS, Items.DIAMOND_BOOTS, Items.DIAMOND_HORSE_ARMOR, Items.DIAMOND_NAUTILUS_ARMOR),
                    RecipeCategory.MISC,
                    Items.DIAMOND,
                    0.1F,
                    200
                )
                .unlockedBy("has_diamond_pickaxe", has(Items.DIAMOND_PICKAXE))
                .unlockedBy("has_diamond_shovel", has(Items.DIAMOND_SHOVEL))
                .unlockedBy("has_diamond_axe", has(Items.DIAMOND_AXE))
                .unlockedBy("has_diamond_hoe", has(Items.DIAMOND_HOE))
                .unlockedBy("has_diamond_sword", has(Items.DIAMOND_SWORD))
                .unlockedBy("has_diamond_spear", has(Items.DIAMOND_SPEAR))
                .unlockedBy("has_diamond_helmet", has(Items.DIAMOND_HELMET))
                .unlockedBy("has_diamond_chestplate", has(Items.DIAMOND_CHESTPLATE))
                .unlockedBy("has_diamond_leggings", has(Items.DIAMOND_LEGGINGS))
                .unlockedBy("has_diamond_boots", has(Items.DIAMOND_BOOTS))
                .unlockedBy("has_diamond_horse_armor", has(Items.DIAMOND_HORSE_ARMOR))
                .unlockedBy("has_diamond_nautilus_armor", has(Items.DIAMOND_NAUTILUS_ARMOR))
                .save(exporter, getSmeltingRecipeName(Items.DIAMOND));
            }
        };
    }

    @Override
    public String getName() {
        return "ModRecipeProvider";
    }
}
