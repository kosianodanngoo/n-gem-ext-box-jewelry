package dev.archthefile.gemextjewelry.recipe;

import com.Nuaah.NGemExtBoxMod.regi.tag.NGemExtBoxModTags;
import dev.archthefile.gemextjewelry.GemExtJewelry;
import dev.archthefile.gemextjewelry.registry.GemExtJewelryRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class GemRingRecipe extends CustomRecipe {
    private NonNullList<Ingredient> ingredients;

    public GemRingRecipe(ResourceLocation id, CraftingBookCategory craftingBookCategory) {
        super(id, craftingBookCategory);
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        Registry<Item> registry = BuiltInRegistries.ITEM;
        List<Item> gems = registry.getTag(NGemExtBoxModTags.Items.COMBINE_GEMS)
                .map(tag -> tag.stream().map(Holder::value).toList())
                .orElse(List.of());
        if (ingredients == null) {
            try {
                ingredients = NonNullList.of(
                        Ingredient.EMPTY,
                        Ingredient.of(getResultItem()),
                        Ingredient.fromValues(gems.stream().map(
                                item -> new Ingredient.ItemValue(new ItemStack(item)))));
            } catch (RuntimeException e) {
                return NonNullList.create();
            }
        }
        return ingredients;
    }

    @Override
    public boolean matches(CraftingContainer grid, Level world) {
        return !assemble(grid, world.registryAccess()).isEmpty();
    }

    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 2;
    }

    @Override
    public ItemStack assemble(CraftingContainer grid, RegistryAccess registryAccess) {
        ItemStack output = getResultItem().copy();

        int rings = 0;
        ItemStack gem = ItemStack.EMPTY;

        for (int j = 0; j < grid.getContainerSize(); j++) {
            ItemStack element = grid.getItem(j);
            if (!element.isEmpty()) {
                if (element.getItem() == output.getItem()) {
                    rings++;
                } else if (gem.isEmpty() && element.is(NGemExtBoxModTags.Items.COMBINE_GEMS)) {
                    gem = element;
                } else {
                    return ItemStack.EMPTY;
                }
            }
        }

        if (rings != 1 || gem.isEmpty()) {
            return ItemStack.EMPTY;
        }
        output.getOrCreateTag().putString("gemextjewelry:gem", ForgeRegistries.ITEMS.getKey(gem.getItem()).toString());
        return output;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return getResultItem();
    }

    public ItemStack getResultItem() {
        return new ItemStack(GemExtJewelryRegistry.GEM_RING.get());
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return GemExtJewelryRegistry.GEM_RING_RECIPE.get();
    }
}