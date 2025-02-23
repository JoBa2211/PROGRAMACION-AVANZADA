package U1_Trabajos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tclase01 extends JFrame {
    private JTextField txtNombre, txtApellido;
    private DefaultListModel<String> modeloLista;
    private JList<String> lista;
    
    public Tclase01() {
        setTitle("Formulario");
        setSize(424, 342);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        
        JPanel panelEntrada = new JPanel(new GridLayout(3, 2, 5, 5));
        txtNombre = new JTextField(15);
        txtApellido = new JTextField(15);
        JButton btnAgregar = new JButton("Agregar");
        JButton btnSalir = new JButton("Salir");
        
        panelEntrada.add(new JLabel("Nombre"));
        panelEntrada.add(txtNombre);
        panelEntrada.add(new JLabel("Apellido"));
        panelEntrada.add(txtApellido);
        panelEntrada.add(btnAgregar);
        panelEntrada.add(btnSalir);
        
        modeloLista = new DefaultListModel<>();
        lista = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(lista);
        scrollPane.setPreferredSize(new Dimension(250, 80));
        
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText().trim();
                String apellido = txtApellido.getText().trim();
                if (!nombre.isEmpty() && !apellido.isEmpty()) {
                    modeloLista.addElement(nombre + " " + apellido);
                    txtNombre.setText("");
                    txtApellido.setText("");
                }
            }
        });
        
        btnSalir.addActionListener(e -> System.exit(0));
        
        getContentPane().add(panelEntrada, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Tclase01();
    }
}
