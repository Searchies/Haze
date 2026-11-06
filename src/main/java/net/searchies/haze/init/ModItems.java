package net.searchies.haze.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.searchies.haze.Haze;
import net.searchies.haze.item.BamboomItem;

import java.util.function.Function;

public class ModItems {
    public static Item BAMBOOM = register("bamboom", BamboomItem::new, new Item.Properties().stacksTo(16));

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
