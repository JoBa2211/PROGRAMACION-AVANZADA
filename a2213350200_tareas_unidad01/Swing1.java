package U1_Trabajos;
import javax.swing.*;
public class Swing1 {


	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable(){
			
			public void run() {
				// crea el jframe y le da titulo
				
				new MainFrame();
				
			}
			
		});

	}

}
