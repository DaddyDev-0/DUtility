package daddy.devmas.dutility.events.user;

import daddy.devmas.dutility.DUtility;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class UserJoin implements Listener {

    private DUtility du;
    public UserJoin(DUtility du) { this.du = du; }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        this.du.getUserManager().createUser(e.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        this.du.getUserManager().removeUser(e.getPlayer());
    }
}
