package U1_Trabajos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Ejemplo05_b1 extends JInternalFrame {
	public Ejemplo05_b1() {
		
		setTitle("Hijo set 2 ");
        setBounds(150, 150, 300, 200); // Posición y tamaño de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana
        
        JLabel lblNewLabel = new JLabel("Paguina Numero 2");
        getContentPane().add(lblNewLabel, BorderLayout.NORTH);
   

	
		
	}
	
}