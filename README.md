# VersionLock — Mod Fabric 1.21.4

Restreint l'inventaire créatif aux blocs disponibles dans la version Minecraft de ton choix.

---

## Commandes en jeu

| Commande | Description |
|---|---|
| `/versionlock set 1.12` | Active le filtre : seuls les blocs existant en 1.12 (et avant) sont visibles |
| `/versionlock clear`    | Désactive le filtre — tous les blocs sont de nouveau visibles |
| `/versionlock status`   | Affiche la version actuellement active |
| `/versionlock list`     | Liste toutes les versions supportées |

> **Note :** Après avoir changé la version, rouvre ton inventaire créatif pour que le filtre s'applique.

---

## Prérequis

- **JDK 21** — Télécharge sur https://adoptium.net (prends "Temurin 21")
- **Git** (optionnel mais recommandé)

---

## Installation & compilation

### 1. Vérifier les versions Fabric

Avant de compiler, vérifie sur https://fabricmc.net/develop/ que les versions dans
`gradle.properties` sont bien les dernières pour Minecraft 1.21.4.

Champs à vérifier :
- `loader_version`
- `fabric_version`
- `yarn_mappings`

### 2. Compiler le mod

Ouvre un terminal dans le dossier `versionlock/` et lance :

```bash
# Linux / macOS
./gradlew build

# Windows
gradlew.bat build
```

La première fois, Gradle va télécharger ses dépendances (~500 Mo). Patiente.

Le fichier `.jar` compilé se trouve dans :
```
build/libs/versionlock-1.0.0.jar
```

### 3. Installer le mod

Copie le `.jar` dans ton dossier mods Minecraft :
- **Windows** : `%AppData%\.minecraft\mods\`
- **macOS**   : `~/Library/Application Support/minecraft/mods/`
- **Linux**   : `~/.minecraft/mods/`

Il te faut également **Fabric Loader** et **Fabric API** installés (si ce n'est pas déjà le cas).

---

## Dépannage fréquent

### Erreur "Field not found: displayItems"
Le nom du champ dans `CreativeModeTab` a peut-être changé avec les mappings Yarn.
1. Ouvre IntelliJ et attend que l'indexation soit terminée
2. Cherche la classe `CreativeModeTab` (Ctrl+N)
3. Cherche un champ de type `Collection<ItemStack>` et note son nom
4. Mets à jour `@Shadow private Collection<ItemStack> displayItems` dans `ItemGroupMixin.java`

### Erreur de version Gradle/Fabric
Mets à jour `gradle.properties` avec les valeurs de https://fabricmc.net/develop/

### Le filtre ne s'applique pas
Ferme et rouvre ton inventaire créatif après avoir exécuté `/versionlock set`.

---

## Étendre la liste des blocs

Tu peux ajouter des blocs manquants dans `BlockVersionData.java`.
Exemple pour ajouter un bloc hypothétique ajouté en 1.16 :
```java
add("1.16", "mon_bloc_custom");
```
Les noms utilisés sont les identifiants Minecraft sans le préfixe `minecraft:`.
