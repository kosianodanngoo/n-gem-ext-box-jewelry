package dev.archthefile.gemextjewelry.registry;

import dev.archthefile.gemextjewelry.GemExtJewelry;
import dev.archthefile.gemextjewelry.items.GemRingItem;
import dev.archthefile.gemextjewelry.recipe.GemRingRecipeSerializer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GemExtJewelryRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GemExtJewelry.MODID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, GemExtJewelry.MODID);

    public static RegistryObject<Item> GEM_RING = ITEMS.register("gem_ring", () -> new GemRingItem(new Item.Properties().stacksTo(1)));

    public static RegistryObject<RecipeSerializer<?>> GEM_RING_RECIPE = RECIPE_SERIALIZER.register("gem_ring_recipe", GemRingRecipeSerializer::new);
}
