package U1_Trabajos;

public class Cproducto {
	private String id,producto;
	
	public Cproducto(String id, String producto) {
		super();
		this.id = id;
		this.producto = producto;
	}
	
	public Cproducto() {
		super();
		this.id = null;
		this.producto = null;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return this.getProducto();
	}

	
}
