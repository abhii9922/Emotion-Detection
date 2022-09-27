package controller;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Process p = Runtime.getRuntime().exec("python E:/project1920/py/duplicate-file-finder-master/duplicatefilefinder.py E:/project1920/py/duplicate-file-finder-master");
	Thread.sleep(1000);
		BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String a = "";
		long startTime = System.currentTimeMillis();
		while ((System.currentTimeMillis()-startTime)<1000 && (a = in.readLine())!=null)
		{
			if(a.equals("duplicate"))
			{
				System.out.println("Duplicate");
				break;
			}
				System.out.println("value is : "+a);
		}
		System.out.println("Exit");
/*		*

ProcessBuilder pb = new ProcessBuilder("python E:/project1920/py/duplicate-file-finder-master/duplicatefilefinder.py E:/project1920/py/duplicate-file-finder-master/a");
Process p = pb.start();
 
BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
int ret = new Integer(in.readLine()).intValue();
System.out.println("value is : "+ret);*/

	}

}
