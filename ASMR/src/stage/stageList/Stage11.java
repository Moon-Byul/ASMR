package stage.stageList;

import java.util.*;

import stage.StageObject;
import stage.StageInterface;
import lib.code.CodeConstants;

public class Stage11 extends StageObject implements StageInterface
{
	int arrayAmount = 3;
	
	public Stage11()
	{
		super.setDescription(
				"input�� ���� ���� �޾� 0�� �ɶ����� output�� ��������!\n"
				+ "ex) 4 2 -> 4 3 2 1 0 2 1 0\n\n"
				+ "*���ο� ��ɾ ������ϴ�.\n"
				+ "inc [n] - [n]��° ���� ���� 1 ������ŵ�ϴ�.\n"
				+ "dec [n] - [n]��° ���� ���� 1 ���ҽ�ŵ�ϴ�.\n"
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
				CodeConstants.CODE_INC +
				CodeConstants.CODE_DEC +
				CodeConstants.CODE_IFCPU +
				CodeConstants.CODE_JUMP
		);
		super.setAvailablePointer(false);
	}
	
	public List<String> getOutputToInput(List<String> input)
	{
		List<String> output = new ArrayList<String>();
		
		for(int i=0; i<input.size(); i++)
		{
			for(int j=Integer.parseInt(input.get(i)); j>=0; j--)
			{
				output.add(Integer.toString(j));
			}
		}
		
		return output;
	}
	
	public List<String> setInput(List<String> input)
	{
		Random randomize = new Random();
		for(int i=0; i<=1; i++)
		{
			int randTemp;
			randTemp = randomize.nextInt(4)+1;
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
