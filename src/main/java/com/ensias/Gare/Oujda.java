package com.ensias.Gare;



public abstract class Oujda {
	
	public final static String nom="Oujda";
	  
	static String[] voisins={"Fes"};
	static int[] duree={330};
	static int[] tarifs={116};
      
    static int tarif=0;
    static int duree_trajet=0;
      
    static String[] horaires_departs={"06h25mn","10h25mn","14h25mn","21h05mn"}; 
    static int[] heure_departs={385,625,865,1265};
      
   
    
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
    		tarif=116+Fes.calculerprix(v);
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
    		duree_trajet=330+Fes.calculerduree(v);
    	}
    	  
    	return duree_trajet;
    }
    
    public static int[] get_horaires_departs(String v)
    {
    	return heure_departs;
    }
}
