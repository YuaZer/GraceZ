package io.github.yuazer.gracez.ItemGroup;

import io.github.yuazer.gracez.Registry.ItemRegistry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class GroupGraceZ extends ItemGroup {
    public GroupGraceZ() {
        super("GraceZGroup");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemRegistry.FirstItem.get());
    }
}
