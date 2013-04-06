package pruebas;

import java.util.List;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import com.avaje.ebean.Query;

public class PlayerListener implements Listener {

	Plugin pl;
	Logger log;

	public PlayerListener(Plugin p) {
		
		this.pl = p;
		log = p.getLogger();

	}

	@EventHandler
	public void PlayerJoin(PlayerJoinEvent ev) {

		// create a query that returns TestBean objects
		Query<IndePlayer> query = pl.getDatabase().find(IndePlayer.class);
		log.info("Ha encontrado la clase");
		// execute the query
		List<IndePlayer> beans = query.findList();
		log.info("Ha encontrado la lista");
		

		for (IndePlayer ip : beans) {
			log.info("entra en bucle");
			if (ip.getAccountName().compareToIgnoreCase(
					ev.getPlayer().getName()) == 0) {

				ev.getPlayer().sendMessage("Bienvenido de nuevo");
				break;
			}

			else {
				log.info("Else");
				IndePlayer ip2 = new IndePlayer();
				ip2.setAccountName(ev.getPlayer().getName());
				
				pl.getDatabase().save(ip2);
				break;

			}
		}
		
		if (beans.size() == 0 || beans == null){
			
			log.info("Ha entrado if secundario");
			IndePlayer ip2 = new IndePlayer();
			ip2.setAccountName(ev.getPlayer().getName());
			
			pl.getDatabase().save(ip2);
			
		}
	}

	@EventHandler
	public void inv(InventoryClickEvent ev) {
		Player p = (Player) ev.getWhoClicked();
		p.sendMessage(String.valueOf(ev.getRawSlot()));
	}
}