import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	//target folder where you want to save jar
	private static final String TARGET_FOLDER = "dist/";
	// path of the installed maven
	private static final String MAVEN_RUNNER_PATH = "D:/workplace/tools/apache-maven-3.8.6/bin/mvn.cmd";

	static Map<String, String> controllers = new HashMap<>();


	public static void main (String[] args) throws Exception{

		System.out.println("program started ...........");
		// create target directory
		createTargetFolder();

		// prepare controller map
		populteControllerList();

		//for each controller create a jar
		for (String buildName : controllers.keySet()) {

			// create jar using maven commands
			build(buildName, controllers.get(buildName));

			// copy jar to trageted folder
			File sourceFile= new File("target/"+buildName+".jar");
			copyFile(sourceFile);
		}
		
	}

	// list of controllers
	public static void populteControllerList() {
		//	here the map key will be name of the targeted jar file
		controllers.put("order-service", "OrderController.class");
		controllers.put("product-service", "ProductController.class");
		controllers.put("store-service", "StoreController.class");
	}

	public static void build(String targetBuildName, String controllerName)  throws Exception {

		// list of controllers to be exclued
		String exclusions = getExlcusions(controllerName);

		// prepare maven command
		String command = MAVEN_RUNNER_PATH + " clean install -Dfinal-name=" + targetBuildName + " -Dexttt=" 
				+ exclusions;
		
		System.out.println(command);

		// run maven command
		Runtime rt = Runtime.getRuntime();
		Process pr = rt.exec(command);

		// collect & print maven logs
		StringBuffer output = new StringBuffer();
		BufferedReader reader = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line = "";

		while ((line = reader.readLine()) != null) {
			output.append(line + "\n");
		}
		System.out.println("Command Output: " + output);
	}
	
	public static String getExlcusions(String controllerName) 
	{
		String exclusions = "";
		for (String str : controllers.keySet()) {
			String sss = controllers.get(str);
			
			if(!sss.equalsIgnoreCase(controllerName)) {
				if(exclusions != "") exclusions += ",";
				exclusions += "**/"+sss;
			}
		}
		return exclusions;
	} 
	
	
	private static void copyFile(File sourceFile)
	        throws IOException {
		
		String dest= TARGET_FOLDER+ sourceFile.getName();
	    if (!sourceFile.exists()) {
	        return;
	    }
	    sourceFile.renameTo(new File(dest));
	}
	

	public static void createTargetFolder() {
		File folder = new File(TARGET_FOLDER);
		
		if(folder.exists())
			folder.delete();
		
		folder.mkdir();
	}
}
