import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends Frame{
    private TextField inputa;
    private TextField inputb;
    private TextField output;
    private Button a;
    private Button s;
    private Button m;
    private Button d;
    private Button c;
    private String ans;
    public CalculatorGUI(){
        setLayout(new FlowLayout());
        //INSERT TEXT
        inputa = new TextField("Enter first number ... ",20);
        add(inputa);
        inputa.setEditable(true);

        inputb = new TextField ("Enter second number ... ", 20);
        add(inputb);
        inputb.setEditable(true);

        a = new Button("ADD");
        add(a);
        a.addActionListener(this::actionPerformed);
        s = new Button("SUBTRACT");
        add(s);
        s.addActionListener(this::actionPerformed);
        m = new Button("MULTIPLY");
        add(m);
        m.addActionListener(this::actionPerformed);
        d = new Button("DIVIDE");
        add(d);
        d.addActionListener(this::actionPerformed);
        c = new Button("CANCEL");
        add(c);
        c.addActionListener(this::actionPerformed);

        output = new TextField(""+ans,  30);
        add(output);
        output.setEditable(false);

        //Required
        setTitle("Calculator");
        setSize(250,250);
        setVisible(true);
    }
    public static void main(String[] args){
        CalculatorGUI test = new CalculatorGUI();
    }

    public void actionPerformed(ActionEvent evt){
        double x1 = Double.parseDouble(inputa.getText());
        double x2 = Double.parseDouble(inputb.getText());
        if (evt.getSource()==a){
            output.setText(String.valueOf(x1+x2));
        }else if (evt.getSource()==s){
            output.setText(String.valueOf(x1-x2));
        }else if (evt.getSource()==m){
            output.setText(String.valueOf(x1*x2));
        }else if (evt.getSource()==d){
            output.setText(String.valueOf(x1/x2));
        }else{
            System.exit(0);
        }
    }
}
