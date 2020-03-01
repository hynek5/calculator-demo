package dk.cngroup.Data;

import java.util.Iterator;
import java.util.LinkedList;

public class Operands {

    private LinkedList<Double> list;
    public Iterator<Double> listItr;

    public Operands() {
        list = new LinkedList<>();
    }

    public void addToList(Double number) {
        list.add(number);
        listItr = list.iterator();
    }
}


