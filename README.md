# FirstVersionBlockLocker — Mod Fabric 1.21.4

> Un mod fait par **FirstStudios** et **Claude by Anthropic** — Restreint l'inventaire créatif aux blocs disponibles dans la version Minecraft de ton choix.

---

## Commandes en jeu

| Commande | Description |
|---|---|
| `/fvbl set 1.12` | Active le filtre : seuls les blocs existant en 1.12 (et avant) sont visibles |
| `/fvbl clear`    | Désactive le filtre — tous les blocs sont de nouveau visibles |
| `/fvbl status`   | Affiche la version actuellement active |
| `/fvbl list`     | Liste toutes les versions supportées |

> **Note :** Après avoir changé la version, ferme et rouvre ton inventaire créatif pour que le filtre s'applique.

### Versions supportées

`1.8` `1.9` `1.10` `1.11` `1.12` `1.13` `1.14` `1.15` `1.16` `1.17` `1.18` `1.19` `1.20` `1.21` `1.21.4`

---

## Prérequis

- **Minecraft Java Edition 1.21.4**
- **Fabric Loader** — https://fabricmc.net/use/installer/
- **Fabric API** — https://modrinth.com/mod/fabric-api

---

## Installation

1. Télécharge le fichier `FirstVersionBlockLocker-1.0.0.jar` dans les [Releases](../../releases)
2. Copie-le dans ton dossier mods Minecraft :
   - **Windows** : `%AppData%\.minecraft\mods\`
   - **macOS**   : `~/Library/Application Support/minecraft/mods/`
   - **Linux**   : `~/.minecraft/mods/`
3. Lance Minecraft avec le profil **Fabric 1.21.4**

---

## Étendre la liste des blocs

Tu peux ajouter des blocs manquants dans `BlockVersionData.java`.
Exemple pour ajouter un bloc ajouté en 1.16 :

```java
add("1.16", "mon_bloc_custom");
```

Les noms utilisés sont les identifiants Minecraft sans le préfixe `minecraft:`.

---

## Dépannage

### Le filtre ne s'applique pas
Ferme et rouvre ton inventaire créatif après avoir exécuté `/fvbl set`.

### Erreur de version Gradle/Fabric
Mets à jour `gradle.properties` avec les valeurs de https://fabricmc.net/develop/

---

## Licence

MIT — Libre d'utilisation et de modification. Crédits **FirstStudios** appréciés.
