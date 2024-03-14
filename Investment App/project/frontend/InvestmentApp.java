package frontend;
import java.awt.event.*;
//Import event librarires that contains Action Listener

public class InvestmentApp{

    public class OptionHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            String userchoice = event.getActionCommand();
            switch(userchoice){
                case "Load": 
                if(workingApp.Load() == false ){
                    ;
                } else {
                    MainMenu.MainMenu2(); workingApp.Home(); break;
                }
                case "Start": 
                if(workingApp.Name() == null ){
                    ;
                } else {
                    MainMenu.MainMenu2(); workingApp.Home(); break;
                }
                case "Option 1": workingApp.selectAction(nextAction1); break;
                case "Option 2": workingApp.selectAction(nextAction2); break;
                case "Option 3": workingApp.selectAction(nextAction3); break;
                case "Option 4": workingApp.selectAction(nextAction4); break;
                case "Option 5": workingApp.selectAction(nextAction5); break;
                case "Option 6": workingApp.selectAction(nextAction6); break;
                case "Option 7": workingApp.selectAction(nextAction7); break;
                case "Option 8": workingApp.selectAction(nextAction8); break;
                case "Save": workingApp.Save(); break;
                
            }
        }
    }
    //Using switch case that controls the buttons that the user presses, we start off with Load and Start as they are on home page, if name is not inputted then stay on page - if no load file is found stay on same page too until name is inputted
    //If Load/Start is success then hide title screen and show user the main page of app 
    
    UserInterface UI = new UserInterface();
    OptionHandler userchoice = new OptionHandler();
    Transition MainMenu = new Transition(UI);
    User user = new User();
    ButtonsActions workingApp = new ButtonsActions(this, UI, MainMenu, user);
    String nextAction1;
    String nextAction2;
    String nextAction3;
    String nextAction4;
    String nextAction5;
    String nextAction6;
    String nextAction7;
    String nextAction8;
    String Save;
    
    //Create new instances of the different classes we have and give them a variable name
    //Pass these variables to class that deals with user input 
    //Specifying some String variables

    public InvestmentApp(){
        UI.GUICreation(userchoice);
        workingApp.StartingFunds();
        MainMenu.MainMenu();
    }
    //InvestmentApp method calls UserInterface, User and ButtonsAction - initializes them so that when ran always goes back to start/load screen - funds are always 0 unless load is selected and hides the textarea and user buttons

    
    public static void main(String[] a){
        new InvestmentApp();
    }
    //Main method that makes a new instance of InvestmentApp

}
