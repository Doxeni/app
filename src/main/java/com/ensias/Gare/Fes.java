package com.ensias.Gare;



public abstract class Fes {
	
	public final static String nom="Fes";
	 
	static String[] voisins={"Meknes","Oujda"};
	static int[] duree={30,330};
	static int[] tarifs={22,116};
     
    static int tarif=0;
    static int duree_trajet=0; 
     
    static String[][] horaires_departs={{"02h10mn","02h30mn","03h20mn","04h30mn","05h25mn","06h00mn"},{"01h35mn","09h05mn","10h55mn","15h35mn"}}; 
    static int[][] heure_departs={{130,150,200,270,325,360},{95,545,655,935}};
     
    
    
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
    		if(Meknes.calculerprix(v)!=0)
    		{
    			tarif=22+Meknes.calculerprix(v);
    		}
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
    		duree_trajet=30+Meknes.calculerduree(v);
    	}
    	  
    	return duree_trajet;
    }
    
    public static int[] get_horaires_departs(String v)
    {
    	for(int i=0;i<voisins.length;i++)
    		if(v.equals(voisins[i]))
    			return heure_departs[i];
    	
    	return heure_departs[0];
    }
}
