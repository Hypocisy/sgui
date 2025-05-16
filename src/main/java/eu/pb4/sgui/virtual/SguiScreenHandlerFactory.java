package eu.pb4.sgui.virtual;

import eu.pb4.sgui.api.gui.GuiInterface;
import eu.pb4.sgui.api.gui.SlotGuiInterface;
import eu.pb4.sgui.virtual.inventory.VirtualScreenHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuConstructor;

import javax.annotation.Nullable;

public record SguiScreenHandlerFactory<T extends GuiInterface>(T gui, MenuConstructor factory) implements MenuProvider {

	public static <T extends SlotGuiInterface> SguiScreenHandlerFactory<T> ofDefault(T gui) {
		return new SguiScreenHandlerFactory<>(gui, ((syncId, inv, player) -> new VirtualScreenHandler(gui.getType(), syncId, gui, player)));
	}

	@Override
	public Component getDisplayName() {
		Component text = this.gui.getTitle();
		if (text == null) {
			text = Component.empty();
		}
		return text;
	}

	@Nullable
	@Override
	public AbstractContainerMenu createMenu(int syncId, Inventory inventory, Player player) {
		return factory.createMenu(syncId, inventory, player);
	}
}
