package frontend;

public class Nvidia extends Stocks{
    //Nvidia class inherits all the methods and such from super class Stocks by using the word 'extends'

    Integer pricehigh = 600;

    Integer pricelow = 120;
    //Setting a high and low - to be later used to generate a random number between the bounds

    public Nvidia(){

        setName("Nvidia");
        //Using setter to set the name to Nvidia

        setlow(30);

        sethigh(80);

        //Using setters to change the standard values of 'high' and 'low' from class Stocks to new values

        int randomQuantity = random.nextInt(gethigh()-getlow()) + getlow();
        //Randomly generating a quantity value using new values

        int randomPrice = random.nextInt(pricehigh - pricelow) + pricelow;
        //Randomly generating a price using the standard values from 'Stocks'

        newpricelist.add(randomPrice+33);
        //Adding the selling price of the share which is the randomly generated number +33 to  the arraylist newpricelist

        setPrice(randomPrice);
        //Setting the price of Nvidia using setter

        setQuantity(randomQuantity);
        //Setting the quantity of Nvidia using setter
    }

    public String information(){

        stockhistory = "With new top of the line GPU's coming out within the next 2 months, the share prices are rapidly increasing.";

        return stockhistory;

    }
    //Abstract class from Stocks class is being defined and stockshistory overwritten with data more suited for Nvidia shares
    
}
