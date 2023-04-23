package store.aethra.scsetspawn.Listener;

import com.iridium.iridiumcolorapi.IridiumColorAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import store.aethra.scsetspawn.ScSetSpawn;

public class SetSpawn implements CommandExecutor {

    private final ScSetSpawn spawnplugin;

    public SetSpawn(ScSetSpawn spawnplugin) {
        this.spawnplugin = spawnplugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        FileConfiguration config = spawnplugin.getConfig();
        String settedMessage = IridiumColorAPI.process(spawnplugin.getConfig().getString("settings.prefix")) + IridiumColorAPI.process(spawnplugin.getConfig().getString("settings.ayarlandıMesajı"));
        String reloadedConfig = IridiumColorAPI.process(spawnplugin.getConfig().getString("settings.prefix")) + IridiumColorAPI.process(spawnplugin.getConfig().getString("settings.configYenilendi"));
        Player player = (Player) sender;
        if (sender instanceof Player) {



        }

        if(args.length == 0) {
            player.sendMessage(settedMessage);
            Location location = player.getLocation();

            spawnplugin.getConfig().set("spawn", location);

            spawnplugin.saveConfig();
        } else if(args[0].equalsIgnoreCase("reload")) {
            spawnplugin.saveConfig();
            spawnplugin.reloadConfig();
            player.sendMessage(reloadedConfig);
        }

        return true;
    }
}
