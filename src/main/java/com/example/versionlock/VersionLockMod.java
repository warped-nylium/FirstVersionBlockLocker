package com.example.versionlock;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VersionLockMod implements ModInitializer {

    public static final String MOD_ID = "firstversionblocklocker";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("FirstVersionBlockLocker chargé ! By FirstStudios.");
    }
}
