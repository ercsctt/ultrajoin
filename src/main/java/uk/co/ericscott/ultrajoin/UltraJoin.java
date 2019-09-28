package uk.co.ericscott.ultrajoin;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import sun.security.krb5.Config;
import uk.co.ericscott.ultrajoin.commands.UltraJoinCommand;
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

    private boolean usingPapi;

    /**
     * List of commands to be loaded
     */
    private Object[] commands = {
        new UltraJoinCommand(this)
    };

    /**
     * List of listeners to be loaded
     */
    private Listener[] listeners = {
        new JoinListener(this)
    };

    /**
     * Log command, for quickly logging debug / messages to console
     *
     * @param message
     */
    public static void log(String message){
        instance.getServer().getLogger().info("[UltraJoin] " + message);
    }

    /**
     * Runs when the plugin is enabled
     */
    public void onEnable()
    {
        instance = this;

        this.configuration = new Configuration(this, "config");

        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null)
        {
            log("UltraJoin has loaded with PlaceholderAPI! You can use all PAPI placeholders in your UltraJoin messages!");

            usingPapi = true;
        }else
        {
            log("UltraJoin has loaded without PlaceholderAPI! For a better experience with UltraJoin, we recommend you install PlaceholderAPI:");
            log("-> https://www.spigotmc.org/resources/placeholderapi.6245/");

            usingPapi = false;
        }

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

    /**
     * Returns configuration
     *
     * @return Configuration
     */
    public Configuration getConfiguration()
    {
        return configuration;
    }

    /**
     * Returns commandframework
     *
     * @return CommandFramework
     */
    public CommandFramework getCommandFramework()
    {
        return commandFramework;
    }

    /**
     * Returns usingPapi
     *
     * @return boolean
     */
    public boolean isUsingPlaceholderAPI()
    {
        return usingPapi;
    }

}