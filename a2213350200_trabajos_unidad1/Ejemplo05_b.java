package U1_Trabajos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejemplo05_b extends JDialog {

    public Ejemplo05_b(JFrame parent) {
        super(parent, "Ventana Modal", true); // 'true' la hace modal
        setTitle("Hijo");
        setBounds(150, 150, 300, 200); // Posición y tamaño de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cierra solo esta ventana

        JLabel label = new JLabel("Hijo", JLabel.CENTER);
        getContentPane().add(label, BorderLayout.CENTER);
        
        JButton btnNewButton = new JButton("Padre");
        getContentPane().add(btnNewButton, BorderLayout.NORTH);
        
        // Acción del botón que cierra la ventana hija y muestra la ventana padre
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Cierra la ventana hija
                dispose(); 
                // Asegura que la ventana padre sigue visible
                parent.setVisible(true);
            }
        });
    }
}

