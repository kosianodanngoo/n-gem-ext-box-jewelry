package dev.archthefile.gemextjewelry.datagen.recipes;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.function.Consumer;

public class GemExtJewelryRecipeProvider extends RecipeProvider {
    public GemExtJewelryRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

    }
}
