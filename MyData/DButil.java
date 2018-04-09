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
	/*�������ݿ�*/
	public boolean Connection(String driver,String url,String user,String pwd)throws ClassNotFoundException,SQLException
	{
		try
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,pwd);
			return true;
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "���ӷ�����ʧ��,���������Ƿ�������");
			return false;
		}
		
	}
	/*�ͷ���Դ*/
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
	/*��̬sql��ѯִ��*/
	public ResultSet executeQuery(String preparedSql,String[] param)
	{
		try
		{
			ps = conn.prepareStatement(preparedSql); //�õ�preparedStatement���� ��̬sql
			if(param != null)
			{
				for(int i = 0 ; i < param.length; i ++)
				{
					ps.setString(i+1,param[i]); //Ϊԥ�����sql���ò���
				}
			}
			rs = ps.executeQuery();//ִ�д˶�̬sql���ؽ����
		}catch(Exception e)
		{
				e.printStackTrace();
		}
		return rs;
	}
	/*��̬sql��ɾ�Ĳ�*/
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
				count = ps.executeUpdate();//����ִ�н��Ӱ�쵽������
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return count;
	}
}
