package purity;

import java.util.logging.Logger;

import listeners.CraftListener;
import listeners.DropListener;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import tools.PickaxeListener;
import armors.ArmorsListener;

//import tools.PickaxeListener;

public class Purity extends JavaPlugin {

	Logger log;

	@Override
	public void onEnable() {

		log = this.getLogger();

		PluginManager pm = this.getServer().getPluginManager();

		pm.registerEvents(new CraftListener(this), this);
		pm.registerEvents(new DropListener(this), this);

	}

	@Override
	public void onDisable() {
		// TODO Insert logic to be performed when the plugin is disabled
	}

}
