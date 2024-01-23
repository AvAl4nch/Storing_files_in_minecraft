package me.ava_l4nch.storage.customeCommands

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class StoreCommand : CommandExecutor {

    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if (sender is Player) {
            if (sender.isOp) {
                if (args.size < 4) {
                    sender.sendMessage(ChatColor.RED.toString() + "Usage: /store <X> <y> <z> <path>")
                    return true
                }

                val filePath = args[3]
                val fileBytes = me.ava_l4nch.storage.readFileAsBytes(filePath)

                try {
                    val x = args[0].toDouble()
                    val y = args[1].toDouble()
                    val z = args[2].toDouble()
                    val slotSize = 32
                    var c = 0

                    val blocks = listOf(
                        "acacia_leaves",
                        "acacia_log",
                        "acacia_planks",
                        "acacia_wood",
                        "amethyst_block",
                        "ancient_debris",
                        "andesite",
                        "azalea_leaves",
                        "barrel",
                        "basalt",
                        "bedrock",
                        "birch_leaves",
                        "birch_log",
                        "birch_planks",
                        "birch_wood",
                        "black_concrete",
                        "black_glazed_terracotta",
                        "black_stained_glass",
                        "blackstone",
                        "black_terracotta",
                        "black_wool",
                        "blue_concrete",
                        "blue_glazed_terracotta",
                        "blue_stained_glass",
                        "blue_terracotta",
                        "blue_wool",
                        "bone_block",
                        "bookshelf",
                        "bricks",
                        "brown_concrete",
                        "brown_glazed_terracotta",
                        "brown_mushroom_block",
                        "brown_stained_glass",
                        "brown_terracotta",
                        "brown_wool",
                        "calcite",
                        "chiseled_deepslate",
                        "chiseled_nether_bricks",
                        "chiseled_polished_blackstone",
                        "chiseled_quartz_block",
                        "chiseled_red_sandstone",
                        "chiseled_sandstone",
                        "chiseled_stone_bricks",
                        "coal_block",
                        "coal_ore",
                        "coarse_dirt",
                        "cobbled_deepslate",
                        "cobblestone",
                        "copper_ore",
                        "cracked_deepslate_bricks",
                        "cracked_deepslate_tiles",
                        "cracked_nether_bricks",
                        "cracked_polished_blackstone_bricks",
                        "cracked_stone_bricks",
                        "crimson_hyphae",
                        "crimson_planks",
                        "crimson_stem",
                        "crying_obsidian",
                        "cyan_concrete",
                        "cyan_glazed_terracotta",
                        "cyan_stained_glass",
                        "cyan_terracotta",
                        "cyan_wool",
                        "dark_oak_leaves",
                        "dark_oak_log",
                        "dark_oak_planks",
                        "dark_oak_wood",
                        "dark_prismarine",
                        "deepslate",
                        "deepslate_bricks",
                        "deepslate_coal_ore",
                        "deepslate_copper_ore",
                        "deepslate_diamond_ore",
                        "deepslate_emerald_ore",
                        "deepslate_gold_ore",
                        "deepslate_iron_ore",
                        "deepslate_lapis_ore",
                        "deepslate_redstone_ore",
                        "deepslate_tiles",
                        "diamond_block",
                        "diamond_ore",
                        "diorite",
                        "dirt",
                        "dried_kelp_block",
                        "emerald_block",
                        "emerald_ore",
                        "end_stone",
                        "end_stone_bricks",
                        "flowering_azalea_leaves",
                        "gilded_blackstone",
                        "glass",
                        "glowstone",
                        "gold_block",
                        "gold_ore",
                        "granite",
                        "grass_block",
                        "gray_concrete",
                        "gray_glazed_terracotta",
                        "gray_stained_glass",
                        "gray_terracotta",
                        "gray_wool",
                        "green_concrete",
                        "green_glazed_terracotta",
                        "green_stained_glass",
                        "green_terracotta",
                        "green_wool",
                        "hay_block",
                        "honeycomb_block",
                        "iron_block",
                        "iron_ore",
                        "jack_o_lantern",
                        "jungle_leaves",
                        "jungle_log",
                        "jungle_planks",
                        "jungle_wood",
                        "lapis_block",
                        "lapis_ore",
                        "light_blue_concrete",
                        "light_blue_glazed_terracotta",
                        "light_blue_stained_glass",
                        "light_blue_terracotta",
                        "light_blue_wool",
                        "light_gray_concrete",
                        "light_gray_glazed_terracotta",
                        "light_gray_stained_glass",
                        "light_gray_terracotta",
                        "light_gray_wool",
                        "lime_concrete",
                        "lime_glazed_terracotta",
                        "lime_stained_glass",
                        "lime_terracotta",
                        "lime_wool",
                        "lodestone",
                        "magenta_concrete",
                        "magenta_glazed_terracotta",
                        "magenta_stained_glass",
                        "magenta_terracotta",
                        "magenta_wool",
                        "magma_block",
                        "moss_block",
                        "mossy_cobblestone",
                        "mossy_stone_bricks",
                        "nether_bricks",
                        "nether_gold_ore",
                        "netherite_block",
                        "nether_quartz_ore",
                        "netherrack",
                        "nether_wart_block",
                        "oak_leaves",
                        "oak_log",
                        "oak_planks",
                        "oak_wood",
                        "obsidian",
                        "orange_concrete",
                        "orange_glazed_terracotta",
                        "orange_stained_glass",
                        "orange_terracotta",
                        "orange_wool",
                        "pink_concrete",
                        "pink_glazed_terracotta",
                        "pink_stained_glass",
                        "pink_terracotta",
                        "polished_andesite",
                        "polished_basalt",
                        "polished_blackstone",
                        "polished_blackstone_bricks",
                        "polished_deepslate",
                        "polished_diorite",
                        "polished_granite",
                        "prismarine_bricks",
                        "pumpkin",
                        "purple_concrete",
                        "purple_glazed_terracotta",
                        "purple_stained_glass",
                        "purple_terracotta",
                        "purple_wool",
                        "purpur_block",
                        "quartz_block",
                        "quartz_bricks",
                        "quartz_pillar",
                        "raw_copper_block",
                        "raw_gold_block",
                        "raw_iron_block",
                        "red_concrete",
                        "red_glazed_terracotta",
                        "red_mushroom_block",
                        "red_nether_bricks",
                        "red_sandstone",
                        "red_stained_glass",
                        "redstone_lamp",
                        "redstone_ore",
                        "red_terracotta",
                        "red_wool",
                        "sandstone",
                        "sea_lantern",
                        "shroomlight",
                        "smooth_quartz",
                        "smooth_red_sandstone",
                        "smooth_sandstone",
                        "smooth_stone",
                        "snow_block",
                        "sponge",
                        "spruce_leaves",
                        "spruce_log",
                        "spruce_planks",
                        "spruce_wood",
                        "stone",
                        "stone_bricks",
                        "stripped_acacia_log",
                        "stripped_acacia_wood",
                        "stripped_birch_log",
                        "stripped_birch_wood",
                        "stripped_crimson_hyphae",
                        "stripped_crimson_stem",
                        "stripped_dark_oak_log",
                        "stripped_dark_oak_wood",
                        "stripped_jungle_log",
                        "stripped_jungle_wood",
                        "stripped_oak_log",
                        "stripped_oak_wood",
                        "stripped_spruce_log",
                        "stripped_spruce_wood",
                        "stripped_warped_hyphae",
                        "stripped_warped_stem",
                        "target",
                        "terracotta",
                        "tinted_glass",
                        "tuff",
                        "warped_hyphae",
                        "warped_planks",
                        "warped_stem",
                        "warped_wart_block",
                        "white_concrete",
                        "white_glazed_terracotta",
                        "white_stained_glass",
                        "white_terracotta",
                        "white_wool",
                        "yellow_concrete",
                        "yellow_glazed_terracotta",
                        "yellow_stained_glass",
                        "yellow_terracotta",
                        "yellow_wool",
                        "crafting_table",
                        "fletching_table",
                        "smithing_table",
                        "cartography_table",
                        "blast_furnace",
                        "furnace",
                        "smoker",
                        "slime_block",
                        "honey_block",
                        "mycelium",
                        "beacon",
                        "black_shulker_box",
                        "blue_shulker_box",
                        "brown_shulker_box"
                    )

                    sender.sendMessage("build started...")
                    if (fileBytes != null) {
                        sender.sendMessage("${fileBytes.size}")
                    }

                    for (si in 0 until 50) {
                        for (ix in 0 until slotSize) {
                            for (yi in 0 until slotSize) {
                                for (zi in 0 until slotSize) {
                                    if (c < (fileBytes?.size ?: 0)) {
                                        val blockIndex = fileBytes!![c].toInt() + 128
                                        val location = sender.world.getBlockAt(
                                            (x + ix + si * slotSize).toInt(),
                                            (y + yi).toInt(),
                                            (z + zi).toInt()
                                        ).location

                                        if (blockIndex in 0 until blocks.size) {
                                            val blockType = blocks[blockIndex].uppercase()
                                            location.block.type = Material.getMaterial(blockType) ?: Material.STONE
                                        } else {
                                            sender.sendMessage(
                                                ChatColor.RED.toString() + "Invalid block index: $blockIndex"
                                            )
                                            return true
                                        }
                                    } else {
                                        sender.sendMessage(
                                            ChatColor.GREEN.toString() + "Done :)"
                                        )
                                        return true
                                    }
                                    c++
                                }
                            }
                        }
                    }
                } catch (e: NumberFormatException) {
                    sender.sendMessage(ChatColor.RED.toString() + "Invalid coordinates provided.")
                    return true
                }
            }
        }
        return false
    }
}



