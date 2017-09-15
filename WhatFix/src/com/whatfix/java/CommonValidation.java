package com.whatfix.java;

import java.util.ArrayList;
import java.util.List;

public class CommonValidation {

	public static void parserThings(String[] arr1, List<PackageDTO> list, double maxWeight) {
		//System.err.println("maxWeight   "+maxWeight);
		
		for (int i = 0; i < arr1.length; i++) {
			
			String arr2[]=(arr1[i].substring(1, arr1[i].length()-1)).split(",");
			int id=Integer.parseInt(arr2[0]);
			double weight=Double.parseDouble(arr2[1]);
			/*System.out.println(weight+"  weight");
			System.out.println(" id  "+id);
	    	System.out.println(" weight   "+weight);*/
			double cost=Double.parseDouble(arr2[2].substring(1,arr2[2].length()));
			//System.out.println("cost   "+cost);
			
			if(weight<=maxWeight)
			{
				PackageDTO dto=new PackageDTO(id,weight,cost);
				list.add(dto);
			}
			
			
			
		}
		
		
	}

	public static String getOptimumFor(List<PackageDTO> list, int ii, int maxWeightd)
	{
		/*System.err.println(list);
		System.err.println(ii);
		System.err.println(maxWeightd);*/
		
		
		int indexSolution=0;
    	String returnData ="";
    	double maxWeight=0;
    	double maxCost=0;
    	
    	
    	 int[] data=new int[ii];
    	 
    	 List<Integer> res = new ArrayList<Integer>();
    	 
    	 int[] arr=new int[list.size()];
    	 
    	 for(int i=0;i<list.size();i++)
 	    {
 	    	arr[i]=i;
 	    }
    	 
    	 
    	 getCombination(arr, data, res, 0, 0);
    	 
    	 for(int i=0;i<=res.size()-ii;i+=ii)
    	 {
    		 double somWeight=0;
 	    	double somCost=0;
 	    	for(int j=0;j<ii;j++)
	    	{
	    		somWeight+=list.get(res.get(i+j)).getWeight();
	    		somCost+=list.get(res.get(i+j)).getCost();
	    	}
 	    	
 	    	if(somWeight<=maxWeightd)
 	    	{
 	    		if((somCost>maxCost)||((somCost==maxCost)&&(somWeight<=maxWeight)))
 	    		{
 	    			indexSolution=i;
		    		maxWeight=somWeight;
		    		maxCost=somCost;
 	    		}
 	    		
 	    	}
    		 
    	 }
    	 
    	 for(int k=indexSolution;k<ii+indexSolution;k++)
     	{
     		returnData+=res.get(k)+",";
     	}
    	 
    	 return returnData+maxCost+","+maxWeight;
		
	}

	private static void getCombination(int[] arr, int[] data, List<Integer> res, int start, int index)
	{
		if(index==data.length)
		{
			for (int j=0; j<data.length; j++){
	        	res.add(data[j]);
	        }
	        return;
		}
		
		 for (int i=start; i<arr.length && arr.length-i >= data.length-index; i++)
		    {
		        data[index] = arr[i];
		        getCombination(arr, data,res, i+1, index+1);
		    }
		
		
	}

}
