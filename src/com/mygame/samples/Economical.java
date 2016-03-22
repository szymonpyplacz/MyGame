package com.mygame.samples;

public abstract class Economical extends Building {
    private String ware;
    private int production;
    private int stored;
    private int capacity;
    private boolean underProduction = true;
    private boolean underCollecting = true;

    Economical(String name, String wareName, int woodcost, int stonecost, int workhours, int prod, int capacity, SettlersList settler){
        super(name, woodcost, stonecost, workhours);
        this.production = prod;
        this.capacity = capacity;
        this.stored = 0;
        ware = wareName;
        settler.hireCraftman();
    }

    public boolean getDelivery(){return underCollecting;}
    public int returnWorkHours(){return workhours;}
    public void changeProduction(){
        if (this.underProduction == true)
            this.underProduction = false;
        else
            this.underProduction = true;
    }
    public void underCollecting(){
        if (this.underCollecting == true)
            this.underCollecting = false;
        else
            this.underCollecting = true;
    }


    public String getAllInfo(){
        if  (this.workhours == 0){
            if(this.underProduction && this.underCollecting)
                return (name + " " + ware + ": " + stored + "/" + capacity + " || production: " + production );
            else if (this.underProduction && !this.underCollecting)
                return (name + " " + ware + ": " + stored + "/" + capacity + " || production: " + production + " || collecting stopped" );
            else if (!this.underProduction && this.underCollecting)
                return (name + " " + ware + ": " + stored + "/" + capacity + " || production stopped" );
            else
                return (name + " " + ware + ": " + stored + "/" + capacity + " || production and collecting stopped" );
    }
        else
            return(name + " is under building for a " + this.workhours);
    }

    public void product(){
        if(this.workhours == 0 && underProduction == true){
            if (production + stored <= capacity)
                stored = stored + production;
            else
                stored = capacity;
    }
        else if (this.workhours > 0)
            this.workhours--;
    }

    public int returnWorkhours(){
        return this.workhours;
    }

    public int getStored(){
        return stored;
    }

    public String getWare(){
        return ware;
    }

    public void takeFrom(int value){
        this.stored = this.stored-value;
    }

}
