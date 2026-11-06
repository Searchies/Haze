package net.searchies.haze;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.searchies.haze.init.ModEntityRenderers;
import net.searchies.haze.init.ModEntityTypes;

public class HazeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModEntityRenderers.init();
    }
}
