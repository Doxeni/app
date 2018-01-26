package com.ensias.Gare;



public abstract class Casablanca {
	
	public final static String nom="Casablanca";
	  
	static String[] voisins={"Marrakech","Aeroport","Rabat"};
	static int[] duree={210,30,60};
	static int[] tarifs={95,43,37};
     
    static int tarif=0;
    static int duree_trajet=0;  
      
    static String[][] horaires_departs={{"06h33mn","06h55mn","08h55mn","10h55mn","12h55mn","14h55mn"},{"05h40mn","06h26mn","07h34mn","08h09mn","09h26mn","10h26mn"},{"05h50mn","06h05mn","07h05mn","07h30mn","07h47mn","08h05mn"}}; 
    static int[][] heure_departs={{393,415,535,655,775,895},{340,386,454,489,566,626},{350,365,425,450,467,485}}; 
     
    
      
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
    		tarif=37+Rabat.calculerprix(v);
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
    		duree_trajet=30+Rabat.calculerduree(v);
    	}
    	  
    	return duree_trajet;
    }
    
    public static int[] get_horaires_departs(String v)
    {
    	for(int i=0;i<voisins.length;i++)
    		if(v.equals(voisins[i]))
    			return heure_departs[i];
    	
		return heure_departs[2];
    }
}
