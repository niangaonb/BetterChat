package com.niangaoa.betterchat;

import me.dreamvoid.miraimc.api.MiraiBot;
import me.dreamvoid.miraimc.bukkit.event.message.passive.MiraiGroupMessageEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public class CommandExample extends JavaPlugin implements Listener {

    @Override // 加载插件
    public void onLoad() { }

    @Override // 启用插件
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override // 禁用插件
    public void onDisable() { }

    @EventHandler
    public void onFriendMessageReceive(@NotNull MiraiGroupMessageEvent e){
        if(e.getMessage().equals("在线人数")) {
            MiraiBot.getBot(e.getBotID()).getFriend(e.getSenderID()).sendMessage("当前在线人数：" + Bukkit.getServer().getOnlinePlayers().size()+"人");
        }
    }

    @EventHandler
    public void onGroupMessageReceive(@NotNull MiraiGroupMessageEvent e){
        if(e.getMessage().equals("在线人数")) {
            MiraiBot.getBot(e.getBotID()).getGroup(e.getGroupID()).sendMessage("当前在线人数：" + Bukkit.getServer().getOnlinePlayers().size()+"人");
        }
    }
}
