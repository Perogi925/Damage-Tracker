package com.LogsInInventory;

import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;
import net.runelite.client.ui.overlay.OverlayPosition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

public class LogsInInventoryPluginTest
{
	Client client;

	@Inject
	private LogsInInventoryPluginTest(Client client) {
		this.client = client;
	}

	@Test
	public void returnTrue(){
		Assertions.assertTrue(true == true);
	}

	@Test
	public void fullInventoryTest(){
		ItemContainer itemContainer = client.getItemContainer(InventoryID.INVENTORY);
		Item[] items = itemContainer.getItems();
		for(int i = 0; i < 28; i++){
			if (items[i].getId() == 1511){

			}
		}

		}

	 public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(LogsInInventoryPlugin.class);
		RuneLite.main(args);
	}


}