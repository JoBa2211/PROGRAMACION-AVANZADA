package a2233336135_Tareas_Unidad01;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class JBotonEvento2 extends JFrame {
    static JLabel La, Lb;
    static JButton Bboton;

    public JBotonEvento2() {
        this.setLayout(null);
        this.setBounds(10, 10, 200, 300);

        La = new JLabel("el triangulo de base 5 y de altura 2");
        La.setBounds(10, 10, 200, 30);
        Lb = new JLabel();
        Lb.setBounds(10, 100, 200, 30);

        Bboton = new JButton();
        Bboton.setText("Calcular");
        Bboton.setBounds(10, 50, 100, 30);
       Bboton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Lb.setText("el área del triángulo es 5");
            }
        });

        this.add(La);
        this.add(Lb);
        this.add(Bboton);
    }

    public static void main(String parametro[]) {
        JBotonEvento2 ventana = new JBotonEvento2();
        ventana.setVisible(true);
    }}