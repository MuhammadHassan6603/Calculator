import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String;
class Calculator implements ActionListener
{
    JFrame frame;
    JTextField textfield;
    JButton [] numbuttons=new JButton[10];
    JButton [] funcbuttons=new JButton[8];
    JButton addButton,subButton,divButton,mulButton;
    JButton decButton,clrButton,delButton,equalButton;
    JPanel panel;
    double num1=0,num2=0,result=0;
    char operator;

    Calculator()
    {
        frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(3);
        frame.setSize(420,550);
        frame.setLayout(null);


        textfield =new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setEditable(false);

        addButton=new JButton("+");
        subButton=new JButton("-");
        divButton=new JButton("/");
        mulButton=new JButton("*");
        decButton=new JButton(".");
        clrButton=new JButton("Clear");
        delButton=new JButton("Delete");
        equalButton=new JButton("Equal");

        funcbuttons[0]=addButton;
        funcbuttons[1]=subButton;
        funcbuttons[2]=divButton;
        funcbuttons[3]=mulButton;
        funcbuttons[4]=decButton;
        funcbuttons[5]=clrButton;
        funcbuttons[6]=delButton;
        funcbuttons[7]=equalButton;

        for(int i=0;i<8;i++)
        {
            funcbuttons[i].addActionListener(this);
        }
        for(int i=0;i<10;i++)
        {
            numbuttons[i]=new JButton(String.valueOf(i));
            numbuttons[i].addActionListener(this);
        }

        clrButton.setBounds(50,430,145,50);
        delButton.setBounds(205,430,145,50);

        panel=new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        
        panel.add(numbuttons[1]);        
        panel.add(numbuttons[2]);
        panel.add(numbuttons[3]);
        panel.add(addButton);
        panel.add(numbuttons[4]);
        panel.add(numbuttons[5]);
        panel.add(numbuttons[6]);
        panel.add(subButton);
        panel.add(numbuttons[7]);
        panel.add(numbuttons[8]);
        panel.add(numbuttons[9]);
        panel.add(mulButton);
        panel.add(equalButton);
        panel.add(numbuttons[0]);
        panel.add(decButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(clrButton);
        frame.add(delButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String args[])
    {
        Calculator calc=new Calculator();
    }

    public void actionPerformed(ActionEvent e)
    {
        for(int i=0;i<10;i++)
        {
            if(e.getSource() == numbuttons[i])
            {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton)
            {
                textfield.setText(textfield.getText().concat("."));
            }
        if(e.getSource() == subButton)
            {
                num1=Double.parseDouble(textfield.getText());
                operator='-';
                textfield.setText("");
            }
        if(e.getSource() == mulButton)
            {
                num1=Double.parseDouble(textfield.getText());
                operator='*';
                textfield.setText("");
            }
        if(e.getSource() == divButton)
            {
                num1=Double.parseDouble(textfield.getText());
                operator='/';
                textfield.setText("");
            }
        if(e.getSource() == addButton)
            {
                num1=Double.parseDouble(textfield.getText());
                operator='+';
                textfield.setText("");
            }
        if(e.getSource() == clrButton)
            {
                textfield.setText("");
            }
        if(e.getSource() == delButton)
            {
                String s=textfield.getText();
                textfield.setText(s.substring(0,s.length()-1));
            }
        if(e.getSource() == equalButton)
        {
            num2=Double.parseDouble(textfield.getText());
            switch(operator)
            {
                case'+':
                    result=num1+num2;
                    break;
                case'-':
                    result=num1-num2;
                    break;
                case'*':
                    result=num1*num2;
                    break;
                case'/':
                    result=num1/num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
        }
    }
}