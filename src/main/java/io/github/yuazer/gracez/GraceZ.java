package io.github.yuazer.gracez;

import io.github.yuazer.gracez.Utils.ZUtils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod("gracez")
@Mod.EventBusSubscriber
public class GraceZ {
    @SubscribeEvent
    public static void onJoin(PlayerEvent.PlayerLoggedInEvent event) {
        PlayerEntity player = event.getPlayer();
        ZUtils.sendMsg(player,"Welcome!»¶Ó­Äú£¡"+player.getDisplayName().getString());
    }

}
