package ian.tomaz.ethernalcrates.events;

import ian.tomaz.ethernalcrates.EthernalCrates;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class ClickBlockEvent implements Listener {
    private boolean debounce = false;

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack item = e.getItem();

        assert item != null;
        if (item.getType() == Material.BOOK) {
            if (item.hasItemMeta()) {
                if (item.getItemMeta().hasCustomModelData()) {
                    int customData = item.getItemMeta().getCustomModelData();

                    if (customData == 102) {
                        if (!debounce) {
                            debounce = true;
                            String sorted = sortMob(player);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " permission set " + sorted);
                            player.sendMessage(EthernalCrates.pluginTag + " O Pet sorteado foi: " + EthernalCrates.permsHash.get(sorted));

                            debounce = false;
                        }
                    }
                }
            }
        }





    }


    private String sortMob(Player player) {
        int sort = new Random().nextInt(EthernalCrates.permissions.size());
        return EthernalCrates.permissions.get(sort);
    }






}
