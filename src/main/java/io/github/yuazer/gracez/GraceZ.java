package io.github.yuazer.gracez;

import io.github.yuazer.gracez.Utils.ZUtils;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod("gracez")
@Mod.EventBusSubscriber
public class GraceZ {
    @SubscribeEvent
    public static void onJoin(PlayerEvent.PlayerLoggedInEvent event) {
        PlayerEntity player = event.getPlayer();
        ZUtils.sendMsg(player,"Welcome!欢迎您！"+player.getDisplayName().getString()+"|isClient:"+(player.level.isClientSide?"Client":"Server"));
    }
    @SubscribeEvent
    public static void onRightClick(PlayerInteractEvent.RightClickItem event){
        PlayerEntity player = event.getPlayer();
        if (!player.level.isClientSide&&player.getMainHandItem().getItem()== Items.DIAMOND_SWORD){
            RayTraceResult rtr = player.pick(20,0,false);
            Vector3d vec = rtr.getLocation();
            player.teleportTo(vec.x,vec.y,vec.z);
            ZUtils.sendMsg(player,"§a飞咯飞咯~");
        }
    }
}
