package com.cbd102435.ex4;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.Style;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.resps.Tuple;
/**
 * Hello world!
 *
 */
public class App_b 
{

    public static void main( String[] args ) throws IOException
    {
        Jedis jedis = new Jedis();

        String line = "";
        String splitBy = ";";  

        //parsing a CSV file into BufferedReader class constructor  
        BufferedReader br = new BufferedReader(new FileReader("../nomes-pt-2021.csv"));  
        while ((line = br.readLine()) != null)   //returns a Boolean value  
        {  
            String[] name = line.split(splitBy);    // use comma as separator 
            double score = Double.parseDouble(name[1]);
            jedis.zadd("names",score,name[0]);
        }  

        br.close();

        String input = "";
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
     
        while (! (input.equals("exit"))){

            System.out.print("Enter name: ");
    
            input = myObj.nextLine();  // Read user input

            if (input.equals("exit")){
                break;
            }

            String searchTerm = input;
            /* 
            byte[] prefixByte = ("[" + searchTerm).getBytes();
            byte[] prefixByteExtended = Arrays.copyOf(prefixByte, prefixByte.length + 1);
            prefixByteExtended[prefixByte.length] = (byte) 0xFF;
            */
            List<Tuple> autofill =  jedis.zrangeByScoreWithScores("names", 1, 100000000);

            for ( int i = autofill.size() -1; i >= 0 ;  i-- ) {
                if (autofill.get(i).getElement().toLowerCase().startsWith(searchTerm.toLowerCase())) {
                    System.out.println(autofill.get(i).getElement() + " -> " + autofill.get(i).getScore());
                }
            }
        }

        myObj.close();


        jedis.close();
    }
}
