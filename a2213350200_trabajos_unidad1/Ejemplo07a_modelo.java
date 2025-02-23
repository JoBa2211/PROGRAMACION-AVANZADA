package U1_Trabajos;
import javax.swing.*;
public class Ejemplo07a_modelo {
 private DefaultComboBoxModel listacombo;
 private DefaultListModel listalista;
 
 public Ejemplo07a_modelo() {
	listacombo=new DefaultComboBoxModel();
	listalista=new DefaultListModel();
	
 }
 public DefaultComboBoxModel getModelComboBox() {
	 return this.listacombo;
 }
 public DefaultListModel getModeloList() {
	 return this.listalista;
 }
 public void InsertComboBox(Cproducto info) {
	 this.listacombo.addElement(info);
 }
 public void InsertListBox(Cproducto info) {
	 this.listalista.addElement(info);
 }
}
