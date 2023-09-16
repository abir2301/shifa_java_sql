module PhProject {
	requires javafx.controls;
	requires java.sql;
	requires mysql.connector.java;
	requires javafx.graphics;
	requires  javafx.base;
	requires java.sql.rowset;
	requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml , javafx.base;
}
