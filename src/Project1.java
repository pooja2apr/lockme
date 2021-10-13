import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileInputStream;
import java.io.FileInputStream;

public class Project1 {

	public void File(String name) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		System.out.println("Welcome");

		char choice;
		do {
			System.out.println("1.Application name and developer details");
			System.out.println("2.Add a file");
			System.out.println("3.Delete a file");
			System.out.println("4.Search a file");
			System.out.println("5.Exit");
			System.out.println("Enter your choice");
			Scanner sc = new Scanner(System.in);
			int ch =sc.nextInt();

			switch(ch){

			case 1:
				System.out.println("Application name: LockedMe.com");
				System.out.println("Developer Details: Developed by Pooja Verma");
				break;

				//Create a file and writing data to file

			case 2: System.out.println("Enter the name of a file");
			sc = new Scanner(System.in);
			String name =sc.nextLine();
			try {
				File f=new File(name);
				//check if file already exist
				boolean exist = f.exists();
				if(!exist) {
					OutputStream fout=new FileOutputStream(name);

					System.out.println("Enter the data you want to write to a file");
					String  data=sc.nextLine();
					//Convert string into bytes
					byte[]databytes=data.getBytes();

					//write data to output stream.
					fout.write(databytes);

					System.out.println("Data is written to file");

					//closes the stream
					fout.close();
				}
				else {
					System.out.println("File already exist");
				}
			}




			catch(IOException e) {
				System.out.println(e);
			}

			break;
			/*	try {
				System.out.println("Enter the data you want to write to a file");
				sc = new Scanner(System.in);
				String s =sc.next();

				FileOutputStream fout=new FileOutputStream(name);
				//byte buf[]=s.getBytes();

				fout.write();
				fout.close();

				System.out.println("Successfully wrote");

			}
			catch(IOException e) {
				System.out.println(e);
			}*/



			case 3: //Delete a file
				try {

					System.out.println("Enter the name of a file to be deleted");
					sc=new Scanner(System.in);
					name=sc.nextLine();
					File f=new File(name);
					if(f.delete()) {

						System.out.println(f.getName()+" file deleted");

					}

					else {
						System.out.println("Failed");
					}

				}
				catch(Exception e) {
					System.out.println(e);
				}

				break;

			case 4://Search a file

				try {
					System.out.println("Enter the name of a file to be searched");
					sc=new Scanner(System.in);
					name=sc.nextLine();
					FileInputStream f1=new FileInputStream(name);
					//read the file
					int i=0;
					while((i=f1.read())!=-1) {
						System.out.print((char)i);

					}

					f1.close();


				}
				catch(Exception e) {
					System.out.println(e);
				}
				break;

			case 5: 
				System.out.println("Exiting Program...");
				System.exit(0);
				break;

			}
			System.out.println();
			System.out.println("Enter Y for yes or N for no: ");
			choice = sc.next().charAt(0);
		}while((choice == 'y') || (choice == 'Y'));
	}
}


