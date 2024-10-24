package main;

import java.util.Scanner;

import service.ShowService;
import service.ShowServiceImpl;

public class MainClass {
	
	static ShowService service = new ShowServiceImpl();
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("========================================================================================================================================================================");
		System.out.println("                                                               WELCOME TO CARTOON NETWORK CHANNEL                                                 ");
		System.out.println("========================================================================================================================================================================");
		while (true) {
			System.out.println("Press 1 for add cartoon ===>");
			System.out.println("Press 2 for display cartoons ===>");
			System.out.println("Press 3 for display cartoon by id ===>");
			System.out.println("Press 4 for display cartoon by name ===>");
			System.out.println("Press 5 for change cartoon rating by cartoon name ==>");
			System.out.println("Press 6 for change cartoon rating by cartoon id ===>");
			System.out.println("Press 7 for change cartoon timing by id ===>");
			System.out.println("Press 8 for remove cartoon by id ===>");
			System.out.println("Press 9 for remove cartoon by rating ===>");
			System.out.println("Press 10 for remove cartoon by cartoon name ===>");
			System.out.println("Press 11 for display cartoons by timings ===>");
			System.out.println("Press 12 for change timing by cartoon name ==>");
			switch (scanner.nextInt()) {
			case 1: service.addShow(); break;
			case 2: service.displayCartoons(); break;
			case 3: service.displayCartoonByShowId(); break;
			case 4: service.displayCartoonByShowName(); break;
			case 5: service.changeCartoonRatingByCartoonName(); break;
			case 6: service.changeCartoonRatingByCartoonId(); break;
			case 7: service.changeCartoonTimingByCartoonId(); break;
			case 8: service.removeCartoonById(); break;
			case 9: service.removeCartoonByRating(); break;
			case 10: service.removeCartoonByCartoonName(); break;
			case 11: service.displayCartoonByCartoonTimings(); break;
			case 12: service.changeCartoonTimingByCartoonName(); break;
			default: System.out.println("Invalid option");
			}
			System.out.println("========================================================================================================================================================================");
			System.out.println("Do You Want To Continue [yes/no]");
			String continuation = scanner.next();
			if (continuation.equalsIgnoreCase("yes")) {
				continue;
			}
			else if (continuation.equalsIgnoreCase("no")) {
				System.out.println("Thank you for visiting my channel");
				break;
			}
			else {
				System.out.println("Get lost you choose wrong option bye..");
				break;
			}
		}
		
	}

}
