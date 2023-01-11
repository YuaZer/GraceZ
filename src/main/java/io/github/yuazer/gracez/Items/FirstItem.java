package io.github.yuazer.gracez.Items;

import io.github.yuazer.gracez.GraceZ;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GraceZ.MOD_ID)
public class FirstItem extends Item{
    public static Item firstItem;

    public FirstItem() {
        super(new Properties().tab(ItemGroup.TAB_MATERIALS));
    }

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
        // 注意 setRegistryName 调用。
        // 每一个物品都对应唯一一个注册名，用于和其他物品区分开来。这个注册名不能含有大写字母。
        // 此方法返回被注册的 Item 对象。

    }
}
