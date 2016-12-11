package stage.stageList;

import java.util.*;

import stage.StageObject;
import stage.StageInterface;
import lib.code.CodeConstants;

public class Stage3 extends StageObject implements StageInterface
{
	int arrayAmount = 4;
	
	public Stage3()
	{
		super.setDescription(
				"input�� ���� ���� 2���� ������ �ٲ�� output�� ��������!\n"
				+ "ex) 4 6 2 4 -> 6 4 4 2\n"
				+ "*���ο� ��ɾ ������ϴ�.\n"
				+ "Copyto [n] - Cpu�� ��� �ִ� ���� [n]��° �濡 �����մϴ�.\n"
				+ "CopyFrom [n] - [n]��° �濡 �ִ� ���� Cpu�� �����մϴ�.\n"
				+ "[n]�� Ŭ���ϰ� CPU ���ʿ� ��ġ�� ���� Ŭ���ϸ� \n"
				+ "�ش� ���� ����ŵ�ϴ�.\n"
		);
		super.setArrayAmount(arrayAmount);
		super.setAvailableCommand
		(
				CodeConstants.CODE_SCANDATA +
				CodeConstants.CODE_PRINTDATA +
				CodeConstants.CODE_COPYFROM +
				CodeConstants.CODE_COPYTO +
				CodeConstants.CODE_JUMP
		);
		super.setAvailablePointer(false);
	}
	
	public List<String> getOutputToInput(List<String> input)
	{
		List<String> output = new ArrayList<String>();
		
		output.add(input.get(1));
		output.add(input.get(0));
		output.add(input.get(3));
		output.add(input.get(2));
		output.add(input.get(5));
		output.add(input.get(4));
		
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
