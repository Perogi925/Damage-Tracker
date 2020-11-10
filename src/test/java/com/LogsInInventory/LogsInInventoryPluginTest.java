package com.LogsInInventory;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogsInInventoryPluginTest
{

	@Test
	public void returnTrue(){
		Assertions.assertTrue(true == true);
	}

	 public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(LogsInInventoryPlugin.class);
		RuneLite.main(args);
	}
}