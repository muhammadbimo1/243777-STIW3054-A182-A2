package Assignment2;

import java.io.*;

public class App {

	public static void main(String[] args) throws IOException, Exception {

		PDFScan namefile  = new PDFScan("A182_draft.pdf");
		String data = namefile.getAllContent();
		Thread mainThread = Thread.currentThread();

		CountCourse count = new CountCourse(data);
		CountDate day = new CountDate(data);
		ListSOC soclist = new ListSOC(data);
		CountSOC soccount = new CountSOC(data);
		ShowSTIW display = new ShowSTIW(data);


		Thread thread1 = new Thread(count, "Thread-1: Calculate the total number of courses"); //total course
		Thread thread2 = new Thread(day, "Thread-2: Calculate the total number of days"); //total course
		Thread thread3 = new Thread(soclist, "Thread-3: List of courses from SOC"); //list of soc
		Thread thread4 = new Thread(soccount, "Thread-4: Calculate the number of courses from SOC"); //list of soc
		Thread thread5 = new Thread(display, "Thread-5: Display the information of STIW3054 (Bil, Code, Course, date and time)"); //list of soc
		thread1.start();
		System.out.println(thread1.getName());
		mainThread.sleep(2000);
		thread2.start();
		System.out.println(thread2.getName());
		mainThread.sleep(2000);
		thread4.start();
		System.out.println(thread4.getName());
		mainThread.sleep(2000);
		thread3.start();
		System.out.println(thread3.getName());
		mainThread.sleep(2000);
		thread5.start();
		System.out.println(thread5.getName());
	}
}