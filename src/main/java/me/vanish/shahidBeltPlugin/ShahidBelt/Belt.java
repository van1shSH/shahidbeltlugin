package me.vanish.shahidBeltPlugin.ShahidBelt;

import me.vanish.shahidBeltPlugin.Plugin;
import me.vanish.shahidBeltPlugin.utils.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;

public class Belt {


    private Player player;
    private long timer;
    Map<String, String> arg = new HashMap<>();
    Map<String, String> givenArg = new HashMap<>();

    public Belt(Player player, long timer) {
        this.player = player;
        this.timer = timer;
        startCountdown();
        givenArg.put("%time%", String.valueOf(timer));
        ChatUtil.sendConfigMessage(player, "messages.belt-given", givenArg);

    }

    public Player getPlayer() {
        return player;
    }

    public long getTimer() {
        return timer;
    }

    private void startCountdown() {
        new BukkitRunnable(){
            long timeLeft = timer;


            @Override
            public void run() {

                arg.put("%time%", String.valueOf(timeLeft));
                if (timeLeft <= 0) {
                    ShahidBelt.createExplosion(player, 4.0f);
                    cancel();
                }else if(timeLeft == 1) {
                    ChatUtil.sendConfigTitle(player, "titles.timer", "", arg);
                    player.playSound(player.getLocation(), Plugin.getInstance().getConfig().getString("boom.sound.name"), 1.0f, 1.0f);
                    timeLeft--;
                } else {
                    ChatUtil.sendConfigTitle(player, "titles.timer", "", arg);
                    timeLeft--;
                }
            }
        }.runTaskTimer(Plugin.instance, 0L, 20L);
    }



}
