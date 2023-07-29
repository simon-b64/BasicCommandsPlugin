package at.avox.basicCommands

import at.avox.basicCommands.commands.CustomGameModeCmd
import at.avox.basicCommands.commands.EnderchestCommand
import at.avox.basicCommands.commands.HealCmd
import at.avox.basicCommands.commands.RepairCommand
import at.avox.basicCommands.eventListeners.PlayerDeathListener
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import java.util.logging.Level
import java.util.logging.LogRecord

class BasicCommandsPlugin: JavaPlugin() {

    override fun onEnable() {
        Bukkit.getLogger().log(LogRecord(Level.INFO, "BasicCommands has successfully enabled"))
        registerEventHandlers()
        registerCommands()
    }

    private fun registerCommands() {
        this.getCommand("heal")?.setExecutor(HealCmd())
        this.getCommand("gm")?.setExecutor(CustomGameModeCmd())
        this.getCommand("ec")?.setExecutor(EnderchestCommand())
        this.getCommand("repair")?.setExecutor(RepairCommand())
    }

    private fun registerEventHandlers() {
        server.pluginManager.registerEvents(PlayerDeathListener(), this)
    }
}
