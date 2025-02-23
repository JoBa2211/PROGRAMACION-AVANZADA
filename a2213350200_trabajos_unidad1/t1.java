package U1_Trabajos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoanAssistant extends JFrame {

    public static void main(String args[]) {
        new LoanAssistant().setVisible(true);
    }

    public LoanAssistant() {
        // Frame constructor
        setTitle("Loan Assistant");
        setSize(400, 300); // Establece un tamaño inicial
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Alternativa a WindowAdapter

        getContentPane().setLayout(new GridBagLayout());
        
        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);
    }
}

