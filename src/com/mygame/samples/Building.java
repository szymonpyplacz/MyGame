package com.mygame.samples;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Szymon on 2016-03-07.
 */

public abstract class  Building {
    public String name;
    public int woodCost;
    public int stoneCost;
    public int workhours;
    public String getAllInfo(){return name;};
    Building(String name, int woodcost, int stonecost, int workhours){
        this.woodCost = woodcost;
        this.stoneCost = stonecost;
        this.workhours = workhours;
        this.name = name;
    }

}
