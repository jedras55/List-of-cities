import java.util.ArrayList;

public class Main {
	public final static String COUNTRY_CODE = "PL"; // Change this value for country you want to get Cities
	public static void main(String[] args) {
		FileController controller = new FileController(COUNTRY_CODE);
		ArrayList<String> allCities = controller.getAllCities();
		controller.saveCountryCities(allCities);
	}
}
