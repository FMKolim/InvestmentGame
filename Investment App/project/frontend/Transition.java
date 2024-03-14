package frontend;

public class Transition {
    //Transition class handles what the user sees

    UserInterface UI;

    public Transition(UserInterface uInterface){
        UI = uInterface;
    }
    
    public void MainMenu(){
        UI.InvestmentAppNameLocation.setVisible(true);
        UI.creatorlocation.setVisible(true);
        UI.InvestmentAppOutputArea.setVisible(false);
        UI.Text.setVisible(false);
        UI.UserChoiceArea.setVisible(false);
        UI.UserStartArea.setVisible(true);
    }
    //First screen that is shown to user, hiding the buttons and text area from user and only showing the title and start/load buttons

    public void MainMenu2(){
        UI.InvestmentAppNameLocation.setVisible(true);
        UI.creatorlocation.setVisible(true);
        UI.InvestmentAppOutputArea.setVisible(true);
        UI.Text.setVisible(true);
        UI.UserChoiceArea.setVisible(true);
        UI.UserStartArea.setVisible(false);
    }
    //After either start/load is pressed the screen hides the buttons and shows the text area and rest of buttons to user - shows user main page of application.
    
}
