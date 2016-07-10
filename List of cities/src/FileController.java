import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileController {

	private final String FILE_ALL_CITIES_PATH = "./res/allCities.txt";
	private final String FILE_COUNTRY_CITIES_PATH = "./res/countryCities.txt";
	private String countryCode;
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
		try(
				BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_COUNTRY_CITIES_PATH, true));
		) {
			for(String tmp: countryCities){
				writer.write(tmp);
				writer.newLine();
			}
		} catch(IOException e){
			System.err.println("File save error");
		}
	}
}
