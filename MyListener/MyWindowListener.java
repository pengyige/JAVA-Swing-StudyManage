package MyListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import MyFrame.Main;

public class MyWindowListener extends WindowAdapter{



	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		int flag  = JOptionPane.showConfirmDialog(null, "ȷ���˳�ϵͳ��","ѧ��ѡ�޳ɼ�����ϵͳ",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
		if(0 == flag)
		{
			
			Main.db.closeAll();
			if(Main.l != null)
				Main.l.dispose();
			if(Main.t_Frame != null)
				Main.t_Frame.dispose();
			if(Main.a_Frame != null)
				Main.a_Frame.dispose();
			
			System.exit(0);
		}
		
	}




}
