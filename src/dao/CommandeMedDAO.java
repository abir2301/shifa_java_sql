package dao;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

//import com.mysql.jdbc.PreparedStatement;

import application.NewCommande;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import oo.CommandeMEd;
import oo.Medicament;

public class CommandeMedDAO {
	
            
public static ObservableList<CommandeMEd >  getAllStock (String ph ) throws SQLException, ClassNotFoundException {
		
		 String selectStmt = "select id ,ph, med , numf , prix , datec , datel, sum(quantite) from commandemed  where ph= ? group by med ;";
			 ResultSet rsemps=null;
		        Statement st;
		     
		        try {
		        	 DbUtil.dbConnect();
		        	
		        	java.sql.PreparedStatement selection = DbUtil.conn.prepareStatement(selectStmt);
		    		 selection.setString(1, ph);
		    		ResultSet rsEmps =selection.executeQuery();
		    		// ResultSet rsEmps =st.executeQuery(selectStmt);


		            ObservableList<CommandeMEd> empList =FXCollections.observableArrayList();
		            empList= getMedicament(rsEmps);
		            //Return employee object
		            return empList;
		        } catch (SQLException e) {
		            System.out.println("SQL select operation has been failed: " + e);
		            //Return exception
		            throw e ;}
		        
		 

		
	}
	
public static ObservableList<CommandeMEd >  getAllStockByType (String ph , String type   ) throws SQLException, ClassNotFoundException {
	
	 //String selectStmt = "select id ,ph, m.nom , numf , prix , datec , datel, quantite from commandemed c , medicament m,   where ph= ?  and m.idmed = c.med and m.type = '3' ;";
	 String selectStmt = "select id ,ph, nom , numf , prix , datec , datel,quantite from commandemed , medicament m , typemed t where idmed = med and t.idtype = m.type and ph =?  and t.nomtype like ? ;";
	 		
	 		

	ResultSet rsemps=null;
	        Statement st;
	     
	        try {
	        	 DbUtil.dbConnect();
	        	
	        	java.sql.PreparedStatement selection = DbUtil.conn.prepareStatement(selectStmt);
	    		
	    		 selection.setString(1, ph);
	    		selection.setString(2, type);
	    		ResultSet rsEmps =selection.executeQuery();
	    		// ResultSet rsEmps =st.executeQuery(selectStmt);


	            ObservableList<CommandeMEd> empList =FXCollections.observableArrayList();
	            empList= getMedicament(rsEmps);
	            //Return employee object
	            return empList;
	        } catch (SQLException e) {
	            System.out.println("SQL select operation has been failed: " + e);
	            //Return exception
	            throw e ;}
	        
	 

	
}

public static ObservableList<CommandeMEd >  getAllStockByMarque(String ph , String marque   ) throws SQLException, ClassNotFoundException {
	
	 //String selectStmt = "select id ,ph, m.nom , numf , prix , datec , datel, quantite from commandemed c , medicament m,   where ph= ?  and m.idmed = c.med and m.type = '3' ;";
	 String selectStmt = "select id ,ph, nom , numf , prix , datec , datel,quantite from commandemed , medicament m , marquemed t where idmed = med and t.idmarque = m.marque and ph =?  and t.nommarque like ? ;";
	 		
	 		

	ResultSet rsemps=null;
	        Statement st;
	     
	        try {
	        	 DbUtil.dbConnect();
	        	
	        	java.sql.PreparedStatement selection = DbUtil.conn.prepareStatement(selectStmt);
	    		
	    		 selection.setString(1, ph);
	    		selection.setString(2, marque);
	    		ResultSet rsEmps =selection.executeQuery();
	    		// ResultSet rsEmps =st.executeQuery(selectStmt);


	            ObservableList<CommandeMEd> empList =FXCollections.observableArrayList();
	            empList= getMedicament(rsEmps);
	            //Return employee object
	            return empList;
	        } catch (SQLException e) {
	            System.out.println("SQL select operation has been failed: " + e);
	            //Return exception
	            throw e ;}
	        
	 

	
}
	
public static ObservableList<CommandeMEd >  getAllStockByName(String ph , String Name ) throws SQLException, ClassNotFoundException {
	
	 //String selectStmt = "select id ,ph, m.nom , numf , prix , datec , datel, quantite from commandemed c , medicament m,   where ph= ?  and m.idmed = c.med and m.type = '3' ;";
	 String selectStmt = "select id ,ph, nom , numf , prix , datec , datel,quantite from commandemed , medicament m  where idmed = med and ph =?  and m.nom = ? ;";
	 		
	 		

	ResultSet rsemps=null;
	        Statement st;
	     
	        try {
	        	 DbUtil.dbConnect();
	        	
	        	java.sql.PreparedStatement selection = DbUtil.conn.prepareStatement(selectStmt);
	    		
	    		 selection.setString(1, ph);
	    		selection.setString(2, Name);
	    		ResultSet rsEmps =selection.executeQuery();
	    		// ResultSet rsEmps =st.executeQuery(selectStmt);


	            ObservableList<CommandeMEd> empList =FXCollections.observableArrayList();
	            empList= getMedicament(rsEmps);
	            //Return employee object
	            return empList;
	        } catch (SQLException e) {
	            System.out.println("SQL select operation has been failed: " + e);
	            //Return exception
	            throw e ;}
	        
	 

	
}
	
	
	
	
	
	
	
	
	
private static ObservableList<CommandeMEd> getMedicament(ResultSet rs) throws SQLException, ClassNotFoundException {
	    //Declare a observable List which comprises of Employee objects
	    ObservableList<CommandeMEd> rows=FXCollections.observableArrayList();
		CommandeMEd row=null;
	 try {
	    while (rs.next()) {
	    	row = new CommandeMEd (
	    			rs.getString(1),
	    			rs.getString(2),
	    			rs.getString(3),
	    			rs.getString(4),
	    			rs.getString(5),
	    			rs.getString(6),
	    			rs.getString(7),
	    			rs.getString(8)
	    			);
	    	rows.add(row);
	    	
	        
	       
	        
	        //Add employee to the ObservableList
	        
	    }}
	 catch (Exception e) {
		// TODO: handle exception
	}
	    //return empList (ObservableList of Employees)
	    return rows;
	}
static public int insret(CommandeMEd m) {
	DbUtil.dbConnect();
	 int a = 0 ; 
	 String req =("insert into commandemed values(?,?,?,?,?,?,?,?);");
	 try {
		PreparedStatement ps = (PreparedStatement) DbUtil.conn.prepareStatement(req);
		ps.setString(1, m.geId());
		ps.setString(2, m.getPh());
		ps.setString(3, m.getMed());
		ps.setString(4, m.getNumf());
		ps.setString(5, m.getPrix());
		ps.setString(6,m.getDatec());
		ps.setString(7,m.getDatel() );
		ps.setString(8, m.getQauntite());
		 a =ps.executeUpdate() ;
		 System.out.print("commande inserted ");
		 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	return a;
	
	
	
}
	}




