package com.example.versionlock;

import com.example.versionlock.command.VersionLockCommand;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class VersionLockClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        VersionLockCommand.register();
        VersionLockMod.LOGGER.info("VersionLock client initialisé.");
    }
}
