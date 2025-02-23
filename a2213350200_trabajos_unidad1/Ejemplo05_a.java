package U1_Trabajos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejemplo05_a {

	private JFrame frmPadre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo05_a window = new Ejemplo05_a();
					window.frmPadre.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ejemplo05_a() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmPadre = new JFrame();
		frmPadre.setTitle("Padre");
		frmPadre.setBounds(100, 100, 450, 300);
		frmPadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Hijo");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ejemplo05_b ventanaB = new Ejemplo05_b(frmPadre); // Crea ventana modal
                ventanaB.setVisible(true);       
			}
		});
		frmPadre.getContentPane().add(btnNewButton, BorderLayout.NORTH);
	}

}
