package frontend;

public class Apple extends Stocks{
    //Apple class inherits all the methods and such from super class Stocks by using the word 'extends'

    public Apple(){

        setName("Apple");
        //Using setter to set the name to Apple

        setlow(20);

        sethigh(60);
        //Using setters to set new values for 'low' and 'high'

        int randomQuantity = random.nextInt(gethigh()-getlow()) + getlow();
        //Randomly generating a quantity value using the new 'high' and 'low'

        int standardPrice = 20;
        //Setting the price of each share to 20

        newpricelist.add(standardPrice+12);
        //Adding the selling price of the share apple which is 20 + 12 to arraylist newpricelist

        setPrice(standardPrice);
        //Setting the price of Apple

        setQuantity(randomQuantity);
        //Setting the quantity of apple shares using setter

    }

    public String information(){

        stockhistory = "Most stable company to invest in so far - never fails to return your investments.";

        return stockhistory;

    }
    //Abstract class from Stocks class is being defined and stockshistory overwritten with data more suited for Apple shares

}
