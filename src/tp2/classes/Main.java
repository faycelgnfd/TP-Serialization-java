package tp2.classes;

//Serialisation
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.util.Scanner;
	public class Main {
		
		public static void main(String args[])
		{
			ObjectOutputStream oos=null;
			ObjectInputStream ois=null;
			FileInputStream fichierI = null;
			FileOutputStream fichierO = null;
			
			try
			{
				fichierI = new FileInputStream("D:\\Codes\\java\\projets\\1st project\\bin\\TP2\\Annuaire.ser");
				ois = new ObjectInputStream(fichierI);
			}
			catch(IOException x)
			{
				x.printStackTrace();
			}
			
			Annuaire a = new Annuaire();
			Scanner sc = new Scanner(System.in);
			String input,nom;
			char c = 'o';
			
			try
			{
				a = (Annuaire)(ois.readObject());
			}
			catch(IOException | ClassNotFoundException x)
			{
				x.printStackTrace();
			}
			
			while(c =='o')
			{
				System.out.println("input expected");
				input = sc.next();
				c = input.charAt(0);
				nom = input.substring(1);
				
				if(c == '?')
				{
					try
					{
						System.out.println(a.cherche(nom).toString());
					}
					catch(Exception x)
					{
						System.out.println(x.getMessage());
					}
				}	
				else if(c == '+')
				{
					a.ajoute(nom,sc);
				}
				else if(c == '!')
				{
					a.lister();
				}
				else if(c == '.')
				{
					break;
				}
				else if(c == '*')
				{
					System.out.println(a.liste);
				}
				System.out.println("voulez-vous continuer o/n");
				c = sc.next().charAt(0);
			}
			try
			{
				fichierO = new FileOutputStream("D:\\Codes\\java\\projets\\1st project\\bin\\TP2\\Annuaire.ser");
				oos = new ObjectOutputStream(fichierO);
				
				oos.writeObject(a);
				oos.flush();
				oos.close();
				fichierO.close();
				fichierI.close();
			}
			catch(IOException x)
			{
				x.printStackTrace();
			}
		}
	}


