package MyFrame;

import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


import MyData.DataModelmy;
import MyListener.MyWindowListener;
import MyListener.Stu_Frame_Listener;

import java.awt.*;
import javax.swing.*;
public class Student_Frame extends JFrame {

	private JPanel contentPane;
	private JPanel panel_Infor;//������Ϣ���
	private JPanel panel_Func;//���ֿ�Ƭ���
	private JPanel panel_XuanKe;//ѡ�����
	private JPanel panel_QueryScore;//�ɼ����
	private JPanel panel_Modify_Ps;//�޸��������
	private JPanel panel_BK;//�������
	private JLabel label_Stu_no;
	private JLabel label_Stu_name;
	private JLabel label_Stu_sex;
	private JLabel label_Stu_class;
	private String Stu_no;
	
	private JPanel panel_BtnFunc;//��߰�ť���
	private JButton btn_XuanKe;
	private JButton btn_QueryScore;
	private JButton btn_Modify_Pw;
	
	private JList list_all = null;
	private JList list_my = null;
	private DataModelmy mode_my = null;
	
	private JPanel panel_OK_flu;//ѡ������ϲ�
	private JButton btn_Ok_XK;
	private JButton btn_Flush_XK;
	private JButton btn_OK_Pw;
	
	
	private JTable Score_Table;
	private DefaultTableModel model;
	private CardLayout card;
	
	private JLabel label_BK;
	
	
	private JLabel label_NewPs;
	private JLabel label_NewPsA;
	private JPasswordField PF_NewPs;
	private JPasswordField PF_NewPsA;
	private JButton btn_OK_Ps;
	private JButton btn_Cancel_Ps;
	
	
	private DefaultTableModel model_XK_tab;
	private JTable tab_XK;
	public Student_Frame(String Stu_no) {
		this.Stu_no = Stu_no;
		setTitle("ѧ��ѡ�޳ɼ�����ϵͳ");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(800, 500);
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
		
		label_Stu_no = new JLabel();
		label_Stu_no.setHorizontalAlignment(SwingConstants.LEFT);
		label_Stu_name = new JLabel();
		label_Stu_name.setHorizontalAlignment(SwingConstants.LEFT);
		label_Stu_sex = new JLabel();
		label_Stu_sex.setHorizontalAlignment(SwingConstants.LEFT);
		label_Stu_class = new JLabel();
		label_Stu_class.setHorizontalAlignment(SwingConstants.LEFT);
		//���ñ�ǩtitle
		panel_Infor = new JPanel();
		contentPane.add(panel_Infor, BorderLayout.NORTH);
		panel_Infor.setLayout(new GridLayout(2,2));
		panel_Infor.add(label_Stu_no);
		panel_Infor.add(label_Stu_name);
		panel_Infor.add(label_Stu_sex);
		panel_Infor.add(label_Stu_class);
		Border lBorder = new LineBorder(Color.BLACK,1);
		panel_Infor.setBorder(BorderFactory.createTitledBorder(lBorder, "ѧ����Ϣ"));
		
		
		//��ť���
		panel_BtnFunc = new JPanel();
		contentPane.add(panel_BtnFunc, BorderLayout.WEST);
		panel_BtnFunc.setLayout(new BoxLayout(panel_BtnFunc, BoxLayout.Y_AXIS));
		
		Stu_Frame_Listener Stu_Listener = new Stu_Frame_Listener();
		panel_BtnFunc.add(Box.createVerticalStrut(40));
		btn_XuanKe = new JButton("��ʼѡ��");
		btn_XuanKe.addActionListener(Stu_Listener);
		btn_XuanKe.setActionCommand("��ʼѡ��");
		panel_BtnFunc.add(btn_XuanKe);
		panel_BtnFunc.add(Box.createVerticalStrut(20));
	
		btn_QueryScore = new JButton("��ѯ�ɼ�");
		btn_QueryScore.addActionListener(Stu_Listener);
		btn_QueryScore.setActionCommand("��ѯ�ɼ�");
		panel_BtnFunc.add(btn_QueryScore);
		panel_BtnFunc.add(Box.createVerticalStrut(20));
		
		btn_Modify_Pw = new JButton("�޸�����");
		btn_Modify_Pw.addActionListener(Stu_Listener);
		btn_Modify_Pw.setActionCommand("�޸�����");
		panel_BtnFunc.add(btn_Modify_Pw);
		panel_BtnFunc.add(Box.createVerticalStrut(20));
		panel_BtnFunc.setBorder(BorderFactory.createTitledBorder("�����б�"));
		
		
		//�м䲿�����
		
		//ѡ�����
		panel_XuanKe = new JPanel(new BorderLayout());
		/*������list
		mode_all = new DataModel();
		list_all = new JList(mode_all);
		list_all.addMouseListener(list_Listener);
		list_all.setBorder(BorderFactory.createTitledBorder("���пγ�"));
		panel_XuanKe.add(new JScrollPane(list_all),BorderLayout.CENTER);
		*/
		//���ñ��
		model_XK_tab = new DefaultTableModel();
		tab_XK = new JTable(model_XK_tab);
		DefaultTableCellRenderer r   = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);  
		tab_XK.setDefaultRenderer(Object.class,r);
		panel_XuanKe.add(new JScrollPane(tab_XK),BorderLayout.CENTER);
		
		//��ʾ�γ̻��ǲ���list
		mode_my = new DataModelmy(Stu_no);
		list_my = new JList(mode_my);
		//list_my.addMouseListener(list_Listener);
		list_my.setBorder(BorderFactory.createTitledBorder("�ҵĿγ�"));
		panel_XuanKe.add(new JScrollPane(list_my),BorderLayout.EAST);
		
					//�����ˢ�����
		panel_OK_flu = new JPanel();
		btn_Ok_XK = new JButton("����");
		btn_Ok_XK.addActionListener(Stu_Listener);
		btn_Ok_XK.setActionCommand("����");
		panel_OK_flu.add(btn_Ok_XK);
		
		btn_Flush_XK = new JButton("ˢ��");
		btn_Flush_XK.addActionListener(Stu_Listener);
		btn_Flush_XK.setActionCommand("ˢ��");
		panel_OK_flu.add(btn_Flush_XK);
		panel_XuanKe.add(panel_OK_flu,BorderLayout.SOUTH);
		
		
		//�ɼ����
		panel_QueryScore = new JPanel(new BorderLayout());
		model = new DefaultTableModel();
		Score_Table = new JTable(model); 
		Score_Table.setEnabled(false);
		Score_Table.setDefaultRenderer(Object.class, r);
		Score_Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_QueryScore.add(new JScrollPane(Score_Table),BorderLayout.CENTER);
		
		
		//�������
		panel_BK = new JPanel(new BorderLayout());
		label_BK = new JLabel("ѧ��ѡ�ι���ϵͳ");
		panel_BK.add(label_BK,BorderLayout.CENTER);
		label_BK.setIcon(new ImageIcon("images//BK.png"));
		//Image image = img.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
		//img.setImage(image);
		
		//�޸��������
		label_NewPs = new JLabel("������:");
		label_NewPs.setHorizontalAlignment(SwingConstants.CENTER);
		label_NewPsA = new JLabel("ȷ�����룺");
		label_NewPsA.setHorizontalAlignment(SwingConstants.CENTER);
		PF_NewPs = new JPasswordField();
		PF_NewPsA = new JPasswordField();
		btn_OK_Ps = new JButton("ȷ��");
		btn_OK_Ps.addActionListener(Stu_Listener);
		btn_OK_Ps.setActionCommand("ȷ��");
		btn_Cancel_Ps = new JButton("ȡ��");
		btn_Cancel_Ps.addActionListener(Stu_Listener);
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
		contentPane.add(panel_Func, BorderLayout.CENTER);
		panel_Func.add(panel_XuanKe,"ѡ�ΰ�");
		panel_Func.add(panel_QueryScore,"�ɼ���");
		panel_Func.add(panel_BK,"������");
		panel_Func.add(panel_Modify_Ps,"�����");
		card.show(panel_Func, "������");
	}
	public void setLabel()
	{
	 Student stu = Function.getStudent_Infor(this.Stu_no);
		label_Stu_no.setText("ѧ�ţ�"+stu.getStu_no()) ;
		label_Stu_name.setText("������"+stu.getStu_name());
		label_Stu_sex.setText("�Ա�"+stu.getStu_sex());
		label_Stu_class.setText("�༶��"+stu.getStu_class());
	}
	
	//���ؿ�Ƭ���ֶ���
	public CardLayout getCard()
	{
		return this.card;
	}
	//���������ڿ�Ƭ���ֶ�������
	public JPanel getShowPanel()
	{
		return this.panel_Func;
	}
	
	public JList getList_my()
	{
		return this.list_my;
	}
	public DataModelmy getDataModelmy()
	{
		return this.mode_my;
	}
	//����ѧ��
	public String getStu_no()
	{
		return this.Stu_no;
	}
	//���ر��ģʽ
	public DefaultTableModel getTable_Model()
	{
		return this.model;
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
	//����ѡ�α�ģʽ
	public DefaultTableModel getXK_Tab_Mod()
	{
		return this.model_XK_tab;
	}
	//����ѡ�α�table
	public JTable getXK_Table()
	{
		return this.tab_XK;
	}
}


