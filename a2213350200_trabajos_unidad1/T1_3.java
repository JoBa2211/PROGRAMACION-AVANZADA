package a2213350200_tareas_unidad01;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
public class T1_3 extends JFrame{
	static JLabel La,Lb;
	static JButton Bboton;
	public T1_3()
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
		T1_3 ventana=new T1_3();
		ventana.setVisible(true);
		Lb.setText("el  area del triangulo es 5");

	}
}
