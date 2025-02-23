package a2233336135_Tareas_Unidad01;



import java.awt.EventQueue;


import javax.swing.JFrame;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
public class JBoton extends JFrame{
	static JLabel La,Lb;
	static JButton Bboton;
	public JBoton()
	{
this.setLayout(null);
this.setBounds(10,10,300,300);
La=new JLabel("el triangulo de base 5 y de altura 2");
La.setBounds(10,10,200,30);
Lb=new JLabel();
Lb.setBounds(10, 100,200, 30);
Bboton=new JButton("Calcular");
Bboton.setBounds(10, 50,100, 30);
this.add(La);
this.add(Lb);
this.add(Bboton);
	}
	
	public static void main(String[] args) {
JBoton ventana=new JBoton();
ventana.setVisible(true);
Lb.setText("el  area del triangulo es 5");

	}


}
