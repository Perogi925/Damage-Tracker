package com.LogsInInventory;

import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
	name = "Logs In Inventory",
	description = "Tracks the total number of logs in your inventory",
	tags = {"logs", "inventory"}
)
public class LogsInInventoryPlugin extends Plugin {
	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private LogsInInventoryOverlay overlay;

	@Override
	protected void startUp() throws Exception {
		log.info("Example started!");
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception {
		log.info("Example stopped!");
		overlayManager.remove(overlay);
	}
}

