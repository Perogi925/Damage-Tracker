package com.DamageTracker;


import com.jogamp.nativewindow.util.Dimension;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

import javax.inject.Inject;
import java.awt.*;

public class DamageTrackerOverlay extends Overlay {

    private final Client client;
    private final PanelComponent panelComponent = new PanelComponent();

    @Inject
    private DamageTrackerOverlay(Client client){
        setPosition(OverlayPosition.ABOVE_CHATBOX_RIGHT);
        this.client = client;
    }

    @Override
    public java.awt.Dimension render(Graphics2D graphics){
        panelComponent.getChildren().clear();
        String overlayTitle = "Damage Tracker";

        panelComponent.getChildren().add(TitleComponent.builder()
            .text(overlayTitle)
            .color(Color.GREEN)
            .build());

        panelComponent.setPreferredSize(new java.awt.Dimension(graphics.getFontMetrics().stringWidth(overlayTitle) + 30, 0));

        panelComponent.getChildren().add(LineComponent.builder().left("Damage:").right(Integer.toString(client.getWorld())).build());

        return panelComponent.render(graphics);

    }
}
