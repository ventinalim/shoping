import javax.swing.*;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.sql.*;
import java.util.StringTokenizer;
import java.util.Vector;

public class PrintingMembers extends JInternalFrame implements Printable {

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	private String URL = "jdbc:odbc:JLibrary";
	private JTextArea textArea = new JTextArea();
	private Vector lines;
	public static final int TAB_SIZE = 10;
	
public PrintingMembers(String query) {
		super("Printing Members", false, true, false, true);
		Container cp = getContentPane();
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 9));
		cp.add(textArea);
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}
    
}
