package MyListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.text.html.HTMLDocument.Iterator;

import MyFrame.Function;
import MyFrame.Main;

public class Tea_Frame_Listener implements ActionListener{

	
	private static boolean flag = false;
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "录入成绩")
		{
			Main.t_Frame.getCard().show(Main.t_Frame.getShowPanel(), "录入吧");
			//获取教师课程安排信息
			//若获取到了就不在获取
			if(flag == false)
			{
				 if(!Function.getSchedule(Main.t_Frame.getTea_no()))
					 {
					 	JOptionPane.showMessageDialog(null, "获取教师课程安排失败！");
					 };
				java.util.Iterator iter = Main.t_Frame.hm_Tea_Cou.entrySet().iterator();
				boolean b_flag = false;
				while(iter.hasNext())
					{
					//获取课程名
					Map.Entry entry = (Map.Entry)iter.next();
						Object key = entry.getKey();
						Main.t_Frame.getcBox_Cou().addItem((String)key);
					}
				if(Main.t_Frame.hm_Tea_Cou == null)
				{
					JOptionPane.showMessageDialog(null, "您还没有课程安排");
				}
			}
			Tea_Frame_Listener.flag = true;
			return;
		}
		if(e.getActionCommand() == "查询成绩")
		{
			String str_no = JOptionPane.showInputDialog(null, "请输入学号:");
			if(str_no == null)
			{
				return ;
			}
			Function.Show_Score(str_no,2);
			//显示成绩卡片面板
			Main.t_Frame.getCard().show(Main.t_Frame.getShowPanel(),"成绩吧");
			return;
		}
		if(e.getActionCommand() == "修改密码")
		{
			Main.t_Frame.getCard().show(Main.t_Frame.getShowPanel(),"密码吧");
			return;
		}
		if(e.getActionCommand() == "确定")
		{
			String new_Ps = new String(Main.t_Frame.getPF_NEW().getPassword());
			String new_PsA = new String(Main.t_Frame.getPF_NEWA().getPassword());
			System.out.println(new_Ps+"   "+new_PsA);
			if(!new_Ps.equals(new_PsA))
			{
				JOptionPane.showMessageDialog(null, "两次输入的密码不正确，请重试!");
				return ;
			}
			if(Function.Modify_Ps(Main.t_Frame.getTea_no(),new_Ps,2))
				JOptionPane.showMessageDialog(null, "修改成功！");
			else
				JOptionPane.showMessageDialog(null, "修改出错！请检查网络是否正常");
			return;
			
		}
		
		if(e.getActionCommand() == "课程确定")
		{
			String Tea_no = Main.t_Frame.getTea_no();
			String Cou_name = (String) Main.t_Frame.getcBox_Cou().getSelectedItem();
			String Cou_no = (String)Main.t_Frame.hm_Tea_Cou.get(Cou_name);
			Function.setInScoreTable(Tea_no, Cou_no);
			return;
		}
		
		if(e.getActionCommand() == "保存")
		{
			//通过课程名和教师号确定唯一的课程号
			String Cou_name = (String)Main.t_Frame.getcBox_Cou().getSelectedItem();
			String Cou_no = (String)Main.t_Frame.hm_Tea_Cou.get(Cou_name);
			if(Function.setSaveScore(Cou_no))
			{
				JOptionPane.showMessageDialog(null, "录入学生成绩成功");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "录入学生成绩失败");
			}
			return;
		}
		if(e.getActionCommand() == "取消")
		{
			Main.t_Frame.getCard().show(Main.t_Frame.getShowPanel(),"背景吧");
			return;
		}
	}

}
