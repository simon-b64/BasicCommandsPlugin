package at.avox.basicCommands.commands

import at.avox.basicCommands.util.MessageUtil.sendRedMessage
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.meta.Damageable

class RepairCommand: CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>?): Boolean {
        if (sender !is Player) {
            sender.sendRedMessage("You can't execute this command!")
            return true
        }

        if (args != null && args.isNotEmpty()) {
            sender.sendRedMessage("This command doesn't take arguments!")
            return true
        }

        sender.inventory.itemInMainHand.editMeta {
            if(it is Damageable) {
                it.damage = 0
            }
        }

        return true
    }
}
