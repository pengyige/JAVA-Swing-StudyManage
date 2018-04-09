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
		if(e.getActionCommand() == "��ʼѡ��")
		{
			if(Function.Open_XuanKe())
			{
				JOptionPane.showMessageDialog(null, "��ʼѡ�γɹ�!");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "��ʼѡ��ʧ��");
			}
			return;
		}
		
		if(e.getActionCommand() == "ֹͣѡ��")
		{
			if(Function.Stop_XuanKe())
			{
				JOptionPane.showMessageDialog(null, "ֹͣѡ�γɹ�");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "ֹͣѡ��ʧ��");
			}
			return;
		}
		if(e.getActionCommand() == "�γ̰���")
		{
			if(!Function.get_XK_Plan())
			{
				JOptionPane.showMessageDialog(null, "��ȡ�γ̰���ʧ�ܣ�");
			}
			Main.a_Frame.getCard().show(Main.a_Frame.getShow_Panel(),"�ƻ���");
			return;
		}
		if(e.getActionCommand() == "���")
		{
			Main.a_Frame.get_Insert_Dia().setVisible(true);
			return ;
		}
		if(e.getActionCommand() == "�޸�")
			
		{
			//�жϿγ̺��Ƿ����
			String Cou_no = JOptionPane.showInputDialog("������γ̺�");
		
			if(Cou_no == null)
				return;
			String Tea_no = JOptionPane.showInputDialog("�������ʦ��");
			if(Tea_no == null)
				return;
			
			if(Cou_no.equals("")||Tea_no.equals(""))
			{
				JOptionPane.showMessageDialog(null, "���벻��Ϊ��!");
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
				JOptionPane.showMessageDialog(null, "����Ŀγ̺źͽ�ʦ�Ų�����");
			}
		
		}
		if(e.getActionCommand() == "�鿴")
		{
			if(!Function.get_XK_Plan())
			{
				JOptionPane.showMessageDialog(null, "��ȡ�γ̰���ʧ�ܣ�");
			}
			return;
		}
		if(e.getActionCommand() == "ȡ��")
		{
			Main.a_Frame.getCard().show(Main.a_Frame.getShow_Panel(),"������");
			return;
		}
		
		if(e.getActionCommand() == "ɾ��")
		{
			String Cou_no = JOptionPane.showInputDialog("������γ̺�");
			if(Cou_no == null)
				return;
			String Tea_no = JOptionPane.showInputDialog("�������ʦ��");
			if(Tea_no == null)
				return;
	
			if(Cou_no.equals("")||Tea_no.equals(""))
			{
				JOptionPane.showMessageDialog(null, "���벻��Ϊ��");
				return;
			}
			if(Function.delete_XK_Plan(Cou_no,Tea_no))
			{
				JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
			}
			else
				JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
			return;
		}
		if(e.getActionCommand() == "")
		{
			return;
		}
		
	}
	
	
}
