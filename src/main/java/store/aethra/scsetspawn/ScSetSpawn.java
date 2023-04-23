package store.aethra.scsetspawn;

import com.iridium.iridiumcolorapi.IridiumColorAPI;
import org.bukkit.plugin.java.JavaPlugin;
import store.aethra.scsetspawn.Listener.SetSpawn;
import store.aethra.scsetspawn.Listener.Spawn;
import store.aethra.scsetspawn.Listener.SpawnHandler;

public final class ScSetSpawn extends JavaPlugin {

    @Override
    public void onEnable() {

        System.out.println("Eklenti Başlatılıyor");

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("setspawn").setExecutor(new SetSpawn(this));
        getCommand("spawn").setExecutor(new Spawn(this));
        getServer().getPluginManager().registerEvents(new SpawnHandler(this), this);

    }

    @Override
    public void onDisable() {
        System.out.println("Eklenti Kapatılıyor");
    }
}
