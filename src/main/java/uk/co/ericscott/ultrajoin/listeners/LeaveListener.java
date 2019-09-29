package uk.co.ericscott.ultrajoin.listeners;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import uk.co.ericscott.ultrajoin.UltraJoin;

public class LeaveListener implements Listener
{

    private UltraJoin instance;

    public LeaveListener(UltraJoin instance){
        this.instance = instance;
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event){
        Player player = event.getPlayer();

        handleLeave(player, event);
    }

    /**
     * Called when the player leaves
     *
     * @param event
     */
    private void handleLeave(Player player, PlayerQuitEvent event)
    {
        if(instance.getConfiguration().getBoolean("leave.enabled"))
        {
            String leaveMessage = this.instance.getConfiguration().translateString("leave.message");

            if(instance.isUsingPlaceholderAPI())
            {
                leaveMessage = PlaceholderAPI.setPlaceholders(
                        player,
                        leaveMessage
                );
            }

            leaveMessage = leaveMessage
                    .replace("{player}", player.getName())
                    .replace("{displayname}", player.getDisplayName());

            if(leaveMessage.isEmpty())
            {
                leaveMessage = null;
            }

            event.setQuitMessage(leaveMessage);
        }
    }

}
