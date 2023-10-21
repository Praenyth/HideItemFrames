package lol.praenyth.mods.hideitemframes.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class HideItemFramesClient implements ClientModInitializer {
    /**
     * Runs the mod initializer on the client environment.
     */

    private static final KeyBinding BEGIN = new KeyBinding("key.hideitemframes", GLFW.GLFW_KEY_DELETE, "key.categories.misc");
    private static boolean HIDE_ITEM_FRAMES = true;

    @Override
    public void onInitializeClient() {

        KeyBindingHelper.registerKeyBinding(BEGIN);
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (BEGIN.wasPressed()) {

                HIDE_ITEM_FRAMES = !HIDE_ITEM_FRAMES;

                if (HIDE_ITEM_FRAMES) {
                    client.inGameHud.setOverlayMessage(Text.literal("Item Frames have been hidden!"), true);
                } else {
                    client.inGameHud.setOverlayMessage(Text.literal("Item Frames are now shown!"), true);
                }

            }
        });

    }

    public static boolean ifItemFramesHidden() {
        return HIDE_ITEM_FRAMES;
    }
}
