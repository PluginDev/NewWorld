package pruebas;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.PersistenceException;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Pruebas extends JavaPlugin {

	Logger log;

	@Override
	public void onEnable() {

		log = this.getLogger();

		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new PlayerListener(this), this);

		setupDatabase();

	}

	@Override
	public void onDisable() {
		// TODO Insert logic to be performed when the plugin is disabled
	}

	private void setupDatabase() {
		try {
			getDatabase().find(IndePlayer.class).findRowCount();
		} catch (PersistenceException ex) {
			System.out.println("Installing database for "
					+ getDescription().getName() + " due to first time usage");
			installDDL();
		}
	}

	@Override
	public List<Class<?>> getDatabaseClasses() {// register database beans
		
		List<Class<?>> classes = new LinkedList<Class<?>>(); // add all beans 
		classes.add(IndePlayer.class); // ... add other beans
		// return the complete list
		
		return classes;
	}
}
