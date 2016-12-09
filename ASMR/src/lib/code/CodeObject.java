package lib.code;

import javax.swing.JLabel;

import lib.exception.NotOverrideEssentialMethodException;

public class CodeObject implements Cloneable
{
	private String name = null;
	private boolean defaultObject = false;
	
	public JLabel[] lblOperand = new JLabel[3];
	
	public CodeObject()
	{
		for(int i=0; i<=2; i++)
		{
			lblOperand[i] = new JLabel();
			lblOperand[i].setOpaque(true);
		}
	}
	
	public void run() throws Exception
	{
		// �������̵� �ϼ���
	}
	
	public CodeObject copy()
	{
		// �̰͵� �������̵�
		return null;
	}
	
	public void setFirstOperand(String input)
	{
		lblOperand[0].setText(input);
	}
	
	public void setSecondOperand(String input)
	{
		lblOperand[1].setText(input);
	}
	
	public void setThirdOperand(String input)
	{
		lblOperand[2].setText(input);
	}

	/*
	public final String getFirstOperandValue()
	{
		String tempStr;

		tempStr = getCompareOperand();
		if(tempStr != null)
		{
			System.out.println("Compare Return");
			return tempStr;
		}
		return getSecondOperandValue();
	}
	
	public final String getSecondOperandValue()
	{
		int temp;
		
		temp = getTargetOperand();
		if(temp > -1)
		{
			System.out.println("Target Return");
			return Integer.toString(temp);
		}
		return getThirdOperandValue();
	}
	
	public final String getThirdOperandValue()
	{
		int temp;
		
		temp = getDestinationAddr();
		if(temp > -1)
		{
			System.out.println("Destination Return");
			return Integer.toString(temp);
		}
		else
		{
			System.out.println("Null Return");
			return null;
		}
	}
	*/
	
	public boolean isAvailablePointer() throws NotOverrideEssentialMethodException
	{
		if(getTargetOperand() < 0)
			return false;
		else
		{
			// �� �ڵ��� Target Operand�� �����͸� ����Ҽ� �ִ���!
			// TargetOperand�� �������̵� �ؼ� �ִµ� 
			// �������̵� ���ϰ� ���� *��������*
			throw new NotOverrideEssentialMethodException(name + " code is not override isAvailablePointer.");
		}
	}
	
	public boolean isCheckedPointer() throws NotOverrideEssentialMethodException
	{
		// Target variable operand�� �����ͷ� �������ִ��� boolean ���� return �ϴ� �޼ҵ忡��
		// �������̵� ���ϰ� ���� *��������*
		throw new NotOverrideEssentialMethodException(name + " code is not override isCheckedPointer.");
	}
	
	public int getTargetOperand()
	{
		// ���꿡 ����� target variable operand�� ���ϴ� �޼ҵ忡��
		// �������̵� ���ϸ� null�� return �ؿ�
		return -1;
	}
	
	public String getCompareOperand()
	{
		// ifcpu�������� ���
		// �������̵� ���ϸ� null�� return �ؿ�
		return null;
	}
	
	public int getDestinationAddr()
	{
		// Code-window���� Destination �ּҸ� ���ϴ� �޼ҵ忡��
		// �������̵� ���ϸ� null�� return �ؿ�
		return -1;
	}
	
	public void setCheckedPointer(boolean input)
	{
		// ������ üũ�Ҳ�����?
		// �ʿ��� �� �������̵� �ϼ���
	}
	
	public void setTargetOperand(int operand)
	{
		// ���꿡 ����� target variable operand�� �����ϴ� �޼ҵ忡��
		// �ʿ��� �� �������̵� �ϼ���
	}
	
	public void setCompareOperand(int operand)
	{
		// ifcpu�������� ���
		// �ʿ��� �� �������̵� �ϼ���
	}
	
	public void setDestinationAddr(int destination)
	{
		// Code-window���� Destination �ּҸ� �����ϴ� �޼ҵ忡��
		// �ʿ��� �� �������̵� �ϼ���
	}
	
	public boolean getDefaultObject()
	{
		return defaultObject;
	}
	
	public void setDefaultObject(boolean input)
	{
		defaultObject = input;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String input)
	{
		name = input;
	}
}
