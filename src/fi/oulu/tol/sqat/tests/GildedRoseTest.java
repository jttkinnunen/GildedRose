package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

// Example scenarios for testing
//			SellIn Value = number of day it have to sell -1/day
//			Quality Value =  min 0  max 50; Value of item -1/day  -2x/SellIn=0
//			"Backstage passes"
//			"Aged Brie"
//			SellIn Value = number of day it have to sell -1/day
//			Quality Value =  min 0 ; Value of item +2/day  SellIn <=10  +3/day SellIn<=5
//			Quality Value =   0 ; SellIn = 0  
//			"Sulfuras"
//			SellIn Value = 0
//			Quality Value =  min 0  max 80
	// Syntax Item("Name",SellIn,Quality)


//   Item("Conjured Mana Cake", 3, 6));

	@Test
	public void testUpdateEndOfDay_SellIn_Quality_11_11() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Normal Item", 11, 11) );
		int days=0;
		// Act
		do {
			store.updateEndOfDay();
			days++;
		}
		while( days < 11);
		
		// Assert
		List<Item> items = store.getItems();
		Item itemNormal = items.get(0);
		assertEquals(11, days);
		assertEquals(0, itemNormal.getQuality());
		assertEquals(0, itemNormal.getSellIn());
	}
// -2x
	@Test
	public void testUpdateEndOfDay_SellIn_Quality_1_12() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Normal Item", 1, 12) );
		int days=0;
		// Act
		do {
			store.updateEndOfDay();
			days++;
		}
		while( days < 5);
		
		// Assert
		List<Item> items = store.getItems();
		Item itemNormal = items.get(0);
		assertEquals(5, days);
		assertEquals(3, itemNormal.getQuality());
		assertEquals(0, itemNormal.getSellIn());
	}
//  Item("Aged Brie", 2, 0));+3/day SellIn<=5
	@Test
	public void testUpdateEndOfDa_AgedBrie_2_0y() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 2, 0));
		int days=0;
		// Act
		do {
			store.updateEndOfDay();
			days++;
			}
		while( days < 2);
		// Assert
		List<Item> items = store.getItems();
		Item itemBrie = items.get(0);
		assertEquals(2, days);
		assertEquals(6, itemBrie.getQuality());
		assertEquals(0, itemBrie.getSellIn());
	}
//  Item("+5 Dexterity Vest", 10, 20)); -1/day
	@Test
	public void testUpdateEndOfDayDexterity() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("+5 Dexterity Vest", 10, 20));
		int days=0;
		// Act
		do {
			store.updateEndOfDay();
			days++;
			}
		while( days < 10);
		// Assert
		List<Item> items = store.getItems();
		Item itemDexterity = items.get(0);
		assertEquals(10, days);
		assertEquals(10, itemDexterity.getQuality());
		assertEquals(0, itemDexterity.getSellIn());
	}
//  Item("Elixir of the Mongoose", 5, 7)); -1/day all
	@Test
	public void testUpdateEndOfDayMongoose() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Elixir of the Mongoose", 5, 7));
		int days=0;
		// Act
		do {
			store.updateEndOfDay();
			days++;
			}
		while( days < 5);
		// Assert
		List<Item> items = store.getItems();
		Item itemMongoose = items.get(0);
		assertEquals(5, days);
		assertEquals(2, itemMongoose.getQuality());
		assertEquals(0, itemMongoose.getSellIn());
	}
//  Item("Sulfuras, Hand of Ragnaros", 0, 80)); legend
	@Test
	public void testUpdateEndOfDayRagnaros() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		int days=0;
		// Act
		do {
			store.updateEndOfDay();
			days++;
			}
		while( days < 5);
		// Assert
		List<Item> items = store.getItems();
		Item itemRagnaros = items.get(0);
		assertEquals(5, days);
		assertEquals(80, itemRagnaros.getQuality());
		assertEquals(0, itemRagnaros.getSellIn());
	}
//  Item("Backstage passes to a TAFKAL80ETC concert", 15, 20)); Quality +2 SellIn<10 and +3 SellIn<5
	@Test
	public void testUpdateEndOfDayBackstage_passes() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		int days=0;
		// Act
		do {
			store.updateEndOfDay();
			days++;
			}
		while( days < 15);
		// Assert
		List<Item> items = store.getItems();
		Item itemRagnaros = items.get(0);
		assertEquals(15, days);
		assertEquals(35, itemRagnaros.getQuality());
		assertEquals(0, itemRagnaros.getSellIn());
	}
//  Item("Conjured Mana Cake", 3, 6));
	@Test
	public void testUpdateEndOfDayMana_Cake() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Conjured Mana Cake", 3, 6));
		int days=0;
		// Act
		do {
			store.updateEndOfDay();
			days++;
			}
		while( days < 3);
		// Assert
		List<Item> items = store.getItems();
		Item itemMana_Cake = items.get(0);
		assertEquals(3, days);
		assertEquals(3, itemMana_Cake.getQuality());
		assertEquals(0, itemMana_Cake.getSellIn());
	}
//  Item("Aged Brie", 20, 40));Quality max50
	@Test
	public void testUpdateEndOfDayAged_BrieMax50() {
		// Arrange
		GildedRose store = new GildedRose();
		store.addItem(new Item("Aged Brie", 20, 40));
		int days=0;
		// Act
		do {
			store.updateEndOfDay();
			days++;
			}
		while( days < 20);
		// Assert
		List<Item> items = store.getItems();
		Item itemMana_Cake = items.get(0);
		assertEquals(20, days);
		assertEquals(50, itemMana_Cake.getQuality());
		assertEquals(0, itemMana_Cake.getSellIn());
	}
}
