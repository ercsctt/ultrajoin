package uk.co.ericscott.ultrajoin;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import uk.co.ericscott.ultrajoin.listeners.JoinListener;
import uk.co.ericscott.ultralibs.commands.CommandFramework;
import uk.co.ericscott.ultralibs.config.Configuration;

import java.util.Arrays;

/**
 * Main class for UltraJoin
 */
public class UltraJoin extends JavaPlugin
{

    private static UltraJoin instance;

    private Configuration configuration;

    private CommandFramework commandFramework;

    /**
     * List of commands to be loaded
     */
    private Object[] commands = {
    };

    /**
     * List of listeners to be loaded
     */
    private Listener[] listeners = {
        new JoinListener(this)
    };

    /**
     * Runs when the plugin is enabled
     */
    public void onEnable()
    {
        instance = this;

        this.configuration = new Configuration(this, "config");

        loadListeners();
        loadCommands();
    }

    /**
     * Runs when the plugin is disabled / unloaded
     */
    public void onDisable()
    {
        instance = null;
    }

    /**
     * Loads listeners
     */
    private void loadListeners()
    {
        Arrays.stream(listeners).forEach(listener ->
                getServer().getPluginManager().registerEvents(listener, this)
        );
    }

    /**
     * Initialises CommandFramework and registers commands
     */
    private void loadCommands()
    {
        this.commandFramework = new CommandFramework(this);

        Arrays.stream(commands).forEach(command ->
                this.commandFramework.registerCommands(command)
        );

        this.commandFramework.registerHelp();
    }

    /**
     * Returns instance
     *
     * @return UltraJoin
     */
    public UltraJoin getInstance()
    {
         return instance;
    }

}
