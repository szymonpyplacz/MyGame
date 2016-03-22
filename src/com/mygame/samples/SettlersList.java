package com.mygame.samples;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Szymon on 2016-03-09.
 */
public class SettlersList {

    List<Settler> Freeones = new LinkedList<Settler>();
    List<Settler> Builders = new LinkedList<Settler>();
    List<Settler> Craftmen = new LinkedList<Settler>();
    public List<Settler> Porter = new LinkedList<Settler>();
    public SettlersList(){}

    SettlersList(int number){
        for (int i=0; i<number; i++)
            Freeones.add(new Settler());
    }

    public void addNewBarrack(){
        for (int i=0; i<20; i++)
            Freeones.add(new Settler());
    }

    public void hireBuilder(){
        Freeones.remove(Freeones.get(Freeones.size()-1));
        Builders.add(new Settler());
    }

    public void hirePoreter(){
        Freeones.remove(Freeones.get(Freeones.size()-1));
        Porter.add(new Settler());
    }

    public void hireCraftman(){
        Freeones.remove(Freeones.get(Freeones.size()-1));
        Craftmen.add(new Settler());
    }

    public int getFreeones(){
        return Freeones.size();
    }
    public int getBuilders(){
        return Builders.size();
    }
    public int getPorters(){
        return Porter.size();
    }
    public int getCraftmen(){
        return Craftmen.size();
    }

    public int getComsunedCorn(){
        return (getBuilders()/2 + getPorters()/2 + getCraftmen());
    }

    public String getAllInfo(){
        return ("Cratfmen: " + getCraftmen() + "<br>Builders:" + getBuilders() + "<br>Porters: " + getPorters() + "<br>Freeones: " + getFreeones() + "<br><br>Total comsumption: " + getComsunedCorn());
    }

}
