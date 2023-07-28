package at.avox.basicCommands.commands

import at.avox.basicCommands.util.MessageUtil.sendRedMessage
import at.avox.basicCommands.util.MessageUtil.sendGreenMessage
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class HealCmd: CommandExecutor{

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if(sender !is Player) {
            sender.sendRedMessage("You can't execute this command!")
            return false
        }

        sender.health = 20.0
        sender.saturation = 20.0f
        sender.foodLevel =  20

        sender.sendGreenMessage("You've been healed!")

        return true
    }

}
