package com.example.autoclick;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.CommandManager;
import net.minecraft.text.Text;

public class AutoclickMod implements ModInitializer {
    public static boolean enabled = false;

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("clikk").executes(ctx -> {
                enabled = !enabled;
                ctx.getSource().sendFeedback(Text.literal("Autoclick: " + enabled));
                return 1;
            }));
        });
    }
}
