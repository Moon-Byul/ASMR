package lib.code.instruction;

import lib.code.CodeObject;
import lib.exception.InvalidValueException;
import lib.variable.VariableManager;

public class PrintData extends CodeObject
{
	VariableManager vm;
	
	public PrintData(VariableManager vmInput)
	{
		this.setName("printData");
		vm = vmInput;
	}
	
	@Override
	public void run() throws InvalidValueException
	{
		try
		{
			String temp = vm.getCpu();
			vm.setCpu("");
			vm.depositOutput(temp);
		}
		catch(InvalidValueException ive)
		{
			throw new InvalidValueException("���� ! CPU�� ����� ���� �������� �ʽ��ϴ�.");
		}
	}
}
