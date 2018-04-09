package MyListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import MyFrame.Function;
import MyFrame.Main;
import MyFrame.Adm_Modify_Dia;
import MyFrame.Adm_Up_Dia;
public class Adm_Frame_Listener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "开始选课")
		{
			if(Function.Open_XuanKe())
			{
				JOptionPane.showMessageDialog(null, "开始选课成功!");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "开始选课失败");
			}
			return;
		}
		
		if(e.getActionCommand() == "停止选课")
		{
			if(Function.Stop_XuanKe())
			{
				JOptionPane.showMessageDialog(null, "停止选课成功");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "停止选课失败");
			}
			return;
		}
		if(e.getActionCommand() == "课程安排")
		{
			if(!Function.get_XK_Plan())
			{
				JOptionPane.showMessageDialog(null, "获取课程安排失败！");
			}
			Main.a_Frame.getCard().show(Main.a_Frame.getShow_Panel(),"计划吧");
			return;
		}
		if(e.getActionCommand() == "添加")
		{
			Main.a_Frame.get_Insert_Dia().setVisible(true);
			return ;
		}
		if(e.getActionCommand() == "修改")
			
		{
			//判断课程号是否存在
			String Cou_no = JOptionPane.showInputDialog("请输入课程号");
		
			if(Cou_no == null)
				return;
			String Tea_no = JOptionPane.showInputDialog("请输入教师号");
			if(Tea_no == null)
				return;
			
			if(Cou_no.equals("")||Tea_no.equals(""))
			{
				JOptionPane.showMessageDialog(null, "输入不能为空!");
				return ;
			}
			
			Vector<Integer> v = Function.getCou_no_Plan(Cou_no, Tea_no);
			if(null != v)
			{
				Adm_Modify_Dia amd = (Adm_Modify_Dia) Main.a_Frame.get_Modify_Dia();
				amd.textField_Cou_no.setText(Cou_no);
				amd.textField_Tea_no.setText(Tea_no);
				amd.textField_Sch_rs.setText(String.valueOf(v.get(0)));
				amd.textField_yi_rs.setText(String.valueOf(v.get(1)));
				Main.a_Frame.get_Modify_Dia().setVisible(true);
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "输入的课程号和教师号不存在");
			}
		
		}
		if(e.getActionCommand() == "查看")
		{
			if(!Function.get_XK_Plan())
			{
				JOptionPane.showMessageDialog(null, "获取课程安排失败！");
			}
			return;
		}
		if(e.getActionCommand() == "取消")
		{
			Main.a_Frame.getCard().show(Main.a_Frame.getShow_Panel(),"背景吧");
			return;
		}
		
		if(e.getActionCommand() == "删除")
		{
			String Cou_no = JOptionPane.showInputDialog("请输入课程号");
			if(Cou_no == null)
				return;
			String Tea_no = JOptionPane.showInputDialog("请输入教师号");
			if(Tea_no == null)
				return;
	
			if(Cou_no.equals("")||Tea_no.equals(""))
			{
				JOptionPane.showMessageDialog(null, "输入不能为空");
				return;
			}
			if(Function.delete_XK_Plan(Cou_no,Tea_no))
			{
				JOptionPane.showMessageDialog(null, "删除成功");
			}
			else
				JOptionPane.showMessageDialog(null, "删除失败");
			return;
		}
		if(e.getActionCommand() == "")
		{
			return;
		}
		
	}
	
	
}
