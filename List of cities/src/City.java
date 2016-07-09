public class City {

	private String id;
	private String name;
	private String lat;
	private String lon;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}

	public City(String id, String name, String lat, String lon){
		setId(id);
		setName(name);
		setLat(lat);
		setLon(lon);
	}

}