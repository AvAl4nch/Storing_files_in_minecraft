package me.ava_l4nch.storage.customeCommands

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class LoadCommand : CommandExecutor {
    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {
        if (sender is Player) {
            if (sender.isOp) {
                if (args.size < 3) {
                    sender.sendMessage(ChatColor.RED.toString() + "Usage: /load <x> <y> <z>")
                    return true
                }

                try {
                    var x = args?.get(0)?.toDouble() ?: return false
                    var y = args?.get(1)?.toDouble() ?: return false
                    var z = args?.get(2)?.toDouble() ?: return false
                    val slot_size = 32
                    val blocks = mutableListOf<String>()
                    var c = 0

                    for (ix in 0 until slot_size) {
                        for (zi in 0 until slot_size) {
                            for (yi in 0 until slot_size) {
                                val blockType = sender.world.getBlockAt((x + ix).toInt(), (y + yi).toInt(), (z + zi).toInt()).type
                                blocks.add(blockType.toString().lowercase())
                            }
                        }
                    }

                    sender.sendMessage(ChatColor.RED.toString() + "loaded the things ...........")

                    x = 120.0
                    y = 120.0
                    z = 120.0


                    for (ix in 0 until slot_size) {
                        for (zi in 0 until slot_size){
                            for (yi in 0 until slot_size){
                                val location = sender.world.getBlockAt((x + ix).toInt(), (y + yi).toInt(), (z + zi).toInt()).location
                                location.block.type = blocks[c%256].uppercase().let { Material.getMaterial(it) } ?: run {
                                    sender.sendMessage(ChatColor.RED.toString() + "Invalid block type: $blocks[c].uppercase()")
                                    return true
                                }
                                c++
                            }
                        }

                    }






                    return true

                } catch (e: NumberFormatException) {
                    sender.sendMessage(ChatColor.RED.toString() + "Invalid coordinates provided.")
                    return true
                }
            }
        }
        return true
    }
}