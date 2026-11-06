package net.searchies.haze.init;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;

public class ModEntityRenderers {
    public static void init() {
        EntityRenderers.register(ModEntityTypes.BAMBOOM, ThrownItemRenderer::new);
    }
}
