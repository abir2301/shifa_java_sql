package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import application.NewCommande;
import oo.CommandeMEd;
import oo.Fournisseur;
import oo.Medicament;
import oo.Pharmacie;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

public class FournisseurDAO {

	static public int insere(Fournisseur m) {
		DbUtil.dbConnect();
		 int a = 0 ; 
		 String req =("insert into fournisseur  values(?,?,?,?,?);");
		 try {
			PreparedStatement ps = (PreparedStatement) DbUtil.conn.prepareStatement(req);
			ps.setString(1, m.getNum());
			ps.setString(2, m.getNomf());
			ps.setString(3, m.getAdresse());
			ps.setString(4, m.getNumtel());
			
			 a =ps.executeUpdate() ;
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
		
		
		
	}
	static public int update(Fournisseur m) {
		DbUtil.dbConnect();
		 int a = 0 ; 
		 String req =("update fournisseur set  num=? ,nomf =? ,adresse =? numtel=? ;");
		 try {
			PreparedStatement ps = (PreparedStatement) DbUtil.conn.prepareStatement(req);
			ps.setString(1, m.getNum());
			ps.setString(2, m.getNomf());
			ps.setString(3, m.getAdresse());
			ps.setString(4, m.getNumtel());
			 a =ps.executeUpdate() ;
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
		
		
		
		
		
	}


	static public int delete( String id ) {
		DbUtil.dbConnect();
		 int a = 0 ; 
		 String req =("delete from fournisseur  where num=?;");
		 try {
			PreparedStatement ps = (PreparedStatement) DbUtil.conn.prepareStatement(req);
			ps.setString(1, id);
			
			 a =ps.executeUpdate() ;
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
		
		
		
		
		
	}
		
	public static ObservableList<Fournisseur >  getAllFournisseur (String ph ) throws SQLException, ClassNotFoundException {
		
		 String selectStmt = " select distinct(f.num ),f.nomf, f.adresse, f.numtel from fournisseur f , commandemed c where f.num=c.numf and c.ph = ? ;";
			 ResultSet rsemps=null;
		        Statement st;
		     
		        try {
		        	 DbUtil.dbConnect();
		        	
		        	java.sql.PreparedStatement selection = DbUtil.conn.prepareStatement(selectStmt);
		    		 selection.setString(1, ph);
		    		ResultSet rsEmps =selection.executeQuery();
		    		// ResultSet rsEmps =st.executeQuery(selectStmt);


		            ObservableList<Fournisseur> empList =FXCollections.observableArrayList();
		            empList= getFournisseurList (rsEmps);
		            //Return employee object
		            return empList;
		        } catch (SQLException e) {
		            System.out.println("SQL select operation has been failed: " + e);
		            //Return exception
		            throw e ;}
		        
		 

		
	}
	
	public static ObservableList<Fournisseur >  getFournisseurNoun(String ph , String nom  ) throws SQLException, ClassNotFoundException {
		
		 String selectStmt = "select distinct(f.num ),f.nomf, f.adresse, f.numtel from fournisseur f , commandemed c where f.num=c.numf and c.ph = ? and f.nomf =? ";
			 ResultSet rsemps=null;
		        Statement st;
		     
		        try {
		        	 DbUtil.dbConnect();
		        	
		        	java.sql.PreparedStatement selection = DbUtil.conn.prepareStatement(selectStmt);
		    		 selection.setString(1, ph);
		    		 selection.setString(2, nom);
		    		ResultSet rsEmps =selection.executeQuery();
		    		// ResultSet rsEmps =st.executeQuery(selectStmt);


		            ObservableList<Fournisseur> empList =FXCollections.observableArrayList();
		            empList= getFournisseurList (rsEmps);
		            //Return employee object
		            return empList;
		        } catch (SQLException e) {
		            System.out.println("SQL select operation has been failed: " + e);
		            //Return exception
		            throw e ;}
		        
		 

		
	}
	
	public static ObservableList<Fournisseur >  getFournisseurAdresse(String ph , String adresse  ) throws SQLException, ClassNotFoundException {
		
		 String selectStmt = "select distinct(f.num ),f.nomf, f.adresse, f.numtel from fournisseur f , commandemed c where f.num=c.numf and c.ph = ? and f.adresse =? ";
			 ResultSet rsemps=null;
		        Statement st;
		     
		        try {
		        	 DbUtil.dbConnect();
		        	
		        	java.sql.PreparedStatement selection = DbUtil.conn.prepareStatement(selectStmt);
		    		 selection.setString(1, ph);
		    		 selection.setString(2, adresse);
		    		ResultSet rsEmps =selection.executeQuery();
		    		// ResultSet rsEmps =st.executeQuery(selectStmt);


		            ObservableList<Fournisseur> empList =FXCollections.observableArrayList();
		            empList= getFournisseurList (rsEmps);
		            //Return employee object
		            return empList;
		        } catch (SQLException e) {
		            System.out.println("SQL select operation has been failed: " + e);
		            //Return exception
		            throw e ;}
		        
		 

		
	}
	
	public static ObservableList<Fournisseur >  getFournisseurMEd(String ph , String med  ) throws SQLException, ClassNotFoundException {
		
		 String selectStmt = "select distinct(f.num ),f.nomf, f.adresse, f.numtel from fournisseur f , commandemed c  , medicament m where f.num=c.numf and m.idmed = c.med and c.ph = ? and m.nom =? ";
			 ResultSet rsemps=null;
		        Statement st;
		     
		        try {
		        	 DbUtil.dbConnect();
		        	
		        	java.sql.PreparedStatement selection = DbUtil.conn.prepareStatement(selectStmt);
		    		 selection.setString(1, ph);
		    		 selection.setString(2, med);
		    		ResultSet rsEmps =selection.executeQuery();
		    		// ResultSet rsEmps =st.executeQuery(selectStmt);


		            ObservableList<Fournisseur> empList =FXCollections.observableArrayList();
		            empList= getFournisseurList (rsEmps);
		            //Return employee object
		            return empList;
		        } catch (SQLException e) {
		            System.out.println("SQL select operation has been failed: " + e);
		            //Return exception
		            throw e ;}
		        
		 

		
	}
		  
		  
		  
			   
		 private static ObservableList<Fournisseur> getFournisseurList (ResultSet rs) throws SQLException, ClassNotFoundException {
		        //Declare a observable List which comprises of Employee objects
		        ObservableList<Fournisseur> rows=FXCollections.observableArrayList();
			     Fournisseur row=null;
			 try {
			    while (rs.next()) {
			    	row = new Fournisseur (
			    			 rs.getString(1),
					            rs.getString(2),
					            rs.getString(3),
					            rs.getString(4));
					            
			    			
			    	rows.add(row);
			    	
			        
			       
			        
			        //Add employee to the ObservableList
			        
			    }}
			 catch (Exception e) {
				// TODO: handle excep
		       
		        //return empList (ObservableList of Employees)
		      
		    }
			return rows;
			}
		 public static ObservableList<String>  FournisseurLsit () throws SQLException, ClassNotFoundException {
				
			 String selectStmt = " select * from fournisseur ";
				 ResultSet rs=null;
			        Statement st;

			     
			        try {
			        	 DbUtil.dbConnect();
			        	
			        st = DbUtil.conn.createStatement();
			        rs=st.executeQuery(selectStmt);
			        ObservableList<String> rows=FXCollections.observableArrayList();

			        Fournisseur row=null;
			        try {
			        	
					    while ( rs.next()) {
					    	
					    	row = new Fournisseur (
					    			 rs.getString(1),
							            rs.getString(2),
							            rs.getString(3),
							            rs.getString(4));
							            rows.add(row.getNum());
					        
					       
					        
					        //Add employee to the ObservableList
					        
					    }}
					 catch (Exception e) {
						// TODO: handle excep
				       
				        //return empList (ObservableList of Employees)
				      
				    }
			        return  rows;
			    		 

			           
			        } catch (SQLException e) {
			            System.out.println("SQL select operation has been failed: " + e);
			            //Return exception
			            throw e ;}
					
			        
			 

			
		}
		
		 
		 
		 


}




