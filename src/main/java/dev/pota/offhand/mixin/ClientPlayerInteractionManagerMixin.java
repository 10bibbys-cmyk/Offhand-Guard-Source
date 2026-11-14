package dev.pota.offhand.mixin;

import dev.pota.offhand.OffhandGuard;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayerInteractionManager.class)
public abstract class ClientPlayerInteractionManagerMixin {
    @Inject(method = "interactItem", at = @At("HEAD"), cancellable = true)
    private void pota$stopMaskedOffhandUse(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        if (OffhandGuard.shouldBlockVanillaOffhandUse(player, hand)) {
            cir.setReturnValue(ActionResult.PASS);
            OffhandGuard.logPrevented("client interactItem(OFF_HAND)");
        }
    }
}
