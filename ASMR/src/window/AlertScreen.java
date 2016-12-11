package window;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.LineBorder;



public class AlertScreen extends JPanel implements ActionListener {

	

	 JButton OK;
	 String Message;
	 JLayeredPane alt;

	public AlertScreen(String Msg, JLayeredPane jlp) {
		alt = jlp;
		Message = Msg; // alert�г��� ȣ��ɶ� ��Ȳ�� ���� �޽����� �Է¹������μ� �� �� ��Ȳ�� �°� �޽����� ��°����ϰ���
		this.setBounds(250,150, 200, 200);
		this.setVisible(true);
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		this.setBorder(new LineBorder(Color.WHITE,2));// �׵θ��� ����� �����μ� ���ݴ� ����ϰ� ����
		JPanel pnalr = new JPanel();
		pnalr.setBounds(25, 50, 150,  100);
		pnalr.setOpaque(false); 
		this.add(pnalr);
 
      
		JPanel  top = new JPanel();// �޽��� ��¿� ��� �г�
		JPanel  bottom = new JPanel();// ��ư ��¿� �ϴ� �г�
	    top.setOpaque(false);
		bottom.setOpaque(false);
		pnalr.add(top, BorderLayout.CENTER); 
		pnalr.add(bottom, BorderLayout.SOUTH); 
	
		
		//����г�
	    
		 JPanel pnmsg = new JPanel(); 
		 pnmsg.setLayout(new FlowLayout(FlowLayout.CENTER));
		 pnmsg.setOpaque(false);
		 JLabel lblmsg = new JLabel(Message); 
		 lblmsg.setFont(new Font("���� ���", Font.PLAIN, 17));
		 lblmsg.setForeground(Color.WHITE); // ���ڻ� ����
		 pnmsg.add(lblmsg);
		  top.add(pnmsg);
		 
		  //�����г�
		  
		 JPanel btnpn = new JPanel();	 
		 btnpn.setLayout(new FlowLayout(FlowLayout.CENTER));
		 btnpn.setOpaque(false);
		 OK = new JButton("OK");
		 btnpn.add(OK);
		 bottom.add(btnpn);
		 OK.addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent ae) {
		
		this.setEnabled(false);
		alt.setLayer(this, new Integer(0));//�г� �ǵڷ� ������ ����, �ٷ� ������ �ܻ��� �гο� ���� ���� �гεڷ� ������ �����ϵ��� �Ͽ���
		alt.remove(this);
		
		
	
	}
}
