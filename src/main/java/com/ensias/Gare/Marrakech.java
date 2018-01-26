package com.ensias.Gare;



public abstract class Marrakech {
	
	public final static String nom="Marrakech";  
	
	static String[] voisins={"Casablanca"};
	static int[] duree={210};
	static int[] tarifs={95};
	  
    static int tarif=0;
    static int duree_trajet=0;
      
    static String[] horaires_departs={"04h20mn","06h20mn","08h20mn","10h20mn","12h20mn","14h20mn"}; 
    static int[] heure_departs={260,380,500,620,740,860};
      
      
      
    public static int calculerprix(String v)
    {
    	for(int i=0;i<voisins.length;i++)
    	{
    		if(v.equals(voisins[i]))
    		{
    			tarif=tarifs[i];
    		}
    	}
    	if(tarif==0)
    	{
    		tarif=95+Casablanca.calculerprix(v);
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
    		duree_trajet=210+Casablanca.calculerduree(v);
    	}
    	  
    	return duree_trajet;
    }	
    
    public static int[] get_horaires_departs(String v)
    {
    	return heure_departs;
    }
}
