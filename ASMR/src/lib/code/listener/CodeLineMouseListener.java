package lib.code.listener;

import java.awt.event.MouseEvent;

import lib.code.CodeObject;
import lib.code.panel.CodeModifyPanel;
import lib.code.panel.CodePanel;

public class CodeLineMouseListener extends CodeCentreMouseListener
{
	public CodeLineMouseListener(CodePanel codePanelInput)
	{
		super(codePanelInput);
	}
	
	@Override
	public void mousePressed(MouseEvent e)
	{
		if(codePanel.getCheckModify())
		{
			if(codePanel.modifyPanel.getCheckModifyOperand())
			{
				if(codePanel.listLine.isEnabled() == true)
				{
					int selectedValue = Integer.parseInt(codePanel.listLine.getSelectedValue());
					if(codePanel.listLine.getModel().getSize()-1 >= selectedValue)
					{
						if(selectedValue != codePanel.listMain.getSelectedIndex()+1)
							codePanel.modifyPanel.updateDestinationCode(selectedValue);
					}
				}
				codePanel.modifyPanel.changeDefaultOperandButton();
			}
			else
				codePanel.modifyPanel.invisiblePanel();
		}
	}
}
