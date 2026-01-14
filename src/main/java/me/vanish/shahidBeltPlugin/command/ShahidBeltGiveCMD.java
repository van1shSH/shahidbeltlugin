package me.vanish.shahidBeltPlugin.command;

import me.vanish.shahidBeltPlugin.ShahidBelt.Belt;
import me.vanish.shahidBeltPlugin.ShahidBelt.ShahidBelt;
import me.vanish.shahidBeltPlugin.utils.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

public class ShahidBeltGiveCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NonNull @NotNull String[] args) {
        Player player = (Player) sender;
        if(args.length != 1) {
            ChatUtil.sendConfigMessage(player, "messages.usage");
            return true;
        }
        long timer;
        try {
            timer = Long.parseLong(args[0]);
        } catch (NumberFormatException e) {
            ChatUtil.sendConfigMessage(player, "messages.invalid-time");
            return true;
        }

        if(timer <= 0) {
            ChatUtil.sendConfigMessage(player, "messages.time-greater");
            return true;
        }

        Belt shahid = new Belt(player, timer);




        return true;
    }
}
