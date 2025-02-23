package U1_Trabajos;

public class Ejemplo07a_Controlador {
	
	private Ejemplo07a_vista vista;
	private Ejemplo07a_modelo modelo;
	
	public Ejemplo07a_Controlador(Ejemplo07a_vista vista, Ejemplo07a_modelo modelo) {
		super();
		this.vista = vista;
		this.modelo = modelo;
		Cproducto p1=new Cproducto("001","CocaCola");
		Cproducto p2=new Cproducto("003","Pepsi Cola");
		Cproducto p3=new Cproducto("004","CocaCola Light");
		Cproducto p4=new Cproducto("005","BigCola");
		
		modelo.InsertComboBox(p1);
		modelo.InsertComboBox(p2);
		modelo.InsertComboBox(p3);
		modelo.InsertComboBox(p4);
		
		modelo.InsertListBox(p1);
		modelo.InsertListBox(p2);
		modelo.InsertListBox(p3);
		modelo.InsertListBox(p4);
		
		vista.setComboboxModel(modelo.getModelComboBox());
		vista.serListModel(modelo.getModeloList());
		
	}
	
	

}
