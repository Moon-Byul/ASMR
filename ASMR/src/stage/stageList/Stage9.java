package stage.stageList;

import java.util.*;

import stage.StageObject;
import stage.StageInterface;
import lib.code.CodeConstants;

public class Stage9 extends StageObject implements StageInterface
{
	int arrayAmount = 3;
	
	public Stage9()
	{
		super.setDescription(
				"input�� ���� 2���� ���߿� 2��° ���� 1��° ���� �� ���� \n"
				+ "1��° ���� 2��° ���� �� ���� output���� ��������!\n"
				+ "ex) 2 3 4 1 -> -1 1 3 -3\n\n"
				+ "*���ο� ��ɾ ������ϴ�.\n"
				+ "Sub [n] - Cpu�� ���� [n]��° ���� ���� �� ����\n"
				+ "Cpu�� �����մϴ�.\n"
		);
		super.setArrayAmount(arrayAmount);
		super.setAvailableCommand
		(
				CodeConstants.CODE_SCANDATA +
				CodeConstants.CODE_PRINTDATA +
				CodeConstants.CODE_COPYFROM +
				CodeConstants.CODE_COPYTO +
				CodeConstants.CODE_ADD +
				CodeConstants.CODE_SUB +
				CodeConstants.CODE_IFCPU +
				CodeConstants.CODE_JUMP
		);
		super.setAvailablePointer(false);
	}
	
	public List<String> getOutputToInput(List<String> input)
	{
		List<String> output = new ArrayList<String>();
		
		output.add(Integer.toString(Integer.parseInt(input.get(1))-Integer.parseInt(input.get(0))));
		output.add(Integer.toString(Integer.parseInt(input.get(0))-Integer.parseInt(input.get(1))));
		output.add(Integer.toString(Integer.parseInt(input.get(3))-Integer.parseInt(input.get(2))));
		output.add(Integer.toString(Integer.parseInt(input.get(2))-Integer.parseInt(input.get(3))));
		output.add(Integer.toString(Integer.parseInt(input.get(5))-Integer.parseInt(input.get(4))));
		output.add(Integer.toString(Integer.parseInt(input.get(4))-Integer.parseInt(input.get(5))));
		
		return output;
	}
	
	public List<String> setInput(List<String> input)
	{
		Random randomize = new Random();
		for(int i=0; i<=5; i++)
		{
			int randTemp;
			randTemp = randomize.nextInt(11)-10;
			input.add(Integer.toString(randTemp));
		}
		
		return input;
	}
	
	public String[] impliedArraySet()
	{
		String[] arrayVar = new String[arrayAmount];
		
		return arrayVar;
	}
}
