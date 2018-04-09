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
		if(e.getActionCommand() == "¼��ɼ�")
		{
			Main.t_Frame.getCard().show(Main.t_Frame.getShowPanel(), "¼���");
			//��ȡ��ʦ�γ̰�����Ϣ
			//����ȡ���˾Ͳ��ڻ�ȡ
			if(flag == false)
			{
				 if(!Function.getSchedule(Main.t_Frame.getTea_no()))
					 {
					 	JOptionPane.showMessageDialog(null, "��ȡ��ʦ�γ̰���ʧ�ܣ�");
					 };
				java.util.Iterator iter = Main.t_Frame.hm_Tea_Cou.entrySet().iterator();
				boolean b_flag = false;
				while(iter.hasNext())
					{
					//��ȡ�γ���
					Map.Entry entry = (Map.Entry)iter.next();
						Object key = entry.getKey();
						Main.t_Frame.getcBox_Cou().addItem((String)key);
					}
				if(Main.t_Frame.hm_Tea_Cou == null)
				{
					JOptionPane.showMessageDialog(null, "����û�пγ̰���");
				}
			}
			Tea_Frame_Listener.flag = true;
			return;
		}
		if(e.getActionCommand() == "��ѯ�ɼ�")
		{
			String str_no = JOptionPane.showInputDialog(null, "������ѧ��:");
			if(str_no == null)
			{
				return ;
			}
			Function.Show_Score(str_no,2);
			//��ʾ�ɼ���Ƭ���
			Main.t_Frame.getCard().show(Main.t_Frame.getShowPanel(),"�ɼ���");
			return;
		}
		if(e.getActionCommand() == "�޸�����")
		{
			Main.t_Frame.getCard().show(Main.t_Frame.getShowPanel(),"�����");
			return;
		}
		if(e.getActionCommand() == "ȷ��")
		{
			String new_Ps = new String(Main.t_Frame.getPF_NEW().getPassword());
			String new_PsA = new String(Main.t_Frame.getPF_NEWA().getPassword());
			System.out.println(new_Ps+"   "+new_PsA);
			if(!new_Ps.equals(new_PsA))
			{
				JOptionPane.showMessageDialog(null, "������������벻��ȷ��������!");
				return ;
			}
			if(Function.Modify_Ps(Main.t_Frame.getTea_no(),new_Ps,2))
				JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
			else
				JOptionPane.showMessageDialog(null, "�޸ĳ������������Ƿ�����");
			return;
			
		}
		
		if(e.getActionCommand() == "�γ�ȷ��")
		{
			String Tea_no = Main.t_Frame.getTea_no();
			String Cou_name = (String) Main.t_Frame.getcBox_Cou().getSelectedItem();
			String Cou_no = (String)Main.t_Frame.hm_Tea_Cou.get(Cou_name);
			Function.setInScoreTable(Tea_no, Cou_no);
			return;
		}
		
		if(e.getActionCommand() == "����")
		{
			//ͨ���γ����ͽ�ʦ��ȷ��Ψһ�Ŀγ̺�
			String Cou_name = (String)Main.t_Frame.getcBox_Cou().getSelectedItem();
			String Cou_no = (String)Main.t_Frame.hm_Tea_Cou.get(Cou_name);
			if(Function.setSaveScore(Cou_no))
			{
				JOptionPane.showMessageDialog(null, "¼��ѧ���ɼ��ɹ�");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "¼��ѧ���ɼ�ʧ��");
			}
			return;
		}
		if(e.getActionCommand() == "ȡ��")
		{
			Main.t_Frame.getCard().show(Main.t_Frame.getShowPanel(),"������");
			return;
		}
	}

}
