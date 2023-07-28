package at.avox.basicCommands.commands

import at.avox.basicCommands.util.MessageUtil.sendRedMessage
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class CustomGameModeCmd : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (args == null || args.isEmpty()) {
            if (sender !is Player) {
                sender.sendRedMessage("You can't execute this command without at least two argument!")
                return true
            }
            if(sender.gameMode != GameMode.CREATIVE) {
                sender.gameMode = GameMode.CREATIVE
            } else {
                sender.gameMode = GameMode.SURVIVAL
            }
        } else if (args.size == 1) {
            if (sender !is Player) {
                sender.sendRedMessage("You can't execute this command without at least two argument!")
                return true
            }
            when(args[0]) {
                "0" -> sender.gameMode = GameMode.SURVIVAL
                "1" -> sender.gameMode = GameMode.CREATIVE
                "2" -> sender.gameMode = GameMode.ADVENTURE
                "3" -> sender.gameMode = GameMode.SPECTATOR
                else -> sender.sendRedMessage("Couldn't find gamemode ${args[0]}")
            }
        } else if (args.size == 2) {
            val player = Bukkit.getPlayer(args[1])
            if (player == null) {
                sender.sendRedMessage("The player '${args[1]}' couldn't be found!")
                return true
            }
            when(args[0]) {
                "0" -> player.gameMode = GameMode.SURVIVAL
                "1" -> player.gameMode = GameMode.CREATIVE
                "2" -> player.gameMode = GameMode.ADVENTURE
                "3" -> player.gameMode = GameMode.SPECTATOR
                else -> sender.sendRedMessage("Couldn't find gamemode ${args[0]}")
            }
        } else {
            sender.sendRedMessage("This command only takes a maximum of two arguments!")
        }
        return true
    }
}
