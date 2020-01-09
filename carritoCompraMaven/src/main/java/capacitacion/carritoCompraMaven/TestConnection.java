/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capacitacion.carritoCompraMaven;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import negocio.CarritoComprasNegocio;
import negocio.ProductoNegocio;


/**
 *
 * @author xappia
 */
public class TestConnection {
    public static void main(String[] args) {
		TestConnection obj_DB_Connection = new TestConnection();
		CarritoComprasNegocio carritoComprasNegocio=new CarritoComprasNegocio();
		Scanner sc =new Scanner(System.in);
		int entradaInt=0,idProducto;
		String entrada;
		ProductoNegocio pn=new ProductoNegocio();
		
		System.out.println(obj_DB_Connection.getConnection());
		
		
		do{
			System.out.println("Que desea hacer \n 1 para ver productos \n 2 para ver carrito \n 3 para comprar \n 4 para sacar producto \n 0 para cancelar");
			entrada=sc.nextLine();
			try {
				entradaInt=Integer.parseInt(entrada);				
			}catch(NumberFormatException ne) {
				System.out.println("Error,solo pasar numeros");
			}
			
			switch(entradaInt) {
			case 1:
				
				pn.mostrarProductos();
				
			
			break;
			case 2:
				carritoComprasNegocio.mostrarProductos();
			break;
			
			case 3:
				pn.mostrarProductos();
				System.out.println("Que producto desea comprar?");
				entrada=sc.nextLine();
				try {
					idProducto=Integer.parseInt(entrada);				
				}catch(NumberFormatException ne){
					System.out.println("Error,solo pasar numeros");
				}
				carritoComprasNegocio.anadir(idProducto)
			break;
			case 4: 
				pn.mostrarProductos();
				System.out.println("Que producto desea sacar?");
				try {
					idProducto=Integer.parseInt(entrada);				
				}catch(NumberFormatException ne){
					System.out.println("Error,solo pasar numeros");
				}
				carritoComprasNegocio.sacar(idProducto);
			break;
			
					
			
			}		
		}while((entradaInt!=3) && (entradaInt!=4));
		sc.close();
		
		
	

	}

	
	public Connection getConnection() {
		Connection connection = null;
		System.out.println("connection called");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carrito","root","root");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) { 
			e.printStackTrace();
		}
		return connection;
	}
}