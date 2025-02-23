package a2233336135_Tareas_Unidad01;

import javax.swing.*;
import java.awt.event.*;

/**
 * Write a description of class HandleEvent here.
 * 
 * @author (Eric Y. Chou) 
 * @version (05/28/2016)
 */
public class HandleEventInnerClass extends JFrame {
  public HandleEventInnerClass() {
    // Create two buttons 
    JButton jbtOK = new JButton("OK");
    JButton jbtCancel = new JButton("Cancel");

    // Create a panel to hold buttons
    JPanel panel = new JPanel();
    panel.add(jbtOK);
    panel.add(jbtCancel);

    add(panel); // Add panel to the frame

    // Register listeners
    jbtOK.addActionListener(new ActionListener(){ 
        public void actionPerformed(ActionEvent e) {
          System.out.println("OK button clicked");
         }
    }
    );
    jbtCancel.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e) {
           System.out.println("Cancel button clicked");
        }
    }
    );
  }
  
  public static void main(String[] args) {
    JFrame frame = new HandleEventInnerClass();
    frame.setTitle("Handle Event");
    frame.setSize(200, 150);
    frame.setLocation(200, 100);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
