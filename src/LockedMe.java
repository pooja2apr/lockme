

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class LockedMe {
	static String pathName = ".\\data\\";
	public static void main(String[] args) {
	      System.out.println("Welcome");
		char ch;
		int choice;
		do {
			System.out.println("1.Application name and developer details");
			System.out.println("2.Add a file");
			System.out.println("3.Delete a file");
			System.out.println("4.Search a file");
			System.out.println("5.Exit");
			System.out.println("6.List all the files in current directory in ascending order");
			System.out.println("Enter your choice");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Application name: LockedMe.com");
				System.out.println("Developer Details: Developed by Pooja Verma");
				break;
			// Create a file and writing data to file
			case 2:
				System.out.println("Enter the name of a file");
				sc = new Scanner(System.in);
				String name1 = sc.nextLine();
				String name = name1.toLowerCase();
				try {
					File f = new File(LockedMe.pathName+name);
					// check if file already exist
					boolean exist = f.exists();
					if (!exist) {
						OutputStream fileout = new FileOutputStream(LockedMe.pathName+name);

						System.out.println("Enter the data you want to write to a file");
						String data = sc.nextLine();
						// Convert string into bytes
						byte[] databytes = data.getBytes();
						// write data to output stream.
						fileout.write(databytes);
						System.out.println("Data is written to file");
						// closes the stream
						fileout.close();
					} else {
						System.out.println("File already exist");
					}
				}
				catch (IOException e) {
					System.out.println(e);
				}
				break;
			case 3: // Delete a file
				try {
					System.out.println("Enter the name of a file to be deleted");
					sc = new Scanner(System.in);
					name = sc.nextLine();
					File f = new File(LockedMe.pathName+name);
					if (f.delete()) {
						System.out.println(f.getName() + " file deleted");
					}
					else {
						System.out.println("File not deleted as it doesn't exist.");
					}
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
			case 4:// Search a file

				try {
					System.out.println("Enter the name of a file to be searched");
					sc = new Scanner(System.in);
					name = sc.nextLine();
					FileInputStream f1 = new FileInputStream(LockedMe.pathName+name);
					// read the file
					int i = 0;
					while ((i = f1.read()) != -1) {
						System.out.print((char) i);

					}
					f1.close();
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
			case 5:
				System.out.println("Exiting Program...");
				return;
			case 6:
				File fileDir=new File(LockedMe.pathName);
				List<String> listFile = Arrays.asList(fileDir.list());
		        List<String>sortedList =listFile.stream().sorted().collect(Collectors.toList());
				sortedList.forEach(System.out::println);
				break;
				default:
				System.out.println("You have entered incorrect input");
				
			}
			System.out.println();
			System.out.println("Enter Y for yes or N for no: ");
			ch = sc.next().charAt(0);
		} while ((ch == 'y') || (ch == 'Y'));
	}
}
