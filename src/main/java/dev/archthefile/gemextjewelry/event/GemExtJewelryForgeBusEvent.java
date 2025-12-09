package dev.archthefile.gemextjewelry.event;

import com.Nuaah.NGemExtBoxMod.block.entity.GemCapabilityProvider;
import com.Nuaah.NGemExtBoxMod.main.NGemExtBoxMod;
import dev.archthefile.gemextjewelry.GemExtJewelry;
import dev.archthefile.gemextjewelry.items.GemCharmItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@SuppressWarnings("removal")
@Mod.EventBusSubscriber(modid = GemExtJewelry.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class GemExtJewelryForgeBusEvent {
    @SubscribeEvent
    public static void attachCapability(AttachCapabilitiesEvent<ItemStack> event){
        ItemStack stack = event.getObject();
        if (stack.getItem() instanceof GemCharmItem){
            event.addCapability(
                    new ResourceLocation(NGemExtBoxMod.MOD_ID,"gem_cap"),
                    new GemCapabilityProvider(stack)
            );

        }
    }
}
