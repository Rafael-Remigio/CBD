package com.cbd;



import static com.mongodb.client.model.Filters.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;

import org.bson.Document;
import org.bson.conversions.Bson;
import static com.mongodb.client.model.Sorts.descending;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Accumulators;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCommandException;
import com.mongodb.MongoException;
import com.mongodb.client.AggregateIterable;
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
    
        String nome = "Steakhouse" ;
        System.out.println("Nome de restaurantes contendo "+ nome + " no nome:");
        for (String string :  getRestWithNameCloserTo(nome)) {
            System.out.println("\t -> " + string);
        }
    }

    public static int countLocalidades(){
        int numRecords = 0;

        String uri = "mongodb://localhost:8765";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            
            MongoDatabase database = mongoClient.getDatabase("cbd");
            MongoCollection<Document> collection = database.getCollection("restaurants");

            AggregateIterable<Document> docs = collection.aggregate(
                Arrays.asList(
                    Aggregates.group("$localidade", Accumulators.sum("count", 1))
                )
            );

            for (Document doc : docs) {
                numRecords++;
            }

        
        }


        return numRecords;

    }

    public static Map<String, Integer> countRestByLocalidade(){
        Map<String,Integer> mapa = new HashMap<>();

        String uri = "mongodb://localhost:8765";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            
            MongoDatabase database = mongoClient.getDatabase("cbd");
            MongoCollection<Document> collection = database.getCollection("restaurants");

            AggregateIterable<Document> docs = collection.aggregate(
                Arrays.asList(
                    Aggregates.group("$localidade", Accumulators.sum("count", 1))
                )
            );

            for (Document doc : docs) {
                mapa.put((String) doc.get("_id"), (Integer) doc.get("count"));
            }

        
        }


        return mapa;
    }



    public static List<String> getRestWithNameCloserTo(String name){
        List <String> searchResult = new ArrayList<>();
        String uri = "mongodb://localhost:8765";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            
            MongoDatabase database = mongoClient.getDatabase("cbd");
            MongoCollection<Document> collection = database.getCollection("restaurants");
            
            Bson filter = Filters.text(name);
            collection.find(filter).forEach(doc -> searchResult.add((String)doc.get("nome")));


        
        }

        return searchResult;
    }

}
