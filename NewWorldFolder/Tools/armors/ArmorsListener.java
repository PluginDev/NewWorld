package armors;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class ArmorsListener implements Listener {

	Plugin pl;
	Logger log;

	public ArmorsListener(Plugin p) {

		this.pl = p;
		log = p.getLogger();

	}

	@EventHandler
	public void CraftArmorEvent(PrepareItemCraftEvent ev) {

		if (ev.getInventory().getResult().getTypeId() == 299) {

			// ItemStack armor = new ItemStack(299);

			// ItemMeta im = armor.getItemMeta();

			ItemStack armor = ev.getInventory().getResult();

			ItemMeta im = armor.getItemMeta();

			im.setDisplayName("Traje de energia");
			ArrayList<String> lore = new ArrayList<String>();
			lore.add("Energia: 100%");
			im.setLore(lore);
			armor.setItemMeta(im);

			ev.getInventory().setResult(armor);

		}

		if (ev.getInventory().getResult().getTypeId() == 301) {

			ItemStack armor = ev.getInventory().getResult();

			ItemMeta im = armor.getItemMeta();

			im.setDisplayName("Botas del traje de energia");
			ArrayList<String> lore = new ArrayList<String>();
			lore.add("Sin ellas no funciona");
			im.setLore(lore);
			armor.setItemMeta(im);

			ev.getInventory().setResult(armor);

		}

		if (ev.getInventory().getResult().getTypeId() == 300) {

			ItemStack armor = ev.getInventory().getResult();

			ItemMeta im = armor.getItemMeta();

			im.setDisplayName("Pantalones del traje de energia");
			ArrayList<String> lore = new ArrayList<String>();
			lore.add("Sin ellos no funciona");
			im.setLore(lore);
			armor.setItemMeta(im);

			ev.getInventory().setResult(armor);

		}

	}
}