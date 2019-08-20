package com.arvatoTest.aufgabe1;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Listenvergleich {
	
	private List<String> liste1;
	private List<String> liste2;
	
	public Listenvergleich(String pfadListe1, String pfadListe2) {
		this.liste1 = new ArrayList<String>();
		this.liste2 = new ArrayList<String>();
		this.listenEinlesen(pfadListe1, pfadListe2);
	}
	
	// Zeilen bzw. enthaltene Namen beider Dateien in Listen speichern 
	public void listenEinlesen(String pfadListe1, String pfadListe2) {
		try{
			Stream<String> zeilen1 = Files.lines(Paths.get(pfadListe1));
			liste1 = zeilen1.collect(Collectors.toList());
			Stream<String> zeilen2 = Files.lines(Paths.get(pfadListe2));
			liste2 = zeilen2.collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Elemente die nur in der ersten Liste auftauchen
	public JSONObject getElementeNurInListe1() {
		JSONObject erg1 = new JSONObject();		
		erg1.put("onlyInList1", getEinzigartigeElemente(liste1, liste2));
		return erg1;
	}
	
	// Elemente die nur in der zweiten Liste auftauchen
	public JSONObject getElementeNurInListe2() {
		JSONObject erg2 = new JSONObject();		
		erg2.put("onlyInList2", getEinzigartigeElemente(liste2, liste1));
		return erg2;
	}
	
	// Elemente die nur in der liste auftauchen die als erstes übergeben wird
	public JSONArray getEinzigartigeElemente(List<String> hauptliste, List<String> vergleichsliste) {
		JSONArray ergebnisliste = new JSONArray();
		hauptliste.forEach(element->{
				if(!vergleichsliste.contains(element)) {
					ergebnisliste.add(element);
				}
			}
		);
		return ergebnisliste;
	}
	
	// Elemente die in beiden Listen auftauchen
	public JSONObject getGemeinsameElemente() {
		JSONObject erg = new JSONObject();
		JSONArray ergebnisliste = new JSONArray();
		liste1.forEach(element->{
				if(liste2.contains(element)) {
					ergebnisliste.add(element);
				}
			}
		);
		return erg;
	}
	
}
