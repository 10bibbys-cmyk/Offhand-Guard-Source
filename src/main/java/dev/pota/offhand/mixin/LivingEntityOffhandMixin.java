package dev.pota.offhand.mixin;

import dev.pota.offhand.OffhandGuard;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityOffhandMixin {
    @Inject(method = "setStackInHand", at = @At("HEAD"), cancellable = true)
    private void pota$preventMaskedOffhandClear(Hand hand, ItemStack stack, CallbackInfo ci) {
        if (stack == null || !stack.isEmpty()) {
            return;
        }

        if (!((Object) this instanceof PlayerEntity)) {
            return;
        }

        PlayerEntity player = (PlayerEntity) (Object) this;
        if (OffhandGuard.shouldBlockVanillaOffhandUse(player, hand)) {
            ci.cancel();
        }
    }
}
