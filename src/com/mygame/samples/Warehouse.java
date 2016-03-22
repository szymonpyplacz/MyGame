package com.mygame.samples;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Warehouse extends Building {
    private int totalCapacity = 500;
    private int wood;
    private int stone;
    private int corn;
    private boolean hunger;

    public Warehouse(int corn, int stone, int wood) {
        super("Warehouse", 3, 3, 3);
        this.corn = corn;
        this.stone = stone;
        this.wood = wood;
    }

    public Warehouse() {
        super("Warehouse", 3, 3, 3);
        this.corn = 0;
        this.stone = 0;
        this.wood = 0;
    }

    public int getWood() {
        return wood;
    }

    public int getCorn() {
        return corn;
    }

    public int getStone() {
        return stone;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setWood(int value) {
        this.wood = value;
    }

    public void setCorn(int value) {
        this.corn = value;
    }

    public void setStone(int value) {
        this.stone = value;
    }

    public int setTotalCapacity() {
        return totalCapacity;
    }


    public void useWood(int value) {
        this.wood = this.wood - value;
    }

    public void useStone(int value) {
        this.stone = this.stone - value;
    }

    public void useCorn(int value) {
        this.corn = this.corn - value;
        if (this.corn < 0) {
            this.corn = 0;
            this.hunger = true;
        }
    }

    public String getAllInfo() {
        return (name + "<br>wood: " + wood + "<br>stone: " + stone + "<br>corn: " + corn + "<br>total capacity: " + (wood + stone + corn) + "/" + totalCapacity);
    }

    public boolean getHunger(){
        return hunger;
    }

    public boolean endGame(){
        if(corn >= 10 && wood >= 20 && stone >= 15)
            return true;
        else
            return false;
    }
}