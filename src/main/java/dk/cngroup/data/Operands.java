package dk.cngroup.data;

import java.util.Iterator;
import java.util.LinkedList;

public class Operands implements Validateable {

    private LinkedList<Double> list;
    private Iterator<Double> listItr;

    public Operands() {
        list = new LinkedList<>();
    }

    public LinkedList<Double> getList() {
        return list;
    }

    public Iterator<Double> getListItr() {
        return listItr;
    }

    public void updateItr() {
        listItr = list.iterator();
    }

    public boolean isValid(String operCandidate) {
        Double operand;
        try {
             operand = Double.parseDouble((operCandidate));
        } catch (NumberFormatException exc) {
            return false;
        }
        list.add(operand);
        return true;
    }

}


