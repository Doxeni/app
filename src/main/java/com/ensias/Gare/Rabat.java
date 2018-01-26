package com.ensias.Gare;

import com.ensias.app.Codifier;

public abstract class Rabat {
	
	public final static String nom="Rabat";
	
	static String[] voisins={"Casablanca","Kenitra"};
	static int[] duree={60,30};
	static int[] tarifs={37,16};
    
    static int tarif=0;
    static int duree_trajet=0;
    
    static String[][] horaires_departs={{"05h15mn","05h30mn","05h45mn","06h15mn","06h30mn","07h00mn"},{"06h58mn","07h13mn","07h53mn","08h13mn","08h37mn","08h53mn"}}; 
    static int[][] heure_departs={{315,330,345,375,390,420},{418,433,473,493,517,533}};
    
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
   		    	tarif=16+Kenitra.calculerprix(v);
   		    else
   		    	tarif=37+Casablanca.calculerprix(v);
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
   		    	duree_trajet=30+Kenitra.calculerduree(v);
   		    else
   		    	duree_trajet=60+Casablanca.calculerduree(v);
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
		   return heure_departs[1];
		else
		   return heure_departs[0];
    }
}
