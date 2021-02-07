package com.crm.autodesk.genericlib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
/**
 * 
 * @author Deepak
 *
 */
public class DatabaseUtils {
	 Connection con = null;
	 ResultSet result = null;

	
	public void connectToDB() {
		Driver driverRef;
		try {
			driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SDET", "root", "root");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}
	
	
	public void closeDb() throws SQLException {
		con.close();
	}
	
	
	/**
	 * used to execute select database query & retrun table in the form of ResultSet 
	 * @param query
	 * @return ResultSet
	 * @throws SQLException 
	 */
	public ResultSet executeDBSelectQuery(String query) throws SQLException {
		Connection con = null;
		ResultSet result = null;
		try {
			//step 1 : rigester the database 
		      Driver mysqlDriverR = new Driver();
		      DriverManager.registerDriver(mysqlDriverR);
			//step 2 : connect to database 
		        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");  
			//step 3 : create a statement ref
		       Statement stat = con.createStatement();		       		       
			//step 4: execute Query
		       result=  stat.executeQuery(query);
		     
		}catch (Exception e) {
				System.err.println("query is invalid");
		}finally {
				//step 5: close the conection
			 con.close();
			 System.out.println("close");
		}
		return result;
	}

	/**
	 *   used to execute non select database query & return int, if 0==> invalid query , 1==> executed successfully
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public int  executeNonSelectQuery(String query) throws SQLException {
		Connection con = null;
		 int result=0;
			try {
			      Driver mysqlDriverR = new Driver();
			      DriverManager.registerDriver(mysqlDriverR);
			        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			       Statement stat = con.createStatement();
			       result=  stat.executeUpdate(query);
			           if(result==1) {
			        	   System.out.println("query successfully executed");
			           }                
			}catch (Exception e) {
				if(result==0) {
					System.err.println("invaid query");
				}
					System.out.println(result);
			}finally {
				 con.close();
				 System.out.println("close");
			}
       return result;
	}
}
