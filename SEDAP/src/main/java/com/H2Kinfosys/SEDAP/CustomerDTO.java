package com.H2Kinfosys.SEDAP;

import java.io.Serializable;

public class CustomerDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int entryId;
   private int customerId;
  private String customerFirstName;
  private String customerLastName;
  private int startWatchTime;
  private int endWatchTime;
  private int channelNum;
  private int age;
  
  public CustomerDTO ()
  {
	  
  }
  
  
  




@Override
public String toString() {
	return "CustomerDTO [entryId=" + entryId + ", customerId=" + customerId + ", customerFirstName=" + customerFirstName
			+ ", customerLastName=" + customerLastName + ", startWatchTime=" + startWatchTime + ", endWatchTime="
			+ endWatchTime + ", channelNum=" + channelNum + ", age=" + age + "]";
}







public CustomerDTO(int entryId,int customerId, String customerFirstName, String customerLastName, int startWatchTime,
		int endWatchTime, int channelNum, int age) {
	super();
	this.entryId=entryId;
	this.customerId = customerId;
	this.customerFirstName = customerFirstName;
	this.customerLastName = customerLastName;
	this.startWatchTime = startWatchTime;
	this.endWatchTime = endWatchTime;
	this.channelNum = channelNum;
	this.age = age;
}
public int getEntryId() {
		return entryId;
	}
public void setEntryId(int entryId) {
	this.entryId = entryId;
}
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getCustomerFirstName() {
	return customerFirstName;
}
public void setCustomerFirstName(String customerFirstName) {
	this.customerFirstName = customerFirstName;
}
public String getCustomerLastName() {
	return customerLastName;
}
public void setCustomerLastName(String customerLastName) {
	this.customerLastName = customerLastName;
}
public int getStartWatchTime() {
	return startWatchTime;
}
public void setStartWatchTime(int startWatchTime) {
	this.startWatchTime = startWatchTime;
}
public int getEndWatchTime() {
	return endWatchTime;
}
public void setEndWatchTime(int endWatchTime) {
	this.endWatchTime = endWatchTime;
}
public int getChannelNum() {
	return channelNum;
}
public void setChannelNum(int channelNum) {
	this.channelNum = channelNum;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
  
  
  
}
