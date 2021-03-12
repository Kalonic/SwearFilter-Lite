package dev.kalonic.swearfilter;

import dev.kalonic.swearfilter.utils.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SwearFilter implements Listener {

    @EventHandler
    public void onMsgSend(AsyncPlayerChatEvent event) {

        Player p = event.getPlayer();
        if(p.hasPermission("sf.bypass")) {
            return;
        } else {

            List<String> swears = new ArrayList<>();

            swears.add("fuck");
            swears.add("shit");
            swears.add("bastard");
            swears.add("retard");
            swears.add("nigga");
            swears.add("nigger");

            Iterator iter = swears.iterator();

            while(iter.hasNext()) {

                String word = iter.next().toString();

                if(event.getMessage().toLowerCase().contains(word)) {
                    event.setCancelled(true);
                    p.sendMessage(Utils.chat("&cSorry, You may not use the word, '" + word + "'."));
                    return;
                }
            }
        }
    }
}
