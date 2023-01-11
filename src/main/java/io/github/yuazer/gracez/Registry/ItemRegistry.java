package io.github.yuazer.gracez.Registry;

import io.github.yuazer.gracez.GraceZ;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    //物品注册
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GraceZ.MOD_ID);
    public static RegistryObject<Item> FirstItem = ITEMS.register("testsword", io.github.yuazer.gracez.Items.FirstItem::new);
}
