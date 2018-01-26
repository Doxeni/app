package com.ensias.Gare;

import com.ensias.app.Codifier;

public abstract class Tanger {
	
	public final static String nom="Tanger";
	  
	static String[] voisins={"Kenitra","Meknes"};
	static int[] duree={180,420};
	static int[] tarifs={90,90};
      
    static int tarif=0;
    static int duree_trajet=0;
    
    static String[][] horaires_departs={{"05h25mn","07h25mn","08h15mn","09h25mn","10h30mn","11h25mn"},{"08h15mn","10h30mn","12h50mn","18h40mn"}}; 
    static int[][] heure_departs={{325,445,495,565,630,685},{495,630,770,1120}};  
      
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
    		cod = new Codifier(nom,v);
    		way=cod.get_the_way();
    		if(way)
    		{
    			  tarif=90+Meknes.calculerprix(v);
    		}
    		else tarif=90+Kenitra.calculerprix(v);
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
   		    	duree_trajet=420+Meknes.calculerduree(v);
   		    else
   		    	duree_trajet=180+Kenitra.calculerduree(v);
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
