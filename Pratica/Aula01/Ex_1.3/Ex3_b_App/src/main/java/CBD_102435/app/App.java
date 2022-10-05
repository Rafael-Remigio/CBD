package CBD_102435.app;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import redis.clients.jedis.Jedis;

public class App {
public static String USERS_KEY = "users"; // Key set for users' name
    public static void main(String[] args) {    
        Jedis jedis = new Jedis();
        // some users
        String[] users = { "Ana", "Pedro", "Maria", "Luis" };
        // jedis.del(USERS_KEY); // remove if exists to avoid wrong type


        jedis.sadd(USERS_KEY, users);

        ArrayList<String> otherUsers = new ArrayList<String>(Arrays.asList("Linus Torvalds","Andrew Tanenbaum","Richard Stallman"));

        for (String iterable_element : otherUsers) {
            jedis.sadd(USERS_KEY, iterable_element);
        
        }


        HashMap<String,String> mapa = new HashMap<String,String>();

        mapa.put("Erich Gamma","Gang of Four");
        mapa.put("Richard Helm","Gang of Four");
        mapa.put("Ralph Johnson","Gang of Four");
        mapa.put("John Vlissides","Gang of Four");


        System.out.println("User inserted from Array and ArrayList");
        jedis.smembers(USERS_KEY).forEach(System.out::println);

        System.out.println("\nMap inserted using hmset method");
        jedis.hmset("hashmap", mapa);
        jedis.hmget("hashmap","Erich Gamma","Richard Helm","Ralph Johnson","John Vlissides").forEach(System.out::println);

        jedis.close();

        }
}