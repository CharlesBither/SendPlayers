package tech.secretgarden.sendplayers;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Sender {
    public void init(CommandSender sender, String serverName) {
        // check if sender is a player
        if (sender instanceof ProxiedPlayer) {

            // get player and server name
            ProxiedPlayer player = (ProxiedPlayer) sender;
            String currentServer = player.getServer().getInfo().getName();

            // handle already in server
            if (currentServer.equalsIgnoreCase(serverName)) {
                player.sendMessage(new ComponentBuilder("You are already in the " + serverName + " server!").color(ChatColor.RED).create());
            } else {
                // send player to lobby
                player.sendMessage(new ComponentBuilder("Connecting you to the " + serverName + " server").color(ChatColor.RED).create());
                player.connect(ProxyServer.getInstance().getServerInfo(serverName));
            }

        } else {
            // command sent from console
            System.out.println("You must be a player to use this command");
        }
    }
}
