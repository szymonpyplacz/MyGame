package com.mygame.samples;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Farm extends Economical{
    public Farm(SettlersList settler) {
        super("Farm", "corn", 3, 3, 4, 3, 12, settler);
    }
}
