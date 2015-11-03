package edu.ustc.mix.persistence.mongodb;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBClient {
	
	private static final MongoClient mongo = new MongoClient("127.0.0.1", 27017);

	public static void main(String[] args) throws Exception {
		
		MongoDatabase db = mongo.getDatabase("mix");
		
		MongoCollection<Document> collection = db.getCollection("users");
		collection.insertOne(new Document().append("name", "mix7").append("password", 123));
		collection.insertOne(new Document().append("name", "mix8").append("password", 123));
		
		FindIterable<Document> iterable = collection.find(new Document("password", 123));
		for (Document document : iterable) {
			System.out.println(document);
		}
	}
}