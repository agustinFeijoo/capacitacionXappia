/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;
/**
 *
 * @author xappia
 */
public class TestConnection {
    public static void main(String[] args) {
		TestConnection obj_DB_Connection = new TestConnection();
		
		System.out.println(obj_DB_Connection.getConnection());
		
		System.out.println("good");
		
	

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