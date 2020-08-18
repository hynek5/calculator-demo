package dk.cngroup.data;

import java.util.Iterator;
import java.util.LinkedList;

import static dk.cngroup.data.Operator.*;

public class Operators  implements  Validateable{

    // public enum Operator {
    //    ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION
    //}

    private LinkedList<Operator> list;
    private Iterator<Operator> listItr;

    public Operators() {
        list = new LinkedList<>();
        listItr = list.iterator();
    }

    public LinkedList<Operator> getList() {
        return list;
    }

    public Iterator<Operator> getListItr() {
        return listItr;
    }


    public void updateIter() {
        listItr = list.iterator();
    }

    public boolean isValid(String operCandidate) {
        switch (operCandidate.toLowerCase()) {
            case "addition": case "add": {
                list.add(ADDITION);
                return true;
            }
            case "subtraction": case "subtract": {
                list.add(SUBTRACTION);
                return true;
            }
            case "multiply": case "multiplication": {
                list.add(MULTIPLICATION);
                return true;
            }
            case "divide": case "division": {
                list.add(DIVISION);
                return true;
            }
            case "apply": {
                return true;
            }
            default:
                return false;
        }
    }
}

