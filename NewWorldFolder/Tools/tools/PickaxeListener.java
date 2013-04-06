package tools;

import java.util.List;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class PickaxeListener implements Listener {

	Plugin pl;
	Logger log;

	public PickaxeListener(Plugin p) {

		this.pl = p;
		log = p.getLogger();

	}

	@EventHandler
	public void BlockBreak(BlockDamageEvent ev) {

		Player p = ev.getPlayer();

		boolean active;

		if (p.getEquipment().getChestplate() != null
				&& p.getEquipment().getBoots() != null
				&& p.getEquipment().getLeggings() != null) {
			log.info("checkea que esta equipado");

			if (p.getEquipment().getChestplate().getTypeId() == 299
					&& p.getEquipment().getBoots().getTypeId() == 301
					&& p.getEquipment().getLeggings().getTypeId() == 300) {
				
				log.info("checkea que tiene los cueros");

				if (getLoreEnergy(p.getEquipment().getChestplate()
						.getItemMeta().getLore()) > 0) {
					log.info("checkea que tiene energia el traje");

					List<String> lore = p.getEquipment().getChestplate()
							.getItemMeta().getLore();
					lore = reduceEnergy(lore);

					ItemStack armor = new ItemStack(299);

					ItemMeta im = armor.getItemMeta();

					im.setDisplayName("Traje de energia");
					im.setLore(lore);
					armor.setItemMeta(im);

					p.getEquipment().setChestplate(armor);

					active = false;
				} else
					active = true;

			} else
				active = true;

			ev.setCancelled(active);

		} else
			ev.setCancelled(true);

	}

	private List<String> reduceEnergy(List<String> lore) {

		lore.set(0, "Energia: " + String.valueOf(getLoreEnergy(lore) - 10)
				+ "%");

		return lore;

	}

	private int getLoreEnergy(List<String> lore) {

		String temp = lore.get(0).split(":")[1];
		temp = temp.split("%")[0];

		int en = Integer.valueOf(temp.trim());

		return en;

	}
}
