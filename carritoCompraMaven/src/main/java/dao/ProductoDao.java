package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Producto;

/**
 * Una implementacion de {@link ProductoDAO} que persiste
 * en una base de datos relacional utilizando JDBC
 *
 */
public class ProductoDao{

	public CarritoComprasDao() {
	}

	@Override
	public void guardar(Producto Producto) {
		this.executeWithConnection(conn -> {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Producto (nombre, pesoMaximo, xp, vida) VALUES (?,?,?,?)");
			ps.setString(1, Producto.getNombre());
			ps.setInt(2, Producto.getPesoMaximo());
			ps.setInt(3, Producto.getXp());
			ps.setInt(4, Producto.getVida());
			//ojo, no estamos guardando el inventario!
			ps.execute();

			if (ps.getUpdateCount() != 1) {
				throw new RuntimeException("No se inserto el Producto " + Producto);
			}
			ps.close();

			return null;
		});
	}

	@Override
	public Producto recuperar(String nombre) {
		return this.executeWithConnection(conn -> {
			PreparedStatement ps = conn.prepareStatement("SELECT pesoMaximo, xp, vida FROM Producto WHERE nombre = ?");
			ps.setString(1, nombre);
			
			ResultSet resultSet = ps.executeQuery();

			Producto Producto = null;
			while (resultSet.next()) {
				//si Producto no es null aca significa que el while dio mas de una vuelta, eso
				//suele pasar cuando el resultado (resultset) tiene mas de un elemento.
				if (Producto != null) {
					throw new RuntimeException("Existe mas de un Producto con el nombre " + nombre);
				}
				
				Producto = new Producto(nombre);
				Producto.setPesoMaximo(resultSet.getInt("pesoMaximo"));
				Producto.setXp(resultSet.getInt("xp"));
				Producto.setVida(resultSet.getInt("vida"));
			}

			ps.close();
			return Producto;
		});
	}

	/**
	 * Ejecuta un bloque de codigo contra una conexion.
	 */
	private <T> T executeWithConnection(ConnectionBlock<T> bloque) {
		Connection connection = this.openConnection();
		try {
			return bloque.executeWith(connection);
		} catch (SQLException e) {
			throw new RuntimeException("Error no esperado", e);
		} finally {
			this.closeConnection(connection);
		}
	}

	/**
	 * Establece una conexion a la url especificada
	 * @return la conexion establecida
	 */
	private Connection openConnection() {
		try {
			//La url de conexion no deberia estar harcodeada aca
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/carrito","root","root");
		} catch (SQLException e) {
			throw new RuntimeException("No se puede establecer una conexion", e);
		}
	}

	/**
	 * Cierra una conexion con la base de datos (libera los recursos utilizados por la misma)
	 * @param connection - la conexion a cerrar.
	 */
	private void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException("Error al cerrar la conexion", e);
		}
	}


}
