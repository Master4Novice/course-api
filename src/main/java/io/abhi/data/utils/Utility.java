package io.abhi.data.utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import io.abhi.data.User;

public class Utility {

	private static Gson gson;

	private static final String URL = "./src/main/resources/data/";
	private static final String EX_JSON = ".json";

	public static void saveOrUpdate(User user){
		String directory = URL+user.getUsername()+EX_JSON;
		gson = new Gson();
		try (FileWriter writer = new FileWriter(directory)) 
		{
			gson.toJson(user, writer);

		} 
		catch (IOException e) {

			e.printStackTrace();

		}
	}

	public static boolean isUserExist(User user){
		String username = user.getUsername()+EX_JSON;
		File directory = new File(URL);

		File[] fList = directory.listFiles();
		for (File file : fList){
			if(username.equalsIgnoreCase(file.getName())){
				return true;
			}

		}
		return false;
	}

	/**This method returns the list of all users.
	 * @return
	 */
	public static List<User> fetch(){
		gson = new Gson();
		File directory = new File(URL);
		User user = null;
		List<User> users = new ArrayList<User>();
		File[] fList = directory.listFiles();
		for (File file : fList){
			try (Reader reader = new FileReader(URL+file.getName())) {

				user = gson.fromJson(reader,User.class);
				users.add(user);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return users;
	}
	
	/**This method delete the provided user.
	 * @param username
	 * @return true if deleted.
	 */
	public static boolean delete(String username){
		String directory = URL+username+EX_JSON;
		File file = new File(directory);
        boolean success = false;
        success = file.delete();
        return success;
	}
}
