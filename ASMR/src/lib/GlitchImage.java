package lib;

import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * �۸�ġ ȿ���� ���� �ִϸ��̼��� �ڵ����� ������ִ� Ŭ����
 * 
 * GlitchLib�� ImageIcon���� �̷���� �迭�� ��� label�� �־��ָ�ȴ�.
 * ImageIcon �迭�� ù��°�� �⺻ �̹����̰� �������� �۸�ġ ȿ���� �� �̹����̴�.
 * delayTime�� �۸�ġ ȿ���� �����̸� �����ϴ� ����.
 * effectTime�� �۸�ġ �ִϸ��̼��� �ð��� �����ϴ� ����.
 * effectCount�� �۸�ġ �ִϸ��̼��� ��� ����Ǵ��� �����ϴ� ����.
 */

public class GlitchImage extends TimerTask
{
	/*
	 *  class���� ����� ���� ����
	 */
	int[] randomize;
	ImageIcon[] glitchImage;
	JLabel lblTarget;
	Timer glitchTimer; // Timer�� Thread�� ����ϴ�. Background���� �۾��Ѵ�.
	Timer effectTimer;
	TimerTask effectTask; // Thread�� run �Լ�ó�� Timer�� run�� �����Ѵٰ� �����ϸ� ��. ����ȭ.
	static int count = 0;
	static int delayTime = 0;
	static int effectTime = 0;
	static int effectCount = 0;
	
	public GlitchImage(ImageIcon[] imagesTemp, JLabel lblTemp, int delayTimeTemp, int effectTimeTemp, int effectCountTemp)
	{
		glitchImage = imagesTemp;
		lblTarget = lblTemp;
		delayTime = delayTimeTemp;
		effectTime = effectTimeTemp;
		effectCount = effectCountTemp;
	}
	
	public void start()
	{
		glitchTimer = new Timer(true);
		glitchTimer.schedule(this, delayTime, delayTime);
	}
	
	public void run()
	{
		count = 0;
		randomize = randomizeArray(glitchImage.length, effectCount);
		
		effectTimer = new Timer(true);
		effectTask = new TimerTask()
		{
			/*
			 * �̷������� Ŭ������ ���� �������� �ʰ� �������̵��� �Ҽ��ִ�.
			 */
			@Override
			public void run()
			{
				if(count < effectCount)
				{
					glitchEffect();
					count++;
				}
				else
				{
					lblTarget.setIcon(glitchImage[0]);
					//Timer�� �����Ѵ�. �ٸ� ����� ������...
					effectTimer.cancel();
				}
			}
		};
		effectTimer.schedule(effectTask, 0, effectTime);
	}
	
	void glitchEffect()
	{
		lblTarget.setIcon(glitchImage[randomize[count]]);
	}
	
	/*
	 * randomizeArray - �ϳ��� Array�� ������ Array�� index number�� length�� ��ŭ �ߺ� ���� �������� return �Ѵ�.
	 */
	int[] randomizeArray(int element, int length)
	{
		int i;
		int swapTemp;
		int randTemp;
		Random randomize = new Random();
		int arrTemp[] = new int[element];
		int arrResult[] = new int[length];
		
		if(element > 1)
		{
			for(i=0; i<element; i++)
			{
				arrTemp[i] = i;
			}
			
			// �迭�� 0��° index�� �����
			for(i=1; i<=element*2; i++)
			{
				randTemp = randomize.nextInt(element-2)+1;
				swapTemp = arrTemp[0];
				arrTemp[0] = arrTemp[randTemp];
				arrTemp[randTemp] = swapTemp;
			}
			
			for(i=0; i<length; i++)
				arrResult[i] = arrTemp[i];
		}
		else
			arrResult[0] = 0;
		return arrResult;
	}
}
