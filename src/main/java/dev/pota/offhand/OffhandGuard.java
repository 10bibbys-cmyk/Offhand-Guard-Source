package dev.pota.offhand;

import net.bettercombat.api.WeaponAttributes;
import net.bettercombat.logic.WeaponRegistry;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;

/**
 * Recovered from the verified 1.0.0 production JAR.
 * This predicate deliberately preserves the existing offhand protection conditions.
 */
public final class OffhandGuard {
    private OffhandGuard() {
    }

    public static boolean shouldBlockVanillaOffhandUse(PlayerEntity player, Hand hand) {
        if (player == null || hand != Hand.OFF_HAND) {
            return false;
        }

        PlayerInventory inventory = player.getInventory();
        if (inventory == null || inventory.offHand.isEmpty()) {
            return false;
        }

        ItemStack offhandSlot = inventory.offHand.get(0);
        if (offhandSlot == null || offhandSlot.isEmpty()) {
            return false;
        }

        ItemStack mainHand = inventory.getMainHandStack();
        if (mainHand == null || mainHand.isEmpty()) {
            return false;
        }

        WeaponAttributes attributes = WeaponRegistry.getAttributes(mainHand);
        if (attributes == null || !attributes.isTwoHanded()) {
            return false;
        }

        ItemStack equippedOffhand = player.getEquippedStack(EquipmentSlot.OFFHAND);
        return equippedOffhand != null && equippedOffhand.isEmpty();
    }
}
