package net.searchies.haze.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.searchies.haze.Haze;
import net.searchies.haze.entity.Bamboom;

public class ModEntityTypes {
    public static final EntityType<Bamboom> BAMBOOM = register(
            "bamboom", EntityType.Builder.<Bamboom>of(Bamboom::new, MobCategory.MISC).noLootTable().sized(0.25F, 0.25F).clientTrackingRange(4).updateInterval(10)
    );

    private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, Haze.id(name));
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
    }

    public static void init() {

    }

    public static void registerAttributes() {

    }
}