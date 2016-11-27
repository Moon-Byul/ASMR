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

public class GlitchLib extends TimerTask
{
	/*
	 *  class���� ����� ���� ����
	 */
	ImageIcon[] glitchImage;
	JLabel lblTarget;
	Timer glitchTimer; // Timer�� Thread�� ����ϴ�. Background���� �۾��Ѵ�.
	Timer effectTimer;
	TimerTask effectTask; // Thread�� run �Լ�ó�� Timer�� run�� �����Ѵٰ� �����ϸ� ��. ����ȭ.
	static int count = 0;
	static int effectTime = 0;
	static int effectCount = 0;
	
	public GlitchLib(ImageIcon[] imagesTemp, JLabel lblTemp, int delayTime, int effectTimeTemp, int effectCountTemp)
	{
		glitchImage = imagesTemp;
		lblTarget = lblTemp;
		effectTime = effectTimeTemp;
		effectCount = effectCountTemp;

		glitchTimer = new Timer(true);
		glitchTimer.schedule(this, delayTime, delayTime);
	}
	
	public void run()
	{
		count = 0;
		
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
		Random effectRandom = new Random();
		
		lblTarget.setIcon(glitchImage[effectRandom.nextInt(glitchImage.length-1)+1]);
	}
}
