import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		FileController controller = new FileController("PL");
		ArrayList<String> allCities = controller.getAllCities();
		controller.saveCountryCities(allCities);
	}

}
