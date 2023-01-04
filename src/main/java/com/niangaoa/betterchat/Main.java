package com.niangaoa.betterchat;

import me.dreamvoid.miraimc.api.MiraiBot;
import me.dreamvoid.miraimc.bukkit.event.message.passive.MiraiFriendMessageEvent;
import me.dreamvoid.miraimc.bukkit.event.message.passive.MiraiGroupMessageEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginLogger;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;
import java.util.logging.LogRecord;

public class Main extends JavaPlugin implements Listener {
    @Override // 加载插件
    public void onLoad() {
    }

    @Override // 启用插件
    public void onEnable() {
        PluginLogger pluginLogger = new PluginLogger(new Main());
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().log(new LogRecord(Level.INFO, "guirlsb"));
    }

    @Override // 禁用插件
    public void onDisable() { }

    @EventHandler
    public void onFriendMessageReceive(@NotNull MiraiFriendMessageEvent e){
        getLogger().info("接收到好友"+e.getSenderID()+"的消息: "+e.getMessage());
        MiraiBot.getBot(e.getBotID()).getFriend(e.getSenderID()).sendMessage("你发送了一条消息："+e.getMessage());
    }

    @EventHandler
    public void onGroupMessageReceive(@NotNull MiraiGroupMessageEvent e){
        getLogger().info("接收到群聊"+e.getGroupID()+"的消息: "+e.getMessage());
        MiraiBot.getBot(e.getBotID()).getGroup(e.getGroupID()).sendMessageMirai("[mirai:at:"+e.getSenderID()+"] 你发送了一条消息："+e.getMessage());
    }
}
