package U1_Trabajos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimerApp extends JFrame {
    private JButton startButton, stopButton, exitButton;
    private JTextField startTimeField, stopTimeField, elapsedTimeField;
    private long startTime, stopTime;

    public TimerApp() {
        // Configuración de la ventana principal
        setTitle("Timer App");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Componentes
        startButton = new JButton("Start Timing");
        stopButton = new JButton("Stop Button");
        exitButton = new JButton("Exit");

        startTimeField = new JTextField(15);
        stopTimeField = new JTextField(15);
        elapsedTimeField = new JTextField(15);
        elapsedTimeField.setEditable(false);

        // Añadir componentes a la ventana
        add(startButton);
        add(new JLabel("Start Time"));
        add(startTimeField);
        add(stopButton);
        add(new JLabel("Stop Time"));
        add(stopTimeField);
        add(new JLabel("Elapsed Time (sec)"));
        add(elapsedTimeField);
        add(exitButton);

        // ActionListener para el botón Start
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startTime = System.currentTimeMillis();
                startTimeField.setText(getCurrentTime());
            }
        });

        // ActionListener para el botón Stop
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopTime = System.currentTimeMillis();
                stopTimeField.setText(getCurrentTime());

                long elapsed = (stopTime - startTime) / 1000;  // El tiempo transcurrido en segundos
                elapsedTimeField.setText(String.valueOf(elapsed));
            }
        });

        // ActionListener para el botón Exit
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    // Método para obtener la hora actual en formato hh:mm:ss
    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }

    // Método principal
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TimerApp().setVisible(true);
            }
        });
    }
}
