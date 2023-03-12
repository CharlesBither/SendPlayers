package tech.secretgarden.sendplayers;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import tech.secretgarden.sendplayers.Commands.Server;

public final class SendPlayers extends Plugin {

    @Override
    public void onEnable() {
        System.out.println("Hello World!");

        String[] lobbyAliases = {"hub"};
        String[] creativeAliases = {"plot"};
        String[] survivalAliases = {"smp"};
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Server("lobby", null, lobbyAliases));
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Server("creative", null, creativeAliases));
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new Server("survival", null, creativeAliases));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
