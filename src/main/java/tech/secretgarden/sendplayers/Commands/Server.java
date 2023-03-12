package tech.secretgarden.sendplayers.Commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import tech.secretgarden.sendplayers.Sender;

public class Server extends Command {

    public Server(String name, String permission, String... aliases) {
        super(name, permission, aliases);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Sender s = new Sender();
        String name = super.getName();
        s.init(sender, name);
    }
}
