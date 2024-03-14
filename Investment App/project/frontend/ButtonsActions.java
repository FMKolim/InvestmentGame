package frontend;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;
import javax.swing.*;
//Importing the necessary libraries 

public class ButtonsActions {
    InvestmentApp iApp;
    UserInterface UI;
    Transition MainMenu;
    User user;
    ArrayList<String> stockslist = new ArrayList<String>();
    Nvidia nvidia = new Nvidia();
    AMD amd = new AMD();
    Apple apple = new Apple();
    Random random = new Random();
    String username;
    Integer nvidiaOwned = 0;
    Integer amdOwned = 0;
    Integer AppleOwned = 0;
    Path filelocation = Paths.get("userdetails.txt");
    Collector<String, ?, List<String>> list = Collectors.toList();
    //Intialising some variables, arraylists, giving variable names to classes etc.

    public ButtonsActions(InvestmentApp Investment, UserInterface uInterface, Transition transitions, User User){
        iApp = Investment;
        UI = uInterface;
        MainMenu = transitions;
        user = User;
    }
    //Directing the variable name to what class they link to

    public void StartingFunds(){
        user.setBalance(0);
    }
    //Starting off by setting the users balance to 0

    public String Name(){
        username = JOptionPane.showInputDialog("What is the users name?");
        return username;
    }
    //Method to ask the user for their name and save it for later use

    public void Home(){
        UI.Text.setText("Hello " + username + "! \n \n Welcome to the Investment App created by Fahad, an app designed to allow you - the user - to confidently invest your money into stocks. \n \nUsing the app is quite simple, the button names indicate their use. \n You can come back to this screen using 'Home', deposit and withdraw money using 'Deposit' and 'Withdraw', view your balance using 'Show Funds', show stock which can be bought using 'Show Stock', buy and sell stocks using 'Buy Stock' or 'Sell Stock', view your portfolio using 'Show Portfolio' and lastly save your data using 'Save' \n \n Data will not be saved if button is not pressed! App also only deals with whole integers so no decimals! \n \n Share prices also change every time a new session is made so be sure to buy up all the stocks and sell later down the line for juicy profit! ");
        UI.option1.setText("Home");
        UI.option2.setText("Show Funds");
        UI.option3.setText("Deposit");
        UI.option4.setText("Withdraw");
        UI.option5.setText("Show Stock");
        UI.option6.setText("Buy Stock");
        UI.option7.setText("Sell Stock");
        UI.option8.setText("Show Portfolio");
        iApp.nextAction1 = "Home";
        iApp.nextAction2 = "ShowFunds";
        iApp.nextAction3 = "Deposit";
        iApp.nextAction4 = "Withdraw";
        iApp.nextAction5 = "ShowStock";
        iApp.nextAction6 = "BuyStock";
        iApp.nextAction7 = "SellStock";
        iApp.nextAction8 = "ShowPortfolio";
    }
    //Home page for user - displays instructions, buttons and the buttons link to their appropiate method

    public void ShowFunds(){
        UI.Text.setText("Current balance for user " + username + " is: \u00A3 " + Integer.toString(user.getBalance()));
    }
    //ShowFunds used to print out the balance of user to text area

    public void Deposit(){
        String stringAmount = JOptionPane.showInputDialog("Enter Amount: ");
        if (stringAmount == null){
            ;
        } else {
            try {
                int amount = Integer.parseInt(stringAmount);
                if(amount > 0){
                    user.deposit(amount);
                    UI.Text.setText("\u00A3" + amount + " has been deposited to user " + username + "'s account.");
                } else {
                    UI.Text.setText("Error, try again!");
                }
            } catch (Exception e) {
                UI.Text.setText("Cannot deal with decimals/strings, please enter whole numbers!");
            }
        }
    }
    //Deposit button that creates a new window asking the user for how much they want to deposit into account - if cancel button is pressed do nothing - if inputted amount is not an integer and something else catch the exception (print error)
    //If input is an integer and meets all requirements then calls deposit method from 'User' and adds onto balance

    public void Withdraw(){
        String stringAmount = JOptionPane.showInputDialog("Enter Amount: ");
        if (stringAmount == null){
            ;
        } else {
            try {
                int amount = Integer.parseInt(stringAmount);
                if(amount > 0){
                    if(user.getBalance() < amount){
                        UI.Text.setText("Cannot overdraw from account! You tried to withdraw \u00A3" + amount + " when the account only held \u00A3" + user.getBalance());
                    } else {
                        user.withdraw(amount);
                        UI.Text.setText("\u00A3" + amount + " has been withdrawn from user " + username + "'s account.");
                    } 
                } else {
                    UI.Text.setText("Error, try again!");
                } 
            } catch (Exception e) {
                UI.Text.setText("Cannot deal with decimals, please enter whole numbers!");
            }
        }
    }
    //Withdraw button that creates a new window asking the user for how much they want to withdraw from account - if cancel button is pressed do nothing - if inputted amount is not an integer and something else catch the exception (print error)
    //If input is an integer and amount to withdraw is < balance then calls withdraw method from 'User' and takes away from balance - if withdraw amount is > available balance print error

    public void ShowStock(){
        stockslist.add(nvidia.getName());
        stockslist.add(amd.getName());
        stockslist.add(apple.getName());
        int chances = (int) (Math.random() * stockslist.size());
        if(stockslist.get(chances).equals("Nvidia")){
            UI.Text.setText("The current stock that can be bought is: \n " + stockslist.get(chances) + "\n \n There's " + nvidia.getQuantity() + " shares that can be bought right now at the price of \u00A3" + nvidia.getPrice() + " each. \n \n Information about the shares: " + nvidia.information());
        } 
        if (stockslist.get(chances).equals("AMD")){
            UI.Text.setText("The current stock that can be bought is: \n " + stockslist.get(chances) + "\n \n There's " + amd.getQuantity() + " shares that can be bought right now at the price of \u00A3" + amd.getPrice() + " each.\n \n Information about the shares: " + amd.information());
        } 
        if (stockslist.get(chances).equals("Apple")){
            UI.Text.setText("The current stock that can be bought is: \n " + stockslist.get(chances) + "\n \n There's " + apple.getQuantity() + " shares that can be bought right now at the price of \u00A3" + apple.getPrice() + " each.\n \n Information about the shares: " + apple.information());
        }
    }
    //Adds the stock names to an arraylist which randomly generates a random number, using get(chances) and if statements we find the name of stock and we print its information out.
    //Get information about stock using getters.

    public void BuyStock(){
        String[] names = {"Apple", "AMD", "Nvidia"};
        String StockBuying =  (String) JOptionPane.showInputDialog(null, "What share would you like to buy?  Current prices for buying shares are: \n AMD: \u00A3" + amd.getPrice() + "\n Apple: \u00A3" + apple.getPrice() + "\n Nvidia: \u00A3" + nvidia.getPrice(), "Choose Stock", 0, null, names, names[0]);
        try {
            if(StockBuying == "AMD"){
                Integer StocksQuantity = Integer.parseInt(JOptionPane.showInputDialog("How many shares would you like to buy? "));
                if(amd.getQuantity() >= StocksQuantity && StocksQuantity > 0){
                    if(user.getBalance() >= (amd.getPrice() * StocksQuantity)){
                        Integer cost = amd.getPrice() * StocksQuantity;
                        user.withdraw(cost);
                        int newQuantity = amd.getQuantity() - StocksQuantity;
                        amd.setQuantity(newQuantity);
                        amdOwned = amdOwned + StocksQuantity;
                        UI.Text.setText("Successfully bought: " + StocksQuantity + " shares.");
                    } else {
                        UI.Text.setText("Insufficient funds, cannot buy stocks.");
                    }
                } else {
                    UI.Text.setText("Invalid number of shares are trying to be bought.");
                }
            }
            if(StockBuying == "Apple"){
                Integer StocksQuantity = Integer.parseInt(JOptionPane.showInputDialog("How many shares would you like to buy? "));
                if(apple.getQuantity() >= StocksQuantity && StocksQuantity > 0){
                    if(user.getBalance() >= (apple.getPrice() * StocksQuantity)){
                        Integer cost = apple.getPrice() * StocksQuantity;
                        user.withdraw(cost);
                        int newQuantity = apple.getQuantity() - StocksQuantity;
                        apple.setQuantity(newQuantity);
                        AppleOwned = AppleOwned + StocksQuantity;
                        UI.Text.setText("Successfully bought: " + StocksQuantity + " shares.");
                    } else {
                        UI.Text.setText("Insufficient funds, cannot buy stocks.");
                    }
                } else {
                    UI.Text.setText("Invalid number of shares are trying to be bought.");
                }
            }
            if(StockBuying == "Nvidia"){
                Integer StocksQuantity = Integer.parseInt(JOptionPane.showInputDialog("How many shares would you like to buy? "));
                if(nvidia.getQuantity() >= StocksQuantity && StocksQuantity > 0){
                    if(user.getBalance() >= (nvidia.getPrice() * StocksQuantity)){
                        Integer cost = nvidia.getPrice() * StocksQuantity;
                        user.withdraw(cost);
                        int newQuantity = nvidia.getQuantity() - StocksQuantity;
                        nvidia.setQuantity(newQuantity);
                        nvidiaOwned = nvidiaOwned + StocksQuantity;
                        UI.Text.setText("Successfully bought: " + StocksQuantity + " shares.");
                    } else {
                        UI.Text.setText("Insufficient funds, cannot buy stocks.");
                    }
                } else {
                    UI.Text.setText("Invalid number of shares are trying to be bought.");
                }
            }
        } catch (Exception e) {
            UI.Text.setText("Cancelled.");
        }
    }
    //Method for dealing when user clicks the buy stock button - Makes a dropdown list using the stock names for user to select from, if cancelled does nothing, if an option is chosen then asks for how many shares they would like
    //If input is > 0 and user has the balance to buy shares then calculate total cost and take away from user balance, add shares bought to corresponding variable eg. If AMD bought add to amdOwned else prince error that you couldn't buy shares
    //Take away stocks bought from total stocks of that share (the randomly generated integer) and print out to user they bought the shares - If input for how many stocks they want is < 0 print error
    //If user cancels decision to buy stocks when inputting value then catch exception printing out "Cancelled" 

    public void SellStock(){

        String[] names = {"Apple", "AMD", "Nvidia"};
        String StockSelling =  (String) JOptionPane.showInputDialog(null, "What share would you like to sell? Current prices for selling shares are: \n AMD: \u00A3" + amd.newpricelist.get(0) + "\n Apple: \u00A3" + apple.newpricelist.get(0) + "\n Nvidia: \u00A3" + nvidia.newpricelist.get(0), "Choose Stock", 0, null, names, names[0]);
        try {
            if(StockSelling == "AMD"){
                Integer StocksQuantity = Integer.parseInt(JOptionPane.showInputDialog("How many shares would you like to sell? "));
                if(amdOwned >= StocksQuantity && StocksQuantity > 0){
                    Integer profit = amd.newpricelist.get(0) * StocksQuantity;
                    user.deposit(profit);
                    amdOwned = amdOwned - StocksQuantity;
                    int newQuantity = amd.getQuantity() + StocksQuantity;
                    amd.setQuantity(newQuantity);
                    UI.Text.setText("Successfully sold " + StocksQuantity + " shares of AMD.");
                } else {
                    UI.Text.setText("Error, you do not own that many shares thus cannot sell.");
                }
            }
            if(StockSelling == "Apple"){
                Integer StocksQuantity = Integer.parseInt(JOptionPane.showInputDialog("How many shares would you like to sell? "));
                if(AppleOwned >= StocksQuantity && StocksQuantity > 0){
                    Integer profit = apple.newpricelist.get(0) * StocksQuantity;
                    user.deposit(profit);
                    AppleOwned = AppleOwned - StocksQuantity;
                    int newQuantity = apple.getQuantity() + StocksQuantity;
                    apple.setQuantity(newQuantity);
                    UI.Text.setText("Successfully sold " + StocksQuantity + " shares of Apple.");
                } else {
                    UI.Text.setText("Error, you do not own that many shares thus cannot sell.");
                }
            }
            if(StockSelling == "Nvidia"){
                Integer StocksQuantity = Integer.parseInt(JOptionPane.showInputDialog("How many shares would you like to sell? "));
                if(nvidiaOwned >= StocksQuantity && StocksQuantity > 0){
                    Integer profit = nvidia.newpricelist.get(0) * StocksQuantity;
                    user.deposit(profit);
                    nvidiaOwned = nvidiaOwned - StocksQuantity;
                    int newQuantity = nvidia.getQuantity() + StocksQuantity;
                    nvidia.setQuantity(newQuantity);
                    UI.Text.setText("Successfully sold " + StocksQuantity + " shares of Nvidia.");
                } else {
                    UI.Text.setText("Error, you do not own that many shares thus cannot sell.");
                }
            }
        } catch (Exception e) {
            UI.Text.setText("Cancelled.");
        }
    }
    //Method for when user wants to sell shares - When button clicked a window should pop up displaying the selling price of each stock and drop down list for them to choose their stock to sell
    //If cancelled then do nothing, if selected new window pops up to ask user for how many they want to sell - if input > 0 and they own that many shares then sell
    //Calculate profit by getting input * newpricelist (arraylist from Stocks class), add that on to user balance by using deposit method
    //Take away input from corresponding variable Eg. if AMD sold then take away from amdOwned, add quantity sold back total shares available for session and print successful message
    //If user input < 0 or does not own that many shares then catch the exception - print error message

    public void ShowPortfolio(){
        UI.Text.setText(" Number of AMD stocks owned: " + amdOwned + "\nNumber of Nvidia stocks owned: " + nvidiaOwned + "\nNumber of Apple stocks owned: " + AppleOwned);
    }
    //Method that prints out the number of shares the user currently owns - variable changes every time they either buy/sell stocks

    public void Save(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("userdetails.txt"));
            writer.write(username);
            writer.write("\n" + user.getBalance());
            writer.write("\n" + amdOwned);
            writer.write("\n" + AppleOwned);
            writer.write("\n" + nvidiaOwned);
            writer.close();
        } catch (Exception e) {
            UI.Text.setText("Failed to save, try again");
        }
    }
    //Using java.io library we use BufferedWriter to create a new file called 'userdetails.txt' where if button for save is pressed we save users name, their balance and how many of each stock they own
    //try_catch also used in case an error occurs where a message saying it failed will be printed

    public boolean Load(){
        boolean gotName = false;
        try {
            List<String> reader = Files.lines(filelocation).collect(list);
            username = reader.get(0);
            int savedbalance = Integer.parseInt(reader.get(1));
            user.setBalance(savedbalance);
            amdOwned = Integer.parseInt(reader.get(2));
            AppleOwned = Integer.parseInt(reader.get(3));
            nvidiaOwned = Integer.parseInt(reader.get(4));
            gotName = true;
        } catch (Exception e) {
            gotName = false;
        }
        return gotName;
    }
    //Load button that when pressed will read data from textfile called 'userdetails.txt' and update the information for user automatically such as their name, stocks owned and balance
    //Using libraries such as java.nio and java.util.stream each line of the textfile is read and saved into a List and each line of text is assigned a different variable
    //As when we used Save() we made a new line for each new variable we are storing - here we read each new line and save into their corresponding variable
    //Using try_catch - if user has a previous session then data is loaded if they saved their file - if no previous session exists then when load button is pressed a new session will be created where their name has to be entered - if cancel button is pressed do nothing


    public void selectAction(String userAction){
        if(userAction == null){
            ;
        } else {
            switch(userAction){
                case "Name": Name(); break;
                case "Home": Home(); break;
                case "ShowFunds": ShowFunds(); break;
                case "Deposit": Deposit(); break;
                case "Withdraw": Withdraw(); break;
                case "ShowStock": ShowStock(); break;
                case "BuyStock": BuyStock(); break;
                case "SellStock": SellStock(); break;
                case "ShowPortfolio": ShowPortfolio(); break;
                case "Save": Save(); break;
            }
        }
    }
    //After user clicks a button, redirect them to their appropiate method - if no button is clicked remain at that page and do nothing


}
