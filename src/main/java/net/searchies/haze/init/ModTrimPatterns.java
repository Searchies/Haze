package net.searchies.haze.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.trim.TrimPattern;
import net.searchies.haze.Haze;

public class ModTrimPatterns {
    public static final ResourceKey<TrimPattern> HAZE_TRIM_PATTERN = registryKey("haze_trim_pattern");

    public static void bootstrap(BootstrapContext<TrimPattern> bootstrapContext) {
        register(bootstrapContext, HAZE_TRIM_PATTERN);
    }

    public static void register(BootstrapContext<TrimPattern> bootstrapContext, ResourceKey<TrimPattern> resourceKey) {
        TrimPattern trimPattern = new TrimPattern(
                resourceKey.identifier(), Component.translatable(Util.makeDescriptionId("trim_pattern", resourceKey.identifier())), false
        );
        bootstrapContext.register(resourceKey, trimPattern);
    }

    private static ResourceKey<TrimPattern> registryKey(String string) {
        return ResourceKey.create(Registries.TRIM_PATTERN, Haze.id(string));
    }
}
