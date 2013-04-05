package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class NWCore extends JavaPlugin {

	PlayerAdmin pa;

	Logger log;

	@Override
	public void onEnable() {

		log = this.getLogger();
		this.pa = new PlayerAdmin(this);
		createDB();

	}

	@Override
	public void onDisable() {
		// TODO Insert logic to be performed when the plugin is disabled
	}

	public PlayerAdmin getPlayerAdmin() {

		return this.pa;
	}

	private boolean createDB() {

		try {
			Connection Conn = DriverManager
					.getConnection("jdbc:mysql://localhost/?user=root&password=");
			Statement s = Conn.createStatement();

			int Result = s
					.executeUpdate("CREATE DATABASE basedatospruebamolona2");
		} catch (SQLException e) {

			log.info(e.getMessage()
					+ " If you want to use another one change it at confing.yml");
		}

		return true;
	}

}
