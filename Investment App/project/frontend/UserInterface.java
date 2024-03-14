package frontend;
import javax.swing.*;
import frontend.InvestmentApp.OptionHandler;
import java.awt.*;
//Import java swing, awt libraries and optionhandler

public class UserInterface{

    JFrame MainMenu;
    JPanel InvestmentAppNameLocation;
    JLabel InvestmentAppName;
    JPanel creatorlocation;
    JLabel creatortitle;
    Container container;
    Font TitleFont = new Font("Comic Sans", Font.BOLD, 25);
    Font CreatorFont = new Font("Comic Sans", Font.ITALIC, 10   );
    JPanel InvestmentAppOutputArea;
    JPanel UserChoiceArea;
    JPanel UserStartArea;
    JPanel UserFundsPanel;
    JLabel UserFunds;
    JButton Start;
    JButton option1;
    JButton option2;
    JButton option3;
    JButton option4;
    JButton option5;
    JButton option6;
    JButton option7;
    JButton option8;
    JButton Save;
    JButton Load;
    JTextArea Text;
    ImageIcon background;
    JLabel appBackground;
    //Creating labels/buttons/panels and assigning them a name

    public void GUICreation(OptionHandler userchoice){

        MainMenu = new JFrame();
        MainMenu.setSize(800,600);
        MainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainMenu.getContentPane().setBackground(Color.gray);
        MainMenu.setLayout(null);
        MainMenu.setTitle("Investment App");
        container = MainMenu.getContentPane();
        //A window in which text and buttons will show up in is created, specifies the name of window that will pop up, what happens when X is clicked and the size of the window

        InvestmentAppNameLocation = new JPanel();
        InvestmentAppNameLocation.setBounds(300, 40, 200, 40);
        InvestmentAppNameLocation.setOpaque(false);
        container.add(InvestmentAppNameLocation);
        //Location for where the title is to be on the frame is specified with its dimensions and transparency option

        InvestmentAppName = new JLabel("Investment App");
        InvestmentAppName.setForeground(Color.cyan);
        InvestmentAppName.setFont(TitleFont);
        InvestmentAppNameLocation.add(InvestmentAppName);
        //The actual title of the application is specified here with its font and colour, which is then added to the location of where title is to be

        creatorlocation = new JPanel();
        creatorlocation.setBounds(420, 80, 50, 50);
        creatorlocation.setOpaque(false);
        container.add(creatorlocation);
        //Location for where the creator title is to be on the frame is specified with its dimensions and transparency option

        creatortitle = new JLabel("By Fahad");
        creatortitle.setForeground(Color.orange);
        creatortitle.setFont(CreatorFont);
        creatorlocation.add(creatortitle);
        //The creator title of the application is specified here with its font and colour, which is then added to the creator location

        InvestmentAppOutputArea = new JPanel();
        InvestmentAppOutputArea.setBounds(70, 130, 640, 250);
        InvestmentAppOutputArea.setBackground(Color.white);
        MainMenu.add(InvestmentAppOutputArea);
        //This is the text area which will output text and such to the user

        Text = new JTextArea();
        Text.setBounds(70, 130, 640, 250);
        Text.setBackground(Color.white);
        Text.setForeground(Color.black);
        Text.setLineWrap(true);
        Text.setWrapStyleWord(true);
        Text.setEditable(false);
        InvestmentAppOutputArea.add(Text);
        //Methods to specify the settings of the text area, such as the bounds in which the text can show up in, the background/foreground colour, if its editable etc.

        UserChoiceArea = new JPanel();
        UserChoiceArea.setBounds(130, 400, 500, 150);
        UserChoiceArea.setBackground(Color.black);
        UserChoiceArea.setLayout(new GridLayout(3,4));
        MainMenu.add(UserChoiceArea);
        //Specifying where the users buttons will be on the screen after they have signed in/loaded in

        UserStartArea = new JPanel();
        UserStartArea.setBounds(300, 300, 200, 100);
        UserStartArea.setLayout(new GridLayout(1,2));
        MainMenu.add(UserStartArea);
        //Specifying where the user buttons will be when the application is initially started - where start/load buttons will be 

        //Below are the buttons - each specifying their colours, what would happen is clicked, where it will go and their names
        Start = new JButton("Start");
        Start.setBackground(Color.black);
        Start.setForeground(Color.white);
        Start.setFocusPainted(false);
        Start.addActionListener(userchoice);
        Start.setActionCommand("Start");
        UserStartArea.add(Start);

        Load = new JButton("Load");
        Load.setBackground(Color.black);
        Load.setForeground(Color.white);
        Load.setFocusPainted(false);
        Load.addActionListener(userchoice);
        Load.setActionCommand("Load");
        UserStartArea.add(Load);

        option1 = new JButton();
        option1.setBackground(Color.black);
        option1.setForeground(Color.white);
        option1.setFocusPainted(false);
        option1.addActionListener(userchoice);
        option1.setActionCommand("Option 1");
        UserChoiceArea.add(option1);

        option2 = new JButton();
        option2.setBackground(Color.black);
        option2.setForeground(Color.white);
        option2.setFocusPainted(false);
        option2.addActionListener(userchoice);
        option2.setActionCommand("Option 2");
        UserChoiceArea.add(option2);

        option3 = new JButton();
        option3.setBackground(Color.black);
        option3.setForeground(Color.white);
        option3.setFocusPainted(false);
        option3.addActionListener(userchoice);
        option3.setActionCommand("Option 3");
        UserChoiceArea.add(option3);

        option4 = new JButton();
        option4.setBackground(Color.black);
        option4.setForeground(Color.white);
        option4.setFocusPainted(false);
        option4.addActionListener(userchoice);
        option4.setActionCommand("Option 4");
        UserChoiceArea.add(option4);

        option5 = new JButton();
        option5.setBackground(Color.black);
        option5.setForeground(Color.white);
        option5.setFocusPainted(false);
        option5.addActionListener(userchoice);
        option5.setActionCommand("Option 5");
        UserChoiceArea.add(option5);

        option6 = new JButton();
        option6.setBackground(Color.black);
        option6.setForeground(Color.white);
        option6.setFocusPainted(false);
        option6.addActionListener(userchoice);
        option6.setActionCommand("Option 6");
        UserChoiceArea.add(option6);

        option7 = new JButton();
        option7.setBackground(Color.black);
        option7.setForeground(Color.white);
        option7.setFocusPainted(false);
        option7.addActionListener(userchoice);
        option7.setActionCommand("Option 7");
        UserChoiceArea.add(option7);

        option8 = new JButton();
        option8.setBackground(Color.black);
        option8.setForeground(Color.white);
        option8.setFocusPainted(false);
        option8.addActionListener(userchoice);
        option8.setActionCommand("Option 8");
        UserChoiceArea.add(option8);

        Save = new JButton("Save");
        Save.setBackground(Color.black);
        Save.setForeground(Color.white);
        Save.setFocusPainted(false);
        Save.addActionListener(userchoice);
        Save.setActionCommand("Save");
        UserChoiceArea.add(Save);

        //Try catch method to display background image for the app, if image is found then make it the background else change the properties of title etc. 
        try {
            background = new ImageIcon(this.getClass().getResource("InvestmentAppBackground.png"));
            appBackground = new JLabel(background);
            appBackground.setSize(800, 600);
            MainMenu.add(appBackground);
        } catch (Exception e) {
            InvestmentAppNameLocation.setOpaque(true);
            creatorlocation.setOpaque(true);
            InvestmentAppNameLocation.setBackground(Color.black);
            creatorlocation.setBackground(Color.black);
        }

        MainMenu.setLocationRelativeTo(null);
        MainMenu.setVisible(true);
        //Centres the window when application is run and makes it visible.
    }
}