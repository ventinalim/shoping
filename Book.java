import javax.swing.*;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;

public PrintingMembers(String query) {
		super("Printing Members", false, true, false, true);
		Container cp = getContentPane();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 9));
		cp.add(textArea);
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}
		catch (ClassNotFoundException ea) {
			System.out.println(ea.toString());
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		try {
			connection = DriverManager.getConnection(URL);
			statement = connection.createStatement();
    
}
