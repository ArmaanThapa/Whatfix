package com.whatfix.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProblemOnPackage {

	public static void main(String[] args) {
		File file=new File("E://whtaflixpackage//Package.txt");
		
		BufferedReader reader=null;
		
		try {
			reader=new BufferedReader(new FileReader(file));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}
		String str;
		List<PackageDTO> list=new ArrayList<PackageDTO>();
		
		try {
			
			while((str=reader.readLine())!=null)
			{
				String s="";
				
				//System.err.println(str);
				String []arr=str.split(" : ");
				
			//	System.err.println(arr[0]);
				
				int id=Integer.parseInt(arr[0]);
				String [] arr1=arr[1].split(" ");
				//System.err.println(arr1[0]);
				
				if(arr1.length>1)
				{
					list.clear();
					CommonValidation.parserThings(arr1,list,id);
					double maxCost=0;
				    double maxWeight=0;
				    
				    for (int i = 1; i < list.size(); i++) {
				    	
				   String resultat=CommonValidation.getOptimumFor(list,i,id);
				   
				   String[] sub4=resultat.split(",");
				   //System.err.println(sub4[0]);
				   
				   
				   double cost=Double.parseDouble(sub4[sub4.length-2]);
				   
					double weight=Double.parseDouble(sub4[sub4.length-1]);
					/*System.err.println("cost  "+cost);
			    	System.err.println(" weight "+weight);*/
					
					if(cost==maxCost)
					{
						if(weight<maxWeight)
						{
							maxCost=cost;
				    		maxWeight=weight;
			    			s=resultat;
						
						}
					}
					
					if(cost>maxCost)
			    	{
			    		maxCost=cost;
			    		maxWeight=weight;
			    		s=resultat;
			    	}
					
				    }
					
				    
					String[] sub5=s.split(",");
					
					  System.err.println(sub5[0]);
					
					String ss="";
					
					for(int j=0;j<sub5.length-2;j++)
				    {
				    	ss+=list.get(Integer.parseInt(sub5[j])).getId()+",";
				    }
					
					
					
					 if(ss.equals(""))
					 {
					 System.err.println("armaan");
					    	System.out.println("-");
					 }
					 
					    else
					    	System.out.println(ss.substring(0,ss.length()-1));
						
					
				    
				}
				else
				
			      	System.out.println("-");
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
