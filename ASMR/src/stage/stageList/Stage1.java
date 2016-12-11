package stage.stageList;

import java.util.*;

import stage.StageObject;
import stage.StageInterface;
import lib.code.CodeConstants;

public class Stage1 extends StageObject implements StageInterface
{
	int arrayAmount = 0;
	
	public Stage1()
	{
		super.setDescription(
				"ASM���ӿ� ���Ű��� ȯ���մϴ�. �� ������ �ڵ带 �̿��Ͽ�\n"
				+ "�� ������ �ڵ带 �̿��Ͽ� ������ �ذ��ϴ� �����Դϴ�.\n"
				+ "������ scanData�� printData �ڵ带 �巡�� �ϰ� Code Window��\n"
				+ "�ٿ��־� ������. �״���, ������ �ϴ��� ��� ��ư�� ����������!\n"
				+ "*���ο� ��ɾ ������ϴ�.\n"
				+ "scanData - Input�� ù��° ���� �����ͼ� cpu�� �����մϴ�.\n"
				+ "printData - cpu�� ù��° ���� output�� �����ϴ�.\n"
		);
		super.setArrayAmount(arrayAmount);
		super.setAvailableCommand
		(
				CodeConstants.CODE_SCANDATA +
				CodeConstants.CODE_PRINTDATA
		);
		super.setAvailablePointer(false);
	}
	
	public List<String> getOutputToInput(List<String> input)
	{
		List<String> output = new ArrayList<String>();
		
		output.add(input.get(0));
		
		return output;
	}
	
	public List<String> setInput(List<String> input)
	{
		Random randomize = new Random();
		int randTemp;
		randTemp = randomize.nextInt(9)+1;
			
		input.add(Integer.toString(randTemp));
		
		return input;
	}
	
	public String[] impliedArraySet()
	{
		String[] arrayVar = new String[arrayAmount];
		
		return arrayVar;
	}
}
