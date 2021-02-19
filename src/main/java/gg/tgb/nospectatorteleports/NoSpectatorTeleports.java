package gg.tgb.nospectatorteleports;


import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoSpectatorTeleports extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("NoSpectatorTeleports Enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("NoSpectatorTeleports Disabled!");
    }

    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event) {

        Player p = event.getPlayer();
        if(p.getGameMode() == GameMode.SPECTATOR) {
            event.setCancelled(true);
            getLogger().info("Cancelled Teleport for " + p.getDisplayName());
            p.sendMessage("Teleporting is disabled for spectators");
        }
    }
}
