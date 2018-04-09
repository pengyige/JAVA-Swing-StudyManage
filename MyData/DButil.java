package MyData;
import java.sql.*;

import javax.swing.JOptionPane;
public class DButil {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private CallableStatement cstmt = null;
	private ResultSet rs = null;
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public PreparedStatement getPs() {
		return ps;
	}
	public void setPs(PreparedStatement ps) {
		this.ps = ps;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	
	public CallableStatement getCstmt() {
		return cstmt;
	}
	public void setCstmt(CallableStatement cstmt) {
		this.cstmt = cstmt;
	}
	/*连接数据库*/
	public boolean Connection(String driver,String url,String user,String pwd)throws ClassNotFoundException,SQLException
	{
		try
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			return true;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "连接服务器失败,请检查网络是否正常！");
			return false;
		}
		
	}
	/*释放资源*/
	public void closeAll()
	{
		try
		{
			
			if(rs != null)
				rs.close();
			if(ps != null)
				ps.close();
			if(conn != null)
				conn.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	/*动态sql查询执行*/
	public ResultSet executeQuery(String preparedSql,String[] param)
	{
		try
		{
			ps = conn.prepareStatement(preparedSql); //得到preparedStatement对象 动态sql
			if(param != null)
			{
				for(int i = 0 ; i < param.length; i ++)
				{
					ps.setString(i+1,param[i]); //为豫编译的sql设置参数
				}
			}
			rs = ps.executeQuery();//执行此动态sql返回结果集
		}catch(Exception e)
		{
				e.printStackTrace();
		}
		return rs;
	}
	/*动态sql增删改查*/
	public int executeUpdate(String preparedSql,String[] param)
	{
		int count = 0;
		try
		{
			ps = conn.prepareStatement(preparedSql);
			if(param != null)
			{
				for(int i = 0 ; i < param.length; i ++)
				{
					ps.setString(i+1,param[i]);
				}
				count = ps.executeUpdate();//返回执行结果影响到的行数
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return count;
	}
}
