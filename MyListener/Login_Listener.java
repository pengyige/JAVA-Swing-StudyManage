package MyListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.function.Function;

import javax.swing.JOptionPane;

import MyData.DButil;
import MyFrame.Admin_Frame;
import MyFrame.Main;
import MyFrame.Student_Frame;
import MyFrame.Teacher_Frame;

public class Login_Listener implements ActionListener,KeyListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	if(e.getActionCommand() == "登入" )
		if(Main.db.getConn() == null)
		{
			JOptionPane.showMessageDialog(null, "连接服务器失败,请检查网络是否正常！");
		
		}
		if(1 == MyFrame.Function.login())
		{
			//如果是学生登入，显示学生登入界面
			if(Main.l.getCBox_Way().getSelectedIndex() == 0)
			{
				//将学号传入学生窗口
				Main.s_Frame = new Student_Frame(Main.l.getTF_User().getText());
				
				Main.s_Frame.setVisible(true);
				Main.s_Frame.setLabel();
				
			}
			else if(Main.l.getCBox_Way().getSelectedIndex() == 1)
			{
				Main.t_Frame = new Teacher_Frame(Main.l.getTF_User().getText());
				Main.t_Frame.setVisible(true);
			}
			else if(Main.l.getCBox_Way().getSelectedIndex() == 2)
			{
				Main.a_Frame = new Admin_Frame(Main.l.getTF_User().getText());
				Main.a_Frame.setVisible(true);
			}
			//关闭登入窗口
			Main.l.dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "用户名或密码不正确!");
		}
	if(e.getActionCommand() == "取消")
		MyFrame.Main.l.dispose();
	
		return;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			if(MyFrame.Function.login() == 1)
			{
				//如果是学生登入，显示学生登入界面
				if(Main.l.getCBox_Way().getSelectedIndex() == 0)
				{
					//将学号传入学生窗口
					Main.s_Frame = new Student_Frame(Main.l.getTF_User().getText());
					Main.l.dispose();
					Main.s_Frame.setVisible(true);
					Main.s_Frame.setLabel();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "用户名或密码不正确!");
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
