package dev.archthefile.gemextjewelry.client.model;

import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.item.ItemStack;

public class GemRingModelManager {
    public static BakedModel baseModel, setModel;

    public static BakedModel getModelFor(ItemStack stack) {
        return stack.getOrCreateTag().contains("gemextjewelry:gem") ? setModel : baseModel;
    }
}