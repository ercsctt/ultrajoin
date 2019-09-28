package uk.co.ericscott.ultrajoin.listeners;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import uk.co.ericscott.ultrajoin.UltraJoin;

public class JoinListener implements Listener
{

    private UltraJoin instance;

    public JoinListener(UltraJoin instance){
        this.instance = instance;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        if(player.hasPlayedBefore()){
            handleJoin(player, event);
        }else{
            if(instance.getConfiguration().getBoolean("first-join.enabled")){
                handleFirstJoin(player, event);
            }else{
                handleJoin(player, event);
            }
        }
    }

    /**
     * Called when the player joins (not for the first time)
     *
     * @param event
     */
    private void handleJoin(Player player, PlayerJoinEvent event)
    {
        if(instance.getConfiguration().getBoolean("join.enabled"))
        {
            String joinMessage = this.instance.getConfiguration().translateString("join.message");

            if(instance.isUsingPlaceholderAPI())
            {
                joinMessage = PlaceholderAPI.setPlaceholders(
                        player,
                        joinMessage
                );
            }

            joinMessage = joinMessage
                    .replace("{player}", player.getName())
                    .replace("{displayname}", player.getDisplayName());

            event.setJoinMessage(joinMessage);
        }
    }

    /**
     * Called when the player has joined for the first time
     *
     * @param player
     * @param event
     */
    private void handleFirstJoin(Player player, PlayerJoinEvent event)
    {
        String joinMessage = this.instance.getConfiguration().translateString("first-join.message");

        if(instance.isUsingPlaceholderAPI())
        {
            joinMessage = PlaceholderAPI.setPlaceholders(
                    player,
                    joinMessage
            );
        }

        joinMessage = joinMessage
                .replace("{player}", player.getName())
                .replace("{displayname}", player.getDisplayName());

        event.setJoinMessage(joinMessage);
    }

}
