package com.example.versionlock;

import java.util.HashMap;
import java.util.Map;

/**
 * Associe chaque bloc PLAÇABLE à la version Minecraft dans laquelle il a été ajouté.
 *
 * RÈGLE : si un bloc N'EST PAS dans cette liste → pré-1.8 → toujours visible.
 *
 * BLOCS EXCLUS INTENTIONNELLEMENT (block states internes, pas d'item) :
 *   *_wall_sign, *_wall_hanging_sign → block states, pas d'item séparé
 *   kelp_plant, bubble_column, cave_vines_plant → block states
 *   weeping_vines_plant, twisting_vines_plant → block states
 *   wall_torch, soul_wall_torch → block states de torche
 *   powder_snow_cauldron, water_cauldron, lava_cauldron → block states du chaudron
 *   end_gateway → bloc technique non plaçable en créatif
 *   frosted_ice → créé uniquement par enchantement
 *
 * PRÉ-1.8 (toujours visibles, absents de cette liste) :
 *   Terrain : stone, cobblestone, dirt, grass_block, sand, gravel, bedrock, obsidian,
 *             netherrack, soul_sand, glowstone, end_stone, ice, snow_block, packed_ice,
 *             clay, mycelium, podzol, farmland, rooted_dirt (← non, c'est 1.17)
 *   Bois (6 types oak/spruce/birch/jungle/acacia/dark_oak) :
 *             *_log, *_planks, *_leaves, *_sapling, *_stairs, *_slab,
 *             oak_fence, oak_fence_gate, oak_door, oak_trapdoor,
 *             oak_button, oak_pressure_plate, oak_sign
 *   Pierre : sandstone, chiseled_sandstone, smooth_sandstone,
 *             stone_bricks, mossy_stone_bricks, cracked_stone_bricks, chiseled_stone_bricks,
 *             mossy_cobblestone, cobblestone_wall, mossy_cobblestone_wall,
 *             bricks, brick_stairs, brick_slab,
 *             stone_brick_stairs, stone_brick_slab, cobblestone_stairs, cobblestone_slab,
 *             nether_bricks, nether_brick_fence, nether_brick_stairs, nether_brick_slab,
 *             quartz_block, chiseled_quartz_block, quartz_pillar, quartz_stairs, quartz_slab,
 *             smooth_quartz
 *   Fonctionnel : crafting_table, furnace, chest, trapped_chest, ender_chest, anvil,
 *                 enchanting_table, brewing_stand, beacon, bookshelf, jukebox,
 *                 note_block, tnt, dispenser, dropper, hopper, piston, sticky_piston,
 *                 redstone_block, redstone_lamp, daylight_detector, comparator, repeater,
 *                 cauldron, flower_pot, cake, ladder, vine, iron_bars, glass, glass_pane,
 *                 torch, iron_door, stone_pressure_plate, stone_button, jack_o_lantern,
 *                 red_bed, command_block, chiseled_stone_bricks, stone_slab, sandstone_slab
 *   Déco/nature : all *_wool, *_carpet, *_terracotta, *_stained_glass, *_stained_glass_pane,
 *                 dandelion, poppy, blue_orchid, allium, azure_bluet, *_tulip, oxeye_daisy,
 *                 sunflower, lilac, rose_bush, peony, tall_grass, large_fern, fern,
 *                 short_grass, dead_bush, lily_pad, cactus, sugar_cane, pumpkin,
 *                 carved_pumpkin, melon, nether_wart, hay_block, mushrooms, coal_ore,
 *                 iron_ore, gold_ore, diamond_ore, emerald_ore, lapis_ore, redstone_ore,
 *                 nether_quartz_ore, sponge, cobweb, smooth_stone, snow
 */
public class BlockVersionData {

    private static final Map<String, String> BLOCK_ADDED_IN = new HashMap<>();

    static {

        // =====================================================================
        // 1.8 — Bountiful Update (2 sept. 2014)
        // Source confirmée : minecraft.wiki/w/Java_Edition_1.8
        // "36 new blocks: granite, andesite, diorite + polished variants;
        //  3 prismarine; 5 red sandstone; 5 doors/fences/fence gates; sea lantern,
        //  wet sponge, slime block, coarse dirt, barrier, iron trapdoor, banners"
        // =====================================================================
        add("1.8",
                // ---- Pierres décoratives ----
                "granite",            "polished_granite",
                "andesite",           "polished_andesite",
                "diorite",            "polished_diorite",
                // ---- Monument / Prismarine ----
                "prismarine",         "prismarine_bricks",   "dark_prismarine",
                "sea_lantern",
                "wet_sponge",
                // ---- Grès rouge ----
                "red_sandstone",      "chiseled_red_sandstone",  "cut_red_sandstone",
                "smooth_red_sandstone",
                "red_sandstone_stairs", "red_sandstone_slab",
                // ---- Nouvelles portes (5 types de bois hors oak) ----
                "spruce_door",        "birch_door",         "jungle_door",
                "acacia_door",        "dark_oak_door",
                // ---- Nouvelles clôtures (5 types de bois hors oak) ----
                "spruce_fence",       "birch_fence",        "jungle_fence",
                "acacia_fence",       "dark_oak_fence",
                // ---- Nouveaux portails de clôture (5 types de bois hors oak) ----
                "spruce_fence_gate",  "birch_fence_gate",   "jungle_fence_gate",
                "acacia_fence_gate",  "dark_oak_fence_gate",
                // ---- Bannières (16 couleurs) ----
                "white_banner",       "orange_banner",      "magenta_banner",
                "light_blue_banner",  "yellow_banner",      "lime_banner",
                "pink_banner",        "gray_banner",        "light_gray_banner",
                "cyan_banner",        "purple_banner",      "blue_banner",
                "brown_banner",       "green_banner",       "red_banner",
                "black_banner",
                // ---- Divers ----
                "slime_block",
                "barrier",
                "iron_trapdoor",
                "coarse_dirt"
        );

        // =====================================================================
        // 1.9 — Combat Update (29 fév. 2016)
        // Source confirmée : minecraft.wiki/w/Java_Edition_1.9
        // "structure_block added in 1.9, only placeable via /setblock"
        // "dirt_path NOT in creative inventory — pick block only"
        // =====================================================================
        add("1.9",
                // ---- End ----
                "end_stone_bricks",
                "purpur_block",        "purpur_pillar",
                "purpur_stairs",       "purpur_slab",
                "end_rod",
                "chorus_plant",        "chorus_flower",
                "end_crystal",
                // ---- Divers ----
                "dirt_path",
                "structure_block",
                "repeating_command_block",
                "chain_command_block"
        );

        // =====================================================================
        // 1.10 — Frostburn Update (26 juin 2016)
        // Source confirmée : minecraft.wiki/w/Java_Edition_1.10
        // =====================================================================
        add("1.10",
                "magma_block",
                "nether_wart_block",
                "red_nether_bricks",
                "bone_block",
                "structure_void"
        );

        // =====================================================================
        // 1.11 — Exploration Update (14 nov. 2016)
        // Source confirmée : minecraft.wiki/w/Java_Edition_1.11
        // =====================================================================
        add("1.11",
                "observer",
                // ---- Shulker boxes (16 couleurs) ----
                "white_shulker_box",       "orange_shulker_box",
                "magenta_shulker_box",     "light_blue_shulker_box",
                "yellow_shulker_box",      "lime_shulker_box",
                "pink_shulker_box",        "gray_shulker_box",
                "light_gray_shulker_box",  "cyan_shulker_box",
                "purple_shulker_box",      "blue_shulker_box",
                "brown_shulker_box",       "green_shulker_box",
                "red_shulker_box",         "black_shulker_box",
                // ---- Terracotta émaillée (16 couleurs) ----
                "white_glazed_terracotta",       "orange_glazed_terracotta",
                "magenta_glazed_terracotta",     "light_blue_glazed_terracotta",
                "yellow_glazed_terracotta",      "lime_glazed_terracotta",
                "pink_glazed_terracotta",        "gray_glazed_terracotta",
                "light_gray_glazed_terracotta",  "cyan_glazed_terracotta",
                "purple_glazed_terracotta",      "blue_glazed_terracotta",
                "brown_glazed_terracotta",       "green_glazed_terracotta",
                "red_glazed_terracotta",         "black_glazed_terracotta"
        );

        // =====================================================================
        // 1.12 — World of Color Update (7 juin 2017)
        // Source confirmée : minecraft.wiki/w/Java_Edition_1.12
        // "Added 15 new beds in addition to the existing red bed"
        // =====================================================================
        add("1.12",
                // ---- Béton (16 couleurs) ----
                "white_concrete",        "orange_concrete",
                "magenta_concrete",      "light_blue_concrete",
                "yellow_concrete",       "lime_concrete",
                "pink_concrete",         "gray_concrete",
                "light_gray_concrete",   "cyan_concrete",
                "purple_concrete",       "blue_concrete",
                "brown_concrete",        "green_concrete",
                "red_concrete",          "black_concrete",
                // ---- Poudre de béton (16 couleurs) ----
                "white_concrete_powder",       "orange_concrete_powder",
                "magenta_concrete_powder",     "light_blue_concrete_powder",
                "yellow_concrete_powder",      "lime_concrete_powder",
                "pink_concrete_powder",        "gray_concrete_powder",
                "light_gray_concrete_powder",  "cyan_concrete_powder",
                "purple_concrete_powder",      "blue_concrete_powder",
                "brown_concrete_powder",       "green_concrete_powder",
                "red_concrete_powder",         "black_concrete_powder",
                // ---- Lits colorés (15 nouveaux — le rouge existait avant 1.8) ----
                "white_bed",       "orange_bed",      "magenta_bed",
                "light_blue_bed",  "yellow_bed",      "lime_bed",
                "pink_bed",        "gray_bed",        "light_gray_bed",
                "cyan_bed",        "purple_bed",      "blue_bed",
                "brown_bed",       "green_bed",       "black_bed"
        );

        // =====================================================================
        // 1.13 — Update Aquatic (18 juil. 2018)
        // Source confirmée : minecraft.wiki/w/Java_Edition_1.13
        // "Trapdoors, buttons, and pressure plates made from all 6 wood types"
        // "Bark blocks now craftable"
        // NOTE : walls/stairs/slabs variantes de pierre → 1.14, PAS ici.
        // =====================================================================
        add("1.13",
                // ---- Coraux vivants ----
                "tube_coral_block",    "brain_coral_block",   "bubble_coral_block",
                "fire_coral_block",    "horn_coral_block",
                "tube_coral",          "brain_coral",          "bubble_coral",
                "fire_coral",          "horn_coral",
                "tube_coral_fan",      "brain_coral_fan",      "bubble_coral_fan",
                "fire_coral_fan",      "horn_coral_fan",
                // ---- Coraux morts ----
                "dead_tube_coral_block",    "dead_brain_coral_block",   "dead_bubble_coral_block",
                "dead_fire_coral_block",    "dead_horn_coral_block",
                "dead_tube_coral",          "dead_brain_coral",          "dead_bubble_coral",
                "dead_fire_coral",          "dead_horn_coral",
                "dead_tube_coral_fan",      "dead_brain_coral_fan",      "dead_bubble_coral_fan",
                "dead_fire_coral_fan",      "dead_horn_coral_fan",
                // ---- Aquatique ----
                "blue_ice",
                "dried_kelp_block",
                "kelp",
                "seagrass",            "tall_seagrass",
                "conduit",
                "sea_pickle",
                "turtle_egg",
                // ---- Bois écorcés stripped (6 types × 2 formes) ----
                "stripped_oak_log",      "stripped_oak_wood",
                "stripped_spruce_log",   "stripped_spruce_wood",
                "stripped_birch_log",    "stripped_birch_wood",
                "stripped_jungle_log",   "stripped_jungle_wood",
                "stripped_acacia_log",   "stripped_acacia_wood",
                "stripped_dark_oak_log", "stripped_dark_oak_wood",
                // ---- Bois bark tout-écorce (6 types, maintenant craftables) ----
                "oak_wood",     "spruce_wood",    "birch_wood",
                "jungle_wood",  "acacia_wood",    "dark_oak_wood",
                // ---- Trappes bois (5 nouveaux types) ----
                "spruce_trapdoor",   "birch_trapdoor",   "jungle_trapdoor",
                "acacia_trapdoor",   "dark_oak_trapdoor",
                // ---- Boutons bois (5 nouveaux types) ----
                "spruce_button",     "birch_button",     "jungle_button",
                "acacia_button",     "dark_oak_button",
                // ---- Plaques de pression bois (5 nouveaux types) ----
                "spruce_pressure_plate",    "birch_pressure_plate",   "jungle_pressure_plate",
                "acacia_pressure_plate",    "dark_oak_pressure_plate",
                // ---- Prismarine : escaliers et dalles ----
                "prismarine_stairs",       "prismarine_slab",
                "prismarine_brick_stairs", "prismarine_brick_slab",
                "dark_prismarine_stairs",  "dark_prismarine_slab",
                // ---- Grès taillé (smooth = smelted, déjà pré-1.8 pour les blocs) ----
                "cut_sandstone",
                "cut_sandstone_slab",
                "cut_red_sandstone_slab"
        );

        // =====================================================================
        // 1.14 — Village & Pillage (23 avr. 2019)
        // Source confirmée : minecraft.wiki/w/Java_Edition_1.14
        // "Added spruce, birch, jungle, acacia, dark oak signs"
        // "New stair, slab, and wall variants"
        // "Before 1.14, only cobblestone and mossy cobblestone walls existed"
        // =====================================================================
        add("1.14",
                // ---- Blocs fonctionnels ----
                "scaffolding",
                "campfire",
                "lantern",
                "barrel",
                "bell",
                "blast_furnace",
                "smoker",
                "fletching_table",
                "smithing_table",
                "composter",
                "loom",
                "stonecutter",
                "cartography_table",
                "grindstone",
                "lectern",
                "jigsaw",
                // ---- Végétation / déco ----
                "bamboo",
                "sweet_berry_bush",
                "cornflower",
                "lily_of_the_valley",
                "wither_rose",
                // ---- Panneaux (5 nouveaux types de bois) ----
                "spruce_sign",   "birch_sign",    "jungle_sign",
                "acacia_sign",   "dark_oak_sign",
                // ---- Walls (TOUTES nouvelles variantes — absentes avant 1.14) ----
                "brick_wall",
                "stone_brick_wall",       "mossy_stone_brick_wall",
                "andesite_wall",          "diorite_wall",           "granite_wall",
                "sandstone_wall",         "red_sandstone_wall",
                "prismarine_wall",
                "nether_brick_wall",      "red_nether_brick_wall",
                "end_stone_brick_wall",
                // ---- Escaliers (nouvelles variantes de pierre) ----
                "stone_stairs",
                "mossy_cobblestone_stairs",  "mossy_stone_brick_stairs",
                "granite_stairs",            "polished_granite_stairs",
                "andesite_stairs",           "polished_andesite_stairs",
                "diorite_stairs",            "polished_diorite_stairs",
                "smooth_sandstone_stairs",   "smooth_red_sandstone_stairs",
                "smooth_quartz_stairs",
                "end_stone_brick_stairs",
                "red_nether_brick_stairs",
                // ---- Dalles (nouvelles variantes de pierre) ----
                "stone_slab",               // smooth stone slab renommé + recette ajoutée
                "granite_slab",             "polished_granite_slab",
                "andesite_slab",            "polished_andesite_slab",
                "diorite_slab",             "polished_diorite_slab",
                "mossy_cobblestone_slab",   "mossy_stone_brick_slab",
                "smooth_sandstone_slab",    "smooth_red_sandstone_slab",
                "smooth_quartz_slab",
                "red_nether_brick_slab",
                "end_stone_brick_slab"
        );

        // =====================================================================
        // 1.15 — Buzzy Bees (10 déc. 2019)
        // =====================================================================
        add("1.15",
                "bee_nest",
                "beehive",
                "honeycomb_block",
                "honey_block"
        );

        // =====================================================================
        // 1.16 — Nether Update (23 juin 2020)
        // Source confirmée : minecraft.wiki/w/Java_Edition_1.16
        // Note : smooth_basalt = 1.17 (géodes d'améthyste), PAS 1.16
        // =====================================================================
        add("1.16",
                // ---- Bois Crimson ----
                "crimson_stem",              "stripped_crimson_stem",
                "crimson_hyphae",            "stripped_crimson_hyphae",
                "crimson_planks",
                "crimson_slab",              "crimson_stairs",
                "crimson_fence",             "crimson_fence_gate",
                "crimson_door",              "crimson_trapdoor",
                "crimson_pressure_plate",    "crimson_button",
                "crimson_sign",
                // ---- Bois Warped ----
                "warped_stem",               "stripped_warped_stem",
                "warped_hyphae",             "stripped_warped_hyphae",
                "warped_planks",
                "warped_slab",               "warped_stairs",
                "warped_fence",              "warped_fence_gate",
                "warped_door",               "warped_trapdoor",
                "warped_pressure_plate",     "warped_button",
                "warped_sign",
                // ---- Végétation Nether ----
                "crimson_nylium",            "warped_nylium",
                "crimson_roots",             "warped_roots",
                "nether_sprouts",
                "crimson_fungus",            "warped_fungus",
                "shroomlight",
                "weeping_vines",             "twisting_vines",
                "warped_wart_block",
                // ---- Blackstone ----
                "blackstone",
                "gilded_blackstone",
                "polished_blackstone",
                "chiseled_polished_blackstone",
                "polished_blackstone_bricks",
                "cracked_polished_blackstone_bricks",
                "blackstone_slab",                "blackstone_stairs",            "blackstone_wall",
                "polished_blackstone_slab",       "polished_blackstone_stairs",   "polished_blackstone_wall",
                "polished_blackstone_brick_slab", "polished_blackstone_brick_stairs", "polished_blackstone_brick_wall",
                "polished_blackstone_pressure_plate", "polished_blackstone_button",
                // ---- Soul ----
                "soul_soil",
                "soul_torch",
                "soul_fire",
                "soul_campfire",
                "soul_lantern",
                // ---- Basalte ----
                "basalt",
                "polished_basalt",
                // ---- Nether bricks variants ----
                "cracked_nether_bricks",
                "chiseled_nether_bricks",
                "quartz_bricks",
                // ---- Minerais / Netherite ----
                "ancient_debris",
                "netherite_block",
                "nether_gold_ore",
                // ---- Divers ----
                "crying_obsidian",
                "respawn_anchor",
                "lodestone",
                "chain",
                "target"
        );

        // =====================================================================
        // 1.17 — Caves & Cliffs Part I (8 juin 2021)
        // Source confirmée : minecraft.wiki/w/Java_Edition_1.17
        // Note : smooth_basalt = ici (couche des géodes), PAS en 1.16
        // =====================================================================
        add("1.17",
                // ---- Améthyste ----
                "amethyst_block",      "budding_amethyst",
                "small_amethyst_bud",  "medium_amethyst_bud",
                "large_amethyst_bud",  "amethyst_cluster",
                // ---- Cuivre brut ----
                "raw_copper_block",    "raw_iron_block",    "raw_gold_block",
                // ---- Minerai de cuivre ----
                "copper_ore",
                // ---- Cuivre : blocs (toutes oxydations + cirés) ----
                "copper_block",         "exposed_copper",         "weathered_copper",        "oxidized_copper",
                "waxed_copper_block",   "waxed_exposed_copper",   "waxed_weathered_copper",  "waxed_oxidized_copper",
                // ---- Cuivre : cut ----
                "cut_copper",                        "exposed_cut_copper",
                "weathered_cut_copper",              "oxidized_cut_copper",
                "waxed_cut_copper",                  "waxed_exposed_cut_copper",
                "waxed_weathered_cut_copper",        "waxed_oxidized_cut_copper",
                // ---- Cuivre : cut stairs ----
                "cut_copper_stairs",                 "exposed_cut_copper_stairs",
                "weathered_cut_copper_stairs",       "oxidized_cut_copper_stairs",
                "waxed_cut_copper_stairs",           "waxed_exposed_cut_copper_stairs",
                "waxed_weathered_cut_copper_stairs", "waxed_oxidized_cut_copper_stairs",
                // ---- Cuivre : cut slabs ----
                "cut_copper_slab",                   "exposed_cut_copper_slab",
                "weathered_cut_copper_slab",         "oxidized_cut_copper_slab",
                "waxed_cut_copper_slab",             "waxed_exposed_cut_copper_slab",
                "waxed_weathered_cut_copper_slab",   "waxed_oxidized_cut_copper_slab",
                // ---- Deepslate et variantes ----
                "deepslate",
                "cobbled_deepslate",        "chiseled_deepslate",
                "polished_deepslate",
                "deepslate_bricks",         "cracked_deepslate_bricks",
                "deepslate_tiles",          "cracked_deepslate_tiles",
                "infested_deepslate",
                "cobbled_deepslate_slab",   "cobbled_deepslate_stairs",   "cobbled_deepslate_wall",
                "polished_deepslate_slab",  "polished_deepslate_stairs",  "polished_deepslate_wall",
                "deepslate_brick_slab",     "deepslate_brick_stairs",     "deepslate_brick_wall",
                "deepslate_tile_slab",      "deepslate_tile_stairs",      "deepslate_tile_wall",
                // ---- Minerais deepslate ----
                "deepslate_coal_ore",      "deepslate_iron_ore",    "deepslate_gold_ore",
                "deepslate_emerald_ore",   "deepslate_lapis_ore",   "deepslate_diamond_ore",
                "deepslate_redstone_ore",  "deepslate_copper_ore",
                // ---- Roches des géodes ----
                "tuff",
                "calcite",
                "smooth_basalt",
                // ---- Stalactites ----
                "pointed_dripstone",
                "dripstone_block",
                // ---- Végétation souterraine ----
                "moss_block",          "moss_carpet",
                "rooted_dirt",         "hanging_roots",
                "big_dripleaf",        "small_dripleaf",
                "glow_lichen",         "spore_blossom",
                "cave_vines",
                "azalea",              "flowering_azalea",
                "azalea_leaves",       "flowering_azalea_leaves",
                // ---- Divers ----
                "tinted_glass",
                "powder_snow",
                "lightning_rod",
                // ---- Bougies (neutre + 16 couleurs) ----
                "candle",
                "white_candle",       "orange_candle",      "magenta_candle",
                "light_blue_candle",  "yellow_candle",      "lime_candle",
                "pink_candle",        "gray_candle",         "light_gray_candle",
                "cyan_candle",        "purple_candle",       "blue_candle",
                "brown_candle",       "green_candle",        "red_candle",         "black_candle",
                // ---- Sculk sensor ----
                "sculk_sensor"
        );

        // =====================================================================
        // 1.18 — Caves & Cliffs Part II (30 nov. 2021)
        // Uniquement génération de monde — aucun nouveau bloc plaçable.
        // =====================================================================

        // =====================================================================
        // 1.19 — The Wild Update (7 juin 2022)
        // Source confirmée : minecraft.wiki/w/Java_Edition_1.19
        // =====================================================================
        add("1.19",
                // ---- Sculk ----
                "sculk",
                "sculk_catalyst",
                "sculk_shrieker",
                "sculk_vein",
                // ---- Bois Mangrove ----
                "mangrove_log",              "mangrove_wood",
                "stripped_mangrove_log",     "stripped_mangrove_wood",
                "mangrove_planks",
                "mangrove_slab",             "mangrove_stairs",
                "mangrove_fence",            "mangrove_fence_gate",
                "mangrove_door",             "mangrove_trapdoor",
                "mangrove_pressure_plate",   "mangrove_button",
                "mangrove_sign",
                "mangrove_leaves",
                "mangrove_roots",            "muddy_mangrove_roots",
                "mangrove_propagule",
                // ---- Boue ----
                "mud",
                "packed_mud",
                "mud_bricks",
                "mud_brick_slab",            "mud_brick_stairs",          "mud_brick_wall",
                // ---- Froglights ----
                "ochre_froglight",
                "verdant_froglight",
                "pearlescent_froglight",
                // ---- Divers ----
                "reinforced_deepslate",
                "frogspawn"
        );

        // =====================================================================
        // 1.20 — Trails & Tales (7 juin 2023)
        // Source confirmée : minecraft.wiki/w/Java_Edition_1.20
        // =====================================================================
        add("1.20",
                // ---- Bois Bambou ----
                "bamboo_block",              "stripped_bamboo_block",
                "bamboo_planks",
                "bamboo_mosaic",
                "bamboo_slab",               "bamboo_mosaic_slab",
                "bamboo_stairs",             "bamboo_mosaic_stairs",
                "bamboo_fence",              "bamboo_fence_gate",
                "bamboo_door",               "bamboo_trapdoor",
                "bamboo_pressure_plate",     "bamboo_button",
                "bamboo_sign",               "bamboo_hanging_sign",
                // ---- Bois Cerisier ----
                "cherry_log",                "cherry_wood",
                "stripped_cherry_log",       "stripped_cherry_wood",
                "cherry_planks",
                "cherry_slab",               "cherry_stairs",
                "cherry_fence",              "cherry_fence_gate",
                "cherry_door",               "cherry_trapdoor",
                "cherry_pressure_plate",     "cherry_button",
                "cherry_sign",               "cherry_hanging_sign",
                "cherry_leaves",             "cherry_sapling",
                // ---- Panneaux suspendus (TOUS les types, y compris anciens bois) ----
                "oak_hanging_sign",          "spruce_hanging_sign",       "birch_hanging_sign",
                "jungle_hanging_sign",       "acacia_hanging_sign",       "dark_oak_hanging_sign",
                "mangrove_hanging_sign",
                "crimson_hanging_sign",      "warped_hanging_sign",
                // ---- Construction ----
                "chiseled_bookshelf",
                "decorated_pot",
                "pink_petals",
                // ---- Archéologie ----
                "suspicious_sand",
                "suspicious_gravel",
                // ---- Sniffer & plantes ----
                "sniffer_egg",
                "torchflower",
                "pitcher_plant",             "pitcher_pod",
                // ---- Redstone ----
                "calibrated_sculk_sensor"
        );

        // =====================================================================
        // 1.21 — Tricky Trials (13 juin 2024)
        // Source confirmée : minecraft.wiki/w/Java_Edition_1.21
        // =====================================================================
        add("1.21",
                // ---- Trial Chamber ----
                "trial_spawner",             "ominous_trial_spawner",
                "vault",                     "ominous_vault",
                // ---- Crafter ----
                "crafter",
                // ---- Cuivre : ciselé ----
                "chiseled_copper",
                "exposed_chiseled_copper",         "weathered_chiseled_copper",
                "oxidized_chiseled_copper",
                "waxed_chiseled_copper",
                "waxed_exposed_chiseled_copper",   "waxed_weathered_chiseled_copper",
                "waxed_oxidized_chiseled_copper",
                // ---- Cuivre : grilles ----
                "copper_grate",              "exposed_copper_grate",
                "weathered_copper_grate",    "oxidized_copper_grate",
                "waxed_copper_grate",        "waxed_exposed_copper_grate",
                "waxed_weathered_copper_grate","waxed_oxidized_copper_grate",
                // ---- Cuivre : ampoules ----
                "copper_bulb",               "exposed_copper_bulb",
                "weathered_copper_bulb",     "oxidized_copper_bulb",
                "waxed_copper_bulb",         "waxed_exposed_copper_bulb",
                "waxed_weathered_copper_bulb","waxed_oxidized_copper_bulb",
                // ---- Cuivre : portes ----
                "copper_door",               "exposed_copper_door",
                "weathered_copper_door",     "oxidized_copper_door",
                "waxed_copper_door",         "waxed_exposed_copper_door",
                "waxed_weathered_copper_door","waxed_oxidized_copper_door",
                // ---- Cuivre : trappes ----
                "copper_trapdoor",           "exposed_copper_trapdoor",
                "weathered_copper_trapdoor", "oxidized_copper_trapdoor",
                "waxed_copper_trapdoor",     "waxed_exposed_copper_trapdoor",
                "waxed_weathered_copper_trapdoor","waxed_oxidized_copper_trapdoor",
                // ---- Tuff : toutes variantes ----
                "tuff_slab",                 "tuff_stairs",               "tuff_wall",
                "chiseled_tuff",
                "polished_tuff",             "polished_tuff_slab",        "polished_tuff_stairs",   "polished_tuff_wall",
                "tuff_bricks",               "tuff_brick_slab",           "tuff_brick_stairs",      "tuff_brick_wall",
                "chiseled_tuff_bricks",
                // ---- Divers ----
                "heavy_core"
        );

        // =====================================================================
        // 1.21.4 — The Garden Awakens (3 déc. 2024)
        // Source confirmée : minecraft.wiki/w/Java_Edition_1.21.4
        // Note : resin_brick (singulier) n'existe pas, seulement resin_bricks (pluriel)
        // =====================================================================
        add("1.21.4",
                // ---- Bois Pale Oak ----
                "pale_oak_log",              "pale_oak_wood",
                "stripped_pale_oak_log",     "stripped_pale_oak_wood",
                "pale_oak_planks",
                "pale_oak_slab",             "pale_oak_stairs",
                "pale_oak_fence",            "pale_oak_fence_gate",
                "pale_oak_door",             "pale_oak_trapdoor",
                "pale_oak_pressure_plate",   "pale_oak_button",
                "pale_oak_sign",             "pale_oak_hanging_sign",
                "pale_oak_leaves",           "pale_oak_sapling",
                // ---- Résine ----
                "resin_clump",
                "resin_block",
                "resin_bricks",
                "resin_brick_slab",          "resin_brick_stairs",        "resin_brick_wall",
                "chiseled_resin_bricks",
                // ---- Mousse pâle ----
                "pale_moss_block",
                "pale_moss_carpet",
                "pale_hanging_moss",
                // ---- Fleur ----
                "eyeblossom",
                "closed_eyeblossom",
                // ---- Divers ----
                "creaking_heart"
        );
    }

    // -------------------------------------------------------------------------

    private static void add(String version, String... blockIds) {
        for (String id : blockIds) {
            BLOCK_ADDED_IN.put("minecraft:" + id, version);
        }
    }

    public static boolean shouldShow(String blockId) {
        String addedIn = BLOCK_ADDED_IN.get(blockId);
        if (addedIn == null) return true;
        return VersionManager.isAvailableInSelectedVersion(addedIn);
    }
}