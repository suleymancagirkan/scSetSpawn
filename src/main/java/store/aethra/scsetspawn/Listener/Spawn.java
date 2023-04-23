package store.aethra.scsetspawn.Listener;

import com.iridium.iridiumcolorapi.IridiumColorAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import store.aethra.scsetspawn.ScSetSpawn;

public class Spawn implements CommandExecutor {

    private final ScSetSpawn plugin;

    public Spawn(ScSetSpawn plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String teleportedMessage = IridiumColorAPI.process(plugin.getConfig().getString("settings.prefix")) + IridiumColorAPI.process(plugin.getConfig().getString("settings.ısınlanıldıMesajı"));
        String spawnNotFound = IridiumColorAPI.process(plugin.getConfig().getString("settings.prefix")) + IridiumColorAPI.process(plugin.getConfig().getString("settings.spawnBulunamadıMesajı"));

        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location location = plugin.getConfig().getLocation("spawn");

            if(location != null) {
                player.teleport(location);
                player.sendMessage(teleportedMessage);
            } else {
                player.sendMessage(spawnNotFound);
                System.out.println(spawnNotFound);
            }
        } else {
            System.out.println("Bilinmeyen hata!");
        }
        return true;
    }


}
