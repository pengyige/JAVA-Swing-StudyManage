package MyFrame;
import java.beans.Statement;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import MyData.DButil;
public  class Function {
	//载入窗口
	public static int login()
	{
		int b_flag = 0;
		try
		{
		String callsql = "{call login(?,?,?,?)}";
		Main.db.setCstmt(Main.db.getConn().prepareCall(callsql));
		String user = Main.l.getTF_User().getText();
		@SuppressWarnings("deprecation")
		String password = Main.l.getPField_PW().getText();
		int index = Main.l.getCBox_Way().getSelectedIndex();
		//System.out.println(index+"  "+user + "  "+password);
		/*注册out型参数*/
		Main.db.getCstmt().registerOutParameter(4,java.sql.Types.INTEGER);
		/*设置存储过程参数*/
		Main.db.getCstmt().setString(1,user);
		Main.db.getCstmt().setString(2, password);
		Main.db.getCstmt().setInt(3,index+1);
		Main.db.getCstmt().execute();
		b_flag = Main.db.getCstmt().getInt(4);
		//System.out.println(b_flag);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return b_flag;
	};
	//得到学生信息
	public static Student getStudent_Infor(String Stu_no)
	{
		Student stu = new Student();
		ResultSet rs = null;
		String selectsql = "SELECT * FROM Student WHERE Stu_no = ?";
		//查询学生信息
		rs = Main.db.executeQuery(selectsql, new String[]{Stu_no});
		try
		{
		while(rs.next())
		{
			/*将返回的结果集记录在Stuent*/
			stu.setStu_no(rs.getString(1));
			stu.setStu_name(rs.getString(2));
			stu.setStu_sex(rs.getString(3));
			stu.setStu_birthday(rs.getDate(4));
			stu.setStu_pnumber(rs.getString(5));
			stu.setStu_class(rs.getString(6));
			stu.setPassword(rs.getString(7));
			
		};
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return stu;
	}
	//得到全部选修课程
	public static boolean getXK_Course()
	{
		
		String[] str_Course =  new String[30];
		String selectsql = "SELECT Cou_no,Cou_name,Cou_period ,Cou_credit,Tea_no,Tea_name,Sch_renshu,Sch_yi_RS FROM Tea_Sch";
		ResultSet rs = null;

		try
		{
		java.sql.Statement stmt = Main.db.getConn().createStatement();
		rs = stmt.executeQuery(selectsql);
		//设置列名
		Vector<String> title = new Vector<String>();
		title.add("课程号");
		title.add("课程名");
		title.add("学时");
		title.add("学分");
		title.add("教师号");
		title.add("教师名");
		title.add("总人数");
		title.add("已选人数");
		while(rs.next())
		{
			Vector<Vector<String>> data = new Vector<Vector<String>>();
			int rowCount = 0;
			while(rs.next())
			{
				rowCount ++;
				//一行数据
				Vector<String> rowdata = new Vector<String>();
				rowdata.add(rs.getString(1));
				rowdata.add(rs.getString(2));
				rowdata.add(String.valueOf(rs.getInt(3)));
				rowdata.add(String.valueOf(rs.getInt(4)));
				rowdata.add(rs.getString(5));
				rowdata.add(rs.getString(6));
				rowdata.add(String.valueOf(rs.getInt(7)));
				rowdata.add(String.valueOf(rs.getInt(8)));
				
				
				data.add(rowdata);
			
				
			};
			if(rowCount == 0)
			{
				JOptionPane.showMessageDialog(null, "没有课程");
				return false;
			}
			else
			{
				Main.s_Frame.getXK_Tab_Mod().setDataVector(data, title);
			}
			
		}
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;

	}
	//得到学生选课信息
	public static String[] getStu_Course(String Stu_no)
	{
		String[] str_Course = new String[30];
		String selectsql = "SELECT Cou_no,Cou_name FROM Stu_Cou WHERE Stu_no = ?";
		ResultSet rs = null;
		int index = 0 ;
		try
		{
			
			rs = Main.db.executeQuery(selectsql, new String[]{Stu_no});
			while(rs.next())
			{
				/*将返回的结果集记录在Stuent*/
				str_Course[index] = rs.getString(1)+" "+rs.getString(2);
			//	System.out.println("我的："+str_Course[index]);
				index++;
				
				
			};
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return str_Course;
	}
	//保存学生选课信息 0表示失败，1成功，2表示没选,3表示已选修,4 人数已满，5表示已选修满
	public static int save_CourseInfor()
	{
		String callsql = "{call Insert_XK(?,?)}";
		String Stu_no = Main.s_Frame.getStu_no();
		String Cou_no = null;
		String Cou_name = null;
		String Tea_no = null;
		int row = Main.s_Frame.getXK_Table().getSelectedRow();
		Cou_no =(String) Main.s_Frame.getXK_Table().getValueAt(row, 0);
		Cou_name = (String)Main.s_Frame.getXK_Table().getValueAt(row, 1);
		Tea_no = (String)Main.s_Frame.getXK_Table().getValueAt(row, 4);
		
		//判断是否超过人
		int Sch_renshu = Integer.valueOf((String)Main.s_Frame.getXK_Table().getValueAt(row, 6));
		int Sch_yi_rs = Integer.valueOf((String)Main.s_Frame.getXK_Table().getValueAt(row, 7));
		if(Sch_yi_rs >= Sch_renshu)
		{
			JOptionPane.showMessageDialog(null, "人数已满，请选择其他课程！");
			return 4;
		}
		//判断是否超过4门
		int count = 0;
		String selectsql = "SELECT COUNT(*) FROM Score WHERE Stu_no = ?";
		ResultSet st = Main.db.executeQuery(selectsql, new String[]{Stu_no});
		try
		{
			while(st.next())
			{
				count = st.getInt(1);
			}
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "发生错误-009");
		}
		if(count == 4)
		{
			JOptionPane.showMessageDialog(null, "最多选修四门！");
			return 5;
		}
		//判断是否已选修
		String[] str_Course = null;
		str_Course = getStu_Course(Main.s_Frame.getStu_no());
		int i = 0 ;
		while(str_Course[i] != null)
		{
			if(str_Course[i].split(" ")[0].equals(Cou_no))
			{
				JOptionPane.showMessageDialog(null, Cou_name+"课程已选修过，请选择其他！");
				return 3;
			}
			i++;
		}
		//判断是否真的要选
		int flag = JOptionPane.showConfirmDialog(null, "你确定选修："+Cou_no+" "+Cou_name+"课程吗?");
		if(0 != flag)
		{
			return 2;
		}
		//关闭自动提交
	
		try {
			boolean autoCommit = Main.db.getConn().getAutoCommit();
			if(autoCommit)
			{
			Main.db.getConn().setAutoCommit(false);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try
		{
		CallableStatement cstmt = Main.db.getConn().prepareCall(callsql);
		cstmt.setString(1, Stu_no);
		cstmt.setString(2, Cou_no);
		cstmt.execute();
		//更新选课人数
		String callsql_add = "{call f_Schedule_add(?,?)}";
		CallableStatement cstmt_add =Main.db.getConn().prepareCall(callsql_add);
		cstmt_add.setString(1, Cou_no);
		cstmt_add.setString(2,Tea_no);
		cstmt_add.execute();
		
		Main.db.getConn().commit();
		}catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		//添加到mylist中
		Main.s_Frame.getDataModelmy().addElement(Cou_no+" "+Cou_name);
		try
		{
		boolean autoCommit = Main.db.getConn().getAutoCommit();
		if(!autoCommit)
		{
		Main.db.getConn().setAutoCommit(true);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return 1;
	}
	//删除该学生的选课信息
	public static boolean delete_CourseInfor(String Stu_no)
	{
		
		String deletesql = "DELETE FROM Score WHERE Stu_no = ?";
		try
		{
		Main.db.executeQuery(deletesql,new String[]{Stu_no});
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//显示学生分数 b_flag=1表示学生面板查询,=2表示教师面板查询
	public static void Show_Score(String Stu_no,int b_flag)
	{
		String selectsql = "SELECT Cou_no,Cou_name,Score FROM Stu_Cou WHERE Stu_no = ?";
		ResultSet rs = null;
		try
		{
			rs = Main.db.executeQuery(selectsql, new String[]{Stu_no});
			//得到结果集中的各种属性
			ResultSetMetaData rsmd = rs.getMetaData();
			//获取列数
			int colCount = rsmd.getColumnCount();
			//存放列名
			Vector<String> title = new Vector<String>();
			/*
			for(int i = 1 ; i<= colCount; i++)
			{
				title.add(rsmd.getColumnLabel(i));
				System.out.println(rsmd.getColumnLabel(i));
			}
			*/
			title.add("课程号");
			title.add("课程名");
			title.add("分数");
			//表格中数据
			Vector<Vector<String>> data = new Vector<Vector<String>>();
			int rowCount = 0;
			while(rs.next())
			{
				rowCount ++;
				//一行数据
				Vector<String> rowdata = new Vector<String>();
				rowdata.add(rs.getString(1));
				rowdata.add(rs.getString(2));
				//如果成绩为空
				if(rs.getInt(3) >= 0 && rs.getInt(3) <= 100)
				{
					rowdata.add(String.valueOf(rs.getInt(3)));
				}
				
				data.add(rowdata);
			
				
			};
			if(rowCount == 0)
			{
				JOptionPane.showMessageDialog(null, "没有进行选课");
				
			}
			else
			{
				if(1 == b_flag)
				Main.s_Frame.getTable_Model().setDataVector(data, title);
				else if(2 == b_flag)
				Main.t_Frame.getTableModel().setDataVector(data, title);
					
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
	
	}
	public static boolean IscanXuanke()
	{
		String selectsql = "SELECT State FROM XK_STATE_Tab";
		int State = 0;
		ResultSet rs = Main.db.executeQuery(selectsql,new String[]{});
		try
		{
		while(rs.next())
		{
			State = rs.getInt(1);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		if(0 == State)
			return false;
		else
			return true;
	}
	//选课打开
	public static boolean Open_XuanKe()
	{
		String updatesql = "UPDATE XK_STATE_Tab SET State = 1";
		try
		{
			Main.db.executeUpdate(updatesql, new String[]{});
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//选课关闭
	public static boolean Stop_XuanKe()
	{
		String updatesql = "UPDATE XK_STATE_Tab SET State = 0";
		try
		{
			Main.db.executeUpdate(updatesql, new String[]{});
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	//修改密码，第三个参数若1表示学生，2表示老师，3表示管理员
	public static boolean Modify_Ps(String no,String new_Ps,int b_flag)
	{
		String updatesql = null;
		int Count = 0;
		switch(b_flag)
		{
		case 1:updatesql = "UPDATE Student SET Stu_Password = '"+new_Ps+"' WHERE Stu_no = ?";break;
		case 2:updatesql = "UPDATE Teacher SET Tea_Password = '"+new_Ps+"' WHERE Tea_no = ?";break;
		case 3:updatesql = "UPDATE Administrator SET Adm_Password = '"+new_Ps+"' WHERE Adm_no = ?";break;
		};
		try
		{
			Count = Main.db.executeUpdate(updatesql, new String[]{no});
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		if(0 == Count)
			return false;
		else
			return true;
		
	}
	
	/*
	 * 得到教师信息
	 */
	public static String[] getTeacher_Infor(String Tea_no)
	{

		
		ResultSet rs = null;
		String[] result = new String[2];
		String selectsql = "SELECT * FROM Teacher WHERE Tea_no = ?";
		//查询学生信息
		rs = Main.db.executeQuery(selectsql, new String[]{Tea_no});
		try
		{
		while(rs.next())
		{
			result[0] = rs.getString(1);
			result[1] = rs.getString(2);
			
		};
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	/*
	 *得到教师的课程
	 */
	public static boolean getSchedule(String Tea_no)
	{
		
		ResultSet rs = null;
		String selectsql = "SELECT Cou_name, Cou_no FROM Tea_Sch WHERE Tea_no = ?";
		//获取教师课程
		rs = Main.db.executeQuery(selectsql, new String[]{Tea_no});
		try
		{
		while(rs.next())
		{
			Main.t_Frame.hm_Tea_Cou.put(rs.getString(1), rs.getString(2));
		}
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "获取教师课程失败！");
			return false;
		}
		return true;
	}
	//不采用这种方式
	/*
	/*
	 * 获取该课程名和教师号对应的课程号
	 */ 
	/*
	public static String getCou_Tea_no(String Tea_no,String Cou_name)
	{
		String Cou_no = null;
		String selectsql = "SELECT Cou_no FROM Tea_Sch WHERE Tea_no = '"+Tea_no+"'"+"AND Cou_name = '"+Cou_name+"'";
		ResultSet rs = null;
	
		try
		{
		java.sql.Statement mysm = Main.db.getConn().createStatement();
		rs = mysm.executeQuery(selectsql);
		while(rs.next())
		{
			Cou_no = rs.getString(1);
		}
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "获取教师课程号失败!");
			return null;
		}
		return Cou_no;
	}*/
	/*
	 *设置表格模式选修了该课程的所有学生成绩，若同一个课程名由两个老师来教,则要确定该课程名对应的课程号到底由那个老师来教
	 */
	 public static void setInScoreTable(String Tea_no,String Cou_no)
	 {
		 //返回教师号和课程名对应的课程号
		 //String Cou_no = getCou_Tea_no(Tea_no,Cou_name);
		// System.out.println("课程号为:"+Cou_no);
		 ResultSet rs = null;
		String selectsql = "SELECT Stu_no,Stu_name,Stu_class,Score FROM Stu_Cou WHERE Cou_no = ?";
		//获取选修了该课程号的成绩信息
		rs = Main.db.executeQuery(selectsql, new String[]{Cou_no});
		try
		{
			ResultSetMetaData rsmd = rs.getMetaData();
			//获取列数
			int colCount = rsmd.getColumnCount();
			//存放列名
			Vector<String> title = new Vector<String>();
			/*
			for(int i = 1 ; i<= colCount; i++)
			{
				title.add(rsmd.getColumnLabel(i));
				System.out.println(rsmd.getColumnLabel(i));
			}
			*/
			title.add("学号");
			title.add("姓名");
			title.add("班级");
			title.add("分数");
			//表格中数据
			Vector<Vector<String>> data = new Vector<Vector<String>>();
			int rowCount = 0;
			while(rs.next())
			{
				rowCount ++;
				//一行数据
				Vector<String> rowdata = new Vector<String>();
				rowdata.add(rs.getString(1));
				rowdata.add(rs.getString(2));
				rowdata.add(rs.getString(3));
				//如果成绩为空
				if(rs.getInt(4) >=0 && rs.getInt(4)<=100)
				{
					rowdata.add(String.valueOf(rs.getInt(4)));
				}
			
				data.add(rowdata);
			
				
			};
			if(rowCount == 0 )
			{
				JOptionPane.showMessageDialog(null, "没有学生选修该课");
				
			}
			else
			{
				Main.t_Frame.getModel_InScore().setDataVector(data, title);
			}

			
		}catch(Exception e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "获取成绩信息失败!");
		}
		
	 }
	 /*
	  * 保存学生成绩信息  参数为此课程名和老师号对应的课程号
	  */
	 public static boolean setSaveScore(String Cou_no)
	 {
		 //获取表格中的信息
		 DefaultTableModel inScoremodel = Main.t_Frame.getModel_InScore();
		 java.sql.Statement st = null;
	
		 try
		 {
		   Main.db.getConn().setAutoCommit(false);//取消自动提交
	    st = Main.db.getConn().createStatement();
	
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 int row = inScoremodel.getRowCount();
		// System.out.println(row+" "+inScoremodel.getColumnCount());
		// int col = Main.t_Frame.getModel_InScore().getColumnCount();
		 for(int i = 0 ; i < row; i ++)
		 {
			 String Stu_no = (String) inScoremodel.getValueAt(i, 0);
			 int score =  Integer.parseInt((String)inScoremodel.getValueAt(i, 3));
			// System.out.println("课程号:"+Cou_no+"   分数:"+score+"   学号:"+Stu_no);
			 String  updatesql = "UPDATE Score SET score = "+score+"  WHERE Stu_no = '"+Stu_no+"' and Cou_no = '"+Cou_no+"'";
			int rs = 0;
			  try {
				st.addBatch(updatesql);
			  }catch(Exception e)
			  {
				  e.printStackTrace();
			  }		
		 }
		 try
		 {
		 st.executeBatch();
		 Main.db.getConn().commit();
		   Main.db.getConn().setAutoCommit(true);//打开自动提交
		 }catch(Exception e)
		 {
			 //发生异常回滚
			 try {
				Main.db.getConn().rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
	
			}
		 }
		 
		return true; 
	 }
	 /*
	  * 显示选课计划信息
	  */
	 public static boolean get_XK_Plan()
	 {
		 ResultSet rs = null;
		 String selectsql = "SELECT Cou_no,Cou_name,Tea_no,Tea_name,Sch_renshu,Sch_yi_RS FROM Tea_Sch";
		 try
		 {
			rs = Main.db.executeQuery(selectsql, new String[]{});
			//存放列名
			Vector<String> title = new Vector<String>();
			title.add("课程号");
			title.add("课程名");
			title.add("教师号");
			title.add("教师名");
			title.add("总人数");
			title.add("已选人数");
			
			Vector<Vector<String>> data = new Vector<Vector<String>>();
			int rowCount = 0;
			while(rs.next())
			{
				rowCount ++;
				//一行数据
				Vector<String> rowdata = new Vector<String>();
				rowdata.add(rs.getString(1));
				rowdata.add(rs.getString(2));
				rowdata.add(rs.getString(3));
				rowdata.add(rs.getString(4));
				rowdata.add(String.valueOf(rs.getInt(5)));
				rowdata.add(String.valueOf(rs.getInt(6)));
			
				data.add(rowdata);
			
				
			};
			if(rowCount == 0 )
			{
				JOptionPane.showMessageDialog(null, "还没有选课安排！");
				
			}
			else
			{
				Main.a_Frame.getTable_Model().setDataVector(data, title);
			}

			
		 }catch(Exception e)
		 {
			 e.printStackTrace();
			 return false;
		 }
		 return true;
	 }
	 /*
	  *修改选课安排 
	  */
	 public static boolean update_XK_Plan(String Cou_no,String Tea_no,int Sch_renshu,int Sch_yi_rs)
	 {
		
		 
		 String updatesql = "UPDATE Schedule set Tea_no = '"+Tea_no+"' ,Sch_renshu ="+Sch_renshu+",Sch_yi_RS ="+Sch_yi_rs
			+" WHERE Cou_no = '"+Cou_no+"' AND Tea_no = '"+Tea_no+"'" ;
		 try
		 {
			 java.sql.Statement st = Main.db.getConn().createStatement();
			 st.executeUpdate(updatesql);
			 
		 }catch(Exception e)
		 {
			 e.printStackTrace();
			 return false;
		 }
		 

		 return true;
	 }
	 
	 /*
	  * 添加选课计划
	  */
	 public static boolean insert_XK_Plan(String Cou_no,String Tea_no,int All_Number)
	 {
		 
		 String insertsql = "INSERT INTO Schedule(Cou_no,Tea_no,Sch_renshu)  VALUES(?,?,?)";
		 try
		 {
			 PreparedStatement ps = Main.db.getConn().prepareStatement(insertsql);
			 ps.setString(1, Cou_no);
			 ps.setString(2,Tea_no);
			 ps.setInt(3, All_Number);
			 ps.executeUpdate();
		 }catch(Exception e)
		 {
			 e.printStackTrace();
			 return false;
		 }
		 return true;
	 }
	 /*
	  * 删除选课计划
	  */
	 public static boolean delete_XK_Plan(String Cou_no,String Tea_no)
	 {
		 String deletesql = "DELETE FROM Schedule WHERE Cou_no = ? AND Tea_no = ?";
		 try
		 {
			 Main.db.executeUpdate(deletesql, new String[]{Cou_no,Tea_no});
		 }catch(Exception e)
		 {
			 e.printStackTrace();
			 return false;
		 }
		 return true;
	 }
	 /*
	  * 返回对应课程号和教师号的信息
	  */
	 public static Vector<Integer> getCou_no_Plan(String Cou_no,String Tea_no)
	 {
		 String selectsql = "select Sch_renshu,Sch_yi_RS FROM Schedule WHERE Cou_no = ? AND Tea_no = ?";
		ResultSet rs = null;
		Vector<Integer> v = new Vector<Integer>();
		int count = 0;
		 try
		 {
			rs =  Main.db.executeQuery(selectsql, new String[]{Cou_no,Tea_no});
			while(rs.next())
			{
				count++;
				v.add(rs.getInt(1));
				v.add(rs.getInt(2));
			}
		 }catch(Exception e)
		 {
			 e.printStackTrace();
			 JOptionPane.showMessageDialog(null, "发生错误001");
			 return null;
		 }
		if(0 == count)
			return null;
		
		return v;
	 }
	
	
}
