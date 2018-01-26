package com.ensias.app;

public class Codifier {

	String[] Gares={"Marrakech","Aeroport","Casablanca","Rabat","Kenitra","Tanger","Meknes","Fes","Oujda"};
	boolean up=false;
	int i,j;
	public Codifier(String depart,String arrivee)
	{
	   for(i=0;i<Gares.length;i++)
		   if(depart.equals(Gares[i]))
			   break;
	   for(j=0;j<Gares.length;j++)
		   if(arrivee.equals(Gares[j]))
			   break;
	   if(i<j)
		   up=true;
	}
	public boolean get_the_way()
	{
		return up;
	}
}
