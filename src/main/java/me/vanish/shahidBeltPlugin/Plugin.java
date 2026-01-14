package me.vanish.shahidBeltPlugin;

import me.vanish.shahidBeltPlugin.command.ShahidBeltGiveCMD;
import me.vanish.shahidBeltPlugin.command.createExplosionCMD;
import me.vanish.shahidBeltPlugin.utils.ConfigManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {

    public static Plugin instance;

    public static Plugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;


        ConfigManager.instance.init("messages");
        getCommand("createexplsion").setExecutor(new createExplosionCMD());
        getCommand("shahidbelt").setExecutor(new ShahidBeltGiveCMD());
        saveDefaultConfig();

    }

}
