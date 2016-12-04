package window;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import lib.GlitchImage;
import lib.TextLimit;

public class LoginScreen extends JFrame implements ActionListener
{
	JTextField tfId;
	JPasswordField pfPw;
	JLabel lblId;
	JLabel lblPw;
	JLabel lblTitle;
	JButton btnReg;
	JButton btnJoin;
	Container ctLogin;

	// ImageIcon region start
	
	/*
	 * GlitchLib�� ���� ���� Glitch Animation Images
	 */
	public void paint(Graphics g)
	{
		super.paint(g);
	}
	
	ImageIcon[] titleImage =
	{
		new ImageIcon("src/img/defaultNew.png"),
		new ImageIcon("src/img/defaultNewGB.png"),
		new ImageIcon("src/img/defaultNewRB.png"),
		new ImageIcon("src/img/defaultNewRBGB.png"),
		new ImageIcon("src/img/defaultGlitch.png"),
		new ImageIcon("src/img/defaultGlitch2.png"),
		new ImageIcon("src/img/defaultGlitch3.png"),
		new ImageIcon("src/img/glitch1.png"),
		new ImageIcon("src/img/glitch2.png"),
		new ImageIcon("src/img/glitch3.png"),
		new ImageIcon("src/img/glitch4.png"),
		new ImageIcon("src/img/glitch5.png"),
		new ImageIcon("src/img/glitch6.png"),
		new ImageIcon("src/img/glitch7.png"),
		new ImageIcon("src/img/glitch8.png"),
		new ImageIcon("src/img/glitch9.png"),
		new ImageIcon("src/img/glitch10.png"),
		new ImageIcon("src/img/glitch11.png")
	};
	
	ImageIcon imgId = new ImageIcon("src/img/titleId.png");
	ImageIcon imgPw = new ImageIcon("src/img/titlePW.png");
	ImageIcon imgTf = new ImageIcon("src/img/textField.png");
	
	// ImageIcon region end
	
	public LoginScreen(String title)
	{
		/*
		 * ������ �⺻ ����
		 */
		setResizable(false);
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(720, 480);
		ctLogin = getContentPane();
		ctLogin.setBackground(Color.BLACK);
		ctLogin.setLayout(null); // ��ġ ���� �����Ҳ�����..
		
		
		/*
		 * �⺻ UI ����
		 */
		JPanel pnLogin = new JPanel();
		pnLogin.setBounds(180,  270,  305,  100);
		pnLogin.setOpaque(false); //����� ���������.
		ctLogin.add(pnLogin);
		pnLogin.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel pnLoginId = new JPanel();
		pnLoginId.setBackground(Color.WHITE);
		pnLoginId.setOpaque(false);
		pnLogin.add(pnLoginId);
		pnLoginId.setLayout(null);
		
		JPanel pnLoginPw = new JPanel();
		pnLoginPw.setBackground(Color.WHITE);
		pnLoginPw.setOpaque(false);
		pnLogin.add(pnLoginPw);
		pnLoginPw.setLayout(null);
		
		lblId = new JLabel(imgId);
		lblId.setFont(new Font("���� ���", Font.PLAIN, 12));
		lblId.setBounds(10, 15, 100, 20);
		pnLoginId.add(lblId);
		
		lblPw = new JLabel(imgPw);
		lblPw.setFont(new Font("���� ���", Font.PLAIN, 12));
		lblPw.setBounds(10, 15, 100, 20);
		pnLoginPw.add(lblPw);
		
		tfId = new JTextField(20);
		tfId.setFont(new Font("���� ���", Font.PLAIN, 17));
		tfId.setForeground(Color.WHITE); // ���ڻ� ����
		tfId.setOpaque(false);
		tfId.setBounds(2, 0, 185, 30);
		tfId.setBorder(null);	 //�׵θ��� �Ⱥ��̰�
		tfId.addKeyListener(new TextLimit(tfId, 16,"[a-zA-Z0-9_-]"));
		pnLoginId.add(tfId);
		
		pfPw = new JPasswordField(20);
		pfPw.setFont(new Font("���� ���", Font.PLAIN, 17));
		pfPw.setForeground(Color.WHITE);
		pfPw.setOpaque(false);
		pfPw.setBounds(2, 0, 185, 30);
		pfPw.setBorder(null);
		pfPw.addKeyListener(new TextLimit(pfPw, 20, "[a-zA-Z0-9!@#$%^&*()+=-_`~]"));
		pnLoginPw.add(pfPw);
		
		btnReg = new JButton("Register");
		btnReg.setBounds(310, 405, 100, 25);
		ctLogin.add(btnReg);
		btnReg.addActionListener(this);
		
		btnJoin = new JButton("Join");
		btnJoin.setBounds(310, 375, 100, 25);
		ctLogin.add(btnJoin);
		
		lblTitle = new JLabel();
		lblTitle.setBounds(50, 50, 620, 120);
		ctLogin.add(lblTitle);
		
		
		/*
		 * Image ����
		 */
		lblTitle.setIcon(titleImage[0]);
		GlitchImage glitchEffect = new GlitchImage(titleImage, lblTitle, 2500, 60, 6);
		glitchEffect.start();
		
		/*
		 * TextField�� ��� �̹����� ���� ������ ���� ���... label�� imageIcon�� ���� ��
		 * TextField�� label�� add�ߴ�. ���� label�� ������ ����ȭ ���ѳ�����!
		 */
		JLabel lblImageTfId = new JLabel(imgTf);
		lblImageTfId.setBounds(117, 10, 183, 30);
		pnLoginId.add(lblImageTfId);
		lblImageTfId.add(tfId);
		
		JLabel lblImageTfPw = new JLabel(imgTf);
		lblImageTfPw.setBounds(117, 10, 183, 30);
		pnLoginPw.add(lblImageTfPw);
		lblImageTfPw.add(pfPw);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand() == "Register")
		{
		}
		else if(ae.getActionCommand() == "Join")
		{
		}
	}
}
