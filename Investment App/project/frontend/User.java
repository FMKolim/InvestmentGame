package frontend;

public class User{
    
    private int Balance; 
    //Initialize a new private variable called 'Balance' which will hold the users balance

    public User(){

        this.Balance = 0;

    }
    //When application is started and not saved/loaded set the users balance to 0


    public User(int Balance){

        this.Balance = Balance;

    }
    //Set the balance of user to whatever value is passed as parameter 

    public void setBalance(Integer Balance){

        this.Balance = Balance;

    }
    //Setters used to set the balance to whatever is passed as parameter

    public Integer getBalance(){

        return this.Balance;

    }
    //Getters used to get the balance of the user

    public void deposit(int amount){

        Balance = Balance + amount;

    }
    //Deposit method that adds the 'amount' passed as parameter to users balance
    
    public void withdraw(int amount){

        Balance = Balance - amount;

    }
    //Withdraw method that withdraws the 'amount' passed as parameter from users balance




}
