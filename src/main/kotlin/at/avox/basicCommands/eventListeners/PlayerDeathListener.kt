package at.avox.basicCommands.eventListeners

import at.avox.basicCommands.util.MessageUtil.sendRedMessage
import org.bukkit.Material
import org.bukkit.block.Chest
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent

class PlayerDeathListener : Listener {

    @EventHandler
    fun onPlayerDeath(event: PlayerDeathEvent) {
        val location = event.player.location

        if (!event.player.inventory.isEmpty) {
            while (location.block.type != Material.AIR) {
                location.add(0.0, 1.0, 0.0)
            }
            location.block.type = Material.CHEST
            var chest = (location.block.state as Chest)
            event.player.inventory.contents.filterNotNull().forEach {
                if (chest.inventory.contents.none { itemStack -> itemStack == null }) {
                    location.add(0.0, 1.0, 0.0).block.type = Material.CHEST
                    chest = location.block.state as Chest
                }
                chest.inventory.addItem(it)
            }
            event.drops.clear()
        }

        event.player.sendRedMessage(
            "Your death chest is at X:${location.blockX} Y:${location.blockY} Z:${location.blockZ}"
        )
    }

}
