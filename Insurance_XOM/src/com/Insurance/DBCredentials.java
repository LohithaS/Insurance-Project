package com.Insurance;

import java.net.UnknownHostException;
import java.util.Arrays;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class DBCredentials {

	public static MongoClient connection() throws UnknownHostException {
		ServerAddress mongo = new ServerAddress("localhost", 27017);
		MongoCredential credential = MongoCredential.createCredential("admin",
				"admin", "admin".toCharArray());
		MongoClient client = new MongoClient(mongo, Arrays.asList(credential));
		return client;
	}
public static void main(String args[]) throws UnknownHostException{
	DBCredentials.connection().getDB("dbname");
}
}