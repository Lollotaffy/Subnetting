package utilities;

import java.io.*;

public class Utility{
	//legge stringa
	public static String leggiString(){
		BufferedReader tast=new BufferedReader(new InputStreamReader(System.in));
		String str=null;
		try{
			str=tast.readLine();
		}catch(IOException e){
			System.out.println(e.toString());
		}
		return str;
	}
	//legge char
	public static char leggiChar(){
		BufferedReader tast=new BufferedReader(new InputStreamReader(System.in));
		String str=null;
		char dato = 0;
		try{
			str=tast.readLine();
			dato=str.charAt(0);
		}catch(IOException e){
			System.out.println(e.toString());
		}
		return dato;
	}
	//legge int
	public static int leggiInt(){
		BufferedReader tast=new BufferedReader(new InputStreamReader(System.in));
		String str=null;
		int dato=0;
		try{
			str=tast.readLine();
			dato=Integer.parseInt(str);
		}catch(IOException e){
			System.out.println(e.toString());
		}
		return dato;
	}
	//leggi double
	public static double leggiDouble(){
		BufferedReader tast=new BufferedReader(new InputStreamReader(System.in));
		String str=null;
		double dato=0;
		try{
			str=tast.readLine();
			dato=Double.parseDouble(str);
		}catch(IOException e){
			System.out.println(e.toString());
		}
		return dato;
	}
	//leggi long
	public static long leggiLong(){
		BufferedReader tast=new BufferedReader(new InputStreamReader(System.in));
		String str=null;
		long dato=0;
		try{
			str=tast.readLine();
			dato=Long.parseLong(str);
		}catch(IOException e){
			System.out.println(e.toString());
		}
		return dato;
	}
	//leggi boolean
	public static boolean leggiBoolean(){
		BufferedReader tast=new BufferedReader(new InputStreamReader(System.in));
		int scelta=0;
		boolean dato=true;
		try{
			scelta=Integer.parseInt(tast.readLine());
			if(scelta==0){
				dato=true;
			}else{
				dato=false;
			}
		}catch(IOException e){
			System.out.println(e.toString());
		}
		return dato;
	}
}