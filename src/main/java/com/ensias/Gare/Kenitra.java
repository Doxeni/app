package com.ensias.Gare;

import com.ensias.app.Codifier;

public abstract class Kenitra {
	
	public final static String nom="Kenitra";
	 
	static String[] voisins={"Rabat","Tanger","Meknes"};
	static int[] duree={30,180,100};
	static int[] tarifs={16,90,53};
   
    static int tarif=0;
    static int duree_trajet=0;
    
    static String[][] horaires_departs={{"04h25mn","04h40mn","05h02mn","05h34mn","05h50mn","06h20mn"},{"00h30mn","07h31mn","07h48mn","09h09mn","09h48mn","11h09mn"},{"07h48mn","08h42mn","09h48mn","10h42mn","11h48mn","12h42mn"}}; 
    static int[][] heure_departs={{265,280,302,334,350,380},{30,451,468,549,588,669},{350,365,425,450,467,485}};
    
    static boolean way=false;
    static Codifier cod;
     
     

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
    		cod=new Codifier(nom,v);
  		  	way=cod.get_the_way();
  		    if(way)
  		    	tarif=53+Meknes.calculerprix(v);
  		    else
  		    	tarif=16+Rabat.calculerprix(v);
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
    			break;
    		}
    	}
    	  
    	if(duree_trajet==0)
    	{
    		cod=new Codifier(nom,v);
    		way=cod.get_the_way();
   		    if(way)
   		    	duree_trajet=100+Meknes.calculerduree(v);
   		    else
   		    	duree_trajet=30+Rabat.calculerduree(v);
    	}
    	  
    	return duree_trajet;
    }
    
    public static int[] get_horaires_departs(String v)
    {
    	for(int i=0;i<voisins.length;i++)
    		if(v.equals(voisins[i]))
    			return heure_departs[i];
    	
    	cod=new Codifier(nom,v);
		way=cod.get_the_way();
		if(way)
		   return heure_departs[2];
		else
		   return heure_departs[0];
    }
    
    
}
