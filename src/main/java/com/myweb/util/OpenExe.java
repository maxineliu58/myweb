package com.myweb.util;
public class OpenExe {
	public static boolean openFileOfSys(String realPath) 
	//C:/Program Files/WinRAR/WinRAR.exe
	{
		Runtime rt = Runtime.getRuntime();
		Process p = null;
		try
		{
			p = rt.exec(new String[]{realPath});
			return true;

		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		}
	public static void main(String[] args) 
	//
	{
		Runtime rt = Runtime.getRuntime();
		Process p = null;
		try
		{
			p = rt.exec(new String[]{"C:/Program Files/WinRAR/WinRAR.exe"});

		}catch (Exception e) {
			e.printStackTrace();
		}
		}
	
}