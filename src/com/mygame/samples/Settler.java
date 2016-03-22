package com.mygame.samples;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Settler{
    boolean isFree = true;
    public void setFree(){
        isFree = true;
    }
    public void portering(Economical econom, Warehouse ware){
        if(econom.getStored() > 0 && this.isFree && econom.getDelivery()) {
            if (econom.getStored() < 6) {
                if (econom.getStored() + ware.getStone() + ware.getCorn() + ware.getWood() <= ware.getTotalCapacity()) {
                    if (econom.getWare() == "wood") {
                        ware.setWood(ware.getWood() + econom.getStored());
                    } else if (econom.getWare() == "corn") {
                        ware.setCorn(ware.getCorn() + econom.getStored());
                    } else
                        ware.setStone(ware.getStone() + econom.getStored());
                }
                econom.takeFrom(econom.getStored());
                this.isFree = false;
            }
            else {
                if (econom.getStored() + ware.getStone() + ware.getCorn() + ware.getWood() <= ware.getTotalCapacity()) {
                    if (econom.getWare() == "wood") {
                        ware.setWood(ware.getWood() + 5);
                    } else if (econom.getWare() == "corn") {
                        ware.setCorn(ware.getCorn() + 5);
                    } else
                        ware.setStone(ware.getStone() + 5);
                }
                econom.takeFrom(5);
                this.isFree = false;
            }
        }
    }
}
