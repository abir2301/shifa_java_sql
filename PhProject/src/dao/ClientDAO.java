package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import oo.Client;
import oo.Pharmacie;

public   class ClientDAO {
	 public static void insertClient (Client  c ) throws SQLException, ClassNotFoundException {
		   int a =0 ;
		   DbUtil.dbConnect();
		   	 String req =("insert into client  values(?,?,?,?,?,?);");

		   	try {
				PreparedStatement ps = (PreparedStatement) DbUtil.conn.prepareStatement(req);
				ps.setString(1,c.getNcin());
				ps.setString(2, c.getMpass());
				ps.setString(3, c.getEmail());
				ps.setString(4, c.getAdresse());
				ps.setString(5, c.getNom());
				ps.setString(6, c.getPrenom());
				
				 a =ps.executeUpdate() ;
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		   	
		   	
		   	
		   	
		   	public static   void getClientbympass( String mpass) throws SQLException, ClassNotFoundException {
				 Statement st;
				
				 DbUtil.dbConnect();
				 st = DbUtil.conn.createStatement();
				 String selectStmt = "SELECT * FROM client where mpass = '"+mpass+"' ;";
				 
			            //Get ResultSet from dbExecuteQuery method
				 ResultSet rs =st.executeQuery(selectStmt);
				 System.out.print("after result set \n ");
				   getClientFromResultSet(rs);
				 System.out.print("after get client  \n ");

				
			          
			            
				 }
		   	
			
 private static  void    getClientFromResultSet(ResultSet   rs) throws SQLException 
		    
		    {
	 System.out.print("firsline \n ");
		    	Client  ph = new Client()  ; 
		        
		        boolean  x= rs.next();
		        
		        if (x) {
		        	
		           
					  String s1 =rs.getString(1);
					  String s2 =rs.getString(2);
					  String s3=rs.getString(3);
					  String s4 =rs.getString(4);
					  String s5 =rs.getString(5);
					  String s6 =rs.getString(6);
					  System.out.print("2second line \n ");
					  System.out.print(s1+s2+s3+s4+s5+s6);
		         //  System.out.println(" result s1="+s1+"s2="+s2+"s3="+s3+s4+s5+s6);
		          ph = new Client (s1,s2,s3,s4,s5,s6);
		           Client.setSelecteClient(ph);
		           //Pharmacie ph1 = new Pharmacie (s1,s2,s3,s4,s5,s6) ; 
		           
		        }
		      
		        
		    }
		    
		    
		    
		    
		    
	 
		    
	 
	 

	
}
