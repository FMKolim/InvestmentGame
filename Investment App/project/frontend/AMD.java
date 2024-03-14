package frontend;

public class AMD extends Stocks{
    //AMD class inherits all the methods and such from super class Stocks by using the word 'extends'

    Integer pricehigh = 200;

    Integer pricelow = 60;

    //Setting a high and low - to be later used to generate a random number between the bounds

    public AMD(){

        setName("AMD");
        //Using setter to set the name to AMD

        int randomQuantity = random.nextInt(gethigh()-getlow()) + getlow();
        //Getting values from stocks class and randomly generating a value between the bounds

        int randomPrice = random.nextInt(pricehigh - pricelow) + pricelow;
        //Using the variables from before to randomly generate a random price value between the range

        newpricelist.add(randomPrice+33);
        //Adding the selling price of the share which is the randomly generated number +33 to  the arraylist newpricelist

        setPrice(randomPrice);
        //Setting the price of AMD using setter

        setQuantity(randomQuantity);
        //Setting the quanitity of AMD using setter
    }

    public String information(){

        stockhistory = "Share prices took a sharp hit when they were found guilty of hiding information from customers!";

        return stockhistory;

    }
    //Abstract class from Stocks class is being defined and stockshistory overwritten with data more suited for AMD shares

    
}
