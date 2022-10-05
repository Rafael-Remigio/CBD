package com.cbd102435;

import java.util.ArrayList;
import java.util.Set;


import redis.clients.jedis.Jedis;

public class Client {

    Jedis jedis = new Jedis();
    String name;
    ArrayList<String> following;

    Client(String name){
        this.name = name;
        following = new ArrayList<String>();
        jedis.sadd("users",name);
    }

    public void listAllUsers(){
        Set<String> membros = jedis.smembers("users");
        for (String iterable_element : membros) {
            System.out.println(iterable_element);
        }
    }

    public void sendMsg(String user,String Message){

    }

    public void Befriend (String user){
        following.add(user);
    }
    public void Unfriend (String user){
        following.remove(user);
    }

}
