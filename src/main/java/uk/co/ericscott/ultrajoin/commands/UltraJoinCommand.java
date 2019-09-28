package uk.co.ericscott.ultrajoin.commands;

import uk.co.ericscott.ultrajoin.UltraJoin;
import uk.co.ericscott.ultralibs.commands.Command;
import uk.co.ericscott.ultralibs.commands.CommandArgs;
import uk.co.ericscott.ultralibs.commands.Completer;
import uk.co.ericscott.ultralibs.utils.ChatUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UltraJoinCommand
{

    private UltraJoin instance;

    /**
     * Help message to send player
     */
    private String[] message = {
        "&8&m----------------------------------------------",
        "&6&lUltraJoin v1.0",
        "&7Created by &eericscott.co.uk",
        "&e&nhttps://www.spigotmc.org/members/esshd.22642/",
        "&e ",
        "&7Commands:",
        "&7 - &e/ultrajoin reload&7 (Reloads UltraJoin config)",
        "&8&m----------------------------------------------"
    };

    public UltraJoinCommand(UltraJoin instance)
    {
        this.instance = instance;
    }

    /**
     * UltraJoin base command
     *
     * @param commandArgs
     */
    @Command(
            name = "ultrajoin",
            aliases = { "uj" },
            description = "UltraJoin command",
            usage = "/ultrajoin"
    )
    public void ultraJoinCommand(CommandArgs commandArgs)
    {
        Arrays.stream(message).forEach(line ->
            commandArgs.getSender().sendMessage(ChatUtils.translate(line))
        );
    }

    /**
     * /ultrajoin command completer, completes subcommands in this case
     *
     * @param args
     * @return
     */
    @Completer(
            name = "ultrajoin",
            aliases = { "uj" }
    )
    public List<String> ultraJoinCommandCompleter(CommandArgs args){
        return Collections.singletonList("reload");
    }

    /**
     * UltraJoin reload config command
     *
     * @param commandArgs
     */
    @Command(
            name = "ultrajoin.reload",
            aliases = { "uj.reload" },
            description = "Reload UltraJoin configuration file",
            usage = "/ultrajoin reload",
            permission = "ultrajoin.reload"
    )
    public void ultraJoinReload(CommandArgs commandArgs)
    {
        this.instance.getConfiguration().reload();
        commandArgs.getSender().sendMessage(ChatUtils.translate("&aUltraJoin has been reloaded!"));
    }

}
