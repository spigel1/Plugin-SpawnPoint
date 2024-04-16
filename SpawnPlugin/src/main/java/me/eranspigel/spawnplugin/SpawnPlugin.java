package me.eranspigel.spawnplugin;

import me.eranspigel.spawnplugin.commands.SetSpawnCommand;
import me.eranspigel.spawnplugin.commands.SpawnCommand;
import me.eranspigel.spawnplugin.listners.SpawnListeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpawnPlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        //Setup/Load Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //register the commands
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));

        //register the events
        getServer().getPluginManager().registerEvents(new SpawnListeners(this), this);

    }

}