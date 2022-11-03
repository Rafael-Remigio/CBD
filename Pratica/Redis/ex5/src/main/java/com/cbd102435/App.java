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

        while (!input.equals("exit")) {
            System.out.println("\nChoose a number");
            System.out.println("1.) Follow a friend.");
            System.out.println("2.) Send a message to another user");
            System.out.println("3.) Read messages");
            System.out.println("4.) Make a post");
            System.out.println("5.) See posts from people you follow");
            System.out.println("6.) See all users ");
            System.out.println("7.) List people I follow");
            System.out.println("8.) Unfollow a friend.");
            System.out.println("9.) Exit");

            input = scn.nextLine();

            switch(input){
                case "1":
                    System.out.print("Who do you want to follow?: ");
                    String newfriend = scn.nextLine();
                    user.Befriend(newfriend);
                    break;
                case "2":
                    System.out.print("Who we texting?: ");
                    String person = scn.nextLine();
                    System.out.print("And what are we texting?: ");
                    String text = scn.nextLine();
                    user.sendMsg(person, text);
                    break;
                case "3":
                    user.Readmessages();
                    break;
                case "4":
                    System.out.print("What are we posting about, what is on your mind?: ");
                    String post = scn.nextLine();
                    user.makePost(post);
                    break;
                case "5":
                    user.ReadPosts();
                    break;
                case "6":
                    user.listAllUsers();
                    break;
                case "7":
                    user.peopleIfollow();   
                    break;
                case "8":
                    System.out.print("Who do you want to unfollow?: ");
                    String lostfriend = scn.nextLine();
                    user.Unfriend(lostfriend);   
                    break;
                case "9":
                    System.out.println("Bye see you tomorrow");
                    input = "exit";
                    break;
                default: 
                    System.out.println("No such option pls try again");
            }
        }
        scn.close();

    }
}
