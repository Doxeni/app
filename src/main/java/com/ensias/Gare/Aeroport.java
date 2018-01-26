package com.ensias.Gare;

public abstract class Aeroport {
	
	public final static String nom="Aeroport";
	  
	static String[] voisins={"Casablanca"};
	static int[] duree={30};
	static int[] tarifs={43};
     
    static int tarif=0;
    static int duree_trajet=0;  
      
    static String[] horaires_departs={"06h32mn","07h32mn","08h23mn","09h32mn","10h32mn","11h32mn"}; 
    static int[] heure_departs={392,452,503,572,632,692};
      
    
    
    public static int calculerprix(String v)
    {
    	for(int i=0;i<tarifs.length;i++)
    	{
    		if(v.equals(voisins[i]))
    		{
    			tarif=tarifs[i];
    		}
    	}
    	  
    	if(tarif==0)
    	{
    		tarif=43+Casablanca.calculerprix(v);
    	}
    	  
    	return tarif;
    }

    public static int calculerduree(String v)
    {
    	for(int i=0;i<voisins.length;i++)
    	{
    		if(v.equals(voisins[i]))
    		{
    			duree_trajet=duree[i];
    		}
    	}
    	  
    	if(duree_trajet==0)
    	{
    		duree_trajet=30+Casablanca.calculerduree(v);
    	}
    	  
    	return duree_trajet;
    }		
    
    public static int[] get_horaires_departs(String v)
    {
    	return heure_departs;
    }
}
