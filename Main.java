package coursework2;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.PrintWriter;
public class Main {
	static Scanner read = new Scanner(System.in);

	public static void main(String[] args)throws FileNotFoundException {
		// TODO Auto-generated method stub	
		//an object of the main method to reference non-static methods
		Main mainObj = new Main();
		//creating the arraylist at the start of the programme rather than have to make it in each method, using arraylist in case the company 
		//adds more seats or takes away seats
		ArrayList<seatMemory> seatMemoryList = mainObj.seatMemoryArray();

		//console display of teh main menu
		System.out.println("Main Menu \n"
				+"1 - Reserve Seat \n"
				+"2 - Cancel Seat \n"
				+"3 - View Seat Reservations \n"
				+"Q - Quit");

		String menuOpt = read.next();
		menuOpt = menuOpt.toLowerCase();

		while (!(menuOpt.equals("1")||menuOpt.equals("2")||menuOpt.equals("3")||menuOpt.equals("q"))) {
			System.out.println("Invalid Input, please enter a number or letter related to the menu item you wish to use");
			menuOpt = read.next();
		}

		//switch for the main menu since there are four options making an else if statement redundant
		switch(menuOpt) {
		case ("1"):
			mainObj.reserveSeat(seatMemoryList);
		break;
		case ("2"):
			mainObj.cancelSeat(seatMemoryList);
		break;
		case ("3"):
			mainObj.viewSeatReservations(seatMemoryList);
		break;
		case ("q"):
			System.out.print("Exiting System");
		System.exit(0);
		break;
		}


	}

	public void reserveSeat(ArrayList<seatMemory> seatReservations) throws FileNotFoundException {
		//making an arraylist that has the seat numbers of the seats that match to the users search criteria 
		// so the user can only reserve seats that have been returned from their search and not ones that
		//are already reserved. It also makes it possible to display teh number of matches
		ArrayList<String> seatMatch = new ArrayList<String>();

		//flag controlled loop that becomes true if there is a match to the users search criteria, otherwise 
		// the user is asked to enter new search criteria to find a seat
		boolean criteria = false;
		while (!criteria) {

			System.out.println("Would you a 1st class or Standard seat? (1st/STD)");
			String seatClass = read.next();
			seatClass = seatClass.toUpperCase();

			//a while loop for validation to ensure only "Y" or "N" is entered, this is used for variables
			//where the answer is "Y" or "N"
			while (!(seatClass.equals("1ST")||seatClass.equals("STD"))) {
				System.out.println("Invalid Input, please enter either \"1st\" or \"STD\"");
				seatClass = read.next();
				seatClass = seatClass.toUpperCase();
			}

			System.out.println("Do you want a window seat? (Y/N)");
			String seatWindow = read.next();
			seatWindow = seatWindow.toUpperCase();

			//changes the Y/N values to boolean to match the data in the file, more user friendly than making
			//the user type "true" or "false"
			boolean boolWindow = false;
			if (seatWindow.equals("Y")) {
				boolWindow = Boolean.parseBoolean(seatWindow);
				boolWindow = true;
			}else {
				if (seatWindow.equals("N")) {
					boolWindow = Boolean.parseBoolean(seatWindow);
					boolWindow = false;
				}
			}
			while (!(seatWindow.equals("Y")||seatWindow.equals("N"))) {
				System.out.println("Invalid Input, please enter either \"Y\" or \"N\"");
				seatWindow = read.next();
				seatWindow = seatWindow.toUpperCase();

			}


			System.out.println("Do you want a aisle seat? (Y/N)");
			String seatAisle = read.next();
			seatAisle = seatAisle.toUpperCase();

			boolean boolAisle = false;
			if (seatAisle.equals("Y")) {
				boolAisle = Boolean.parseBoolean(seatAisle);
				boolAisle = true;
			}else {
				if (seatAisle.equals("N")) {
					boolAisle = Boolean.parseBoolean(seatAisle);
					boolAisle = false;
				}
			}

			while (!(seatAisle.equals("Y")||seatAisle.equals("N"))) {
				System.out.println("Invalid Input, please enter either \"Y\" or \"N\"");
				seatAisle = read.next();
				seatAisle = seatAisle.toUpperCase();
			}

			System.out.println("With a Table (Y/N)");
			String seatTable = read.next();
			seatTable = seatTable.toUpperCase();

			boolean boolTable = false;
			if (seatTable.equals("Y")) {
				boolTable = Boolean.parseBoolean(seatTable);
				boolTable = true;
			}else {
				if (seatTable.equals("N")) {
					boolTable = Boolean.parseBoolean(seatTable);
					boolTable = false;
				}
			}

			while (!(seatTable.equals("Y")||seatTable.equals("N"))) {
				System.out.println("Invalid Input, please enter either \"Y\" or \"N\"");
				seatTable = read.next();
				seatTable = seatTable.toUpperCase();
			}

			System.out.print("Please enter your max Price \n"
					+ "£");
			double maxPrice = 0;
			//flag controlled loop for validation to ensure that only a double can be entered for the maxPrice variable
			boolean flag = false;
			while(!flag) {
				try {
					maxPrice = read.nextDouble();
					flag = true;
				}

				catch(InputMismatchException e) {
					System.out.println("The data entered was incorrect or not formatted correctly\n");
					read.nextLine();
				}
			}
			System.out.println("YOUR CRITERIA");
			System.out.println("Seat Class: " +seatClass);
			System.out.println("By Window: " +seatWindow);
			System.out.println("By Aisle: " +seatAisle);
			System.out.println("With Table: " +seatTable);
			System.out.printf("Max Price £%.2f \n\n",maxPrice);

			for (int i = 0;i<seatReservations.size();i++) {

				if (seatReservations.get(i).seatClass.equals(seatClass)
						&& seatReservations.get(i).isWindow==(boolWindow)
						&& seatReservations.get(i).isAisle==(boolAisle)
						&& seatReservations.get(i).isTable==(boolTable)
						&& seatReservations.get(i).seatPrice<=(maxPrice) 
						&& seatReservations.get(i).eMail.equals("free"))

				{

					System.out.println("Match Found");
					System.out.println("Seat Num: " +seatReservations.get(i).seatNum);
					System.out.println("Seat Class: " +seatReservations.get(i).seatClass);
					if (boolWindow==true) {
						System.out.println("Window Seat");
					}
					if (boolAisle==true) {
						System.out.println("Aisle Seat");
					}
					if (boolTable==true) {
						System.out.println("With Table");
					}

					System.out.println("Seat Price: £" +seatReservations.get(i).seatPrice +"\n");

					seatMatch.add(seatReservations.get(i).seatNum);
					criteria = true;
				}
			} if (criteria == false ) {
				System.out.print("No Match Found\n");
				System.out.printf("Please enter new search criteria\n\n");

			}
		}
		//size of the array indicates how many matches there are
		System.out.print(seatMatch.size());
		System.out.println(" Matches Found");
		System.out.println(seatMatch);

		System.out.println("Would you like to reserve a seat(Y/N)");		
	
		String yesOrNo	= read.next();
		yesOrNo = yesOrNo.toUpperCase();

		while (!(yesOrNo.equals("Y")||yesOrNo.equals("N"))) {
			System.out.print("Invalid Input, please enter either \"Y\" or \"N\"");
			yesOrNo	= read.next();
			yesOrNo = yesOrNo.toUpperCase();
		}
		if (yesOrNo.equals("N")) {
			main(null);
		} 
		//flag controlled loop that loops if the seat number the user enters isn't one in the 
		//seatMatch arraylist, this mean the user can only reserve seats returned to them 
		//from their searches and not ones that are already reserved
		String cusSeatNum = "";
		boolean match = false;
		while(!match) {
			System.out.println("Please specify the seat number");
			cusSeatNum = read.next();
			cusSeatNum = cusSeatNum.toUpperCase();


			for (int i = 0; i<seatMatch.size(); i++) {
				if (cusSeatNum.equals(seatMatch.get(i))) {
					match = true;
					break;
				} else {
					if(i==seatMatch.size()-1) { 
						System.out.println("Please choose a seat provided by your search criteria");
					}
				}

			}
		}

		System.out.println("Please enter your email to make the reservation");
		String cusEmail = "";
		boolean customerEmailValidation = false;
		while (!customerEmailValidation) {
			cusEmail = read.next();
			cusEmail = cusEmail.toLowerCase();
			String emailValidation = ".*[@].*";
		if (cusEmail.matches(emailValidation)) {
			customerEmailValidation = true;
		} else {
			customerEmailValidation=false;
			System.out.println("Email is in invalid format, please re-enter your email");
		}
		}
		
		//a for loop to write to the file, if the seat number matches the one entered , matches the ones
		//entered by the user then the email field is replaced with the email entered by the user, otherwise
		//the data is just printed out. Each seat must be re-printed as printWriter deletes the pre-existing text
		//in a file
		String fileName2 = "seats.txt";
		PrintWriter write = new PrintWriter(fileName2);
		for (int i = 0; i<seatReservations.size(); i++) {
			String tempSeatNum = seatReservations.get(i).seatNum;
			String tempSeatClass = seatReservations.get(i).seatClass;
			boolean tempIsWindow = seatReservations.get(i).isWindow;
			boolean tempIsAisle = seatReservations.get(i).isAisle;
			boolean tempIsTable = seatReservations.get(i).isTable;
			double tempSeatPrice = seatReservations.get(i).seatPrice;
			String tempEMail = seatReservations.get(i).eMail;

			if(seatReservations.get(i).seatNum.equals(cusSeatNum)) {
				write.printf("%s %s %b %b %b %.2f %s \n", tempSeatNum, tempSeatClass, tempIsWindow, tempIsAisle, tempIsTable, tempSeatPrice, cusEmail);
			} else {

				write.printf("%s %s %b %b %b %.2f %s \n", tempSeatNum, tempSeatClass, tempIsWindow, tempIsAisle, tempIsTable, tempSeatPrice, tempEMail);
			}
		}
		write.close();

		System.out.println("Enter \"R\" to return to main menu");
		String returnToMenu = read.next();
		returnToMenu= returnToMenu.toUpperCase();

		while (!(returnToMenu.equals("R"))) {
			System.out.print("Press \"R\" to return to the main menu");
			returnToMenu = read.next();
			returnToMenu= returnToMenu.toUpperCase();
		}
		//creates a repeating main menu by allowing the user to go back to the main menu
		if (returnToMenu.equals("R")) {
			main(null);
		}
	}

	public void cancelSeat(ArrayList<seatMemory> seatReservations) throws FileNotFoundException {
		//flag controlled loop that prints out the reserved seat information associated with the email entered
		String reservationEmail = "";	

		boolean confirmSeat = false;
		while (!confirmSeat) {
			System.out.println("Please enter your email you used to reserve your seat or enter \"R\" to return to the main menu");
			reservationEmail = read.next();
			reservationEmail = reservationEmail.toLowerCase();
			if (reservationEmail.equals("r")) {
				main(null);
			}
			String seatConfirm ="";
			for (int i = 0;i<seatReservations.size();i++) {
				if (seatReservations.get(i).eMail.equals(reservationEmail))
				{
					System.out.println("Seat Num: " +seatReservations.get(i).seatNum);
					System.out.println("Seat Class: " +seatReservations.get(i).seatClass);
					if (seatReservations.get(i).isWindow==(true)){
						System.out.println("Window Seat");
					}
					if (seatReservations.get(i).isAisle==(true)) {
						System.out.println("Aisle Seat");
					}
					if (seatReservations.get(i).isTable==(true)) {
						System.out.println("With Table");
					}

					System.out.println("Seat Price: £" +seatReservations.get(i).seatPrice +"\n");

					System.out.println("Is this your seat? (Y/N)");
					seatConfirm = read.next();
					seatConfirm = seatConfirm.toUpperCase();
					while (!(seatConfirm.equals("Y")||seatConfirm.equals("N"))) {
						System.out.print("Invalid Input, please enter either \"Y\" or \"N\"");
						seatConfirm = read.next();
						seatConfirm = seatConfirm.toUpperCase();
					}
				}
			} if (seatConfirm.equals("Y")) {
				confirmSeat = true;
			} else {
				confirmSeat = false;
			}
		}
		System.out.println("Are you sure you want to cancel your seat?(Y/N)");
		String cancelConfirm = read.next();
		cancelConfirm = cancelConfirm.toUpperCase();

		while (!(cancelConfirm.equals("Y")||cancelConfirm.equals("N"))) {
			System.out.print("Invalid Input, please enter either \"Y\" or \"N\"");
			cancelConfirm = read.next();
			cancelConfirm = cancelConfirm.toUpperCase();
		}
		if (cancelConfirm.equals("N")) {
			main(null);
		}
		String fileName = "seats.txt";
		PrintWriter write = new PrintWriter(fileName);

		//for loop that searches for the seat that is being cancelled and replaces the user email with "free" to indicate it's unreserved
		for (int i = 0; i<seatReservations.size(); i++) {
			String tempSeatNum = seatReservations.get(i).seatNum;
			String tempSeatClass = seatReservations.get(i).seatClass;
			boolean tempIsWindow = seatReservations.get(i).isWindow;
			boolean tempIsAisle = seatReservations.get(i).isAisle;
			boolean tempIsTable = seatReservations.get(i).isTable;
			double tempSeatPrice = seatReservations.get(i).seatPrice;
			String tempEMail = seatReservations.get(i).eMail;

			if(seatReservations.get(i).eMail.equals(reservationEmail)) {
				write.printf("%s %s %b %b %b %.2f free \n", tempSeatNum, tempSeatClass, tempIsWindow, tempIsAisle, tempIsTable, tempSeatPrice);
			} else {

				write.printf("%s %s %b %b %b %.2f %s \n", tempSeatNum, tempSeatClass, tempIsWindow, tempIsAisle, tempIsTable, tempSeatPrice, tempEMail);
			}
		}
		write.close();
		System.out.println("Reservation canceled\n");
		main(null);
	}

	public void viewSeatReservations(ArrayList<seatMemory> seatReservations) throws FileNotFoundException{
		//arraylist to show many seats are reserved and therefore are unavailable
		ArrayList<String> seatCancel = new ArrayList<String>();

//for loop that displays the seats with email fields that arent "free"
		for (int i = 0; i<seatReservations.size();i++) {
			if (!seatReservations.get(i).eMail.equals("free")) {

			}else {
				System.out.println("Seat Num: " +seatReservations.get(i).seatNum);
				System.out.println("Seat Class: " +seatReservations.get(i).seatClass);
				if (seatReservations.get(i).isWindow==true) {
					System.out.println("Window Seat");
				}
				if (seatReservations.get(i).isAisle==true) {
					System.out.println("Aisle Seat");
				}
				if (seatReservations.get(i).isTable==true) {
					System.out.println("With Table");
				}

				System.out.println("Seat Price: £" +seatReservations.get(i).seatPrice +"\n");

				seatCancel.add(seatReservations.get(i).seatNum);
			}

		}
		System.out.println(seatCancel.size() +" seat(s) have not been reserved");

		System.out.println("Enter \"R\" to return to main menu");
		String returnToMenu = read.next();
		returnToMenu= returnToMenu.toUpperCase();

		while (!(returnToMenu.equals("R"))) {
			System.out.print("Press \"R\" to return to the main menu");
			returnToMenu = read.next();
			returnToMenu= returnToMenu.toUpperCase();
		}
		if (returnToMenu.equals("R")) {
			main(null);
		}
	}

	public ArrayList<seatMemory> seatMemoryArray() throws FileNotFoundException {
		//this method creates an arraylist, creates an instance of the seatMemory class,
		//reads from the "seats.txt" file to assign values to each variable of the object 
		// and then adds each object created to the arraylist
		String fileName = "seats.txt";
		FileReader file = new  FileReader(fileName);
		Scanner read = new Scanner(file);


		ArrayList<seatMemory> seatReservations = new ArrayList<seatMemory>();

		while (read.hasNext()) {
			seatMemory object = new seatMemory();
			object.seatNum = read.next();
			object.seatClass = read.next();
			object.isWindow = read.nextBoolean();
			object.isAisle = read.nextBoolean();
			object.isTable = read.nextBoolean();
			object.seatPrice = read.nextDouble();
			object.eMail = read.next();
			seatReservations.add(object);
		}

		read.close();
		return seatReservations;

	}
}
