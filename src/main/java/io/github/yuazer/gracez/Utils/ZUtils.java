package io.github.yuazer.gracez.Utils;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Util;
import net.minecraft.util.text.StringTextComponent;

public class ZUtils {
    public static void sendMsg(PlayerEntity playerEntity, String message){
        playerEntity.sendMessage(new StringTextComponent(message), Util.NIL_UUID);
    }
}
