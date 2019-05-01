package com.Insurance;
import java.util.List;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.util.JSON;
public class DBConnection{
		boolean result;

		public boolean newData(String name, List<String> type,
				double paidMonths, double age) {

			InsuranceProcess newPolicy = new InsuranceProcess();
			newPolicy.setAge(age);
			newPolicy.setName(name);
			newPolicy.setPaidMonths(paidMonths);
			newPolicy.setType(type);

			try {
				DB db = DBCredentials.connection().getDB("Insurance");
				DBCollection collection = db.getCollection("PolicyData");
				BasicDBObject query = new BasicDBObject();
				query.put("name", newPolicy.getName());
				if (collection.findOne(query) == null) {
					Gson gson = new Gson();
					BasicDBObject obj = (BasicDBObject) JSON.parse(gson.toJson(newPolicy));
					collection.insert(obj);
					result = true;
					return result;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
		}

		public static void main(String args[]) {
			
		}
	}

