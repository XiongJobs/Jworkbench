import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmailSpider {

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new FileReader("E:\\cesi.html"));
			String line = "";
			while((line=br.readLine()) != null) {
				parse(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void parse(String line) {
		int i=0;
		Pattern p = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");
		Matcher m = p.matcher(line);
		while(m.find()) {
			i++;
			System.out.println(m.group());
		}
		System.out.println(i);
	}

}
