package com.example.michellenguyen.ome;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Christopher on 1/29/16.
 */
public class Group {
    private int groupID;
    private String groupName;
    private HashMap<Integer, Member> members;
    private HashMap<Integer, Payment> paymentHistory;

    public Group(String name, Member creator){
        generateID();
        groupName = name;
        members = new HashMap<Integer, Member>(0);
        members.put(creator.getID(), creator);
    }
    
    public Group(){
    	generateID();
    	groupName = "Default Name";
    	members = new HashMap<Integer, Member>(0);
    	paymentHistory = new HashMap<Integer, Payment>(0);
    }

    //Using millis as pseudo hash. Should be collission-less
    private void generateID(){
        groupID = (int)(System.currentTimeMillis()%100000);
        //System.out.println(groupID);
    }
    
    public int numOfMems(){
    	return members.size();
    }
    
    //0 Success, 1 failure
    public int addMember(Member mem){
    	try{
    		members.put(mem.getID(), mem);
    		return 0;
    	}catch(NullPointerException e){
    	}
    	return 1;
    }
    
    
    public int addPayment(Member p, Member r, double value){
    	try{
    		Payment newOMe = new Payment(p, r, value);
        	paymentHistory.put(newOMe.getID(), newOMe);
        	p.addPaymentID(newOMe.getID());
        	return 0;
    	}catch(NullPointerException e){
    		
    	}
    	return 1;
    }
    
    //1 = success, 0 = clearance failure
    public int setGroupName(String name, Member clearance){
    	if(clearance.getPermissions() == 1){
    		groupName = name;
    		return 1;
    	}else{
    		return 0;
    	}
    }
    
    public Payment getPayment(int paymentID){
    	try{
    		return paymentHistory.get(paymentID);
    	}catch(Exception e){//Placeholder Exception
    		return null;
    	}
    }
    
    public int getGroupID(){
        return groupID;
    }

    public String getGroupName(){
        return groupName;
    }

    public Member getMember(int membID){
        return members.get(membID);
    }
}
