package tech.secretgarden.sendplayers.Commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import tech.secretgarden.sendplayers.Sender;

import java.util.ArrayList;
import java.util.List;

public class SGServer extends Command {

    String[] survivalList = {"crates", "lobby", "spawn", "hub"};

    String serverName = null;

    public SGServer(String name, String... aliases) {
        super(name, null, aliases);
        if (name.equalsIgnoreCase("lobby")) {
            this.serverName = super.getName();
        }
    }

    public SGServer(String name) {
        super(name);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Sender s;
        if (args.length > 0) {
            this.serverName = getServerName(args[0]);
            s = new Sender(args[0]);
        } else {
            s = new Sender();
        }
        s.init(sender, this.serverName);
    }

    public String getServerName(String location) {
        if (location.equalsIgnoreCase("creative")) {
            return "creative";
        } else if (location.equalsIgnoreCase("skyblock")) {
            return "skyblock";
        } else {
            for (String warp : this.survivalList) {
                if (warp.equalsIgnoreCase(location)) {
                    return "lobby";
                }
            }
        }
        return null;
    }
}
