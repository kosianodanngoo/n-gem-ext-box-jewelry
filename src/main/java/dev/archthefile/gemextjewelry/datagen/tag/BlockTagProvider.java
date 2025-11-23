package dev.archthefile.gemextjewelry.datagen.tag;

import dev.archthefile.gemextjewelry.GemExtJewelry;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends BlockTagsProvider {
    public BlockTagProvider(
            PackOutput output,
            CompletableFuture<Provider> lookupProvider,
            @Nullable ExistingFileHelper existingFileHelper
    ) {
        super(output, lookupProvider, GemExtJewelry.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(Provider pProvider) {

    }
}
