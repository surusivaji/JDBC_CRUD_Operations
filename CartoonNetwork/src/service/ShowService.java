package service;

public interface ShowService {
	void addShow();
	void displayCartoons();
	void displayCartoonByShowId();
	void displayCartoonByShowName();
	void changeCartoonRatingByCartoonName();
	void changeCartoonRatingByCartoonId();
	void changeCartoonTimingByCartoonId();
	void removeCartoonById();
	void removeCartoonByRating();
	void removeCartoonByCartoonName();
	void displayCartoonByCartoonTimings();
	void changeCartoonTimingByCartoonName();
}
