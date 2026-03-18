package com.example.versionlock.command;

import com.example.versionlock.VersionManager;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;

@Environment(EnvType.CLIENT)
public class VersionLockCommand {

    // Auto-complétion des versions disponibles
    private static final SuggestionProvider<FabricClientCommandSource> VERSION_SUGGESTIONS =
            (context, builder) -> {
                for (String v : VersionManager.SUPPORTED_VERSIONS) {
                    builder.suggest(v);
                }
                return builder.buildFuture();
            };

    public static void register() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            dispatcher.register(
                ClientCommandManager.literal("fvbl")

                    // /versionlock set <version>
                    .then(ClientCommandManager.literal("set")
                        .then(ClientCommandManager.argument("version", StringArgumentType.word())
                            .suggests(VERSION_SUGGESTIONS)
                            .executes(ctx -> {
                                String version = StringArgumentType.getString(ctx, "version");

                                if (!VersionManager.SUPPORTED_VERSIONS.contains(version)) {
                                    ctx.getSource().sendError(
                                        Component.literal("§6[FirstVersionBlockLocker] §fVersion inconnue : " + version +
                                            ". Versions valides : " + String.join(", ", VersionManager.SUPPORTED_VERSIONS))
                                    );
                                    return 0;
                                }

                                VersionManager.setSelectedVersion(version);
                                refreshCreativeInventory();
                                ctx.getSource().sendFeedback(
                                    Component.literal("§6[FirstVersionBlockLocker] §fVersion réglée sur §e" + version +
                                        "§f. Ouvre ou ferme/rouvre ton inventaire créatif pour appliquer.")
                                );
                                return 1;
                            })
                        )
                    )

                    // /versionlock clear  — supprime le filtre
                    .then(ClientCommandManager.literal("clear")
                        .executes(ctx -> {
                            VersionManager.clearFilter();
                            refreshCreativeInventory();
                            ctx.getSource().sendFeedback(
                                Component.literal("§6[FirstVersionBlockLocker] §fFiltre supprimé — tous les blocs sont visibles.")
                            );
                            return 1;
                        })
                    )

                    // /versionlock status  — affiche la version active
                    .then(ClientCommandManager.literal("status")
                        .executes(ctx -> {
                            String v = VersionManager.getSelectedVersion();
                            if (v == null) {
                                ctx.getSource().sendFeedback(
                                    Component.literal("§6[FirstVersionBlockLocker] §fAucun filtre actif.")
                                );
                            } else {
                                ctx.getSource().sendFeedback(
                                    Component.literal("§6[FirstVersionBlockLocker] §fFiltre actif : §e" + v)
                                );
                            }
                            return 1;
                        })
                    )

                    // /versionlock list  — liste les versions supportées
                    .then(ClientCommandManager.literal("list")
                        .executes(ctx -> {
                            ctx.getSource().sendFeedback(
                                Component.literal("§6[FirstVersionBlockLocker] §fVersions supportées : §e" +
                                    String.join("§f, §e", VersionManager.SUPPORTED_VERSIONS))
                            );
                            return 1;
                        })
                    )
            );
        });
    }

    /**
     * Ferme l'inventaire créatif s'il est ouvert, afin que les onglets
     * soient reconstruits (et filtrés) à la prochaine ouverture.
     */
    private static void refreshCreativeInventory() {
        Minecraft mc = Minecraft.getInstance();
        if (mc.screen != null) {
            // Fermer l'écran actuel force un rebuild des onglets à la réouverture
            mc.setScreen(null);
        }
    }
}