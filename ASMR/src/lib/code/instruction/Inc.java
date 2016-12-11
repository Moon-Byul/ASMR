package lib.code.instruction;

import lib.code.CodeObject;
import lib.exception.InvalidArraySizeException;
import lib.exception.InvalidValueException;
import lib.variable.VariableManager;

public class Inc extends CodeObject
{
	VariableManager vm;
	int targetOperand = 0;
	boolean availablePointer = false;
	boolean checkedPointer = false;

	public Inc(boolean defaultObjectInput, VariableManager vmInput, int inputOperand, boolean inputAvailablePointer)
	{
		super.setDefaultObject(defaultObjectInput);
		this.setName("inc");
		this.setTargetOperand(inputOperand);
		this.availablePointer = inputAvailablePointer;
		vm = vmInput;
	}
	
	@Override
	public Inc copy()
	{
		Inc copyObj = null;
		try
		{
			copyObj = (Inc) super.clone();
		}
		catch(CloneNotSupportedException cnse){};
		
		copyObj.vm = this.vm;
		copyObj.targetOperand = this.targetOperand;
		copyObj.availablePointer = this.availablePointer;
		copyObj.checkedPointer = this.checkedPointer;
		
		return copyObj;
	}
	
	@Override
	public boolean isAvailablePointer()
	{
		return availablePointer;
	}
	
	@Override
	public boolean isCheckedPointer()
	{
		return checkedPointer;
	}
	
	@Override
	public int getTargetOperand()
	{
		return targetOperand;
	}
	
	@Override
	public void setCheckedPointer(boolean input)
	{
		checkedPointer = input;
	}
	
	@Override
	public void setTargetOperand(int operand)
	{
		targetOperand = operand;
	}
	
	@Override
	public void run() throws InvalidArraySizeException, InvalidValueException, NumberFormatException
	{
		String temp;
		try
		{
			if(checkedPointer == true)
				temp = vm.getVariableAtPointer(targetOperand);
			else
				temp = vm.getVariable(targetOperand);
		}
		catch(InvalidArraySizeException iase)
		{
			throw new InvalidArraySizeException("���� ! " + iase.getExtra() + "�� ������ �������� �ʽ��ϴ�.");
		}
		catch(InvalidValueException ive)
		{
			throw new InvalidValueException("���� ! " + ive.getExtra() + "�� �������� ���� �������� �ʽ��ϴ�.");
		}
		catch(NumberFormatException nfe)
		{
			throw new NumberFormatException("���� ! �ּ� ���� ���ڸ� ���� �Ͻ� �� �����ϴ�.");
		}
		
		try
		{
			temp = Integer.toString(Integer.parseInt(temp)+1);
		}
		catch(NumberFormatException nfe)
		{
			throw new NumberFormatException("���� ! ���ڸ� ���� ���� �����ϴ�.");
		}
		
		if(Integer.parseInt(temp) > 999)
		{
			throw new NumberFormatException("�����÷ο� ���� ! 999 �̻��� ���� �ٷ�� �� �����ϴ�.");
		}
		
		try
		{
			if(checkedPointer == true)
				vm.setVariableAtPointer(temp, targetOperand);
			else
				vm.setVariable(temp, targetOperand);
		}
		catch(InvalidArraySizeException iase)
		{
			throw new InvalidArraySizeException("���� ! " + iase.getExtra() + "�� ������ �������� �ʽ��ϴ�.");
		}
		catch(InvalidValueException ive)
		{
			throw new InvalidValueException("���� ! " + ive.getExtra() + "�� �������� ���� �������� �ʽ��ϴ�.");
		}
		catch(NumberFormatException nfe)
		{
			throw new NumberFormatException("���� ! �ּ� ���� ���ڸ� ���� �Ͻ� �� �����ϴ�.");
		}
	}
}
