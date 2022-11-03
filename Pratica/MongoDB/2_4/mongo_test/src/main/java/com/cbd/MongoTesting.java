package com.cbd;

import static com.mongodb.client.model.Filters.*;

import java.util.Random;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;

import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCommandException;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.MongoDatabase;
public class MongoTesting {

    private static String[] catBreeds = {"Abyssinian","Australian Mist","Balinese","Bengal","Birman","Bombay","British Shorthair","Burmese","Burmilla","Cornish Rex","Devon Rex","Egyptian Mau","Exotic Shorthair","Japanese Bobtail","Korat","Siamese","Singapura","Somali","Sphynx","Siberian Forest","Tonkinese","Turkish Van"};
    private static String[] catNames = {"BatMan","Sebastian","Ginger","Chester","Faneca","Sadie","Zoe","Dusty","Luna"};
    public static void main(String[] args) {
        // to not show logging messages and make the command line unreadeble
        ((LoggerContext) LoggerFactory.getILoggerFactory()).getLogger("org.mongodb.driver").setLevel(Level.ERROR);
        
        // Replace the uri string with your MongoDB deployment's connection string
        String uri = "mongodb://localhost:8765";
        testTimes(uri);
    }

    private static void testTimes(String uri){
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("cbd");
            MongoCollection<Document> collection = database.getCollection("restaurants");

            // Test the time for localidade Query
            long startTime = System.currentTimeMillis();
            FindIterable<Document> docs = collection.find(eq("localidade", "Bronx"));
            long endTime = System.currentTimeMillis();
            System.out.println("Total execution time for find by location query was: " + (endTime - startTime));



            // Test the time for localidade Query
            startTime = System.currentTimeMillis();
            docs = collection.find(eq("gastronomia", "Bakery"));
            endTime = System.currentTimeMillis();
            System.out.println("Total execution time for find by gastronomia query was: " + (endTime - startTime));

            Bson filter = text("Shop");
            // Test time for text Search Index
            startTime = System.currentTimeMillis();
            docs = collection.find(filter);
            endTime = System.currentTimeMillis();
            System.out.println("Total execution time for find by location query was: " + (endTime - startTime));

             for(Document doc : docs) {
                //access documents e.g. doc.get()
                System.out.println(doc.toJson());
            }
        }
    }



    // Function used to test the creation of indexes
    private static void createIndexes(String uri){
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("cbd");
            MongoCollection<Document> collection = database.getCollection("restaurants");

            String resultCreateIndex = collection.createIndex(Indexes.ascending("localidade"));

            System.out.println("Created index " + resultCreateIndex);
            
            resultCreateIndex = collection.createIndex(Indexes.ascending("gastronomia"));
            System.out.println("Created index " + resultCreateIndex);

            // Text Field indexes

            try {
                resultCreateIndex = collection.createIndex(Indexes.text("nome"));
                System.out.println(String.format("Index created: %s", resultCreateIndex));
            } catch (MongoCommandException e) {
                if (e.getErrorCodeName().equals("IndexOptionsConflict"))
                    System.out.println("there's an existing text index with different options");
                else{
                    System.out.println(e);
                }
            }

        }
    }


    // Function used to test find queries
    private static void testingFind(String uri) {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("cbd");
            MongoCollection<Document> collection = database.getCollection("restaurants");



            Bson projectionFields = Projections.fields(
                    Projections.include("restaurant_id", "localidade"),
                    Projections.excludeId());


            FindIterable<Document> docs = collection.find(eq("gastronomia", "Seafood")).projection(projectionFields);
            System.out.println("\n\n");

            int numRecords = 0;

            for(Document doc : docs) {
                //access documents e.g. doc.get()
                System.out.println(doc.toJson());
                numRecords++;
            }
            
            

            System.out.println("\n\n");
            System.out.println(numRecords + "\n\n");

            
        
        }
    }

    // Function used to test Insert queries
    private static void testInsert(String uri,int numCats) {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            
            MongoDatabase database = mongoClient.getDatabase("testJavaCrud");
            MongoCollection<Document> collection = database.getCollection("cats");





            System.out.println("\n\n");

                try {
                    for (int  i=0 ; i<numCats; i++ ) {
                        
                        int rnd = new Random().nextInt(catBreeds.length * 2);
                        String breed = "normal cat";
                        if (rnd < catBreeds.length +1){
                            breed = catBreeds[rnd];
                        }
                        rnd = new Random().nextInt(catNames.length);
                        String name = catNames[rnd]; 
                        rnd = new Random().nextInt(18);

                        InsertOneResult result = collection.insertOne(new Document()
                        .append("_id", new ObjectId())
                        .append("name", name)
                        .append("breed", breed)
                        .append("age", rnd));
                        
                        
                    }

                }
                catch (MongoException me) {
                    System.err.println("Unable to insert due to an error: " + me);
                }
            
            System.out.println("all added");
            System.out.println("\n\n");

            
        
        }
    }

    // Function used to test Update queries
    private static void updateCats(String uri) {
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            
            MongoDatabase database = mongoClient.getDatabase("testJavaCrud");
            MongoCollection<Document> collection = database.getCollection("cats");


            Bson updates = Updates.combine(
                    Updates.set("type", "Very cute litle boy"));
            



            System.out.println("\n\n");

            try {
                UpdateResult result = collection.updateMany(new Document(), updates);
                System.out.println("Modified document count: " + result.getModifiedCount());
            } catch (MongoException me) {
                System.err.println("Unable to update due to an error: " + me);
            }

            
            
            System.out.println("\n\n");

            
        
        }
    }


}