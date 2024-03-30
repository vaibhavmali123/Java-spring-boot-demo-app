package com.demo.demo.controllers;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
      
    	List number = Arrays.asList(33,2,3,4,5);

    	// Map function will transform each element in provided list and returns the calculation applied on it 
    	List square=(List) number.stream().map(a->Integer.parseInt(a.toString())*Integer.parseInt(a.toString())).collect(Collectors.toList());
    	
    	List even=(List) number.stream().filter(a->Integer.parseInt(a.toString())%2==0).collect(Collectors.toList());
    	
    		number.stream().sorted().forEach(System.out::println);

    		boolean isExist=number.stream().anyMatch(a->Integer.parseInt(a.toString())==59);
    		
        	List names = Arrays.asList("vaibhav","test","Java");

    		Optional<String> findFirst=names.stream().filter(a->a.toString().startsWith("v")).findFirst();

    	
    	System.out.println("Square list: "+square);
    	System.out.println("Even list: "+even);
    	System.out.println("Any match list: "+isExist);
    	System.out.println("findFirst : "+findFirst.get());

    	 	
    	
    	//List square = (List) number.stream().map(a->a*a).collect(Collectors.toList());
    	
    	
    	/*
    	List names = Arrays.asList(1,2,3);
    	
    	List fList=(List) names.stream().map(a->Integer.parseInt(a.toString())*Integer.parseInt(a.toString())).collect(Collectors.toList());
    	
    	
      System.out.println("Hello, World!"+fList);
      
      List namesn = Arrays.asList("Reflection","Collection","Stream");
      List result = (List) namesn.stream().sorted().collect(Collectors.toList());
      
      System.out.println("Sorted list:"+result);
      
      List numbers=Arrays.asList(1,2,3,4,6,20);
      System.out.println("Sorted list:"+result);
      
      List numbert= Arrays.asList(2,3,5,8);
      int even = (int) numbert.stream().filter(x->Integer.parseInt(x.toString())%2==0).reduce(0,(ans,i)-> Integer.parseInt(ans.toString())+Integer.parseInt(i.toString()));


      System.out.println("EVEN no:"+even);

      */
      System.out.println("Enter name");
      Scanner sc=new Scanner(System.in);
      String name=sc.next();
      System.out.println("Hello, World!"+name);
      


  }
}