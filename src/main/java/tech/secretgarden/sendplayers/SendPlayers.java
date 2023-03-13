package tech.secretgarden.sendplayers;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import tech.secretgarden.sendplayers.Commands.SGServer;

public final class SendPlayers extends Plugin {

    @Override
    public void onEnable() {
        System.out.println("Hello World!");

        getProxy().registerChannel("secret:garden");

        String[] lobbyAliases = {"hub"};
        String[] creativeAliases = {"plot"};
        String[] survivalAliases = {"smp"};
        String[] testAliases = {"test1"};
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new SGServer("lobby", lobbyAliases));
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new SGServer("warp"));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
