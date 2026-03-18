package com.example.versionlock;

import java.util.Arrays;
import java.util.List;

/**
 * Gère la version Minecraft cible choisie par le joueur.
 * Seuls les blocs existant dans cette version (ou avant) seront visibles dans l'inventaire créatif.
 */
public class VersionManager {

    // Ordre chronologique des versions supportées (de la plus ancienne à la plus récente)
    public static final List<String> SUPPORTED_VERSIONS = Arrays.asList(
            "1.8", "1.9", "1.10", "1.11", "1.12",
            "1.13", "1.14", "1.15", "1.16",
            "1.17", "1.18", "1.19", "1.20", "1.21", "1.21.4"
    );

    // null = pas de filtre, tous les blocs sont visibles
    private static String selectedVersion = null;

    public static String getSelectedVersion() {
        return selectedVersion;
    }

    public static void setSelectedVersion(String version) {
        selectedVersion = version;
    }

    public static void clearFilter() {
        selectedVersion = null;
    }

    /**
     * Retourne true si la version sélectionnée est >= à la version d'ajout du bloc.
     * Autrement dit : est-ce que le bloc existait déjà à l'époque choisie ?
     */
    public static boolean isAvailableInSelectedVersion(String addedInVersion) {
        if (selectedVersion == null) return true; // Pas de filtre

        int selectedIdx = SUPPORTED_VERSIONS.indexOf(selectedVersion);
        int addedIdx    = SUPPORTED_VERSIONS.indexOf(addedInVersion);

        // Version inconnue → on affiche le bloc par sécurité
        if (selectedIdx == -1 || addedIdx == -1) return true;

        return selectedIdx >= addedIdx;
    }
}
