package com.cbd102435;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "This is Twitter2.0 (not really pls don't sue me)" );
        System.out.println("Let's make an account");

        Scanner scn = new Scanner(System.in);
        System.out.println("Insert your name:");
        String username = scn.nextLine();
        Client user = new Client(username);
        System.out.println("Your user has been created");

        String input = "";

        while (!input.equals("6")) {
            System.out.println("1.) Make a friend.");
            System.out.println("2.) Send a message to another user");
            System.out.println("3.) Read messages");
            System.out.println("4.) Make a post");
            System.out.println("5.) See posts from user");
            System.out.println("6.) See all users ");

            input = scn.nextLine();

            switch 


        }
    }
}
