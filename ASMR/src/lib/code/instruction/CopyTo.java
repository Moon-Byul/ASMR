package lib.code.instruction;

import lib.code.CodeObject;
import lib.exception.InvalidArraySizeException;
import lib.exception.InvalidValueException;
import lib.variable.VariableManager;

public class CopyTo extends CodeObject
{
	VariableManager vm;
	int targetOperand = 0;
	boolean availablePointer = false;
	boolean checkedPointer = false;

	public CopyTo(boolean defaultObjectInput, VariableManager vmInput, int inputOperand, boolean inputAvailablePointer)
	{
		super.setDefaultObject(defaultObjectInput);
		this.setName("copyTo");
		this.setTargetOperand(inputOperand);
		this.availablePointer = inputAvailablePointer;
		vm = vmInput;
	}
	
	@Override
	public CopyTo copy()
	{
		CopyTo copyObj = null;
		try
		{
			copyObj = (CopyTo) super.clone();
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
			temp = vm.getCpu();
			
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
			if(ive.getExtra() != null)
				throw new InvalidValueException("���� ! " + ive.getExtra() + "�� �������� ���� �������� �ʽ��ϴ�.");
			else
				throw new InvalidValueException("���� ! CPU�� ���� �������� �ʽ��ϴ�.");
		}
		catch(NumberFormatException nfe)
		{
			throw new NumberFormatException("���� ! �ּ� ���� ���ڸ� ���� �Ͻ� �� �����ϴ�.");
		}
	}
}
