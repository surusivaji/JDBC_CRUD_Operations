package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Shows;

public class ShowDaoImpl implements ShowDao	 {
	
	private String url = "jdbc:mysql://localhost:3306/javaexam";
	private String username = "root";
	private String password = "Siva@2805";

	@Override
	public int insertShow(Shows show) {
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String insert = "insert into shows (show_name, show_rating, show_timing) values (?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setString(1, show.getShow_name());
			preparedStatement.setString(2, show.getShow_rating());
			preparedStatement.setString(3, show.getShow_timing());
			int result = preparedStatement.executeUpdate();
			if (result!=0) {
				return result;
			}
			else {
				return 0;
			}
		}
		catch (Exception e) {
			return 0;
		}
	}
	
	@Override
	public List<Shows> selectAllShows() {
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String selectAllShows = "select * from shows";
			PreparedStatement preparedStatement = connection.prepareStatement(selectAllShows);
			ResultSet resultSet = preparedStatement.executeQuery(selectAllShows);
			List<Shows> shows = new ArrayList<Shows>();
			while (resultSet.next()) {
				Shows show = new Shows();
				show.setShow_id(resultSet.getInt(1));
				show.setShow_name(resultSet.getString(2));
				show.setShow_rating(resultSet.getString(3));
				show.setShow_timing(resultSet.getString(4));
				shows.add(show);
			}
			return shows;
		}
		catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public Shows selectShowById(int showId) {
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String selectShowById = "select * from shows where show_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(selectShowById);
			preparedStatement.setInt(1, showId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Shows show = new Shows();
				show.setShow_id(resultSet.getInt(1));
				show.setShow_name(resultSet.getString(2));
				show.setShow_rating(resultSet.getString(3));
				show.setShow_timing(resultSet.getString(4));
				return show;
			}
			else {
				return null;
			}
		}
		catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public Shows selectShowByName(String showName) {
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String selectShowByName = "select * from shows where show_name=?";
			PreparedStatement preparedStatment = connection.prepareStatement(selectShowByName);
			preparedStatment.setString(1, showName);
			ResultSet resultSet = preparedStatment.executeQuery();
			if (resultSet.next()) {
				Shows show = new Shows();
				show.setShow_id(resultSet.getInt(1));
				show.setShow_name(resultSet.getString(2));
				show.setShow_rating(resultSet.getString(3));
				show.setShow_timing(resultSet.getString(4));
				return show;
			}
			else {
				return null;
			}
		}
		catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public int updateCartoonRatingByCartoonName(String showName, String rating) {
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String updateCartoonByCartoonName = "update shows set show_rating=? where show_name=?";
			PreparedStatement preparedStatement = connection.prepareStatement(updateCartoonByCartoonName);
			preparedStatement.setString(1, rating);
			preparedStatement.setString(2, showName);
			int update = preparedStatement.executeUpdate();
			if (update!=0) {
				return update;
			}
			else {
				return 0;
			}
		}
		catch (Exception e) {
			return 0;
		}
	}
	
	@Override
	public int updateCartoonRatingByCartoonId(int showId, String rating) {
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String updateCartoonByCartoonId = "update shows set show_rating=? where show_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(updateCartoonByCartoonId);
			preparedStatement.setString(1, rating);
			preparedStatement.setInt(2, showId);
			int update = preparedStatement.executeUpdate();
			if (update!=0) {
				return update;
			}
			else {
				return 0;
			}
		}
		catch (Exception e) {
			return 0;
		}
	}
	
	@Override
	public int updateCartoonTimingByCartoonId(int showId, String time) {
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String updateCartoonTimingByCartoonId = "update shows set show_timing=? where show_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(updateCartoonTimingByCartoonId);
			preparedStatement.setInt(1, showId);
			preparedStatement.setString(2, time);
			int update = preparedStatement.executeUpdate();
			if (update!=0) {
				return update;
			}
			else {
				return 0;
			}
		}
		catch (Exception e) {
			return 0;
		}
	}
	
	@Override
	public int deleteCartoonById(int showId) {
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String deleteCartoonById = "delete from shows where show_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(deleteCartoonById);
			preparedStatement.setInt(1, showId);
			int delete = preparedStatement.executeUpdate();
			if (delete!=0) {
				return delete;
			}
			else {
				return 0;
			}
		}
		catch (Exception e) {
			return 0;
		}
	}
	
	@Override
	public int deleteCartoonByRating(String rating) {
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String deleteCartoonByRating = "delete from shows where show_rating=?";
			PreparedStatement preparedStatement = connection.prepareStatement(deleteCartoonByRating);
			preparedStatement.setString(1, rating);
			int delete = preparedStatement.executeUpdate();
			if (delete!=0) {
				return delete;
			}
			else {
				return 0;
			}
		}
		catch (Exception e) {
			return 0;
		}
	}
	
	@Override
	public int deleteCartoonByCartoonName(String name) {
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String deleteCartoonByCartoonName = "delete from shows where show_name=?";
			PreparedStatement preparedStatement = connection.prepareStatement(deleteCartoonByCartoonName);
			preparedStatement.setString(1, name);
			int delete = preparedStatement.executeUpdate();
			if (delete!=0) {
				return delete;
			}
			else {
				return 0;
			}
		}
		catch (Exception e) {
			return 0;
		}
	}
	
	@Override
	public Shows selectCartoonByTiming(String timing) {
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String selectCartoonByTiming = "select * from shows where show_timing=?";
			PreparedStatement preparedStatement = connection.prepareStatement(selectCartoonByTiming);
			preparedStatement.setString(1, timing);
			ResultSet query = preparedStatement.executeQuery();
			if (query.next()) {
				Shows shows = new Shows();
				shows.setShow_id(query.getInt(1));
				shows.setShow_name(query.getString(2));
				shows.setShow_rating(query.getString(3));
				shows.setShow_timing(query.getString(4));
				return shows;
			}
			else {
				return null;
			}
		}
		catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public int updateCartoonTimingByCartoonName(String showName, String timing) {
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			String updateCartoonTimingByCartoonName = "update shows set show_timing=? where show_name=?";
			PreparedStatement preparedStatement = connection.prepareStatement(updateCartoonTimingByCartoonName);
			preparedStatement.setString(1, timing);
			preparedStatement.setString(2, showName);
			int update = preparedStatement.executeUpdate();
			if (update!=0) {
				return update;
			}
			else {
				return 0;
			}
		}
		catch (Exception e) {
			return 0;
		}
	}

}
