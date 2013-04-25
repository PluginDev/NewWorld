package carretillas;

import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.Plugin;

public class CarretillasListener implements Listener {

	Plugin pl;
	Logger log;

	public CarretillasListener(Plugin p) {

		this.pl = p;
		log = p.getLogger();

	}

	@EventHandler
	public void PlayerMove(PlayerMoveEvent ev) {

		Player p = ev.getPlayer();
		
	}
}
