package me.gobli989.extremeplayerinfo;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class MainClass extends JavaPlugin implements Listener {
	
	public void onEnable() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("playerinfo")) {
			if(sender instanceof Player) {
				if(getConfig().getBoolean("settings.Enable")) {
					if(player.hasPermission("extremecore.playerinfo")) {
						if(args.length == 0) {
							player.sendMessage(ChatColor.RED+"Usage: /pi <Target>");
						} else {
							Player target = getServer().getPlayer(args[0]);
							player.sendMessage(ChatColor.WHITE+"["+ChatColor.DARK_AQUA+"----------------"+ChatColor.WHITE+"] PlayerInfo ["+ChatColor.DARK_AQUA+"----------------"+ChatColor.WHITE+"]");
							player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.Name")+": "+ChatColor.DARK_AQUA+target.getName());
							player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.DisplayName")+": "+ChatColor.DARK_AQUA+target.getDisplayName());
							player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.UUID")+": "+ChatColor.DARK_AQUA+target.getUniqueId());
							player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.Gamemode")+": "+ChatColor.DARK_AQUA+target.getGameMode());
							player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.World")+": "+ChatColor.DARK_AQUA+target.getWorld().getName());
							player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.LocX")+": "+ChatColor.DARK_AQUA+target.getLocation().getBlockX());
							player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.LocY")+": "+ChatColor.DARK_AQUA+target.getLocation().getBlockY());
							player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.LocZ")+": "+ChatColor.DARK_AQUA+target.getLocation().getBlockZ());
							player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.Food")+": "+ChatColor.DARK_AQUA+target.getFoodLevel());
							player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.Health")+": "+ChatColor.DARK_AQUA+target.getHealth());
							player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.MaxHealth")+": "+ChatColor.DARK_AQUA+target.getMaxHealth());
							player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.Exp")+": "+ChatColor.DARK_AQUA+target.getExp());
							player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.Flying")+": "+ChatColor.DARK_AQUA+target.isFlying());
							player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.FlySpeed")+": "+ChatColor.DARK_AQUA+target.getFlySpeed());
							player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.WalkSpeed")+": "+ChatColor.DARK_AQUA+target.getWalkSpeed());
							player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.Banned")+": "+ChatColor.DARK_AQUA+target.isBanned());
							player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.Whitelisted")+": "+ChatColor.DARK_AQUA+target.isWhitelisted());
							player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.Online")+": "+ChatColor.DARK_AQUA+target.isOnline());
							player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.Op")+": "+ChatColor.DARK_AQUA+target.isOp());
							player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.Sneaking")+": "+ChatColor.DARK_AQUA+target.isSneaking());
							player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.Sprint")+": "+ChatColor.DARK_AQUA+target.isSprinting());
							player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.Sleeping")+": "+ChatColor.DARK_AQUA+target.isSleeping());
							player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.Dead")+": "+ChatColor.DARK_AQUA+target.isDead());
							player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.Blocking")+": "+ChatColor.DARK_AQUA+target.isBlocking());
							player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.InsideVehicle")+": "+ChatColor.DARK_AQUA+target.isInsideVehicle());
							if(player.hasPermission("extremeplayerinfo.info.ip")) {
								player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.Ip")+": "+ChatColor.DARK_AQUA+target.getAddress());
							} else {
								player.sendMessage(ChatColor.WHITE+getConfig().getString("messages.info.Ip")+": "+ChatColor.DARK_AQUA+getConfig().getString("messages.info.Secret"));
							}
							player.sendMessage(ChatColor.WHITE+"["+ChatColor.DARK_AQUA+"----------------"+ChatColor.WHITE+"] PlayerInfo ["+ChatColor.DARK_AQUA+"----------------"+ChatColor.WHITE+"]");
						}
					}
				}
			}
		}
		return false;
	}

}
