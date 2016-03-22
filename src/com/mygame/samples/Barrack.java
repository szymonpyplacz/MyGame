package com.mygame.samples;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Barrack extends Building {
    public Barrack(SettlersList settlerList) {
        super("Barrack", 3, 3, 3);
        settlerList.addNewBarrack();
    }

    public String getAllInfo() {
        return (name);
    }
}
