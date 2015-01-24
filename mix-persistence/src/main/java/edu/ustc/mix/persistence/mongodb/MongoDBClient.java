package edu.ustc.mix.persistence.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class MongoDBClient {
	
	public static void main(String[] args) throws Exception {
		
		MongoClient mongo = new MongoClient("192.168.199.199", 27017);
		
		DB db = mongo.getDB("mix");
		
		BasicDBObject user = new BasicDBObject();
		user.put("name", "mix");
		user.put("password", 123);
		
		DBCollection collection = db.getCollection("users");
		collection.insert(user);
		
		BasicDBObject search = new BasicDBObject();
		search.put("password", 123);
		
		DBCursor cursor = collection.find(search);
		
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}
}