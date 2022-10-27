package com.cbd;


import static com.mongodb.client.model.Filters.*;

import java.time.Instant;
import java.time.Year;
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



public class App 
{
    public static void main( String[] args )
    {
        ((LoggerContext) LoggerFactory.getILoggerFactory()).getLogger("org.mongodb.driver").setLevel(Level.ERROR);

        String uri = "mongodb://localhost:8765";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            // querie number 15 from 2_2

            //findAdultCatsCity(mongoClient,"Viseu");


            findCatsWith(mongoClient,"Eye Problems");
            mongoClient.close();
        }
    }


    private static void findAdultCatsCity(MongoClient mongoClient,String city) {
        MongoDatabase database = mongoClient.getDatabase("cbd");
        MongoCollection<Document> collection = database.getCollection("cats");

        int year = Year.now().getValue();


        Bson projectionFields = Projections.fields(
                Projections.include("name", "breed","owner.city","birthYear"),
                Projections.excludeId());
                

        FindIterable<Document> docs = collection.find(and(eq("owner.city", city),lt("birthYear", year-1.5))).projection(projectionFields);
        System.out.println("\n\n");


        for(Document doc : docs) {
            //access documents e.g. doc.get()
            System.out.println(doc.toJson());
        }
        
    }

    private static void findCatsWith(MongoClient mongoClient,String disease) {
        MongoDatabase database = mongoClient.getDatabase("cbd");
        MongoCollection<Document> collection = database.getCollection("cats");



        Bson projectionFields = Projections.fields(
                Projections.include("name","birthYear","diseases.nome"),
                Projections.excludeId());
                

        FindIterable<Document> docs = collection.find(and(eq("diseases.nome", disease))).projection(projectionFields);
        System.out.println("\n\n");


        for(Document doc : docs) {
            //access documents e.g. doc.get()
            System.out.println(doc.toJson());
        }
        
    }

    

}
