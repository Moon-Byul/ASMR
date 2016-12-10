package window;

import java.awt.*;

import javax.swing.*;

import lib.code.panel.CodePanel;
import lib.variable.VariablePanel;
import stage.StageLib;

public class GameScreen extends JPanel
{
	VariablePanel pnVariable;
	
	public GameScreen(int stageNum)
	{
		this.setBounds(0, 0, 720, 480);
		this.setVisible(true);
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		
		StageLib stageClass = new StageLib(stageNum);
		try
		{
			pnVariable = new VariablePanel(0, 0, 720, 480, stageClass);
			this.add(pnVariable);
		}
		catch(Exception e)
		{
			//�������� ȭ������ ���� �̺�Ʈ
		}
	}
}
