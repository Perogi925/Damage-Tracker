package com.LogsInInventory;


import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.*;


public class LogsInInventoryOverlay extends Overlay {

    private final Client client;
    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    private LogsInInventoryOverlay(Client client) {
        setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
        this.client = client;
    }


    @Override
    public java.awt.Dimension render(Graphics2D graphics) {
        panelComponent.getChildren().clear();
        String overlayTitle = "Total Logs In Inventory";

        panelComponent.getChildren().add(TitleComponent.builder().text(overlayTitle).color(Color.GREEN).build());

        panelComponent.setPreferredSize(new java.awt.Dimension(graphics.getFontMetrics().stringWidth(overlayTitle) + 30, 0));

        panelComponent.getChildren().add(LineComponent.builder().right(Integer.toString(getLogs())).build());

        return panelComponent.render(graphics);

    }

    public int getLogs() {
        final ItemContainer itemContainer = client.getItemContainer(InventoryID.INVENTORY);
        final Item[] items = itemContainer.getItems();
        int counter = 0;

        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                if (items[i].getId() == 1511) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
