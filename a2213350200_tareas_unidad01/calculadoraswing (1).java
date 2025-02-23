package a2233336135_Tareas_Unidad01;


	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class calculadoraswing {	
	    public static void main(String[] args) {
	        // Crear el marco principal
	        JFrame frame = new JFrame("Traductor de Números de Teléfono");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(400, 200);
	        frame.setLayout(new BorderLayout());

	        // Crear el panel superior con el campo de texto y la etiqueta
	        JPanel topPanel = new JPanel();
	        topPanel.setLayout(new FlowLayout());

	        JLabel label = new JLabel("Número de Teléfono (Ej: 1-800-FLOWERS): ");
	        JTextField phoneInput = new JTextField(20);

	        topPanel.add(label);
	        topPanel.add(phoneInput);

	        // Crear el botón de traducir
	        JButton translateButton = new JButton("Traducir");

	        // Crear el área para mostrar el resultado
	        JLabel resultLabel = new JLabel("Resultado: ");
	        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

	        // Agregar la acción del botón
	        translateButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String input = phoneInput.getText();
	                String translated = translatePhoneNumber(input);
	                resultLabel.setText("Resultado: " + translated);
	            }
	        });

	        // Agregar componentes al marco
	        frame.add(topPanel, BorderLayout.NORTH);
	        frame.add(translateButton, BorderLayout.CENTER);
	        frame.add(resultLabel, BorderLayout.SOUTH);

	        // Hacer visible la ventana
	        frame.setVisible(true);
	    }

	    /**
	     * Método para traducir un número de teléfono con letras a su representación numérica.
	     */
	    private static String translatePhoneNumber(String phoneNumber) {
	        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	        String numbers = "22233344455566677778889999";
	        StringBuilder translated = new StringBuilder();

	        for (char c : phoneNumber.toUpperCase().toCharArray()) {
	            if (Character.isLetter(c)) {
	                int index = letters.indexOf(c);
	                translated.append(numbers.charAt(index));
	            } else {
	                translated.append(c);
	            }
	        }

	        return translated.toString();
	    }
	}


