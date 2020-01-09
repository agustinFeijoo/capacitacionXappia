package negocio;

import java.util.List;

import dao.ProductoDao;
import modelo.Producto;

public class ProductoNegocio {
	private ProductoDao pd;
	public ProductoNegocio() {
		pd =new ProductoDao();
	}
	public void mostrarProductos() {
		List<Producto>productos=pd.traerProductos();
			for(Producto p:productos){
			System.out.println(p.toString());
		}
	}
	public Producto traerProducto(int idProducto) {
		return pd.traerProducto(idProducto);
	}
}
