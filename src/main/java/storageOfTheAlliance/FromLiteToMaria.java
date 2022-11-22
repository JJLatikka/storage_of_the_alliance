package storageOfTheAlliance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.sqlite.SQLiteConfig;

public class FromLiteToMaria {

	private Connection c;
	private Statement s;
	protected Map<Integer, String> containers;
	protected Map<Integer, Boolean> spaceLefts;
	protected Map<Integer, List<String>> items;

	public FromLiteToMaria() throws SQLException {
		this.c = connect();
		this.s = statement();
		this.containers = containers();
		this.spaceLefts = spaceLefts();
		this.items = items();
	}

	private Map<Integer, String> containers() {
		Map<Integer, String> m = new TreeMap<>();
		try {
			ResultSet r = s.executeQuery("SELECT id, nimi FROM Säilöt");
			while (r.next()) {
				m.put(r.getInt(1), r.getString(2));
			}
		} catch (SQLException e) {
		}
		return m;
	}  

	private Map<Integer, Boolean> spaceLefts() {
		Map<Integer, Boolean> m = new TreeMap<>();
		try {
			ResultSet r = s.executeQuery("SELECT säilö_id, tilaa FROM Täyttöasteet");
			while (r.next()) {
				m.put(r.getInt(1), r.getBoolean(2));
			}
		} catch (SQLException e) {
		}
		return m;
	}

	private Map<Integer, List<String>> items() {
		Map<Integer, List<String>> m = new TreeMap<>();
		try {
			ResultSet r = s.executeQuery("SELECT S.id, E.nimi FROM Säilöt S, Esineet E LEFT JOIN Sijainnit "
					+ "WHERE S.id=säilö_id AND E.id=esine_id");
			while (r.next()) {
				int k = r.getInt(1);
				m.putIfAbsent(k, new ArrayList<>());
				m.get(k).add(r.getString(2));
			}
		} catch (SQLException e) {
		}
		return m;
	}

	private Statement statement() throws SQLException {
		return c.createStatement();
	}

	private Connection connect() throws SQLException {
		SQLiteConfig config = new SQLiteConfig();
		config.enforceForeignKeys(true);
		Connection connect = DriverManager.getConnection("jdbc:sqlite:Varasto.db", config.toProperties());
		return connect;
	}

}
