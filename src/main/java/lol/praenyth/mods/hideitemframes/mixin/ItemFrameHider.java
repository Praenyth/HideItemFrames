package lol.praenyth.mods.hideitemframes.mixin;

import lol.praenyth.mods.hideitemframes.client.HideItemFramesClient;
import net.minecraft.entity.decoration.ItemFrameEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemFrameEntity.class)
public class ItemFrameHider {

    @Inject(at = @At("HEAD"), method = "shouldRender", cancellable = true)
    public void hideItemFrame(double distance, CallbackInfoReturnable<Boolean> cir) {

        if (HideItemFramesClient.ifItemFramesHidden()) {
            cir.setReturnValue(false);
            return;
        }

    }

}
