package me.ava_l4nch.storage

import me.ava_l4nch.storage.customeCommands.HelloCommand
import me.ava_l4nch.storage.customeCommands.LoadCommand
import me.ava_l4nch.storage.customeCommands.StoreCommand
import org.bukkit.plugin.java.JavaPlugin

class Storage : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
        logger.info("Hello sssss!")
        registerCommands()
    }

    private fun registerCommands(){

        getCommand("hello")?.setExecutor(HelloCommand())
        getCommand("store")?.setExecutor(StoreCommand())
        getCommand("load")?.setExecutor(LoadCommand())
        logger.info("Commands registered.")
    }

    override fun onDisable() {
        // Plugin shutdown logic
        logger.info("shutting Down")
    }
}
