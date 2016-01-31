package com.example.michellenguyen.ome;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Christopher on 1/29/16.
 */

public class Payment {
	private int paymentID;
    private Member Payer, Receiver;
    private double value;
    private Date dateMade;
    //0 = open, 1 = closed
    private int status;

    public Payment(Member p, Member r, double v){
    	generateID();
        dateMade = new Date();
        Payer = p;
        Receiver = r;
        value = v;
        status = 0;
    }
    
    private void generateID(){
    	paymentID = (int)(System.currentTimeMillis()%1000);
    	System.out.println(paymentID);
    }
    
    public int getID(){
    	return paymentID;
    }

    public int attemptPayment(){
    	if(Payer.getFunds() < value){
    		//INVALID FUNDS
    		return 0;
    	}else{
    		Receiver.addFunds(value);
    		return 1;
    	}
    }
    
    public Member getPayer(){
    	return Payer;
    }
    
    public Member getReceiver(){
    	return Receiver;
    }
    
    public void setStatus(int stat){
    	status = stat;
    }
    
    public String getDate(){
    	return dateMade.toString();
    }
}
