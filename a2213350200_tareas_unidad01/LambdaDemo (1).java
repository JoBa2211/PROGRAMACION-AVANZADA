package a2233336135_Tareas_Unidad01;
import javax.swing.*;
import java.awt.event.*;

/**
 * Write a description of class LambdaDemo here.
 * 
 * @author (Eric Y. Chou) 
 * @version (05/30/2016)
 */
public class LambdaDemo extends JFrame{
  public LambdaDemo() {
    // Create four buttons
    JButton jbtNew = new JButton("New");
    JButton jbtOpen = new JButton("Open");
    JButton jbtSave = new JButton("Save");
    JButton jbtPrint = new JButton("Print");

    // Create a panel to hold buttons
    JPanel panel = new JPanel();
    panel.add(jbtNew);
    panel.add(jbtOpen);
    panel.add(jbtSave);
    panel.add(jbtPrint);
    
    add(panel);

    // Create and register anonymous inner class listener
    jbtNew.addActionListener(  e -> {System.out.println("Process New");}   );
    jbtOpen.addActionListener( e -> {System.out.println("Process Open");}  );
    jbtSave.addActionListener( e -> {System.out.println("Process Save");}  );
    jbtPrint.addActionListener(e -> {System.out.println("Process Print");} );
  }

  /** Main method */
  public static void main(String[] args) {
    JFrame frame = new LambdaDemo();
    frame.setTitle("AnonymousListenerDemo");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}