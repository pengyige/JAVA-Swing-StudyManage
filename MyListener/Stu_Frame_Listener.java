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
		if(e.getActionCommand() == "��ʼѡ��")
		{
			if(Function.IscanXuanke())
			{
			Main.s_Frame.getCard().show(Main.s_Frame.getShowPanel(),"ѡ�ΰ�");
				if(!Function.getXK_Course())
				{
					JOptionPane.showMessageDialog(null, "��ȡѡ����Ϣʧ�� !");
				}
			
			}
			else
			{
				JOptionPane.showMessageDialog(null, "ѡ��δ��ʼ��");
			}
			return ;
		}
		if(e.getActionCommand() == "��ѯ�ɼ�")
		{
			
			Function.Show_Score(Main.s_Frame.getStu_no(),1);
			Main.s_Frame.getCard().show(Main.s_Frame.getShowPanel(), "�ɼ���");
			return ;
		}
		if(e.getActionCommand() == "�޸�����")
		{
			Main.s_Frame.getCard().show(Main.s_Frame.getShowPanel(),"�����");
			return ;
		
		}
		if(e.getActionCommand() == "����")
		{
			if(Function.IscanXuanke())
			{
				int flag = Function.save_CourseInfor();
				if(1 == flag)
				{
					JOptionPane.showMessageDialog(null, "ѡ�γɹ�");
				}
				else if(0 == flag)
				{
					JOptionPane.showMessageDialog(null,"�������������ԣ�");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "ѡ��δ��ʼ��");
			}
			return ;
		}
		if(e.getActionCommand() == "ˢ��")
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
		if(e.getActionCommand() == "ȷ��")
		{
			String new_Ps = new String(Main.s_Frame.getPF_NEW().getPassword());
			String new_PsA = new String(Main.s_Frame.getPF_NEWA().getPassword());
			System.out.println(new_Ps+"   "+new_PsA);
			if(!new_Ps.equals(new_PsA))
			{
				JOptionPane.showMessageDialog(null, "������������벻��ȷ��������!");
				return ;
			}
			if(Function.Modify_Ps(Main.s_Frame.getStu_no(),new_Ps,1))
				JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
			else
				JOptionPane.showMessageDialog(null, "�޸ĳ������������Ƿ�����");
			return ;
			
		}
		if(e.getActionCommand() == "ȡ��")
		{
			Main.s_Frame.getCard().show(Main.s_Frame.getShowPanel(),"������");
			return ;
		}
	}
	
	

	
	

}
