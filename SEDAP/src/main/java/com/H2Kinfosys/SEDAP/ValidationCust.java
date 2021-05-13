package com.H2Kinfosys.SEDAP;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationCust {
	  private Pattern pattern;
      private Matcher matcher;
 
      private static final String TIME24HOURS_PATTERN = 
                 "([01]?[0-9]|2[0-3]):[0-5][0-9]";
      
      public  ValidationCust(){
          pattern = Pattern.compile(TIME24HOURS_PATTERN);
      }
      public boolean validateCustInformation(String[] cust)
      {
    	  String[] customer=cust;
    	  int startTime=0;
    	  int endTime=0;
    	  if(isInteger(customer[0]))   //entryId valid
    	  {
    		  if(isInteger(customer[1]))    //custId valid
    		  {
    			  if(isStringValid(customer[2]))   //cust first name valid
    			  {
    				  if(isStringValid(customer[3]))  //Cust last name valid
    				  {
    					  if(isValidTime(customer[4]))    //start watch time valid
    					  {
    						  if(isValidTime(customer[5]))   //end Watch time
    						  {
    							  startTime=Integer.parseInt(customer[4]);
    							  endTime=Integer.parseInt(customer[5]);
    							  if(endTime>startTime)          
    							  {
    								  if(isValidChannel(customer[6]))         //valid channel
    								  {
    									  if(isValidAge(customer[7]))         //valid age
    										  
    									  {
    										  return true;
    									  }
    								  }
    							  }
    						  }  
    							  
    					  }
    				  }
    			  }
    		  }
    		  
    	  }
    	  
    	  
		return false;
    	  
      }
	private boolean isValidAge(String age) {
		boolean isValidIntAge=isInteger(age);
		int custAge=0;
		if(isValidIntAge)
		{
			custAge=Integer.parseInt(age);
			if(custAge>=15 && custAge<=121)
			{
				return true;
			}
		}
		return false;
	}
	private boolean isValidChannel(String channelNum) {
		boolean isChValidInteger=isInteger(channelNum);
		int chNum=0;
		if(isChValidInteger)
		{
			chNum=Integer.parseInt(channelNum);
			if((chNum>=100)&&(chNum<=1500))
					{
			        	return true;
					}
		}
		return false;
	}
	
	
	private boolean isValidTime(String watchTime) {
		
	    matcher=pattern.matcher(watchTime);
	     return matcher.matches();
	      
		
	}
	private boolean isStringValid(String name) {
		
		String nameValidation=name;
		nameValidation=nameValidation.toLowerCase();
			char[] text=nameValidation.toCharArray();
			if(!(text.length>30))
			{
				  for (int i = 0; i < text.length; i++)
				  {
				         char ch = text[i];
				         if (!(ch >= 'a' && ch <= 'z'|| ch >= 'A' && ch <= 'Z')) 
				         {
				            return  false;
				         }
								
		      	}
		    	return true;
		    }
		else
	
		return false;
	}
	private boolean isInteger(String Id) {
		boolean validIntegerOrNot=Id.matches("-?(0|[1-9]\\d*)");
		//if valid integer
		if(validIntegerOrNot)
		{
			int temp=Integer.parseInt(Id);
			if(temp<0)
			{
				return false;
			}
			
		}
		return validIntegerOrNot;
	}
}
