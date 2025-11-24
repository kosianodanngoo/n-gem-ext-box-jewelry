package dev.archthefile.gemextjewelry.recipe;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class GemRingRecipeSerializer implements RecipeSerializer<GemRingRecipe> {
    @Override
    public GemRingRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
        return new GemRingRecipe(recipeId, CraftingBookCategory.MISC);
    }

    @Override
    public GemRingRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
        return new GemRingRecipe(recipeId, CraftingBookCategory.MISC);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buffer, GemRingRecipe recipe) {
        // 特に書くデータがないなら空でOK
    }
}
