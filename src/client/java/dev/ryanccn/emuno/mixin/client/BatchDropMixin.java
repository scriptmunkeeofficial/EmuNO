package dev.ryanccn.emuno.mixin.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MinecraftClient.class)
public class BatchDropMixin {
    @Redirect(
            method = "handleInputEvents()V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/Screen;hasControlDown()Z")
    )
    private boolean hasActualCtrlDown() {
        return InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_LEFT_CONTROL) || InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_RIGHT_CONTROL);
    }
}
