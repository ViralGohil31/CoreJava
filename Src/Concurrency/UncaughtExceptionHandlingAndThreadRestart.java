package Concurrency;

import java.lang.Thread.UncaughtExceptionHandler;

public class UncaughtExceptionHandlingAndThreadRestart {
	public static void main(String[] args) {
		Thread t = new Thread(new Task());
		t.start();
	}
}


class ExceptionHandling implements UncaughtExceptionHandler{
	public void uncaughtException(Thread t,Throwable w) {
		System.out.println("");
		System.out.printf("Exception "+w.getClass().getName(),w.getMessage());
		new Thread(new Task()).start();
	}
}




class Task implements Runnable{

	@Override
	public void run() {
		Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandling());
		System.out.println(Integer.parseInt("123"));
		System.out.println(Integer.parseInt("456"));
		System.out.println(Integer.parseInt("987"));
		System.out.println(Integer.parseInt("XYZ"));
	}
	
}