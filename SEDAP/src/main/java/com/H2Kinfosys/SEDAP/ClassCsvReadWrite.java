package com.H2Kinfosys.SEDAP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ClassCsvReadWrite {

	public static void main(String[] args) throws Exception{
		BufferedReader br=null;
		BufferedWriter bw=null;
	
	   	    
		String customerCSV="/Users/apple/Documents/CustomerData/custCSV.csv";
		String invalidCustCSV="/Users/apple/Documents/CustomerData/custCSVwrite.csv";
		String line="";
		try {
			br=new BufferedReader(new FileReader(customerCSV));
			bw=new BufferedWriter(new FileWriter(invalidCustCSV));
			
			
			List<CustomerDTO> custList=new ArrayList<CustomerDTO>();
			ValidationCust validationCustomer=new ValidationCust();
			
			//skip header
			String header=br.readLine();
	        bw.write(header);
	    
	        //read data fron 2nd line
	        		
		while((line=br.readLine())!=null)
		{
			
			String[] attribute=line.split(",");
			
			boolean isValidCustomer=validationCustomer.validateCustInformation(attribute);
			
			if(isValidCustomer) {
				CustomerDTO validCustomer=saveCustomer(attribute);
				custList.add(validCustomer);
			}
			else
			{
				bw.newLine();
				bw.write(line);
			
					
			}
			
			sendToQueue(invalidCustCSV);
			for(CustomerDTO customer:custList)
			{
				System.out.println(customer);
			}
	
		}
		
		}
		catch(IOException io)
			{
				System.out.println(io.getMessage());
			}
		catch(NullPointerException np){
			System.out.println(np.getMessage());
			
		}catch(ClassCastException cce)
		{
			System.out.println(cce.getMessage());
		}
		finally
		
		{
			if(br!=null) br.close();
			if(bw!=null) bw.close();
		
		}
		
		
	}

	private static CustomerDTO saveCustomer(String[] attribute) {
		
		CustomerDTO customerToSave=new CustomerDTO(Integer.parseInt(attribute[0]),
				Integer.parseInt(attribute[1]),
				attribute[2],
				attribute[3],Integer.parseInt(attribute[4]),
				Integer.parseInt(attribute[5]),
				Integer.parseInt(attribute[6]),
				Integer.parseInt(attribute[7])	);
		
		return customerToSave;
		
		
	
	}
	public static void  sendToQueue(String invalidCustCSV )throws JMSException
	{
		String brokerURL="tcp://localhost:61616";
		String queueName="SEDAP.MANUAL.ANALYSYS.QUEUE";
		Connection conn=null;
		try {
			ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(brokerURL);
			conn = connectionFactory.createConnection();
			conn.start();
			Session session=conn.createSession(false,Session.AUTO_ACKNOWLEDGE);
		    Destination destination=session.createQueue(queueName);
		    MessageProducer producer=session.createProducer(destination);
		    Message message=session.createObjectMessage(invalidCustCSV);
			producer.send(message);
			
			
			
		}catch(JMSException e)
		{
			e.printStackTrace();
		}finally
		{
			if(conn!=null) conn.close();
		}
		
		
	}

}
