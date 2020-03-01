package dk.cngroup.Data;

import dk.cngroup.exception.OperatorException;

import java.util.Iterator;
import java.util.LinkedList;

public class Operators {

     public enum Operator {
        ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION, NONE
    }

    private LinkedList<Operator> list;
    public Iterator<Operator> listItr;

    public Operators() {
        list = new LinkedList<>();
        listItr = list.iterator();
    }

    public void addToList(String oper) throws Exception {
       switch (oper.toLowerCase()) {
           case "addition":case "add": {
               list.add(Operator.ADDITION);
               break;
           }
           case "subtraction": case "subtract": {
               list.add(Operator.SUBTRACTION);
               break;
           }
           case "multiply": case "multiplication": {
               list.add(Operator.MULTIPLICATION);
               break;
           }
           case "divide": case "division": {
               list.add(Operator.DIVISION);
               break;
           }
           default:
               throw new OperatorException("ERROR: Operator  " + oper + " unknown.");
       }
       listItr = list.iterator();
    }

    public Operator getNextOperator() {
        if (listItr.hasNext()) {
            return listItr.next();
        }
        return Operator.NONE;
    }
}
