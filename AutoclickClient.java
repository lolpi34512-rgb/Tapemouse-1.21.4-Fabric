package com.example.autoclick;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class AutoclickClient implements ClientModInitializer {
    private int timer = 0;

    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (AutoclickMod.enabled) {
                timer++;
                if (timer >= 20) {
                    timer = 0;
                    if (client.player != null) client.doItemUse();
                }
            }
        });
    }
}
