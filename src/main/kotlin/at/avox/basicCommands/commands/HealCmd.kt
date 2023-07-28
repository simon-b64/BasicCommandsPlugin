package at.avox.basicCommands.commands

import at.avox.basicCommands.util.MessageUtil.sendRedMessage
import at.avox.basicCommands.util.MessageUtil.sendGreenMessage
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class HealCmd : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (args == null || args.isEmpty()) {
            if (sender !is Player) {
                sender.sendRedMessage("You can't execute this command!")
                return true
            }
            sender.heal()
            sender.sendGreenMessage("You've been healed!")
        } else if (args.size == 1) {
            val player = Bukkit.getPlayer(args[0])
            if (player == null) {
                sender.sendRedMessage("The player '${args[0]}' couldn't be found!")
                return true
            }
            player.heal()
            sender.sendGreenMessage("The player ${player.name} has been healed!")
        } else {
            sender.sendRedMessage("This command only takes a maximum of one arguments!")
        }
        return true
    }

    private fun Player.heal() {
        this.health = MAX_PLAYER_HEALTH
        this.saturation = MAX_PLAYER_SATURATION
        this.foodLevel = MAX_PLAYER_FOOD_LEVEL
    }

    companion object {
        private const val MAX_PLAYER_HEALTH = 20.0
        private const val MAX_PLAYER_SATURATION = 20.0f
        private const val MAX_PLAYER_FOOD_LEVEL = 20
    }

}
