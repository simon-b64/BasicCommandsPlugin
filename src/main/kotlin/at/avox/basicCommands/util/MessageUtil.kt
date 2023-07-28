package at.avox.basicCommands.util

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.NamedTextColor
import org.bukkit.command.CommandSender

object MessageUtil {

    val MESSAGE_PREFIX = Component.text("[BC] ")

    fun CommandSender.sendGreenMessage(message: String) {
        this.sendMessage(
            MESSAGE_PREFIX.append(Component.text(message, NamedTextColor.GREEN))
        )
    }

    fun CommandSender.sendRedMessage(message: String) {
        this.sendMessage(
            MESSAGE_PREFIX.append(Component.text(message, NamedTextColor.RED))
        )
    }

}
