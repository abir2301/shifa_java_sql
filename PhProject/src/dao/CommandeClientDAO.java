package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import oo.CommandeClient;
import oo.Pharmacie;

public class CommandeClientDAO {

	 public static ObservableList<CommandeClient> getCommandeClient (String ph  ) throws SQLException, ClassNotFoundException {
		 String selectStmt = "SELECT  *  from commandeclient c  where c.numph =? ; " ;
	        ResultSet rsemps=null;
	     
	     
	        try {
	        	 DbUtil.dbConnect();
	    		
	    		 java.sql.PreparedStatement selection = DbUtil.conn.prepareStatement(selectStmt);
	    		 selection.setString(1,ph );
	    		 ResultSet rsEmps =selection.executeQuery();

	            ObservableList<CommandeClient> empList =FXCollections.observableArrayList();
	            empList= getCommandeClientFromResultSet(rsEmps);
	            System.out.println("end get elements ");

	            
	           
	            return empList;
	        } catch (SQLException e) {
	            System.out.println("SQL select operation has been failed: " + e);
	           
	            throw e;
	        }
	        }
	    
	    
	 public static ObservableList<CommandeClient> getCommandeClientbyDate (String date , String ph   ) throws SQLException, ClassNotFoundException {
	      
	        String selectStmt = "SELECT  *  from commandeclient c  where dateCommande =?  and  c.numph =?  ; " ;
	        ResultSet rsemps=null;
	     
	     
	        try {
	        	 DbUtil.dbConnect();
	    		
	    		 java.sql.PreparedStatement selection = DbUtil.conn.prepareStatement(selectStmt);
	    		 selection.setString(1, date);
	    		 selection.setString(2, ph);
	    		 ResultSet rsEmps =selection.executeQuery();

	            ObservableList<CommandeClient> empList =FXCollections.observableArrayList();
	            empList= getCommandeClientFromResultSet(rsEmps);
	            System.out.println("end get elements ");

	            
	           
	            return empList;
	        } catch (SQLException e) {
	            System.out.println("SQL select operation has been failed: " + e);
	           
	            throw e;
	        }
	        
	    }
	    
	 public static ObservableList<CommandeClient> getCommandebyMed (String med  , String ph ) throws SQLException, ClassNotFoundException {
		 String selectStmt = "SELECT  *  from commandeclient c  where c.nummed =?  and c.numph =? ; " ;
	        ResultSet rsemps=null;
	     
	     
	        try {
	        	 DbUtil.dbConnect();
	    		
	    		 java.sql.PreparedStatement selection = DbUtil.conn.prepareStatement(selectStmt);
	    		 selection.setString(1, med);
	    		 selection.setString(2, ph);

	    		 ResultSet rsEmps =selection.executeQuery();

	            ObservableList<CommandeClient> empList =FXCollections.observableArrayList();
	            empList= getCommandeClientFromResultSet(rsEmps);
	            System.out.println("end get elements ");

	            
	           
	            return empList;
	        } catch (SQLException e) {
	            System.out.println("SQL select operation has been failed: " + e);
	           
	            throw e;
	        }
	        
	    }
	 
	 public static ObservableList<CommandeClient> getCommandebyClient (String client , String ph  ) throws SQLException, ClassNotFoundException {
	        //Declare a SELECT statement
	        String selectStmt = "SELECT  * from commandeclient c , client l  where c.mpass = l.mpass  and  l.nom =  ? and c.numph =?;" ; 
	        ResultSet rsemps=null;
		     
		     
	        try {
	        	 DbUtil.dbConnect();
	        	 System.out.println(selectStmt);
	    		 java.sql.PreparedStatement selection = DbUtil.conn.prepareStatement(selectStmt);
	    		 selection.setString(1, client);
	    		 selection.setString(2, ph);
	    		 ResultSet rsEmps =selection.executeQuery();
	    		

	            ObservableList<CommandeClient> empList =FXCollections.observableArrayList();
	            empList= getCommandeClientFromResultSet(rsEmps);
	            System.out.println("end get elements ");

	            
	           
	            return empList;
	        } catch (SQLException e) {
	            System.out.println("SQL select operation has been failed: " + e);
	           
	            throw e;
	        }
	        
	    }
	    
	  
	
		//Use ResultSet from DB as parameter and set pharamcie  Object's attributes and return pharmacie object.
		    private static  ObservableList<CommandeClient>   getCommandeClientFromResultSet(ResultSet   rs) throws SQLException 
		    
		    {
		    	ObservableList<CommandeClient> rows=FXCollections.observableArrayList();
				CommandeClient row=null;
		       try {
		    	   while (rs.next()) {
		           row= new CommandeClient(
					 rs.getString(1),
					  rs.getString(2),
					  rs.getString(3),
					  rs.getString(4),
					  rs.getString(5),
					  rs.getString(6),
					  rs.getString(7)
					  );
		           rows.add(row);
					 
		         //  System.out.println(" result s1="+s1+"s2="+s2+"s3="+s3+s4+s5+s6);
		          }}
		       
		       catch (Exception e) {
				// TODO: handle exception
			}
		           
		           //Pharmacie ph1 = new Pharmacie (s1,s2,s3,s4,s5,s6) ; 
		          
		        
		        return rows;
		    }
			// String selectStmt = "SELECT c.id , c.quantite , c.dateCommande, c.mpass ,p.nom ,m.nom from commandeclient c , pharmacie p , medicament m where m.idmed = c.nummed and p.numNational =c.numph and c.mpass =?;"

		    public static ObservableList<CommandeClient> getCommandeByClient (String c  ) throws SQLException, ClassNotFoundException {
				 String selectStmt = "SELECT c.id , c.quantite , c.dateCommande, c.mpass ,p.nom ,m.nom ,c.type from commandeclient c , pharmacie p , medicament m where m.idmed = c.nummed and p.numNational =c.numph and c.mpass =? ;"
				 		+ "" ;
			        ResultSet rsemps=null;
			     
			     
			        try {
			        	 DbUtil.dbConnect();
			    		
			    		 java.sql.PreparedStatement selection = DbUtil.conn.prepareStatement(selectStmt);
			    		 selection.setString(1,c );
			    		 ResultSet rsEmps =selection.executeQuery();

			            ObservableList<CommandeClient> empList =FXCollections.observableArrayList();
			            empList= getCommandeClientFromResultSet(rsEmps);
			            System.out.println("end get elements ");

			            
			           
			            return empList;
			        } catch (SQLException e) {
			            System.out.println("SQL select operation has been failed: " + e);
			           
			            throw e;
			        }
			        }		    
		   
		    public static void insertCommandeClient (CommandeClient c ) throws SQLException, ClassNotFoundException {
				   int a =0 ;
				   DbUtil.dbConnect();
				   	 String req =("insert into commandeclient values(?,?,?,?,?,?,?);");

				   	try {
						PreparedStatement ps = (PreparedStatement) DbUtil.conn.prepareStatement(req);
						ps.setString(1, c.getId());
						ps.setString(2, c.getQuantite());
						ps.setString(3, c.getdateCommande());
						ps.setString(4, c.getMpass());
						ps.setString(5, c.getNumph());
						ps.setString(6, c.getNummed());
						ps.setString(7, c.getType());
						
						 a =ps.executeUpdate() ;
						 
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				    } 
		    
		    
	 
		    
	 

}
