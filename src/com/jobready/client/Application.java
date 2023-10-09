package com.jobready.client;

import com.jobready.inventory.InventoryManager;

public class Application {
	public static void main(String args[]) throws InterruptedException {
		InventoryManager manager = new InventoryManager();
		
		Thread invetoryTask = new Thread(new Runnable(){
			
			@Override
			public void run() {
				manager.PopulateSoldProducts();
			}
			
		});
		
		Thread DisplayTask = new Thread(new Runnable() {

			@Override
			public void run() {
				manager.DisplaySoldProducts();
			}
			
		});
		invetoryTask.start();
		Thread.sleep(2000);
		DisplayTask.start();
	}
}
