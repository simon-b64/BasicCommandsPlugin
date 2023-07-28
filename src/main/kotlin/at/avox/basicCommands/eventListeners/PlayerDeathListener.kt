package at.avox.basicCommands.eventListeners

import at.avox.basicCommands.util.MessageUtil.sendRedMessage
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent

class PlayerDeathListener: Listener{

     @EventHandler
     fun onPlayerDeath(event: PlayerDeathEvent) {
         val location = event.player.location
         event.player.sendRedMessage(
             "You've died at X:${location.blockX} Y:${location.blockY} Z:${location.blockZ}"
         )
     }

}
