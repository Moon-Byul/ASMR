package stage.stageList;

import java.util.*;

import stage.StageObject;
import stage.StageInterface;
import lib.code.CodeConstants;

public class Stage6 extends StageObject implements StageInterface
{
	int arrayAmount = 6;
	
	public Stage6()
	{
		super.setDescription(
				"input�� ���� ���߿� 0�� �ƴ� ���� ����ϼ���!\n\n"
				+ "*���ο� ��ɾ ������ϴ�.\n"
				+ "ifCpu [o] [n] [l] - Cpu�� ���� [n]��° ���� ���� [o]�� ���ؼ�\n"
				+ "������ ������ [l] �������� �̵��ϰ�, �ƴϸ� ifCpu�� ����\n"
				+ "�������� �̵��մϴ�.\n"
				+ "[o]�� Ŭ���ϸ� �ٲ�ϴ�.\n"
		);
		super.setArrayAmount(arrayAmount);
		super.setAvailableCommand
		(
				CodeConstants.CODE_SCANDATA +
				CodeConstants.CODE_PRINTDATA +
				CodeConstants.CODE_COPYFROM +
				CodeConstants.CODE_COPYTO +
				CodeConstants.CODE_ADD +
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
			if(Integer.parseInt(input.get(i)) != 0)
				output.add(input.get(i));
		}
		
		return output;
	}
	
	public List<String> setInput(List<String> input)
	{
		Random randomize = new Random();
		for(int i=0; i<=7; i++)
		{
			int randTemp;
			randTemp = randomize.nextInt(9)+1;
			
			if(randTemp%4 == 0 && i<6)
				input.add("0");
			else
				input.add(Integer.toString(randTemp));
		}
		
		return input;
	}
	
	public String[] impliedArraySet()
	{
		String[] arrayVar = new String[arrayAmount];
		
		arrayVar[0] = "0";
		
		return arrayVar;
	}
}
