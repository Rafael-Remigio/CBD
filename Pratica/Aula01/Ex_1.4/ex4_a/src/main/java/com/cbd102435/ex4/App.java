package com.cbd102435.ex4;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


import java.io.IOException;
import java.nio.file.Files;

import redis.clients.jedis.Jedis;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Jedis jedis = new Jedis();

        Path path = Paths.get("../names.txt");
        ArrayList<String> names = (ArrayList<String>) Files.readAllLines(path);

        for (String name : names)
        {
            jedis.zadd("names",0,name);
        }

        String input = "";
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
     
        while (! (input.equals("exit"))){

            System.out.print("Enter name: ");
    
            input = myObj.nextLine();  // Read user input

            if (input.equals("exit")){
                break;
            }

            String searchTerm = input;

            byte[] prefixByte = ("[" + searchTerm).getBytes();
            byte[] prefixByteExtended = Arrays.copyOf(prefixByte, prefixByte.length + 1);
            prefixByteExtended[prefixByte.length] = (byte) 0xFF;
            List<String> autofill = jedis.zrangeByLex("names", "["+searchTerm, new String(prefixByteExtended));

            for (String iterable_element : autofill) {
                System.out.println(iterable_element);
            }
        }

        myObj.close();


        jedis.close();
    }
}
