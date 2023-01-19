package io.github.yuazer.gracez.Items;

import io.github.yuazer.gracez.GraceZ;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GraceZ.MOD_ID)
public class firstitem extends Item{
    public static Item firstItem;

    public firstitem() {
        super(new Properties().tab(ItemGroup.TAB_MISC));
    }
}
