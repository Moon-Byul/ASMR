package stage;

import java.lang.reflect.*;
import java.util.*;

/*
 * Stage�� ���� �Լ� ������ ���� Ŭ����.
 * stageNum�� 1�� ������ stage.stageList.Stage1�� load�ϰ� return �� �� �ִ�.
 * 
 * �Ʒ��� ����.
 * 
 * StageLib stageClass = new StageLib(1); <-- �̷��� stage1�� �ҷ��´�.
 *				
 *	int[] a = {50, 30};
 *	a = stageClass.getOutputToInput(a);
 *	System.out.println("desc : " + stageClass.getDescription());
 *	System.out.println("arra : " + stageClass.getArrayAmount());
 *	System.out.println("avcm : " + stageClass.getAvailableCommand());
 *	System.out.println("goti : " + a[0]);
 */

public class StageLib
{
	boolean stageLoaded = false;
	Class<?> stageClass = null;
	Object obj = null;
	Method getDesMethod = null;
	Method getArrMethod = null;
	Method getAvCoMethod = null;
	Method getAvPoMethod = null;
	Method getOutMethod = null;
	Method getSetInputMethod = null;
	Method getImpliedArrayMethod = null;
	
	public StageLib(int stageNum)
	{
		try
		{
			stageClass = Class.forName("stage.stageList.Stage"+stageNum);
			obj = stageClass.newInstance();
			
			getDesMethod = obj.getClass().getMethod("getDescription");
			getArrMethod = obj.getClass().getMethod("getArrayAmount");
			getAvCoMethod = obj.getClass().getMethod("getAvailableCommand");
			getAvPoMethod = obj.getClass().getMethod("getAvailablePointer");
			getOutMethod = obj.getClass().getMethod("getOutputToInput", List.class);
			getSetInputMethod = obj.getClass().getMethod("setInput", List.class);
			getImpliedArrayMethod = obj.getClass().getMethod("impliedArraySet");
			
			System.out.println("Success load stage" + stageNum);
		}
		catch(ClassNotFoundException cnfe)
		{
			System.err.print("** could not found : " + cnfe.getMessage());
		}
		catch(InstantiationException ie)
		{
			System.err.println("** cannot Instantiation : " + ie.getMessage());
		}
		catch(IllegalAccessException iae)
		{
			System.err.println("** cannot access method : " + iae.getMessage());
		}
		catch(NoSuchMethodException nsme)
		{
			System.err.println("** could not found method : " + nsme.getMessage());
		}
	}
	
	public String getDescription() throws Exception
	{
		if(getDesMethod != null)
		{
			try
			{
				return (String) getDesMethod.invoke(obj);
			}
			catch(IllegalAccessException iae)
			{
				System.err.println("** cannot access method : " + iae.getMessage());
			}
			catch(IllegalArgumentException iae)
			{
				System.err.println("** argument error to method : " + iae.getMessage());
			}
			catch(InvocationTargetException ite)
			{
				System.err.println("** invocation target to method : " + ite.getMessage());
			}
		}
		throw new Exception("getDesMethod is null");
	}
	
	public int getArrayAmount() throws Exception
	{
		if(getArrMethod != null)
		{
			try
			{
				return (int) getArrMethod.invoke(obj);
			}
			catch(IllegalAccessException iae)
			{
				System.err.println("** cannot access method : " + iae.getMessage());
			}
			catch(IllegalArgumentException iae)
			{
				System.err.println("** argument error to method : " + iae.getMessage());
			}
			catch(InvocationTargetException ite)
			{
				System.err.println("** invocation target to method : " + ite.getMessage());
			}
		}
		throw new Exception("getArrMethod is null");
	}
	
	public int getAvailableCommand() throws Exception
	{
		if(getAvCoMethod != null)
		{
			try
			{
				return (int) getAvCoMethod.invoke(obj);
			}
			catch(IllegalAccessException iae)
			{
				System.err.println("** cannot access method : " + iae.getMessage());
			}
			catch(IllegalArgumentException iae)
			{
				System.err.println("** argument error to method : " + iae.getMessage());
			}
			catch(InvocationTargetException ite)
			{
				System.err.println("** invocation target to method : " + ite.getMessage());
			}
		}
		throw new Exception("getAvCoMethod is null");
	}
	
	public boolean getAvailablePointer() throws Exception
	{
		if(getAvCoMethod != null)
		{
			try
			{
				return (boolean) getAvPoMethod.invoke(obj);
			}
			catch(IllegalAccessException iae)
			{
				System.err.println("** cannot access method : " + iae.getMessage());
			}
			catch(IllegalArgumentException iae)
			{
				System.err.println("** argument error to method : " + iae.getMessage());
			}
			catch(InvocationTargetException ite)
			{
				System.err.println("** invocation target to method : " + ite.getMessage());
			}
		}
		throw new Exception("getAvPoMethod is null");
	}
	
	public List<String> getOutputToInput(List<String> input) throws Exception
	{
		if(getOutMethod != null)
		{
			try
			{
				return (List<String>) getOutMethod.invoke(obj, input);
			}
			catch(IllegalAccessException iae)
			{
				System.err.println("** cannot access method : " + iae.getMessage());
			}
			catch(IllegalArgumentException iae)
			{
				System.err.println("** argument error to method : " + iae.getMessage());
			}
			catch(InvocationTargetException ite)
			{
				System.err.println("** invocation target to method : " + ite.getMessage());
			}
		}
		throw new Exception("getOutMethod is null");
	}
	
	public List<String> setInput(List<String> input) throws Exception
	{
		if(getSetInputMethod != null)
		{
			try
			{
				return (List<String>) getSetInputMethod.invoke(obj, input);
			}
			catch(IllegalAccessException iae)
			{
				System.err.println("** cannot access method : " + iae.getMessage());
			}
			catch(IllegalArgumentException iae)
			{
				System.err.println("** argument error to method : " + iae.getMessage());
			}
			catch(InvocationTargetException ite)
			{
				System.err.println("** invocation target to method : " + ite.getMessage());
			}
		}
		throw new Exception("getSetInputMethod is null");
	}
	
	public String[] impliedArraySet() throws Exception
	{
		if(getImpliedArrayMethod != null)
		{
			try
			{
				return (String[]) getImpliedArrayMethod.invoke(obj);
			}
			catch(IllegalAccessException iae)
			{
				System.err.println("** cannot access method : " + iae.getMessage());
			}
			catch(IllegalArgumentException iae)
			{
				System.err.println("** argument error to method : " + iae.getMessage());
			}
			catch(InvocationTargetException ite)
			{
				System.err.println("** invocation target to method : " + ite.getMessage());
			}
		}
		throw new Exception("getImpliedArrayMethod is null");
	}
}