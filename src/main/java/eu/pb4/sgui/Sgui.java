package eu.pb4.sgui;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Sgui.MODID)
public class Sgui {
	public static final String MODID = "sgui";
	public static final Logger LOGGER = LogManager.getLogger();

	public Sgui(IEventBus modEventBus, ModContainer modContainer) {
		LOGGER.info("Sgui initialized");
//		NeoForge.EVENT_BUS.addListener(SGuiTest::onRegisterCommands);
	}
}
