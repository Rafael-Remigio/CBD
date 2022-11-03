package com.cbd;

import static com.mongodb.client.model.Filters.*;

import java.time.Instant;
import java.util.Date;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;

import org.bson.Document;
import org.bson.conversions.Bson;
import static com.mongodb.client.model.Sorts.descending;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCommandException;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Projections;
import com.mongodb.client.MongoDatabase;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // to not show logging messages and make the command line unreadeble
        ((LoggerContext) LoggerFactory.getILoggerFactory()).getLogger("org.mongodb.driver").setLevel(Level.ERROR);
    
        // Replace the uri string with your MongoDB deployment's connection string
        String uri = "mongodb://localhost:8765";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            // querie number 15 from 2_2
            findBySecondAvaliationAndDate(mongoClient);
            // querie number 09 from 2_2
            querie09(mongoClient);
            querie14(mongoClient);

            querie11(mongoClient);

            querie18(mongoClient);
            mongoClient.close();
        }
    }


    // Querie number 15 from 2_2
    private static void findBySecondAvaliationAndDate(MongoClient mongoClient) {
            MongoDatabase database = mongoClient.getDatabase("cbd");
            MongoCollection<Document> collection = database.getCollection("restaurants");



            Bson projectionFields = Projections.fields(
                    Projections.include("restaurant_id", "nome","grades.score"),
                    Projections.excludeId());
                    

            Instant instant = Instant.parse("2014-08-11T00:00:00Z");
            Date timestamp = Date.from(instant);
            FindIterable<Document> docs = collection.find(and(eq("grades.1.grade", "A"),eq("grades.1.date", timestamp))).projection(projectionFields);
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

     // Querie number 09 from 2_2
     private static void querie09(MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase("cbd");
        MongoCollection<Document> collection = database.getCollection("restaurants");



        Bson projectionFields = Projections.fields(
                Projections.include("restaurant_id", "nome","gastronomia","address.coord"),
                Projections.excludeId());
                

        FindIterable<Document> docs = collection.find(and(gt("grades.score", 70),ne("gastronomia", "American"),lt("address.coord.0",-65))).projection(projectionFields);
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

         // Querie number 14 from 2_2
    private static void querie14(MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase("cbd");
        MongoCollection<Document> collection = database.getCollection("restaurants");
        
        Bson projectionFields = Projections.fields(
                Projections.include("restaurant_id", "nome","grades"),
                Projections.excludeId());
                
        Instant instant = Instant.parse("2014-08-11T00:00:00Z");
        Date timestamp = Date.from(instant);
        
        FindIterable<Document> docs = collection.find(
            and(
                elemMatch("grades", and(
                    eq("score", 10), 
                    eq("grade", "A"),
                    eq("date",timestamp)))
                
            )).projection(projectionFields);
        
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


         // Querie number 11 from 2_2
    private static void querie11(MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase("cbd");
        MongoCollection<Document> collection = database.getCollection("restaurants");
        
        Bson projectionFields = Projections.fields(
                Projections.include("nome", "localidade","gastronomia"),
                Projections.excludeId());
        
        FindIterable<Document> docs = collection.find(
            and(eq("localidade", "Bronx"),in("gastronomia", "American","Chinese"))).projection(projectionFields);
        
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

    private static void querie18(MongoClient mongoClient) {
        MongoDatabase database = mongoClient.getDatabase("cbd");
        MongoCollection<Document> collection = database.getCollection("restaurants");
        
        Bson projectionFields = Projections.fields(
                Projections.include("nome", "localidade","grades.grade","gastronomia"),
                Projections.excludeId());
                
        
        FindIterable<Document> docs = collection.find(and(ne("gastronomia", "American"),eq("grades.grade", "A"),eq("localidade", "Brooklyn"))).projection(projectionFields).sort(descending("gastronomia"));
        
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
