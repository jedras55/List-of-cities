import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileController {

	private final String FILE_ALL_CITIES_PATH = "./res/allCities.txt";
	private final String FILE_COUNTRY_CITIES_PATH = "./res/countryCities.txt";
	private String countryCode;
	private ArrayList<String> countryCities;

	public void setCountryCode(String countryCode){
		this.countryCode = countryCode;
	}
	//private File fileAllcities;
	//private File fileCountryCities;

	public FileController(String countryCode){
		setCountryCode(countryCode);
		countryCities = new ArrayList<String>();
		//fileAllcities = new File(fileAllCitiesPath);
		//fileCountryCities = new File(fileCountryCitiesPath);
	}
	public ArrayList<String> getAllCities(){
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new FileReader(FILE_ALL_CITIES_PATH));
			String line1 = null;
			while((line1 = reader.readLine()) != null){
				String tmp = reader.readLine();
				if(tmp.substring(tmp.length()-2, tmp.length()).matches(countryCode)){
					System.out.println(tmp);
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
		return null;
	}
}
