package lib.code.instruction;

import lib.code.CodeManager;
import lib.code.CodeObject;
import lib.exception.InvalidArraySizeException;
import lib.exception.InvalidValueException;
import lib.variable.VariableManager;

public class IfCpu extends CodeObject
{
	VariableManager vm;
	CodeManager cm;
	int targetOperand = 0;
	int destination = 1;
	String compare = "==";
	boolean availablePointer = false;
	boolean checkedPointer = false;

	public IfCpu(boolean defaultObjectInput, VariableManager vmInput, CodeManager cmInput, String inputCompare, int inputOperand, int inputDestination, boolean inputAvailablePointer)
	{
		super.setDefaultObject(defaultObjectInput);
		this.setName("ifCpu");
		this.setTargetOperand(inputOperand);
		this.setCompareOperand(inputCompare);
		this.setDestinationAddr(inputDestination);
		this.availablePointer = inputAvailablePointer;
		vm = vmInput;
		cm = cmInput;
	}
	
	@Override
	public IfCpu copy()
	{
		IfCpu copyObj = null;
		try
		{
			copyObj = (IfCpu) super.clone();
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
	public String getCompareOperand()
	{
		return compare;
	}
	
	@Override
	public int getDestinationAddr()
	{
		return destination;
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
	public void setCompareOperand(String compareInput)
	{
		compare = compareInput;
	}
	
	@Override
	public void setDestinationAddr(int destinationInput)
	{
		destination = destinationInput;
	}
	
	@Override
	public void run() throws InvalidArraySizeException, InvalidValueException, NumberFormatException, Exception
	{
		boolean check = false;
		String temp;
		int varTemp;
		int cpuTemp;
		
		try
		{
			cpuTemp = Integer.parseInt(vm.getCpu());
		}
		catch(InvalidValueException ive)
		{
			throw new InvalidValueException("���� ! CPU�� ����� ���� �������� �ʽ��ϴ�.");
		}
		catch(NumberFormatException nfe)
		{
			throw new InvalidValueException("���� ! ���ڴ� ���Ͻ� �� �����ϴ�.");
		}
		
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
			varTemp = Integer.parseInt(temp);
		}
		catch(NumberFormatException nfe)
		{
			throw new InvalidValueException("���� ! ���ڴ� ���Ͻ� �� �����ϴ�.");
		}
		
		if(compare.equals(">="))
		{
			if(cpuTemp >= varTemp)
				check = true;
		}
		else if(compare.equals(">"))
		{
			if(cpuTemp > varTemp)
				check = true;
		}
		else if(compare.equals("=="))
		{
			if(cpuTemp == varTemp)
				check = true;
		}
		else if(compare.equals("<"))
		{
			if(cpuTemp < varTemp)
				check = true;
		}
		else if(compare.equals("<="))
		{
			if(cpuTemp <= varTemp)
				check = true;
		}
		
		if(check == true)
		{
			try
			{
				if(destination-1 == cm.getProgramCounter())
					throw new Exception ("���� ! IfCpu �ڵ尡 ��ġ�� ������ �̵��ؾ� �� ���ΰ� ��ġ�ϸ� \n�ȵ˴ϴ�.");
				cm.setProgramCounter(destination-1);
				cm.codeRun();
			}
			catch(Exception e)
			{
				throw e;
			}
		}
		else
		{
			try
			{
				cm.setProgramCounter(cm.getProgramCounter()+1);
				cm.codeRun();
			}
			catch(Exception e)
			{
				throw e;
			}
		}
	}
}
