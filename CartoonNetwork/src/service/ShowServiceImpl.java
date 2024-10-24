package service;

import java.util.List;
import java.util.Scanner;

import dao.ShowDao;
import dao.ShowDaoImpl;
import model.Shows;

public class ShowServiceImpl implements ShowService {
	
	Scanner scanner = new Scanner(System.in);
	
	ShowDao showDao = new ShowDaoImpl();

	@Override
	public void addShow() {
		Shows shows = new Shows();
		System.out.print("Enter The Show Name -->");
		shows.setShow_name(scanner.next());
		System.out.print("Enter The Show Rating -->");
		shows.setShow_rating(scanner.next());
		System.out.print("Enter The Show Timing -->");
		shows.setShow_timing(scanner.next());
		int insertShow = showDao.insertShow(shows);
		if (insertShow!=0) {
			System.out.println("%%% Show Added Successfully %%%");
		}
		else {
			System.out.println("*** Something Went Wrong On the Server ***");
		}
	}
	
	@Override
	public void displayCartoons() {
		List<Shows> shows = showDao.selectAllShows();
		if (shows!=null) {
			for (Shows show : shows) {
				System.out.println("Show ID: "+show.getShow_id());
				System.out.println("Show Name: "+show.getShow_name());
				System.out.println("Show Rating: "+show.getShow_rating());
				System.out.println("Show Timing: "+show.getShow_timing());
				System.out.println("--------------------------------------------------");
			}
		}
		else {
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("================= Somethihg Went Wrong ===============");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		}
	}
	
	@Override
	public void displayCartoonByShowId() {
		System.out.print("Enter The Show ID -->");
		int showId = scanner.nextInt();
		Shows show = showDao.selectShowById(showId);
		if (show!=null) {
			System.out.println("Show Id: "+show.getShow_id());
			System.out.println("Show Name: "+show.getShow_name());
			System.out.println("Show Rating: "+show.getShow_rating());
			System.out.println("Show Timing: "+show.getShow_timing());
		}
		else {
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("=================== SHOW NOT FOUND ===================");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		}
	}
	
	@Override
	public void displayCartoonByShowName() {
		System.out.print("Enter The Show Name -->");
		String showName = scanner.next();
		Shows show = showDao.selectShowByName(showName);
		if (show!=null) {
			System.out.println("Show Id: "+show.getShow_id());
			System.out.println("Show Name: "+show.getShow_name());
			System.out.println("Show Rating: "+show.getShow_rating());
			System.out.println("Show Timing: "+show.getShow_timing());
		}
		else {
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("=================== SHOW NOT FOUND ===================");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		}	
	}
	
	@Override
	public void changeCartoonRatingByCartoonName() {
		System.out.print("Enter The Cartoon Name -->");
		String showName = scanner.next();
		Shows show = showDao.selectShowByName(showName);
		if (show!=null) {
			System.out.print("Enter The Updated Cartoon Rating -->");
			String rating = scanner.next();
			int result = showDao.updateCartoonRatingByCartoonName(showName, rating);
			if (result!=0) {
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
				System.out.println("========== CARTOON RATING UPDATED SUCCESSFULLY =======");
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
				
			}
			else {
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println("================= SOMETHING WENT WRONG ===============");
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			}
		}
		else {
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("=================== SHOW NOT FOUND ===================");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		}	
	}
	
	@Override
	public void changeCartoonRatingByCartoonId() {
		System.out.print("Enter The Cartoon Id -->");
		int showId = scanner.nextInt();
		Shows show = showDao.selectShowById(showId);
		if (show!=null) {
			System.out.print("Enter The Cartoon Rating -->");
			String rating = scanner.next();
			int result = showDao.updateCartoonRatingByCartoonId(showId, rating);
			if (result!=0) {
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
				System.out.println("========== CARTOON RATING UPDATED SUCCESSFULLY =======");
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
				
			}
			else {
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println("================= SOMETHING WENT WRONG ===============");
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			}
		}
		else {
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("=================== SHOW NOT FOUND ===================");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		}	
	}
	
	@Override
	public void changeCartoonTimingByCartoonId() {
		System.out.print("Enter The Cartoon Id -->");
		int showId = scanner.nextInt();
		Shows show = showDao.selectShowById(showId);
		if (show!=null) {
			System.out.print("Enter The Cartoon Timing -->");
			String time = scanner.next();
			int result = showDao.updateCartoonTimingByCartoonId(showId, time);
			if (result!=0) {
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
				System.out.println("========== CARTOON TIMING UPDATED SUCCESSFULLY =======");
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
				
			}
			else {
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println("================= SOMETHING WENT WRONG ===============");
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			}
		}
		else {
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("=================== SHOW NOT FOUND ===================");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		}
	}
	
	@Override
	public void removeCartoonById() {
		System.out.print("Enter The Cartoon Id -->");
		int showId = scanner.nextInt();
		int delete = showDao.deleteCartoonById(showId);
		if (delete!=0) {
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println("============== CARTOON REMOVED SUCCESSFULLY ==========");
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		}
		else {
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("=================== SHOW NOT FOUND ===================");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		}
	}
	
	@Override
	public void removeCartoonByRating() {
		System.out.print("Enter The Cartoon Rating -->");
		String rating = scanner.next();
		int delete = showDao.deleteCartoonByRating(rating);
		if (delete!=0) {
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println("============== CARTOON REMOVED SUCCESSFULLY ==========");
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		}
		else {
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("=================== SHOW NOT FOUND ===================");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		}
	}
	
	@Override
	public void removeCartoonByCartoonName() {
		System.out.print("Enter The Cartoon Name -->");
		String name = scanner.next();
		int delete = showDao.deleteCartoonByCartoonName(name);
		if (delete!=0) {
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println("============== CARTOON REMOVED SUCCESSFULLY ==========");
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		}
		else {
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("=================== SHOW NOT FOUND ===================");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		}
	}
	
	@Override
	public void displayCartoonByCartoonTimings() {
		System.out.print("Enter The Cartoon Timing -->");
		String timing = scanner.next();
		Shows show = showDao.selectCartoonByTiming(timing);
		if (show!=null) {
			System.out.println("Show Id: "+show.getShow_id());
			System.out.println("Show Name: "+show.getShow_name());
			System.out.println("Show Rating: "+show.getShow_rating());
			System.out.println("Show Timing: "+show.getShow_timing());
		}
		else {
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("=================== SHOW NOT FOUND ===================");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		}
	}
	
	@Override
	public void changeCartoonTimingByCartoonName() {
		System.out.print("Enter The Cartoon Name -->");
		String showName = scanner.next();
		Shows show = showDao.selectShowByName(showName);
		if (show!=null) {
			System.out.print("Enter Updated Cartoon Timing -->");
			String timing = scanner.next();
			int update = showDao.updateCartoonTimingByCartoonName(showName, timing);
			if (update!=0) {
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
				System.out.println("========== CARTOON RATING UPDATED SUCCESSFULLY =======");
				System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
				
			}
			else {
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println("================= SOMETHING WENT WRONG ===============");
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			}
		}
		else {
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("=================== SHOW NOT FOUND ===================");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		}
	}

}
