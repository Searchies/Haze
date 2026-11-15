package net.searchies.haze.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SmithingTemplateItem;
import net.searchies.haze.Haze;
import net.searchies.haze.item.BamboomItem;

import java.util.function.Function;

public class ModItems {
    public static Item BAMBOOM = register("bamboom", BamboomItem::new, new Item.Properties().stacksTo(16));
//    public static final Item HAZE_ARMOR_TRIM_SMITHING_TEMPLATE = register("haze_armor_trim_smithing_template", SmithingTemplateItem::createArmorTrimTemplate, new Item.Properties().rarity(Rarity.UNCOMMON).modelId(Haze.id("haze_trim")));

    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Haze.id(name));

        T item = itemFactory.apply(settings.setId(itemKey));

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static void init() {

    }

    // make creative tab for it
}
