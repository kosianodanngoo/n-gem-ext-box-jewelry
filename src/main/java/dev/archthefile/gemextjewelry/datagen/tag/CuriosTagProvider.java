package dev.archthefile.gemextjewelry.datagen.tag;

import dev.archthefile.gemextjewelry.registry.GemExtJewelryRegistry;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

@SuppressWarnings("removal")
public class CuriosTagProvider extends ItemTagsProvider {
    public CuriosTagProvider(
            PackOutput pOutput,
            CompletableFuture<Provider> pLookupProvider,
            CompletableFuture<TagsProvider.TagLookup<Block>> pBlockTags,
            @Nullable ExistingFileHelper existingFileHelper
    ) {
        super(pOutput, pLookupProvider, pBlockTags, "curios", existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull Provider pProvider) {
        this.tag(ItemTags.create(new ResourceLocation("curios", "ring")))
                .add(GemExtJewelryRegistry.GEM_RING.get());
        this.tag(ItemTags.create(new ResourceLocation("curios", "charm")))
                .add(GemExtJewelryRegistry.GEM_CHARM.get());
    }
}
