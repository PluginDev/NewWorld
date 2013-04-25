package listeners;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class DropListener implements Listener {

	Plugin pl;
	Logger log;

	public DropListener(Plugin p) {

		this.pl = p;
		log = p.getLogger();

	}

	@EventHandler
	public void itemSpawn(ItemSpawnEvent ev) {

		Item item = ev.getEntity();

		if (!havePurity(item.getItemStack())) {
			Random r = new Random();
			int v = r.nextInt(100);

			ItemStack drop = item.getItemStack();
			ItemMeta im = drop.getItemMeta();

			ArrayList<String> lore = new ArrayList<String>();

			lore.add("Calidad: " + v);

			im.setLore(lore);

			item.getItemStack().setItemMeta(im);
		}

	}

	private boolean havePurity(ItemStack is) {

		boolean result = false;

		if (is.getItemMeta().getLore() != null) {

			ArrayList<String> lore = (ArrayList<String>) is.getItemMeta().getLore();

			for (int i = 0; i < lore.size(); i++) {

				if (lore.get(i).contains("Purity")) {

					result = true;
					break;
				}
			}
		}

		return result;

	}
}
