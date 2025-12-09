package dev.archthefile.gemextjewelry.items;

import com.Nuaah.NGemExtBoxMod.block.entity.NGemExtBoxModCapabilities;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.UUID;

public class GemCharmItem extends Item implements ICurioItem {
    public GemCharmItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(
            SlotContext slotContext, UUID uuid, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        stack.getCapability(NGemExtBoxModCapabilities.GEM_CAP).ifPresent((cap) -> {
            double bonusArmor = 0.0F;
            double bonusDamage = 0.0F;
            for (ItemStack gem : cap.getGems()) {
                if (!gem.isEmpty()) {
                    String id = gem.getItem().toString();
                    if (id.contains("diamond")) {
                        bonusArmor++;
                    }
                    if (id.contains("garnet")) {
                        bonusDamage += 0.5f;
                    }
                }
            }
            if (bonusArmor > 0) {
                builder.put(Attributes.ARMOR, new AttributeModifier(uuid, "GemRing Attribute", bonusArmor, AttributeModifier.Operation.ADDITION));
            }
            if (bonusDamage > 0) {
                builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(uuid, "GemRing Attribute", bonusDamage, AttributeModifier.Operation.ADDITION));
            }
        });
        return builder.build();
    }
}
