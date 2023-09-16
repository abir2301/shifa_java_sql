package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import oo.CommandeClient;
import oo.CommandeMEd;
import oo.Fournisseur;
import oo.Medicament;
import oo.MedicamentPh;

public class MedicamentDAO {
static public int insere(Medicament m) {
	DbUtil.dbConnect();
	 int a = 0 ; 
	 String req =("insert into medicament values(?,?,?,?,?);");
	 try {
		PreparedStatement ps = (PreparedStatement) DbUtil.conn.prepareStatement(req);
		ps.setString(1, m.getIdmed());
		ps.setString(2, m.getNom());
		ps.setString(3, m.getDescription());
		ps.setString(4, m.getMarque());
		ps.setString(5, m.getType());
		 a =ps.executeUpdate() ;
		 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return a;
	
	
	
}
static public int update(Medicament m) {
	DbUtil.dbConnect();
	 int a = 0 ; 
	 String req =("update medicament set  idmed=? ,nom =? ,descrption=? marque=? ,type=?;");
	 try {
		PreparedStatement ps = (PreparedStatement) DbUtil.conn.prepareStatement(req);
		ps.setString(1, m.getIdmed());
		ps.setString(2, m.getNom());
		ps.setString(3, m.getDescription());
		ps.setString(4, m.getMarque());
		ps.setString(5, m.getType());
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
	 String req =("delete from medicament where idmed=?;");
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
	
 
	

	//*************************
//	 String selectStmt = "SELECT m.idmed ,m.nom ,m.description m1.nommarque ,t.nomtype FROM commandemed c , medicament m , marquemed m1 , typemed t WHERE m.idmed =c.med and m1.idmarque = m.marque and m.type=t.idtype and c.ph =? GROUP BY c.med order by count(*) DESC";

public static ObservableList<Medicament> getmedPerime ( String numPh ) throws SQLException, ClassNotFoundException {
	 
	 String selectStmt = "SELECT concat(m.idmed ,\"-\",m.nom ), m.description , m1.nommarque ,m2.nomtype ,sum(c.quantite) FROM commandeclient c , medicament m, marquemed m1 , typemed m2 WHERE    dmed = c.nummed and m2.idtype=m.type and m1.idmarque =m.marque GROUP BY m.idmed;";
	 	        				                     
	 		;
	 Statement st;
try {
	 DbUtil.dbConnect();
	 st = DbUtil.conn.createStatement();
	 ResultSet rsEmps =st.executeQuery(selectStmt);

    ObservableList<Medicament> empList =FXCollections.observableArrayList();
    empList= getMedicamentList(rsEmps);
    return empList;
    }
catch (SQLException e) {
	System.out.println("SQL select operation has been failed: " + e);
    //Return exception
    throw e;
}
	// TODO: handle exception
}
    //Return employee object
    
    
	 /*try {
          //Get ResultSet from dbExecuteQuery method
		 java.sql.PreparedStatement selection = DbUtil.conn.prepareStatement(selectStmt);
		 selection.setString(1, numPh);
		 ObservableList<Medicament> empList =FXCollections.observableArrayList();
		 ResultSet rsEmps =selection.executeQuery();
		 empList= getMedicamentList(rsEmps);
          return empList   ; // retourne la  pharmacie adequoite 
      } catch (SQLException e) {
          System.out.println("While searching  med with " + numPh + " id, an error occurred: " + e);
          // show a dialog to indicate thta the numNational  is wrong 
          throw e;
      }
	 }*/
 

 
public static ObservableList<Medicament >getAllMedWithDetail( String numPh ) throws SQLException, ClassNotFoundException {
	
	 String selectStmt = "select concat(m.idmed ,\"-\",m.nom ), m.description , m.marque , m.type ,sum(c.quantite) FROM commandemed c , medicament m where c.med = m.idmed  where c.ph =? GROUP BY c.med DESC;";

		 ResultSet rsemps=null;
	        Statement st;
	     
	        try {
	        	 DbUtil.dbConnect();
	        	 java.sql.PreparedStatement selection = DbUtil.conn.prepareStatement(selectStmt);
	    		 selection.setString(1, numPh );
	    		
	    		 ResultSet rsEmps =selection.executeQuery();

	            ObservableList<Medicament> empList =FXCollections.observableArrayList();
	            empList= getMedicamentList(rsEmps);
	            //Return employee object
	            return empList;
	        } catch (SQLException e) {
	            System.out.println("SQL select operation has been failed: " + e);
	            //Return exception
	            throw e ;}
	        
	 

	
}

private static ObservableList<MedicamentPh> getMedicament(ResultSet rs) throws SQLException, ClassNotFoundException {
    //Declare a observable List which comprises of Employee objects
    ObservableList<MedicamentPh> rows=FXCollections.observableArrayList();
    MedicamentPh row=null;
 try {
    while (rs.next()) {
    	row = new MedicamentPh (
    			rs.getString(1),
    			rs.getString(3),
    			rs.getString(4),
    			rs.getString(5),
    			rs.getString(2)
    			
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

private static ObservableList<Medicament> getMedicamentList(ResultSet rs) throws SQLException, ClassNotFoundException {
    //Declare a observable List which comprises of Employee objects
    ObservableList<Medicament> rows=FXCollections.observableArrayList();
    Medicament row=null;
 try {
    while (rs.next()) {
    	row = new Medicament (
    			rs.getString(1),
    			rs.getString(2),
    			rs.getString(3),
    			rs.getString(4),
    			rs.getString(5)
    			
    			);
    	rows.add(row);      
    }}
 catch (Exception e) {
	// TODO: handle exception
}
    //return empList (ObservableList of Employees)
    return rows;
}

  public static ObservableList<String>  MedicamentLsit () throws SQLException, ClassNotFoundException {
	
	 String selectStmt = " select * from medicament ";
		 ResultSet rs=null;
	        Statement st;

	     
	        try {
	        	 DbUtil.dbConnect();
	        	
	        st = DbUtil.conn.createStatement();
	        rs=st.executeQuery(selectStmt);
	        ObservableList<String> rows=FXCollections.observableArrayList();

	        Medicament row=null;
	        try {
	        	
			    while ( rs.next()) {
			    	
			    	row = new Medicament (
			    			rs.getString(1),
			    			rs.getString(2),
			    			rs.getString(3),
			    			rs.getString(4),
			    			rs.getString(5)
			    			
			    			);
					            rows.add(row.getIdmed());
			        
			       
			        
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
public static ObservableList<Medicament>  MedicamentLsitClient () throws SQLException, ClassNotFoundException {
	
	 String selectStmt = " select m.idmed , m.nom, m.description,m1.nommarque , t.nomtype from medicament m , typemed t , marquemed m1 where m.marque = m1.idmarque and t.idtype = m.type  ";
		 ResultSet rs=null;
	        Statement st;	     
	        try {
	        	 DbUtil.dbConnect();
	        	
	        st = DbUtil.conn.createStatement();
	        rs=st.executeQuery(selectStmt);
	        ObservableList<Medicament> rows=FXCollections.observableArrayList();

	        Medicament row=null;
	        try {
	        	
			    while ( rs.next()) {
			    	
			    	row = new Medicament (
			    			rs.getString(1),
			    			rs.getString(2),
			    			rs.getString(3),
			    			rs.getString(4),
			    			rs.getString(5)
			    			
			    			);
					            rows.add(row);
			        
			       
			        
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


