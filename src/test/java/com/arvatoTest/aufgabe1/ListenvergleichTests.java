package com.arvatoTest.aufgabe1;

import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ListenvergleichTests {

	
	@Test
	public void liste1vergleichen() throws Exception{
		Listenvergleich lv = new Listenvergleich("List1.txt", "List2.txt");
		String result = lv.getElementeNurInListe1().toString();
		System.out.println(result);
		assertEquals("{\"onlyInList1\":[\"Jason Derulo\",\"Max Mustermann\",\"Jack Tester\"]}", result);
	}
	
	@Test
	public void liste2vergleichen() throws Exception{
		Listenvergleich lv = new Listenvergleich("List1.txt", "List2.txt");
		String result = lv.getElementeNurInListe2().toString();
		System.out.println(result);
		assertEquals("{\"onlyInList2\":[\"Jason Momoa\",\"Jim Panse\",\"Elke Pohn\"]}", result);
	}
	
	@Test
	public void gemeinsameElementeVergleichen() throws Exception{
		Listenvergleich lv = new Listenvergleich("List1.txt", "List2.txt");
		String result = lv.getGemeinsameElemente().toString();
		System.out.println(result);
		assertEquals("{\"inBothLists\":[\"Jason Statham\",\"Miriam Musterfrau\"]}", result);
	}
}
