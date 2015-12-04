package com.untamedears.PrisonPearl;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

public class PPConfig {
	private int upkeep_resource;
	private int upkeep_quantity;
	private boolean ppreturn_kills;
	private boolean ppsummon_clear_inventory;
	private boolean ppsummon_leave_pearls;
	private double summon_broadcast_distance = 64.0D;
	private int chunkDelay;
	private boolean freeOutsideWorldBorder;
	private boolean mysqlEnabled;
	private String mysqlDbname;
	private String mysqlHost;
	private String mysqlUsername;
	private String mysqlPassword;
	private int mysqlPort;
	private boolean fixMissingPearls;
	
	public PPConfig(ConfigurationSection config) {
		this.upkeep_resource = config.getInt("upkeep.resource");
		this.upkeep_quantity = config.getInt("upkeep.quantity"); 
		this.ppreturn_kills = config.getBoolean("ppreturn_kills", false);
		this.summon_broadcast_distance = config.getDouble("broadcast_summon_distance", 64.0D);
		chunkDelay = config.getInt("chunk_delay", 1200);
		String ppsci = config.getString("ppsummon_clear_inventory", "0").toLowerCase();
		if (ppsci.equals("1") || ppsci.equals("true")) {
			ppsummon_clear_inventory = true;
			ppsummon_leave_pearls = false;
		} else if (ppsci.equals("leavepearls")) {
			ppsummon_clear_inventory = true;
			ppsummon_leave_pearls = true;
		} else {
			ppsummon_clear_inventory = false;
			ppsummon_leave_pearls = false;
		}
		this.freeOutsideWorldBorder = config.getBoolean("autofree_worldborder", true);
		this.mysqlEnabled = config.getBoolean("mysql.enabled", false);
		this.mysqlDbname = config.getString("mysql.dbname", "PrisonPearl");
		this.mysqlHost = config.getString("mysql.host", "localhost");
		this.mysqlUsername = config.getString("mysql.username", "bukkit");
		this.mysqlPassword = config.getString("mysql.password", "");
		this.mysqlPort = config.getInt("mysql.port", 3306);
		this.fixMissingPearls = config.getBoolean("fixMissingPearls", false);
	}

	public ItemStack getUpkeepResource() {
		return new ItemStack(upkeep_resource, upkeep_quantity);
	}

	public boolean getPpreturnKills() {
		return this.ppreturn_kills;
	}

	public boolean getPpsummonClearInventory() {
		return this.ppsummon_clear_inventory;
	}
	

	public boolean getPpsummonLeavePearls() {
		return this.ppsummon_leave_pearls;
	}
	
	public double getSummonBroadcastDistance() {
        return summon_broadcast_distance;
    }
	
	public int getChunkUnloadDelay(){
		return chunkDelay;
	}
	
	public boolean getFreeOutsideWorldBorder() {
		return this.freeOutsideWorldBorder;
	}
	
	public boolean getMysqlEnabled(){
		return mysqlEnabled;
	}
	
	public String getMysqlHost(){
		return mysqlHost;
	}
	
	public String getMysqlUsername(){
		return mysqlUsername;
	}
	
	public String getMysqlPassword(){
		return mysqlPassword;
	}
	
	public int getMysqlPort(){
		return mysqlPort;
	}
	
	public String getMysqlDbname(){
		return mysqlDbname;
	}
	
	public boolean getShouldFixMissingPearls() {
		return fixMissingPearls;
	}
}
