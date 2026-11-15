package net.searchies.haze.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.searchies.haze.Haze;

public class ModTrimMaterials {
    public static final ResourceKey<TrimMaterial> HAZE_TRIM = registryKey("haze_trim_material");

    public static void bootstrap(BootstrapContext<TrimMaterial> bootstrapContext) {
        register(bootstrapContext, HAZE_TRIM, Style.EMPTY.withColor(14931140), MaterialAssetGroup.create("haze_trim_ag"));
    }

    private static void register(BootstrapContext<TrimMaterial> bootstrapContext, ResourceKey<TrimMaterial> resourceKey, Style style, MaterialAssetGroup materialAssetGroup) {
        Component component = Component.translatable(Util.makeDescriptionId("trim_material", resourceKey.identifier())).withStyle(style);
        bootstrapContext.register(resourceKey, new TrimMaterial(materialAssetGroup, component));
    }

    private static ResourceKey<TrimMaterial> registryKey(String string) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, Haze.id(string));
    }
}
