package MyFrame;
import java.sql.SQLException;

import javax.swing.SwingUtilities;
import MyData.DButil;

public class Main {

	/**
	 * @param args
	 */
	public static Login l = null;
	public static Student_Frame s_Frame = null;
	public static Teacher_Frame t_Frame = null;
	public static Admin_Frame a_Frame = null;
	public static DButil db;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				 l = new Login();
				 l.addKeyListener(l.Login_Listener);
			}
		});
	 db = new DButil();
		try {
			
			db.Connection("oracle.jdbc.driver.OracleDriver", "jdbc:oracle:thin:@112.74.184.232:6666:myorcl", "pengyi", "pengyi");
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
