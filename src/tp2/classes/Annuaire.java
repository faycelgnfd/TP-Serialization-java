package tp2.classes;

import java.util.Scanner;
import java.util.TreeMap;

public class Annuaire implements java.io.Serializable{
	
	TreeMap<String,Fiche> liste;
	
	Annuaire()
	{
		liste = new TreeMap<String,Fiche>();
	}
	
	public void ajoute(String nom,Scanner s)
	{
		
		System.out.println("Ajout d'une fiche\n");
		System.out.println("Entrez le num");
		String num = s.next();
		System.out.println("Entrez l'adresse");
		String adresse = s.next();
		
		Fiche f = new Fiche(nom,num,adresse);
		liste.put(nom,f);
	}
	
	public Fiche cherche(String nom) throws Exception
	{
		if(!liste.containsKey(nom))
		{
			throw new Exception("nom inexistant");
		}
		else
		{
			return liste.get(nom);
		}
		
	}
	
	public void lister()
	{
		for(Fiche e : liste.values())
		{
			System.out.println(e.toString());
		}
	}
}