package lib.code;

public class CodeObject implements Cloneable
{
	private String name = null;
	private boolean defaultObject = false;
	
	public void run() throws Exception
	{
		// �������̵� �ϼ���
	}
	
	public CodeObject copy()
	{
		// �̰͵� �������̵�
		return null;
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
	
	public boolean isAvailablePointer()
	{
		if(getTargetOperand() < 0)
			return false;
		else
		{
			// �� �ڵ��� Target Operand�� �����͸� ����Ҽ� �ִ���!
			// TargetOperand�� �������̵� �ؼ� �ִµ� 
			// �������̵� ���ϰ� false�� ��ȯ�ؿ�
			return false;
		}
	}
	
	public boolean isCheckedPointer()
	{
		// Target variable operand�� �����ͷ� �������ִ��� boolean ���� return �ϴ� �޼ҵ忡��
		// �������̵� ���ϸ� false�� ��ȯ�ؿ�
		return false;
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
	
	public void setCompareOperand(String operand)
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
