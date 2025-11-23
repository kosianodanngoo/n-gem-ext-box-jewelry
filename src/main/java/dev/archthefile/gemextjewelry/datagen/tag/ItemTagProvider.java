package dev.archthefile.gemextjewelry.datagen.tag;

import dev.archthefile.gemextjewelry.GemExtJewelry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends ItemTagsProvider {
    public ItemTagProvider(
            PackOutput pOutput,
            CompletableFuture<Provider> pLookupProvider,
            CompletableFuture<TagLookup<Block>> pBlockTags,
            @Nullable ExistingFileHelper existingFileHelper
    ) {
        super(pOutput, pLookupProvider, pBlockTags, GemExtJewelry.MODID, existingFileHelper);
    }

    @Override
    public void addTags(@NotNull Provider pProvider) {

    }
}
