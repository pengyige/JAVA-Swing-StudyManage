package MyFrame;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.HashMap;

import javax.swing.*;
import MyListener.MyWindowListener;
import MyListener.Tea_Frame_Listener;

public class Teacher_Frame extends JFrame {

	private JPanel contentPane;
	private JPanel panel_Infor;//������Ϣ���
	private String Tea_no;
	private JLabel label_Tea_no;
	private JLabel label_Tea_name;
	
	private JPanel panel_Func;//���岼���м����
	private JPanel panel_inScore;//¼��ɼ����
	private JPanel panel_QueryScore;//��ѯ�ɼ����
	private JPanel panel_Modify_Ps;//�޸��������
	private JPanel panel_BK;//�������
	
	private JPanel panel_BtnFunc;//��߰�ť���
	private JButton btn_inScore;
	private JButton btn_QueryScore;
	private JButton btn_Modify_Pw;
	
	private JTable Score_Table;
	private DefaultTableModel model;
	
	
	private JLabel label_BK ;
	
	private CardLayout card;//��������
	
	private JLabel label_NewPs;
	private JLabel label_NewPsA;
	private JPasswordField PF_NewPs;
	private JPasswordField PF_NewPsA;
	private JButton btn_OK_Ps;
	private JButton btn_Cancel_Ps;
	
	
	/*¼��ɼ�������*/
	private JPanel panel_CouInfo;
	private JLabel label_Cou_name;
	private JComboBox cbox_Cou_name;
	private JButton btn_OK_In;
	
	private DefaultTableModel model_InScore;
	private JTable InScore_Table;
	
	private JPanel panel_OK_Cancel;
	private JButton btn_Save;
	private JButton btn_Cancel;
	
	//��ʦ�γ̼�¼��
	public static HashMap hm_Tea_Cou = null;
	public Teacher_Frame(String Tea_no) {
		this.Tea_no = Tea_no;
		this.setTitle("ѧ��ѡ�޳ɼ�����ϵͳ");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(500,400);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension di = kit.getScreenSize();
		int x = (int) ((di.getWidth() - 500)/2);
		int y = (int) ((di.getHeight() - 400)/2);
		this.setLocation(x, y);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		//��ӹرռ���
		this.addWindowListener(new MyWindowListener());
		
		//������Ϣ���
		panel_Infor  = new JPanel();
		panel_Infor.setBorder(BorderFactory.createTitledBorder("��ʦ��Ϣ"));
		label_Tea_no = new JLabel();
		label_Tea_no.setHorizontalAlignment(SwingConstants.LEFT);
		label_Tea_name = new JLabel();
		label_Tea_name.setHorizontalAlignment(SwingConstants.LEFT);
		setLabel();
		panel_Infor.add(label_Tea_no);
		panel_Infor.add(label_Tea_name);
		contentPane.add(panel_Infor,BorderLayout.NORTH);
		
		
		//��߰�ť���
		panel_BtnFunc = new JPanel();
		contentPane.add(panel_BtnFunc,BorderLayout.WEST);
		panel_BtnFunc.setLayout(new BoxLayout(panel_BtnFunc, BoxLayout.Y_AXIS));
		Tea_Frame_Listener Tea_Listener = new Tea_Frame_Listener();
		panel_BtnFunc.add(Box.createVerticalStrut(40));
		
		this.btn_inScore = new JButton("¼��ɼ�");
		btn_inScore.addActionListener(Tea_Listener);
		btn_inScore.setActionCommand("¼��ɼ�");
		panel_BtnFunc.add(btn_inScore);
		panel_BtnFunc.add(Box.createVerticalStrut(20));
		
		btn_QueryScore = new JButton("��ѯ�ɼ�");
		btn_QueryScore.addActionListener(Tea_Listener);
		btn_QueryScore.setActionCommand("��ѯ�ɼ�");
		panel_BtnFunc.add(btn_QueryScore);
		panel_BtnFunc.add(Box.createVerticalStrut(20));
		
		btn_Modify_Pw = new JButton("�޸�����");
		btn_Modify_Pw.addActionListener(Tea_Listener);
		btn_Modify_Pw.setActionCommand("�޸�����");
		panel_BtnFunc.add(btn_Modify_Pw);
		panel_BtnFunc.add(Box.createVerticalStrut(20));
		panel_BtnFunc.setBorder(BorderFactory.createTitledBorder("�����б�"));
		
		
		
		//�м����
		
			//¼��ɼ����
		panel_inScore = new JPanel(new BorderLayout());
		panel_CouInfo = new JPanel();
		this.label_Cou_name = new JLabel("�ҵĿγ�:");
		this.cbox_Cou_name = new JComboBox();
		this.btn_OK_In = new JButton("ȷ��");
		btn_OK_In.addActionListener(Tea_Listener);
		btn_OK_In.setActionCommand("�γ�ȷ��");
		panel_CouInfo.add(label_Cou_name);
		panel_CouInfo.add(cbox_Cou_name);
		panel_CouInfo.add(btn_OK_In);
		panel_inScore.add(panel_CouInfo,BorderLayout.NORTH);
		
		model_InScore = new DefaultTableModel();
		this.InScore_Table = new JTable(model_InScore);
		DefaultTableCellRenderer r   = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);   
		InScore_Table.setDefaultRenderer(Object.class, r);
		panel_inScore.add(new JScrollPane(InScore_Table),BorderLayout.CENTER);
		
		panel_OK_Cancel = new JPanel();
		btn_Save = new JButton("����");
		btn_Save.addActionListener(Tea_Listener);
		btn_Save.setActionCommand("����");
		btn_Cancel = new JButton("ȡ��");
		btn_Cancel.addActionListener(Tea_Listener);
		btn_Cancel.setActionCommand("ȡ��");
		panel_OK_Cancel.add(btn_Save);
		panel_OK_Cancel.add(btn_Cancel);
		panel_inScore.add(panel_OK_Cancel,BorderLayout.SOUTH);
		
		
			//��ѯ�ɼ����
		panel_QueryScore = new JPanel(new BorderLayout());
		model = new DefaultTableModel();
		Score_Table = new JTable(model);
		Score_Table.setEnabled(false);
		Score_Table.setDefaultRenderer(Object.class, r);
		panel_QueryScore.add(new JScrollPane(Score_Table),BorderLayout.CENTER);
		
		
		
			//�������
		panel_BK = new JPanel(new BorderLayout());
		label_BK = new JLabel("ѧ��ѡ�ι���ϵͳ");
		panel_BK.add(label_BK,BorderLayout.CENTER);
		label_BK.setIcon(new ImageIcon("images//BK.png"));
			//�޸��������
		label_NewPs = new JLabel("������:");
		label_NewPs.setHorizontalAlignment(SwingConstants.CENTER);
		label_NewPsA = new JLabel("ȷ�����룺");
		label_NewPsA.setHorizontalAlignment(SwingConstants.CENTER);
		PF_NewPs = new JPasswordField();
		PF_NewPsA = new JPasswordField();
		btn_OK_Ps = new JButton("ȷ��");
		btn_OK_Ps.addActionListener(Tea_Listener);
		btn_OK_Ps.setActionCommand("ȷ��");
		btn_Cancel_Ps = new JButton("ȡ��");
		btn_Cancel_Ps.addActionListener(Tea_Listener);
		btn_Cancel_Ps.setActionCommand("ȡ��");
		
		GridLayout myGray = new GridLayout(3,2);
		myGray.setHgap(30);
		myGray.setVgap(50);
		panel_Modify_Ps = new JPanel(myGray);
		panel_Modify_Ps.setBorder(new EmptyBorder(60, 60, 60, 60));
		
		panel_Modify_Ps.add(label_NewPs);
		panel_Modify_Ps.add(PF_NewPs);
		panel_Modify_Ps.add(label_NewPsA);
		panel_Modify_Ps.add(PF_NewPsA);
		panel_Modify_Ps.add(btn_OK_Ps);
		panel_Modify_Ps.add(btn_Cancel_Ps);
		
		//��Ƭ���
		card = new CardLayout();
		panel_Func = new JPanel(card);
		contentPane.add(panel_Func,BorderLayout.CENTER);
		panel_Func.add(panel_BK,"������");
		panel_Func.add(panel_QueryScore,"�ɼ���");
		panel_Func.add(panel_Modify_Ps,"�����");
		panel_Func.add(panel_inScore,"¼���");
		card.show(panel_Func, "������");
		
		
		hm_Tea_Cou = new HashMap();
		
	}
	public void setLabel()
	{
		String[] info = Function.getTeacher_Infor(this.Tea_no);
		label_Tea_no.setText("��ʦ�ţ�"+info[0]);
		label_Tea_name.setText("������"+info[1]);
	}
	public String getTea_no()
	{
		return this.Tea_no;
	}
	public DefaultTableModel getTableModel()
	{
		return this.model;
	}
	public CardLayout getCard()
	{
		return this.card;
	}
	public JPanel getShowPanel()
	{
		return this.panel_Func;
	}
	//��������
	public JPasswordField getPF_NEW()
	{
		return this.PF_NewPs;
	}
	//����ȷ������
	public JPasswordField getPF_NEWA()
	{
		return this.PF_NewPsA;
	}
	//���ؿγ̰���
	public JComboBox getcBox_Cou()
	{
		return this.cbox_Cou_name;
	}
	//����¼��ɼ���ģʽ
	public DefaultTableModel getModel_InScore()
	{
		return model_InScore;
	}
  
}
