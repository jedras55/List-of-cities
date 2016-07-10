import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileController {

	private final String FILE_ALL_CITIES_PATH = "./res/allCities.txt"; // Path to file with all cities from http://openweathermap.org/help/city_list.txt
	private final String FILE_COUNTRY_CITIES_PATH = "./res/countryCities.txt"; // Path to new file with result of program
	private String countryCode; // Code of country we want to get in result for example GB for Great Britain
	private ArrayList<String> countryCities;

	public void setCountryCode(String countryCode){
		this.countryCode = countryCode;
		countryCities = new ArrayList<>();
	}

	public FileController(String countryCode){
		setCountryCode(countryCode);
	}
	public ArrayList<String> getAllCities(){
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new FileReader(FILE_ALL_CITIES_PATH));
			String line1 = null;
			while((line1 = reader.readLine()) != null){
				String tmp = reader.readLine();
				if(tmp.substring(tmp.length()-2, tmp.length()).matches(countryCode)){
					// Getting 2 last characters of each line - it's country code.
					// If it's country code, which we wanted, program is saving all line to ArrayList
					countryCities.add(tmp);
				}
			}
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return countryCities;
	}

	public void saveCountryCities(ArrayList<String> countryCities){
		// It's saving our ArrayList to new file
		File fileCountryCitiesList = new File(FILE_COUNTRY_CITIES_PATH);
		try(
				BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_COUNTRY_CITIES_PATH, true));
		) {
			PrintWriter printwriter = new PrintWriter(fileCountryCitiesList);
			printwriter.write(""); // Cleaning file before each saving
			printwriter.close();
			for(String tmp: countryCities){
				writer.write(tmp);
				writer.newLine();
			}
		} catch(IOException e){
			System.err.println("File save error");
		}
	}
}
