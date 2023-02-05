package io.github.yuazer.gracez.Utils;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Util;
import net.minecraft.util.text.StringTextComponent;

import java.util.List;

public class ZUtils {
    public static void sendMsg(PlayerEntity playerEntity, String message) {
        playerEntity.sendMessage(new StringTextComponent(message), Util.NIL_UUID);
    }

    public static void sendMsg(PlayerEntity playerEntity, List<String> message) {
        for (String msg : message) {
            playerEntity.sendMessage(new StringTextComponent(msg), Util.NIL_UUID);
        }
    }
}
