package MyFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import MyListener.Adm_Frame_Listener;
import MyListener.MyWindowListener;

import java.awt.*;
import javax.swing.*;
public class Admin_Frame extends JFrame {

	private JPanel contentPane;//�����
	private JMenuBar menBar;
	private JMenu menu_Student;
	private JMenu menu_Teacher;
	private JMenu menu_Course;
	private JMenu menu_XK_Ctr;
	
	private JMenuItem mi_Stu_Add;
	private JMenuItem mi_Stu_Query;
	private JMenuItem mi_Stu_Modify;
	private JMenuItem mi_Stu_Delete;
	
	private JMenuItem mi_Tea_Add;
	private JMenuItem mi_Tea_Query;
	private JMenuItem mi_Tea_Modify;
	private JMenuItem mi_Tea_Delete;
	
	private JMenuItem mi_Cou_Add;
	private JMenuItem mi_Cou_Query;
	private JMenuItem mi_Cou_Modify;
	private JMenuItem mi_Cou_Delete;
	
	private JMenuItem mi_Open_Xk;
	private JMenuItem mi_Close_Xk;
	private JMenuItem mi_Plan_Xk;
	private String Adm_no;
	
	private JPanel panel_Plan;//ѡ�μƻ����
	private DefaultTableModel table_model;
	private JTable table_Plan;
	private JPanel panel_Btn;//��ť���
	private JButton btn_Insert_Plan;
	private JButton btn_Modify_Plan;
	private JButton btn_Save_Plan;
	private JButton btn_Delete_Plan;
	private JButton btn_Cancel_Plan;
	
	private CardLayout card;
	
	private JPanel panel_BK;//�������
	private JLabel label_BK;
	
	private Adm_Up_Dia Insert_Dialog;
	private Adm_Modify_Dia Modify_Dia;
	public Admin_Frame(String Adm_no) {
		
		this.Adm_no = Adm_no;
		setTitle("ѧ��ѡ�޳ɼ�����ϵͳ");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(500, 400);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension di = kit.getScreenSize();
		int x = (int) ((di.getWidth() - 500)/2);
		int y = (int) ((di.getHeight() - 400)/2);
		this.setLocation(x, y);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		card = new CardLayout();
		contentPane.setLayout(card);
		setContentPane(contentPane);
		
		//�������ڼ���
		MyWindowListener mWLis = new MyWindowListener();
		this.addWindowListener(mWLis);
		
		
		//������������
		Adm_Frame_Listener admin_Listener = new Adm_Frame_Listener();
		//�˵�������
		menBar = new JMenuBar();
		menu_Student = new JMenu("ѧ������");
		mi_Stu_Add = new JMenuItem("���ѧ��");
		mi_Stu_Add.addActionListener(admin_Listener);
		mi_Stu_Add.setActionCommand("���ѧ��");
		
		mi_Stu_Query =  new JMenuItem("��ѯѧ��");
		mi_Stu_Query.addActionListener(admin_Listener);
		mi_Stu_Query.setActionCommand("��ѯѧ��");
		
		mi_Stu_Modify = new JMenuItem("�޸�ѧ��");
		mi_Stu_Modify.addActionListener(admin_Listener);
		mi_Stu_Modify.setActionCommand("�޸�ѧ��");
		
		mi_Stu_Delete = new JMenuItem("ɾ��ѧ��");
		mi_Stu_Delete.addActionListener(admin_Listener);
		mi_Stu_Delete.setActionCommand("ɾ��ѧ��");
		menu_Student.add(mi_Stu_Add);
		menu_Student.add(mi_Stu_Query);
		menu_Student.add(mi_Stu_Modify);
		menu_Student.add(mi_Stu_Delete);
		
		menBar.add(menu_Student);
		
		
		menu_Teacher = new JMenu("��ʦ����");
		mi_Tea_Add = new JMenuItem("��ӽ�ʦ");
		mi_Tea_Add.addActionListener(admin_Listener);
		mi_Tea_Add.setActionCommand("��ӽ�ʦ");
		
		mi_Tea_Query = new JMenuItem("��ѯ��ʦ");
		mi_Tea_Query.addActionListener(admin_Listener);
		mi_Tea_Query.setActionCommand("��ѯ��ʦ");
		
		mi_Tea_Modify = new JMenuItem("�޸Ľ�ʦ");
		mi_Tea_Modify.addActionListener(admin_Listener);
		mi_Tea_Modify.setActionCommand("�޸Ľ�ʦ");
		
		mi_Tea_Delete = new JMenuItem("ɾ����ʦ");
		mi_Tea_Delete.addActionListener(admin_Listener);
		mi_Tea_Delete.setActionCommand("ɾ����ʦ");
		menu_Teacher.add(mi_Tea_Add);
		menu_Teacher.add(mi_Tea_Query);
		menu_Teacher.add(mi_Tea_Modify);
		menu_Teacher.add(mi_Tea_Delete);
		
		menBar.add(menu_Teacher);
		
		
		menu_Course = new JMenu("�γ̹���");
		mi_Cou_Add = new JMenuItem("��ӿγ�");
		mi_Cou_Add.addActionListener(admin_Listener);
		mi_Cou_Add.setActionCommand("��ӿγ�");
		
		mi_Cou_Query = new JMenuItem("��ѯ�γ�");
		mi_Cou_Query.addActionListener(admin_Listener);
		mi_Cou_Query.setActionCommand("��ѯ�γ�");
		
		mi_Cou_Modify = new JMenuItem("�޸Ŀγ�");
		mi_Cou_Modify.addActionListener(admin_Listener);
		mi_Cou_Modify.setActionCommand("�޸Ŀγ�");
		
		mi_Cou_Delete = new JMenuItem("ɾ���γ�");
		mi_Cou_Delete.addActionListener(admin_Listener);
		mi_Cou_Delete.setActionCommand("ɾ���γ�");
		menu_Course.add(mi_Cou_Add);
		menu_Course.add(mi_Cou_Query);
		menu_Course.add(mi_Cou_Modify);
		menu_Course.add(mi_Cou_Delete);
		
		menBar.add(menu_Course);
		
		menu_XK_Ctr = new JMenu("ѡ�ι���");
		mi_Open_Xk = new JMenuItem("��ʼѡ��");
		mi_Open_Xk.addActionListener(admin_Listener);
		mi_Open_Xk.setActionCommand("��ʼѡ��");
		
		mi_Close_Xk = new JMenuItem("ֹͣѡ��");
		mi_Close_Xk.addActionListener(admin_Listener);
		mi_Close_Xk.setActionCommand("ֹͣѡ��");
		
		mi_Plan_Xk = new JMenuItem("�γ̰���");
		mi_Plan_Xk.addActionListener(admin_Listener);
		mi_Plan_Xk.setActionCommand("�γ̰���");
		menu_XK_Ctr.add(mi_Open_Xk);
		menu_XK_Ctr.add(mi_Close_Xk);
		menu_XK_Ctr.add(mi_Plan_Xk);
		
		menBar.add(menu_XK_Ctr);
		
		
		//�γ̼ƻ����
		panel_Plan = new JPanel(new BorderLayout());
		table_model = new DefaultTableModel();
		this.table_Plan = new JTable(table_model);
		DefaultTableCellRenderer r   = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);   
		table_Plan.setDefaultRenderer(Object.class, r);
		table_Plan.setEnabled(false);
		panel_Plan.add(new JScrollPane(table_Plan),BorderLayout.CENTER);
		
		panel_Btn = new JPanel();
		btn_Insert_Plan = new JButton("���");
		btn_Insert_Plan.addActionListener(admin_Listener);
		btn_Insert_Plan.setActionCommand("���");
		panel_Btn.add(btn_Insert_Plan);
		btn_Modify_Plan = new JButton("�޸�");
		btn_Modify_Plan.addActionListener(admin_Listener);
		btn_Modify_Plan.setActionCommand("�޸�");
		panel_Btn.add(btn_Modify_Plan);
		btn_Save_Plan = new JButton("�鿴");
		btn_Save_Plan.addActionListener(admin_Listener);
		btn_Save_Plan.setActionCommand("�鿴");
		panel_Btn.add(btn_Save_Plan);
		btn_Delete_Plan = new JButton("ɾ��");
		btn_Delete_Plan.addActionListener(admin_Listener);
		btn_Delete_Plan.setActionCommand("ɾ��");
		panel_Btn.add(btn_Delete_Plan);
		btn_Cancel_Plan = new JButton("ȡ��");
		btn_Cancel_Plan.addActionListener(admin_Listener);
		btn_Cancel_Plan.setActionCommand("ȡ��");
		panel_Btn.add(btn_Cancel_Plan);
		
		panel_Plan.add(panel_Btn,BorderLayout.SOUTH);
		
		//�������
		panel_BK = new JPanel(new BorderLayout());
		label_BK = new JLabel("ѧ��ѡ�ι���ϵͳ");
		panel_BK.add(label_BK,BorderLayout.CENTER);
		label_BK.setIcon(new ImageIcon("images//BK.png"));
		
		//��ӿ�Ƭ���ֵĿ�Ƭ
		contentPane.add(panel_Plan,"�ƻ���");
		contentPane.add(panel_BK,"������");
		card.show(contentPane, "������");
		
		this.setJMenuBar(menBar);
		
		
		Insert_Dialog = new Adm_Up_Dia();
		Insert_Dialog.setLocationRelativeTo(this);
		
		Modify_Dia = new Adm_Modify_Dia();
		Modify_Dia.setLocationRelativeTo(this);

		
	}
	//���ؿ�Ƭ����
	public CardLayout getCard()
	{
		return this.card;
	}
	//���ؿ�Ƭ����
	public JPanel getShow_Panel()
	{
		return this.contentPane;
	}
	//���ر��ģʽ
	public DefaultTableModel getTable_Model()
	{
		return this.table_model;
	}
	//������ӶԻ���
	public JDialog get_Insert_Dia()
	{
		return this.Insert_Dialog;
	}
	//�����޸ĶԻ���
	public JDialog get_Modify_Dia()
	{
		return this.Modify_Dia;
	}
	
}
