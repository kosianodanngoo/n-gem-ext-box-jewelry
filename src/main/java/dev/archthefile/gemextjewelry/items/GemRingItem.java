package dev.archthefile.gemextjewelry.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.UUID;

public class GemRingItem extends Item implements ICurioItem {
    public GemRingItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(
            SlotContext slotContext, UUID uuid, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        CompoundTag tag = stack.getOrCreateTag();

        if (tag.contains("gemextjewelry:gem")) {
            String id = tag.getString("gemextjewelry:gem");
            if (id.contains("diamond")) {
                builder.put(Attributes.ARMOR, new AttributeModifier(uuid, "GemRing Attribute", 1.0f, AttributeModifier.Operation.ADDITION));
            }
            if (id.contains("garnet")) {
                builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(uuid, "GemRing Attribute", 0.5f, AttributeModifier.Operation.ADDITION));
            }
        }
        return builder.build();
    }
}

