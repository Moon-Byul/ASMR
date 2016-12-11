package lib.code.instruction;

import lib.code.CodeObject;
import lib.exception.InvalidArraySizeException;
import lib.exception.InvalidValueException;
import lib.variable.VariableManager;

public class Sub extends CodeObject
{
	VariableManager vm;
	int targetOperand = 0;
	boolean availablePointer = false;
	boolean checkedPointer = false;

	public Sub(boolean defaultObjectInput, VariableManager vmInput, int inputOperand, boolean inputAvailablePointer)
	{
		super.setDefaultObject(defaultObjectInput);
		this.setName("sub");
		this.setTargetOperand(inputOperand);
		this.availablePointer = inputAvailablePointer;
		vm = vmInput;
	}
	
	@Override
	public Sub copy()
	{
		Sub copyObj = null;
		try
		{
			copyObj = (Sub) super.clone();
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
		String cpuTemp;
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
			cpuTemp = vm.getCpu();
		}
		catch(InvalidValueException ive)
		{
			throw new InvalidValueException("���� ! CPU�� ����� ���� �������� �ʽ��ϴ�.");
		}
		
		try
		{
			temp = Integer.toString(Integer.parseInt(cpuTemp) - Integer.parseInt(temp));
		}
		catch(NumberFormatException nfe)
		{
			throw new NumberFormatException("���� ! ���ڸ� ���� ���� �����ϴ�.");
		}
		
		if(Integer.parseInt(temp) < -999)
		{
			throw new NumberFormatException("����÷ο� ���� ! -999 ������ ���� �ٷ�� �� �����ϴ�.");
		}
		
		vm.setCpu(temp);
	}
}
