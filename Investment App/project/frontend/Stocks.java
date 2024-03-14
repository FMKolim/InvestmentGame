package frontend;

import java.util.*;
//Import java.util libary

abstract class Stocks {
    //Abstract super class

    ArrayList<Integer> newpricelist = new ArrayList<Integer>();
    
    private String name = "";

    private Integer Quantity = 0;

    private Integer low = 1;

    private Integer high = 100;

    private Integer Price = 0;

    String stockhistory = "";

    Random random = new Random();

    //Intialise some variables and give them their stock values, create arraylist to hold new prices of stocks

    public abstract String information();
    //Method that holds some information about the stock - a generic message for the stock - gets overwritten in different classes to give more personalised information about share

    public void setPrice(Integer Price){
        this.Price = Price;
    }

    public Integer getPrice(){
        return this.Price;
    }

    //Setters and getters for the private variable Price

    public void setQuantity(Integer Quantity){
        this.Quantity = Quantity;
    }

    public Integer getQuantity(){
        return this.Quantity;
    }

    //Setters and getters for private variable Quantity

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    //Setters and getters for private variable Name

    public void setlow(Integer low){
        this.low = low;
    }

    public Integer getlow(){
        return this.low;
    }

    //Setters and getters for private variable low

    public void sethigh(Integer high){
        this.high = high;
    }

    public Integer gethigh(){
        return this.high;
    }

    //Setters and getters for private variable high


}
