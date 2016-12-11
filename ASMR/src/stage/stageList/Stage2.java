package stage.stageList;

import java.util.*;

import stage.StageObject;
import stage.StageInterface;
import lib.code.CodeConstants;

public class Stage2 extends StageObject implements StageInterface
{
	int arrayAmount = 0;
	
	public Stage2()
	{
		super.setDescription(
				"input�� ���� ���� ��� ���ʴ�� output�� ��������!\n"
				+ "�ڵ带 �����ҷ��� �ڵ带 Ŭ�� �� ��, ��Ŭ���� �ϸ� �˴ϴ�.\n\n"
				+ "*���ο� ��ɾ ������ϴ�.\n"
				+ "Jump [n] - Jump ��ɾ�� ������ [n]�� �������� �̵��մϴ�.\n"
				+ "[n]�� Ŭ���ϰ� ������ Ŭ���ϸ� n�� ���� �ٲ�ϴ�.\n"
		);
		super.setArrayAmount(arrayAmount);
		super.setAvailableCommand
		(
				CodeConstants.CODE_SCANDATA +
				CodeConstants.CODE_PRINTDATA +
				CodeConstants.CODE_JUMP
		);
		super.setAvailablePointer(false);
	}
	
	public List<String> getOutputToInput(List<String> input)
	{
		List<String> output = new ArrayList<String>();
		
		for(int i=0; i<input.size(); i++)
			output.add(input.get(i));
		
		return output;
	}
	
	public List<String> setInput(List<String> input)
	{
		Random randomize = new Random();
		for(int i=0; i<=4; i++)
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
