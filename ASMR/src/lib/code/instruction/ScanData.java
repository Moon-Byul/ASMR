package lib.code.instruction;


import lib.code.CodeObject;
import lib.exception.InvalidArraySizeException;
import lib.variable.VariableManager;

public class ScanData extends CodeObject
{
	VariableManager vm;
	
	public ScanData(boolean defaultObjectInput, VariableManager vmInput)
	{
		super.setDefaultObject(defaultObjectInput);
		this.setName("scanData");
		vm = vmInput;
	}
	
	@Override
	public ScanData copy()
	{
		ScanData copyObj = null;
		try
		{
			copyObj = (ScanData) super.clone();
		}
		catch(CloneNotSupportedException cnse){};
		
		copyObj.vm = this.vm;
		
		return copyObj;
	}
	
	@Override
	public void run() throws InvalidArraySizeException
	{
		try
		{
			String temp = vm.withdrawInput();
			vm.setCpu(temp);
		}
		catch(InvalidArraySizeException iase)
		{
			throw new InvalidArraySizeException("���� ! Input�� ���� ���̻� �������� �ʽ��ϴ�.");
		}
	}
}
