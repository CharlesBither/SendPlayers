package tech.secretgarden.sendplayers;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Sender {
    String warp = null;

    public Sender() {}

    public Sender(String warp) {
        this.warp = warp;
    }

    public void init(CommandSender sender, String serverName) {

        // check if sender is a player
        if (sender instanceof ProxiedPlayer) {

            // get player and server name
            ProxiedPlayer player = (ProxiedPlayer) sender;
            String currentServer = player.getServer().getInfo().getName();

            if (this.warp != null) {
                // send data to Bukkit
                sendData(player);
            }


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

    public void sendData(ProxiedPlayer player) {
        if (this.warp != null) {
            System.out.println("sending data");
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("send");
            out.writeUTF(player.getName());
            out.writeUTF("test,test2");

            player.getServer().getInfo().sendData("secret:garden", out.toByteArray());

            System.out.println("data sent");
        }
    }
}
