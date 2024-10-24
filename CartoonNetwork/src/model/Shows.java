package model;

public class Shows {
	
	private int show_id;
	private String show_name;
	private String show_rating;
	private String show_timing;
	
	public Shows() {
		
	}

	public Shows(int show_id, String show_name, String show_rating, String show_timing) {
		this.show_id = show_id;
		this.show_name = show_name;
		this.show_rating = show_rating;
		this.show_timing = show_timing;
	}

	public int getShow_id() {
		return show_id;
	}

	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}

	public String getShow_name() {
		return show_name;
	}

	public void setShow_name(String show_name) {
		this.show_name = show_name;
	}

	public String getShow_rating() {
		return show_rating;
	}

	public void setShow_rating(String show_rating) {
		this.show_rating = show_rating;
	}

	public String getShow_timing() {
		return show_timing;
	}

	public void setShow_timing(String show_timing) {
		this.show_timing = show_timing;
	}

	@Override
	public String toString() {
		return "Shows [show_id=" + show_id + ", show_name=" + show_name + ", show_rating=" + show_rating
				+ ", show_timing=" + show_timing + "]";
	}	

}
