package ian.tomaz.ethernalcrates;

import ian.tomaz.ethernalcrates.commands.OpenStation;
import ian.tomaz.ethernalcrates.commands.SetPermissionByItem;
import ian.tomaz.ethernalcrates.events.ClickBlockEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class EthernalCrates extends JavaPlugin {

    public static List<String> permissions = Arrays.asList("mcpets.voras", "mcpets.vorasred", "mcpets.vorasteal", "mcpets.voraswhite", "mcpets.direwolftaiga", "mcpets.direwolfdesert", "mcpets.direwolf",
            "mcpets.giantturtleroyal", "mcpets.giantturtle", "mcpets.anubisdark", "mcpets.anubis", "mcpets.skog", "mcpets.rot");

    public static HashMap<String, String> permsHash = new HashMap<>();

    public static String pluginTag = ChatColor.GRAY+"["+ ChatColor.AQUA +"Ethernal" +ChatColor.GRAY+"]";

    @Override
    public void onEnable() {
        hashRegister();
        getCommand("ethernalp").setExecutor(new SetPermissionByItem());
        getCommand("ethernalstation").setExecutor(new OpenStation());
        Bukkit.getPluginManager().registerEvents(new ClickBlockEvent(), this);
    }

    @Override
    public void onDisable() {

    }

    private void hashRegister() {
        permsHash.put("mcpets.voras", "Voras");
        permsHash.put("mcpets.vorasred", "Voras Vermelho");
        permsHash.put("mcpets.vorasteal", "Voras Prata");
        permsHash.put("mcpets.voraswhite", "Voras Branca");
        permsHash.put("mcpets.direwolftaiga", "Lobo da Taiga");
        permsHash.put("mcpets.direwolfdesert", "Lobo do Deserto");
        permsHash.put("mcpets.direwolf", "Lobo");
        permsHash.put("mcpets.giantturtleroyal", "Tartaruga Gigante Real");
        permsHash.put("mcpets.giantturtle", "Tartaruga Gigante");
        permsHash.put("mcpets.anubisdark", "Anubis Sombrio");
        permsHash.put("mcpets.anubis", "Anubis");
        permsHash.put("mcpets.skog", "Skog");
        permsHash.put("mcpets.rot", "Javali");
    }



}


