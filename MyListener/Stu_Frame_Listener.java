package MyListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import MyFrame.Function;
import MyFrame.Main;

public class Stu_Frame_Listener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "开始选课")
		{
			if(Function.IscanXuanke())
			{
			Main.s_Frame.getCard().show(Main.s_Frame.getShowPanel(),"选课吧");
				if(!Function.getXK_Course())
				{
					JOptionPane.showMessageDialog(null, "获取选课信息失败 !");
				}
			
			}
			else
			{
				JOptionPane.showMessageDialog(null, "选课未开始！");
			}
			return ;
		}
		if(e.getActionCommand() == "查询成绩")
		{
			
			Function.Show_Score(Main.s_Frame.getStu_no(),1);
			Main.s_Frame.getCard().show(Main.s_Frame.getShowPanel(), "成绩吧");
			return ;
		}
		if(e.getActionCommand() == "修改密码")
		{
			Main.s_Frame.getCard().show(Main.s_Frame.getShowPanel(),"密码吧");
			return ;
		
		}
		if(e.getActionCommand() == "保存")
		{
			if(Function.IscanXuanke())
			{
				int flag = Function.save_CourseInfor();
				if(1 == flag)
				{
					JOptionPane.showMessageDialog(null, "选课成功");
				}
				else if(0 == flag)
				{
					JOptionPane.showMessageDialog(null,"发生错误，请重试！");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "选课未开始！");
			}
			return ;
		}
		if(e.getActionCommand() == "刷新")
		{
			Main.s_Frame.getDataModelmy().removeAllElements();
			String[] str_Course = null;
			str_Course = MyFrame.Function.getStu_Course(Main.s_Frame.getStu_no());
			for(int i = 0 ; str_Course[i] != null; i ++)
			{
				Main.s_Frame.getDataModelmy().addElement(str_Course[i]);
			}
			Function.getXK_Course();
			return ;
		}
		if(e.getActionCommand() == "确定")
		{
			String new_Ps = new String(Main.s_Frame.getPF_NEW().getPassword());
			String new_PsA = new String(Main.s_Frame.getPF_NEWA().getPassword());
			System.out.println(new_Ps+"   "+new_PsA);
			if(!new_Ps.equals(new_PsA))
			{
				JOptionPane.showMessageDialog(null, "两次输入的密码不正确，请重试!");
				return ;
			}
			if(Function.Modify_Ps(Main.s_Frame.getStu_no(),new_Ps,1))
				JOptionPane.showMessageDialog(null, "修改成功！");
			else
				JOptionPane.showMessageDialog(null, "修改出错！请检查网络是否正常");
			return ;
			
		}
		if(e.getActionCommand() == "取消")
		{
			Main.s_Frame.getCard().show(Main.s_Frame.getShowPanel(),"背景吧");
			return ;
		}
	}
	
	

	
	

}
