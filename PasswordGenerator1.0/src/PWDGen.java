import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.*;
import java.lang.*;

public class PWDGen extends Frame implements ActionListener {
    private Label passwordLabel;
    private TextField numOfCharacters;
    private Checkbox symbols;
    private Checkbox numbers;
    private Checkbox lowerc;
    private Checkbox upperc;
    private Button create;
    private Button exitAppButton;

    public PWDGen(){
        setLayout(null);

        passwordLabel = new Label("Password");
        passwordLabel.setBounds(20,20,350,50);
        add(passwordLabel);

        numOfCharacters = new TextField("Number of Characters ", 20);
        numOfCharacters.setBounds(20,75,175,25);
        add(numOfCharacters);

        symbols = new Checkbox("Symbols (e.g.@#$%)");
        symbols.setBounds(15,110,160,25);
        add(symbols);

        numbers = new Checkbox("Numbers (e.g.0123)");
        numbers.setBounds(15,140,170,25);
        add(numbers);

        lowerc = new Checkbox("Lowercase Letters");
        lowerc.setBounds(200,75,160,25);
        add(lowerc);

        upperc = new Checkbox("Uppercase Letters");
        upperc.setBounds(200,105,160,25);
        add(upperc);

        create = new Button("Create Password");
        create.setBounds(200,150,160,25);
        create.addActionListener(this::actionPerformed);
        add(create);

        exitAppButton = new Button("Exit");
        exitAppButton.setBounds(20,215,75,25);
        exitAppButton.addActionListener(this::exitsApp);
        add(exitAppButton);

        setTitle("Password Generator");
        setSize(400,250);
        setVisible(true);
    }

    public static void main(String[] args){
        PWDGen test = new PWDGen();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int numc = Integer.parseInt(numOfCharacters.getText());
        boolean symin = symbols.getState();
        boolean numin = numbers.getState();
        boolean lowin = lowerc.getState();
        boolean uppin = upperc.getState();
        passwordLabel.setText((genPass(numc, symin, numin, lowin, uppin)).toString());
    }

    public void exitsApp(ActionEvent evt){
        System.exit(0);
    }

    public StringBuilder genPass(int strlen, boolean wantSymbols, boolean wantNumbers, boolean wantLowerCase, boolean wantUpperCase){
        StringBuilder password = new StringBuilder();
        int numOfRemainingCharacters = strlen;
        while (numOfRemainingCharacters>0){
            Random rand = new Random();
            int caseGenerator = rand.nextInt(4);
            switch (caseGenerator){
                case 0:
                    if (wantSymbols) {
                        password.append((char) (rand.nextInt(14)+33));
                        numOfRemainingCharacters--;
                        break;
                    }
                case 1:
                    if (wantNumbers) {
                        password.append((char) (rand.nextInt(10)+48));
                        numOfRemainingCharacters--;
                        break;
                    }
                case 2:
                    if (wantLowerCase) {
                        password.append( (char) (rand.nextInt(26)+97));
                        numOfRemainingCharacters--;
                        break;
                    }
                case 3:
                    if (wantUpperCase) {
                        password.append ((char) (rand.nextInt(26)+65));
                        numOfRemainingCharacters--;
                        break;
                    }
            }
        }
        return password;
    }
}
