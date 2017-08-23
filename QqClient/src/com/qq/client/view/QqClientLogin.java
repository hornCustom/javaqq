/*
 * ���ܣ�qq�ͻ��˵�¼����
 * */
package com.qq.client.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.qq.client.model.QqClientUser;
import com.qq.common.User;

public class QqClientLogin extends JFrame implements ActionListener{
	// ���山����Ҫ�����
	JLabel jbll;
	// �����в���Ҫ�����
	// �в�������JPanel����һ��ѡ����ڹ���
	JTabbedPane jtp;
	JPanel jp2, jp3, jp4;

	// �����ϲ���Ҫ�����
	JPanel jp1;
	JButton jp1_jb1, jp1_jb2, jp1_jb3;
	JLabel jp2_jbl1, jp2_jbl2, jp2_jbl3, jp2_jbl4;
	JButton jp2_jb1;
	JTextField jp2_jtf;
	JPasswordField jp2_jpf;
	JCheckBox jp2_jcb1, jp2_jcb2;

	public static void main(String[] args) {
		QqClientLogin qqClientLogin = new QqClientLogin();

	}

	public QqClientLogin() {
		// ������
		jbll = new JLabel(new ImageIcon("new_image/tou.png"));

		// �����в�
		jp2 = new JPanel(new GridLayout(3, 3));

		jp2_jbl1 = new JLabel("QQ����", JLabel.CENTER);
		jp2_jbl2 = new JLabel("QQ����", JLabel.CENTER);
		jp2_jbl3 = new JLabel("��������", JLabel.CENTER);
		jp2_jbl3.setForeground(Color.BLUE);

		jp2_jbl4 = new JLabel("�������뱣��", JLabel.CENTER);
		jp2_jb1 = new JButton(new ImageIcon("new_image/clear.png"));
		jp2_jtf = new JTextField();
		jp2_jpf = new JPasswordField();
		jp2_jcb1 = new JCheckBox("�����¼");
		jp2_jcb2 = new JCheckBox("��ס����");

		// �ѿؼ�����ѭ��ӵ�jp2
		jp2.add(jp2_jbl1);
		jp2.add(jp2_jtf);
		jp2.add(jp2_jb1);
		jp2.add(jp2_jbl2);
		jp2.add(jp2_jpf);
		jp2.add(jp2_jbl3);
		jp2.add(jp2_jcb1);
		jp2.add(jp2_jcb2);
		jp2.add(jp2_jbl4);
		// ����ѡ�����
		jtp = new JTabbedPane();
		jtp.add("QQ����", jp2);
		jp3 = new JPanel();
		jtp.add("�ֻ�����", jp3);
		jp4 = new JPanel();
		jtp.add("�����ʼ�", jp4);

		// �����ϲ�
		jp1 = new JPanel();
		jp1_jb1 = new JButton(new ImageIcon("new_image/denglu.png"));

		//��Ӧ�û������¼
		jp1_jb1.addActionListener(this);
		jp1_jb2 = new JButton(new ImageIcon("new_image/quxiao.png"));

		jp1_jb3 = new JButton(new ImageIcon("new_image/xiangdao.png"));

		// ��������ť�ŵ�jp1
		jp1.add(jp1_jb1);
		jp1.add(jp1_jb2);
		jp1.add(jp1_jb3);

		this.add(jbll, "North");
		this.add(jtp, "Center");
		// ..��jp1�����ϲ�
		this.add(jp1, "South");
		this.setSize(350, 380);
		// ��ֹ�����϶�
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//����û������¼
		if (arg0.getSource()==jp1_jb1) {
			QqClientUser qqClientUser=new QqClientUser();
			User u=new User();
			u.setUserId(jp2_jtf.getText().trim());
			u.setPasswd(new String(jp2_jpf.getPassword()));
			
			if(qqClientUser.checkUser(u))
			{
				new QqFriendList(u.getUserId());
				//�رյ���¼����
				this.dispose();
			}else{
				JOptionPane.showMessageDialog(this,"�û����������");
			}
			
		}
	}
}
