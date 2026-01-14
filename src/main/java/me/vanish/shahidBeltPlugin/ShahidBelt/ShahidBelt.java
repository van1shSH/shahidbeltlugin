package me.vanish.shahidBeltPlugin.ShahidBelt;

import org.bukkit.entity.Player;

public class ShahidBelt {

    private static ShahidBelt instance = new ShahidBelt();


    public static ShahidBelt getInstance() {
        return instance;
    }


    public static void createExplosion(Player player, float power) {
        player.getWorld().createExplosion(player.getLocation(), power, false, true);
        player.damage(1000.0);

    }





}
