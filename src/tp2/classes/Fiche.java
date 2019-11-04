package tp2.classes;

public class Fiche implements Comparable<Fiche>, java.io.Serializable{
	
	private String nom;
	private String num;
	private String adresse;
	
	Fiche(String nom,String num,String adresse)
	{
		this.nom = nom;
		this.num = num;
		this.adresse = adresse;
	}
	
	@Override
	public String toString()
	{
		return("nom: "+nom+" adresse: "+adresse+" num: "+num);
	}
	
	@Override
	public int compareTo(Fiche f)
	{
		return this.nom.compareTo(f.nom);
	}
}