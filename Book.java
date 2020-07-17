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
		catch (ClassNotFoundException ea) {
			System.out.println(ea.toString());
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
		try {
			connection = DriverManager.getConnection(URL);
			statement = connection.createStatement();
			resultset = statement.executeQuery(query);
			textArea.append("=============== Members Information ===============\n\n");
			while (resultset.next()) {
				textArea.append("Member ID: " + resultset.getString("ID") + "\n" +
				        "Name: " + resultset.getString("Name") + "\n" +
				        "Major: " + resultset.getString("Major") + "\n" +
				        "Expired: " + resultset.getString("Expired") + "\n\n");
			}
			textArea.append("=============== Members Information ===============");
			resultset.close();
			statement.close();
			connection.close();
		}
		catch (SQLException SQLe) {
			System.out.println(SQLe.toString());
		}
    		setVisible(true);
		pack();
	}
	Font font = textArea.getFont();
		pg.setFont(font);
		FontMetrics fm = pg.getFontMetrics();
		int hLine = fm.getHeight();

		if (lines == null)
			lines = getLines(fm, wPage);
}
