package store.aethra.scsetspawn.Listener;

import com.iridium.iridiumcolorapi.IridiumColorAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import store.aethra.scsetspawn.ScSetSpawn;

public class SpawnHandler implements Listener {

    private final ScSetSpawn plugin;

    public SpawnHandler(ScSetSpawn plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if(event.getPlayer().hasPlayedBefore()) {

            String spawnNotFound = IridiumColorAPI.process(plugin.getConfig().getString("settings.prefix")) + IridiumColorAPI.process(plugin.getConfig().getString("settings.spawnBulunamadıMesajı"));


            Location location = plugin.getConfig().getLocation("spawn");
            Player player = event.getPlayer();

            if(location != null) {
                player.teleport(location);
            } else {
                player.sendMessage(spawnNotFound);
                System.out.println(spawnNotFound);
            }
        }
    }

    @EventHandler
    public void onPlayerRespawned(PlayerRespawnEvent event) {
        Location location = plugin.getConfig().getLocation("spawn");

        if(location != null) {
            event.setRespawnLocation(location);
        }
    }

}
