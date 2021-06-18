import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
	
	public static void displayFilenames(File f) {
		//Display file names
		String[] filenames;
		filenames = f.list();
		Arrays.sort(filenames);
		List<String> filenamesList = new ArrayList<>();		
		for(String filename : filenames) {
			File f2 = new File(filename);
			if(f2.isFile()) {
				filenamesList.add(filename);
			}
		}
		System.out.println("");
		System.out.print("Files in the root folder: ");
		System.out.println(filenamesList);
		System.out.println("");
	}
	
	public static void main(String[] args) {
		String currentDir = System.getProperty("user.dir");
		File rootDirectory = new File(currentDir);
		int option = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Application Name: LockedMe.com");
		System.out.println("Developer Name: Koti Reddy Kami Reddy");
		System.out.println("The Below Options are User Interactions Information of the Application");
		
		while(true) {
			System.out.println("");
			System.out.println("1: Display Files");
			System.out.println("2: Operations on Files");
			System.out.println("3: Exit Application");
			System.out.print("select an option from 1-3: ");
			try {
				//Take input option
				String optionStr = sc.next();
				option = Integer.parseInt(optionStr);
			} catch(NumberFormatException e) {
				System.out.println("NumberFormatException: please provide valid option!");
			}
			
			if(option == 1) {
				//display list of files in root directory
				displayFilenames(rootDirectory);
			} else if (option == 2) {
				//create another loop to add/delete/search/navigate back filenames
				int option2 = 0;
				while(true) {
					System.out.println("");
					System.out.println("Operations:");
					System.out.println("1: add file");
					System.out.println("2: delete file");
					System.out.println("3: search file");
					System.out.println("4: return to main menu");
					System.out.print("select an option from 1-4: ");
					try {
						//Take input option
						String optionStr = sc.next();
						option2 = Integer.parseInt(optionStr);
					} catch(NumberFormatException e) {
						System.out.println("NumberFormatException: please provide valid option!");
					}
					
					if (option2 == 1) {
						//add files, user input
						System.out.print("Add new File : ");
						String filename = sc.next();
						try {
							//Set new path
							boolean result;
							File fc = new File(rootDirectory, filename);
							result = fc.createNewFile();
							if(result) {
								System.out.println(filename + " file is added to the directory.");
							}else {
								System.out.println("already this file exists...");
							}
							
						} catch (IOException e) {
							// Auto-generated catch block
							System.out.println("invalid input!");
						}
					}else if (option2 == 2) {
						//delete the file
						System.out.print("enter filename to delete : ");
						String deleteFile = sc.next();
						File fd = new File(rootDirectory, deleteFile);
						boolean result = fd.delete();
						if(result) {
							System.out.println(deleteFile + " file has successfully deleted");
						}else {
							System.out.println("file not found");
						}
					}else if (option2 == 3) {
						//search file
						System.out.print("enter filename to search : ");
						String searchFile = sc.next();
						File fs = new File(rootDirectory, searchFile);
						boolean result = fs.exists();
						if(result) {
							System.out.println(searchFile + " file exists in the directory");
						} else {
							System.out.println(searchFile + " doesnot exist in the directory");
						}
					}else if (option2 == 4) {
						break;
					}
				}
			} else if (option == 3) {
				break; // breaks the loop
			} else {
				System.out.println("example: enter 1 in the command line to execute option 1");
			}			
		}
		
		//close scanner
		if(sc!=null) {
			sc.close();
		}
		
	}
}
