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
	if(e.getActionCommand() == "����" )
		if(Main.db.getConn() == null)
		{
			JOptionPane.showMessageDialog(null, "���ӷ�����ʧ��,���������Ƿ�������");
		
		}
		if(1 == MyFrame.Function.login())
		{
			//�����ѧ�����룬��ʾѧ���������
			if(Main.l.getCBox_Way().getSelectedIndex() == 0)
			{
				//��ѧ�Ŵ���ѧ������
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
			//�رյ��봰��
			Main.l.dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "�û��������벻��ȷ!");
		}
	if(e.getActionCommand() == "ȡ��")
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
				//�����ѧ�����룬��ʾѧ���������
				if(Main.l.getCBox_Way().getSelectedIndex() == 0)
				{
					//��ѧ�Ŵ���ѧ������
					Main.s_Frame = new Student_Frame(Main.l.getTF_User().getText());
					Main.l.dispose();
					Main.s_Frame.setVisible(true);
					Main.s_Frame.setLabel();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "�û��������벻��ȷ!");
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
