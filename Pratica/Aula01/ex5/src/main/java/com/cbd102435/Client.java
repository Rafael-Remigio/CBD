package com.cbd102435;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.text.Style;

import redis.clients.jedis.Jedis;

public class Client {

    Jedis jedis = new Jedis();
    String name;
    HashSet<String> following;

    Client(String name){
        this.name = name;
        following = new HashSet<String>();
        jedis.sadd("users",name);
    }


    public void makePost(String text) {
        jedis.lpush(name+":posts", text);
        System.out.println("Post was created and posted successfuly");
    }

    public void ReadPosts() {
        for (String string : following) {
            List<String> posts = jedis.lrange(string+":posts",0,-1);
            for (String post : posts) {
                System.out.println(string + ") "+post);
            }
        }
    }

    public void listAllUsers(){
        Set<String> membros = jedis.smembers("users");
        for (String iterable_element : membros) {
            System.out.println(iterable_element);
        }
    }

    public void Readmessages(){
        long leng = jedis.llen(name+":Actualmessage");
        while (leng > 0){
            String message = jedis.rpop(name+":Actualmessage");
            String person = jedis.rpop(name+":messageSender");
            System.out.println(person + ") " + message);
            leng -=1;
        }

    }

    public void sendMsg(String user,String Message){
        jedis.lpush(user+":Actualmessage", Message);
        jedis.lpush(user+":messageSender", this.name);
        System.out.println("Message was sent to " + user);
    }

    public void Befriend (String user){
        following.add(user);
        jedis.sadd(name+":following",user);
        System.out.println("Started following " + user);

    }

    public void Unfriend (String user){
        following.remove(user);
        if (jedis.sismember( name+":following", user)){

            jedis.srem(name+":following", user);
            System.out.println("Stoped following " + user);
        }
        else {
            System.out.println("You are not even following "+ user+"\nWhat are u doing?");
        }
    }

    public void peopleIfollow(){
        System.out.println("I follow:");
        for (String string : following) {
            System.out.println(string);
        }
    }
}
