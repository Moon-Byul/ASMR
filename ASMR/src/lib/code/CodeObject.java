package lib.code;

import lib.exception.NotOverrideEssentialMethodException;

public class CodeObject
{
	private String name;
	
	public void run() throws Exception
	{
		// �������̵� �ϼ���
	}
	
	public boolean isCheckedPointer() throws NotOverrideEssentialMethodException
	{
		// Target variable operand�� �����ͷ� �������ִ��� boolean ���� return �ϴ� �޼ҵ忡��
		// �������̵� ���ϰ� ���� *��������*
		throw new NotOverrideEssentialMethodException(name + " code is not override isCheckedPointer.");
	}
	
	public String getTargetOperand()
	{
		// ���꿡 ����� target variable operand�� ���ϴ� �޼ҵ忡��
		// �������̵� ���ϸ� null�� return �ؿ�
		return null;
	}
	
	public String getCompareOperand()
	{
		// ifcpu�������� ���
		// �������̵� ���ϸ� null�� return �ؿ�
		return null;
	}
	
	public String getDestinationAddr()
	{
		// Code-window���� Destination �ּҸ� ���ϴ� �޼ҵ忡��
		// �������̵� ���ϸ� null�� return �ؿ�
		return null;
	}
	
	public void setTargetOperand()
	{
		// ���꿡 ����� target variable operand�� �����ϴ� �޼ҵ忡��
		// �������̵� �ϼ���
	}
	
	public void setCompareOperand()
	{
		// ifcpu�������� ���
		// �������̵� �ϼ���
	}
	
	public void setDestinationAddr()
	{
		// Code-window���� Destination �ּҸ� �����ϴ� �޼ҵ忡��
		// �������̵� �ϼ���
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
