package com.rdec.database;




import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.rdec.config.SecretReader;

import shadow.org.bson.Document;

public class DatabaseConnection {
	static String DB_USERNAME = SecretReader.secretReader("MONGO_DB_USERNAME", "en", "US");
	static String DB_PASSWORD = SecretReader.secretReader("MONGO_DB_PASSWORD", "en", "US");
	static String APP_ID = SecretReader.secretReader("MONGO_APP_ID", "en", "US");
	
	static String connectionString = "mongodb+srv://"+DB_USERNAME+":"+DB_PASSWORD+"@cluster0."+APP_ID+".mongodb.net/?appName=Cluster0";

    static ServerApi serverApi = ServerApi.builder()
             .version(ServerApiVersion.V1)
             .build();

    static MongoClientSettings settings = MongoClientSettings.builder()
             .applyConnectionString(new ConnectionString(connectionString))
             .serverApi(serverApi)
             .build();
	static MongoClient mongoClient = MongoClients.create(settings);
	static MongoDatabase database = mongoClient.getDatabase("secc");
	static MongoCollection<Document> c = database.getCollection("users");
	
	
	public static boolean verifyUser(String email) {
		Document userSearch = new Document("userEmail", email);
		Document userFound = c.find(userSearch).first();
		if(userFound != null) {
			Document updatedUser = new Document("$set", new Document("isVerified", true)); 
			c.findOneAndUpdate(userFound, updatedUser);
			return true;
		}
		return false;
	}
	
	public static Document loginUser(String email) {
		Document userSearch = new Document("userEmail", email);
		Document userFound = c.find(userSearch).first();
		if(userFound != null) {
			return userFound;
		}
		return null;
	}
	
	
	public static boolean insertUserData(String fName, String lName, int phone, String userMail ,String userPwd) {
		try {
			  c.insertOne(new Document("firstName", fName)
						.append("lastName", lName)
						.append("phoneNum", phone)
						.append("userEmail", userMail)
						.append("userPassword", userPwd)
						.append("isVerified", false));
			return true;
		} catch (Exception e) {
			return false;
		}
		 
	}
}

