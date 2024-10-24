package dao;

import java.util.List;

import model.Shows;

public interface ShowDao {
	int insertShow(Shows show);
	List<Shows> selectAllShows();
	Shows selectShowById(int showId);
	Shows selectShowByName(String showName);
	int updateCartoonRatingByCartoonName(String showName, String rating);
	int updateCartoonRatingByCartoonId(int showId, String rating);
	int updateCartoonTimingByCartoonId(int showId, String time);
	int deleteCartoonById(int showId);
	int deleteCartoonByRating(String rating);
	int deleteCartoonByCartoonName(String name);
	Shows selectCartoonByTiming(String timing);
	int updateCartoonTimingByCartoonName(String showName, String timing);
	
}
