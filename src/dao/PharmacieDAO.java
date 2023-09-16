package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

//import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import oo.Fournisseur;
import oo.Medicament;
import oo.Pharmacie;

public class PharmacieDAO {
//use it to verify if the  numnational  of the ph is true or not 
	 public static Pharmacie getPharmacieFromNum( String numNational) throws SQLException, ClassNotFoundException {
		 Statement st;
		
		 DbUtil.dbConnect();
		 st = DbUtil.conn.createStatement();
		 String selectStmt = "SELECT * FROM pharmacie where numNational = '"+numNational+"' ;";
		 
	            //Get ResultSet from dbExecuteQuery method
		 ResultSet rs =st.executeQuery(selectStmt);
		 System.out.print(" this is an admin \n  ");

		 Pharmacie  pharmacie  = getPharmacieFromResultSet(rs);
		 System.out.print(" this is an admin \n  ");

	            return pharmacie; 
		 }
		//Use ResultSet from DB as parameter and set pharamcie  Object's attributes and return pharmacie object.
		    private static  Pharmacie   getPharmacieFromResultSet(ResultSet   rs) throws SQLException 
		    
		    {
		    	Pharmacie ph = new Pharmacie()  ; 
		        
		        boolean  x= rs.next();
		        
		        if (x) {
		        	
		           
					  String s1 =rs.getString(1);
					  String s2 =rs.getString(2);
					  String s3=rs.getString(3);
					  String s4 =rs.getString(4);
					  String s5 =rs.getString(5);
					  String s6 =rs.getString(6);
					 
		          System.out.println(" result s1="+s1+"s2="+s2+"s3="+s3+s4+s5+s6);
		          ph = new Pharmacie (s1,s2,s3,s4,s5,s6);
		           
		           //Pharmacie ph1 = new Pharmacie (s1,s2,s3,s4,s5,s6) ; 
		           System.out.print(ph.toString());
		        }
		        
		        return ph;
		    }
		    
		    // fnt used when client try to show all pharmacie connected to the system 
		    
		    public static ObservableList<Pharmacie> searchPharamcie () throws SQLException, ClassNotFoundException {
		        //Declare a SELECT statement
		        String selectStmt = "SELECT  * FROM pharmacie";
		        //Execute SELECT statement
		        try {
		            //Get ResultSet from dbExecuteQuery method
		            ResultSet rsEmps = DbUtil.dbExecuteQuery(selectStmt);
		            //Send ResultSet to the getEmployeeList method and get employee object
		            ObservableList<Pharmacie> empList =getPharamcieList(rsEmps);
		            //Return employee object
		            return empList;
		        } catch (SQLException e) {
		            System.out.println("SQL select operation has been failed: " + e);
		            //Return exception
		            throw e;
		        }
		    }
		    
		    private static ObservableList<Pharmacie> getPharamcieList(ResultSet rs) throws SQLException, ClassNotFoundException {
		        //Declare a observable List which comprises of Employee objects
		        ObservableList<Pharmacie> empList = FXCollections.observableArrayList();
		        while (rs.next()) {
		        	Pharmacie ph = new Pharmacie(null , null , null , null , null , null);
		        	
		            ph.setNom(rs.getString("nom"));
		            ph.setAdresse(rs.getString("adresse"));
		            ph.setNumtel(rs.getString("numtel"));
		            ph.setType(rs.getString("type"));
		            ph.setJour(rs.getString("jourt"));
		            //Add employee to the ObservableList
		            empList.add(ph);
		        }
		        //return empList (ObservableList of Employees)
		        return empList;
		    }
		    
		    // fnt used when client try to search pharamci by noun 

		   
		    
		    // create new pharmacie acount 
		   
		    public static void insertPharmacie (Pharmacie ph ) throws SQLException, ClassNotFoundException {
		   int a =0 ;
		   DbUtil.dbConnect();
		   	 String req =("insert into pharmacie values(?,?,?,?,?,?);");

		   	try {
				PreparedStatement ps = (PreparedStatement) DbUtil.conn.prepareStatement(req);
				ps.setString(1, ph.getNumNational());
				ps.setString(2, ph.getNom());
				ps.setString(3, ph.getAdresse());
				ps.setString(4, ph.getNumtel());
				ps.setString(5, ph.getType());
				ps.setString(6, ph.getJour());
				
				 a =ps.executeUpdate() ;
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		    } 
		    
		    
		    
		    
		    
		    
		    private static ObservableList<Pharmacie> getphListfromResultSet(ResultSet rs) throws SQLException, ClassNotFoundException {
		        //Declare a observable List which comprises of Employee objects
		        ObservableList<Pharmacie> rows=FXCollections.observableArrayList();
		       Pharmacie row=null;
		     try {
		        while (rs.next()) {
		        	row = new Pharmacie (
		        			rs.getString(1),
		        			rs.getString(2),
		        			rs.getString(3),
		        			rs.getString(4),
		        			rs.getString(5),
		        			rs.getString(6));
		        			
		        			
		        	rows.add(row);      
		        }}
		     catch (Exception e) {
		    	// TODO: handle exception
		    }
		        //return empList (ObservableList of Employees)
		        return rows;
		    }
		    
		    
		    
		    public static ObservableList<Pharmacie> getphList () throws SQLException, ClassNotFoundException {
		    	
		    	String selectStmt = " select * from pharmacie  ";
				 ResultSet rs=null;
			        Statement st;

			     
			        try {
			        	 DbUtil.dbConnect();
			        	
			        st = DbUtil.conn.createStatement();
			        rs=st.executeQuery(selectStmt);
		            System.out.println("execute : ");

			        ObservableList<Pharmacie> empList =FXCollections.observableArrayList();
		            empList= getphListfromResultSet (rs);
		            System.out.println("lis ");
		            return empList ;
		    	
		    }
		     catch (SQLException e) {
	            System.out.println("SQL select operation has been failed: " + e);
	            //Return exception
	            throw e ;}
			        
		   
		    
		    }
		    
		    public static ObservableList<Pharmacie> getphListByMed (String med ) throws SQLException, ClassNotFoundException {
		    	 String selectStmt = "select c.prix ,p.nom , p.adresse ,p.numtel , p.type , p.jourt  from pharmacie p  ,commandemed c , medicament m where c.ph = p.numNational  and m.idmed =c.med and m.nom=?;";

				 ResultSet rsemps=null;
			        Statement st;
			     
			        try {
			        	 DbUtil.dbConnect();
			        	 java.sql.PreparedStatement selection = DbUtil.conn.prepareStatement(selectStmt);
			    		 selection.setString(1, med  );
			    		
			    		 ResultSet rsEmps =selection.executeQuery();

			            ObservableList<Pharmacie> empList =FXCollections.observableArrayList();
			            empList=getphListfromResultSet(rsEmps);
			            //Return employee object
			            return empList;
			        } catch (SQLException e) {
			            System.out.println("SQL select operation has been failed: " + e);
			            //Return exception
			            throw e ;}}
		    
		    
		    public static ObservableList<String>  pharmaciList () throws SQLException, ClassNotFoundException {
						
						 String selectStmt = " select * from pharmacie ";
							 ResultSet rs=null;
						        Statement st;

						     
						        try {
						        	 DbUtil.dbConnect();
						        	
						        st = DbUtil.conn.createStatement();
						        rs=st.executeQuery(selectStmt);
						        ObservableList<String> rows=FXCollections.observableArrayList();

						        Pharmacie row=null;
						        try {
						        	
								    while ( rs.next()) {
								    	
								    	row = new Pharmacie (
							        			rs.getString(1),
							        			rs.getString(2),
							        			rs.getString(3),
							        			rs.getString(4),
							        			rs.getString(5),
							        			rs.getString(6));
							        			
										            rows.add(row.getNom());
								        
								       
								        
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
			 
		    public static Pharmacie getPharmacieFromNom( String nom) throws SQLException, ClassNotFoundException {
				 Statement st;
				
				 DbUtil.dbConnect();
				 st = DbUtil.conn.createStatement();
				 String selectStmt = "SELECT * FROM pharmacie where nom = '"+nom+"' ;";
				 
			            //Get ResultSet from dbExecuteQuery method
				 ResultSet rs =st.executeQuery(selectStmt);

				 Pharmacie  pharmacie  = getPharmacieFromResultSet(rs);

			            return pharmacie; 
				 }

			
		    	
		    	
		    

	 
}
