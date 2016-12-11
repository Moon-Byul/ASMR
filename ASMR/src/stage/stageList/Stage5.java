package stage.stageList;

import java.util.*;

import stage.StageObject;
import stage.StageInterface;
import lib.code.CodeConstants;

public class Stage5 extends StageObject implements StageInterface
{
	int arrayAmount = 4;
	
	public Stage5()
	{
		super.setDescription(
				"input�� ���� ���� 2���� ���ؼ� output�� ����ϼ���!\n"
				+ "ex) 4 6 2 4 -> 10 6\n"
				+ "*���ο� ��ɾ ������ϴ�.\n"
				+ "\n"
				+ "Add [n] - [n]��° �濡 �ִ� ���� Cpu�� ���� ���� ����\n"
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
				CodeConstants.CODE_JUMP
		);
		super.setAvailablePointer(false);
	}
	
	public List<String> getOutputToInput(List<String> input)
	{
		List<String> output = new ArrayList<String>();
		
		output.add(Integer.toString(Integer.parseInt(input.get(0)) + Integer.parseInt(input.get(1))));
		output.add(Integer.toString(Integer.parseInt(input.get(2)) + Integer.parseInt(input.get(3))));
		output.add(Integer.toString(Integer.parseInt(input.get(4)) + Integer.parseInt(input.get(5))));
		
		return output;
	}
	
	public List<String> setInput(List<String> input)
	{
		Random randomize = new Random();
		for(int i=0; i<=5; i++)
		{
			int randTemp;
			randTemp = randomize.nextInt(9)+1;
			
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
