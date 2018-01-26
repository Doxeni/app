package com.ensias.app;

import com.ensias.Gare.*;



public class Launcher {

	static boolean way=false;
    static Codifier cod;
    
	public static void main(String[] args) {
		
		String depart="Aeroport",arrivee="Rabat";
		int[] heures_departs={0,0,0,0,0,0};
		int prix=0,duree_trajet=0,e=0;
		
		
		
		if(Marrakech.nom.equals(depart)){
			heures_departs=Marrakech.get_horaires_departs(arrivee);
			duree_trajet=Marrakech.calculerduree(arrivee);
			prix=Marrakech.calculerprix(arrivee);
			System.out.println("\nTrajet "+depart+"-"+arrivee+" : "+prix+"dhs");
			System.out.println("\nHeure de depart\t  Heure d'arrivée");
			while(e<6 && heures_departs[e]!=0)
			{
				System.out.println(heures_departs[e]/60+"h"+heures_departs[e]%60+"mn\t          "+((heures_departs[e]+duree_trajet)/60)%24+"h"+(heures_departs[e]+duree_trajet)%60+"mn");
				e++;
			}
		}
		else if(Aeroport.nom.equals(depart)){
			heures_departs=Aeroport.get_horaires_departs(arrivee);
			duree_trajet=Aeroport.calculerduree(arrivee);
			prix=Aeroport.calculerprix(arrivee);
			System.out.println("\nTrajet "+depart+"-"+arrivee+" : "+prix+"dhs");
			System.out.println("\nHeure de depart\t  Heure d'arrivée");
			while(e<6 && heures_departs[e]!=0)
			{
				System.out.println(heures_departs[e]/60+"h"+heures_departs[e]%60+"mn\t          "+((heures_departs[e]+duree_trajet)/60)%24+"h"+(heures_departs[e]+duree_trajet)%60+"mn");
				e++;
			}
		}
		else if(Casablanca.nom.equals(depart)){
			heures_departs=Casablanca.get_horaires_departs(arrivee);
			duree_trajet=Casablanca.calculerduree(arrivee);
			prix=Casablanca.calculerprix(arrivee);
			System.out.println("\nTrajet "+depart+"-"+arrivee+" : "+prix+"dhs");
			System.out.println("\nHeure de depart\t  Heure d'arrivée");
			while(e<6 && heures_departs[e]!=0)
			{
				System.out.println(heures_departs[e]/60+"h"+heures_departs[e]%60+"mn\t          "+(heures_departs[e]+duree_trajet)/60+"h"+(heures_departs[e]+duree_trajet)%60+"mn");
				e++;
			}
		}
		else if(Rabat.nom.equals(depart)){
			heures_departs=Rabat.get_horaires_departs(arrivee);
			duree_trajet=Rabat.calculerduree(arrivee);
			prix=Rabat.calculerprix(arrivee);
			System.out.println("\nTrajet "+depart+"-"+arrivee+" : "+prix+"dhs");
			System.out.println("\nHeure de depart\t  Heure d'arrivée");
			while(e<6 && heures_departs[e]!=0)
			{
				System.out.println(heures_departs[e]/60+"h"+heures_departs[e]%60+"mn\t          "+(heures_departs[e]+duree_trajet)/60+"h"+(heures_departs[e]+duree_trajet)%60+"mn");
				e++;
			}
		}
		else if(Kenitra.nom.equals(depart)){
			heures_departs=Kenitra.get_horaires_departs(arrivee);
			duree_trajet=Kenitra.calculerduree(arrivee);
			prix=Kenitra.calculerprix(arrivee);
			System.out.println("\nTrajet "+depart+"-"+arrivee+" : "+prix+"dhs");
			System.out.println("\nHeure de depart\t  Heure d'arrivée");
			while(e<6 && heures_departs[e]!=0)
			{
				System.out.println(heures_departs[e]/60+"h"+heures_departs[e]%60+"mn\t          "+(heures_departs[e]+duree_trajet)/60+"h"+(heures_departs[e]+duree_trajet)%60+"mn");
				e++;
			}
		}
		else if(Tanger.nom.equals(depart)){
			heures_departs=Tanger.get_horaires_departs(arrivee);
			duree_trajet=Tanger.calculerduree(arrivee);
			prix=Tanger.calculerprix(arrivee);
			System.out.println("\nTrajet "+depart+"-"+arrivee+" : "+prix+"dhs");
			System.out.println("\nHeure de depart\t  Heure d'arrivée");
			cod=new Codifier(depart,arrivee);
			way=cod.get_the_way();
			if(way)
			{
				while(e<4 && heures_departs[e]!=0)
				{
					System.out.println(heures_departs[e]/60+"h"+heures_departs[e]%60+"mn\t          "+(heures_departs[e]+duree_trajet)/60+"h"+(heures_departs[e]+duree_trajet)%60+"mn");
					e++;
				}
			}
			else while(e<6 && heures_departs[e]!=0)
			{
				System.out.println(heures_departs[e]/60+"h"+heures_departs[e]%60+"mn\t          "+(heures_departs[e]+duree_trajet)/60+"h"+(heures_departs[e]+duree_trajet)%60+"mn");
				e++;
			}
		}
		else if(Meknes.nom.equals(depart)){
			heures_departs=Meknes.get_horaires_departs(arrivee);
			duree_trajet=Meknes.calculerduree(arrivee);
			prix=Meknes.calculerprix(arrivee);
			System.out.println("\nTrajet "+depart+"-"+arrivee+" : "+prix+"dhs");
			System.out.println("\nHeure de depart\t  Heure d'arrivée");
			if(arrivee.equals("Tanger"))
			{
				while(e<4 && heures_departs[e]!=0)
				{
					System.out.println(heures_departs[e]/60+"h"+heures_departs[e]%60+"mn\t          "+(heures_departs[e]+duree_trajet)/60+"h"+(heures_departs[e]+duree_trajet)%60+"mn");
					e++;
				}
			}
			else while(e<6 && heures_departs[e]!=0)
			{
				System.out.println(heures_departs[e]/60+"h"+heures_departs[e]%60+"mn\t          "+(heures_departs[e]+duree_trajet)/60+"h"+(heures_departs[e]+duree_trajet)%60+"mn");
				e++;
			}
		}
		else if(Fes.nom.equals(depart)){
			heures_departs=Fes.get_horaires_departs(arrivee);
			duree_trajet=Fes.calculerduree(arrivee);
			prix=Fes.calculerprix(arrivee);
			System.out.println("\nTrajet "+depart+"-"+arrivee+" : "+prix+"dhs");
			System.out.println("\nHeure de depart\t  Heure d'arrivée");
			if(arrivee.equals("Oujda"))
			{
				while(e<4 && heures_departs[e]!=0)
				{
					System.out.println(heures_departs[e]/60+"h"+heures_departs[e]%60+"mn\t          "+(heures_departs[e]+duree_trajet)/60+"h"+(heures_departs[e]+duree_trajet)%60+"mn");
					e++;
				}
			}
			else while(e<6 && heures_departs[e]!=0)
			{
				System.out.println(heures_departs[e]/60+"h"+heures_departs[e]%60+"mn\t          "+(heures_departs[e]+duree_trajet)/60+"h"+(heures_departs[e]+duree_trajet)%60+"mn");
				e++;
			}
		}
		else if(Oujda.nom.equals(depart)){
			heures_departs=Oujda.get_horaires_departs(arrivee);
			duree_trajet=Oujda.calculerduree(arrivee);
			prix=Oujda.calculerprix(arrivee);
			System.out.println("\nTrajet "+depart+"-"+arrivee+" : "+prix+"dhs");
			System.out.println("\nHeure de depart\t  Heure d'arrivée");
			while(e<4 && heures_departs[e]!=0)
			{
				System.out.println(heures_departs[e]/60+"h"+heures_departs[e]%60+"mn\t          "+((heures_departs[e]+duree_trajet)/60)%24+"h"+(heures_departs[e]+duree_trajet)%60+"mn");
				e++;
			}
		}
		else System.out.println("La gare de départ que vous avez saisi n'est pas reconnu");
		
		
		
		
		
	}

}
