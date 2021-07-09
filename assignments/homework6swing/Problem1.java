package homework6swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.IntStream;

public class Problem1 extends JFrame {

    //Defining JButtons
    private final JButton btnCount;
    private final JButton btnReverse;
    private final JButton btnRemDups;

    //Defining JTextField
    private final JTextField tfInput;
    private final JTextField tfOutput;

    // Setting default size of the window
    public static final int DEFAULT_WIDTH = 800;
    public static final int DEFAULT_HEIGHT = 250;

    public Problem1(){
        setTitle("String Utility");

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //change the background color of the frame
        getContentPane().setBackground(new Color(238, 238, 238));
        getContentPane().setLayout(null);

        //Initialization
        btnCount  = new JButton("Count Letters");
        btnCount.setBounds(110, 20, 250, 40);
        btnCount.setFont(new Font("Arial", Font.BOLD, 17));

        btnReverse = new JButton("Reverse Letters");
        btnReverse.setBounds(110, 70, 250, 40);
        btnReverse.setFont(new Font("Arial", Font.BOLD, 17));

        btnRemDups = new JButton("Remove Duplicates");
        btnRemDups.setBounds(110, 120, 250, 40);
        btnRemDups.setFont(new Font("Arial", Font.BOLD, 17));

        //Defining JLabel
        JLabel lblInput = new JLabel("Input"); // lblInput defined as local variable inside constructor because it is not further used
        lblInput.setBounds(380, 30, 300, 20);
        lblInput.setFont(new Font("Arial", Font.PLAIN, 14));
        tfInput = new JTextField(6);
        tfInput.setBounds(380, 55, 300, 25);

        JLabel lblOutput = new JLabel("Output"); // lblOutput defined as local variable inside constructor because it is not further used
        lblOutput.setBounds(380, 85, 300, 20);
        lblOutput.setFont(new Font("Arial", Font.PLAIN, 14));
        tfOutput = new JTextField(6);
        tfOutput.setBounds(380, 110, 300, 25);

        //add to the frame
        add(btnCount);
        add(btnReverse);
        add(btnRemDups);
        add(lblInput);
        add(lblOutput);
        add(tfInput);
        add(tfOutput);


        //Event handling for Button
        Problem1.ButtonHandler btnHandler = new Problem1.ButtonHandler();
        btnCount.addActionListener(btnHandler);
        btnReverse.addActionListener(btnHandler);
        btnRemDups.addActionListener(btnHandler);
    }

    //define event handling inner class for button handler
    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event){
            String input = tfInput.getText();
            if(event.getSource() == btnCount){ // count button pressed
                tfOutput.setText(String.format("%d", input.length()));
            }
            else if(event.getSource() == btnReverse){ // reverse button pressed
                tfOutput.setText(reverse(input));
            }
            else if(event.getSource() == btnRemDups){ // or simply else{ handle remDups }
                 tfOutput.setText(removeDuplicates(input));
            }
        }
        public String reverse(String str){ // returns reverse of a string
            if(str == null || str.length() == 1) // return str if it is null or has size 1
                return str;
            else {
                StringBuilder sbStr = new StringBuilder(str);
                sbStr.reverse(); // reverse the string
                return sbStr.toString(); // convert StringBuilder to String and return
            }
        }
        public String removeDuplicates(String str){ // removeDuplicates method definition
            StringBuilder sb = new StringBuilder(); // StringBuilder object
            IntStream is = str.chars().distinct(); // get distinct characters from str
            is.forEach(c -> sb.append((char) c)); // add each character to string builder object
            return sb.toString(); // convert string builder object to String and return
        }
    }

    // main function
    public static void main(String[] args){
        Problem1 frame = new Problem1();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }
}
