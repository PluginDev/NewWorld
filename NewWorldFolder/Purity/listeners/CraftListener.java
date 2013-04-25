package listeners;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class CraftListener implements Listener {

	Plugin pl;
	Logger log;

	public CraftListener(Plugin p) {

		this.pl = p;
		log = p.getLogger();

	}

	@EventHandler
	public void CraftArmorEvent(PrepareItemCraftEvent ev) {

		ItemStack item = ev.getInventory().getResult();
		ItemStack[] items = ev.getInventory().getContents();

		int v = getMaxPurity(items);

		ItemStack drop = item;
		ItemMeta im = drop.getItemMeta();

		ArrayList<String> lore = new ArrayList<String>();

		lore.add("Calidad: " + v);

		im.setLore(lore);

		item.setItemMeta(im);

	}

	private int getMaxPurity(ItemStack[] items) {

		int p = 0;

		for (int i = 0; i < items.length; i++) {

			int temp = getItemPurity(items[i]);

			if (temp > p) {

				p = temp;

			}

		}

		return p;

	}

	private int getItemPurity(ItemStack item) {

		if (item.hasItemMeta()) {

			if (item.getItemMeta().hasLore()) {

				if (havePurity(item)) {

					ArrayList<String> lore = (ArrayList<String>) item
							.getItemMeta().getLore();

					for (int i = 0; i < lore.size(); i++) {

						if (lore.get(i).contains("Calidad")) {

							String[] temp = lore.get(i).split(":");
							int purity = Integer.valueOf(temp[1].trim());
							return purity;
						}
					}
				}
			}
		}
		return 0;

	}

	private boolean havePurity(ItemStack is) {

		boolean result = false;

		if (is.getItemMeta().getLore() != null) {

			ArrayList<String> lore = (ArrayList<String>) is.getItemMeta()
					.getLore();

			for (int i = 0; i < lore.size(); i++) {

				if (lore.get(i).contains("Calidad")) {

					result = true;
					break;
				}
			}
		}

		return result;

	}
}