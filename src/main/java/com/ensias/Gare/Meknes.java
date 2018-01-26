package com.ensias.Gare;

import com.ensias.app.Codifier;

public abstract class Meknes {
	
	public final static String nom="Meknes";
	
	static String[] voisins={"Kenitra","Tanger","Fes"};
	static int[] duree={100,420,30};
	static int[] tarifs={53,90,22};
     
    static int tarif=0;
    static int duree_trajet=0;
    
    static String[][] horaires_departs={{"02h46mn","03h07mn","03h54mn","05h09mn","06h00mn","07h10mn"},{"08h42mn","10h28mn","14h28mn","17h33mn"},{"00h15mn","01h08mn","01h45mn","04h00mn","05h30mn","07h15mn"}}; 
    static int[][] heure_departs={{166,187,234,309,360,430},{522,628,868,1053},{15,75,105,240,330,435}};
    
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
   	  			tarif=22+Fes.calculerprix(v);
   	  		else 
   	  			tarif=53+Kenitra.calculerprix(v);  		  
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
    		cod=new Codifier(nom,v);
    		way=cod.get_the_way();
   		    if(way)
   		    	duree_trajet=30+Fes.calculerduree(v);
   		    else
   		    	duree_trajet=100+Kenitra.calculerduree(v);
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
