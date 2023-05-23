package ian.tomaz.ethernalcrates.commands;

import ian.tomaz.ethernalcrates.EthernalCrates;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class OpenStation implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            String station = args[0];

            if (player.hasPermission("ethernal.admin")) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mi stations open " + station + " " + player.getName());
            } else {
                player.sendMessage(EthernalCrates.pluginTag + " Você não tem permissão para executar esse comando!");
            }

        }

        return false;
    }

}
