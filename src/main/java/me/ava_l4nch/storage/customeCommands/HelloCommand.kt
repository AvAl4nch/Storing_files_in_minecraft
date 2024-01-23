package me.ava_l4nch.storage.customeCommands

import net.kyori.adventure.text.Component
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.util.Vector

class HelloCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, lable: String, args: Array<out String>?): Boolean {
        if(sender is Player){
            if(sender.isOp){
                if (args != null && args.isNotEmpty()) {
                        val z = args[0].toDouble()
                        sender.sendMessage(Component.text("Hello"))
                        sender.velocity = sender.velocity.add(Vector(0.0, z, 0.0))
                        return true
                }
            }
        }
        return false
    }
}