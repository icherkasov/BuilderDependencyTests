package utils;
import personActions.Person;
import java.util.ArrayList;
import java.util.HashSet;

public class CollectionUtils {
    public ArrayList<Person> merge(ArrayList<Person> first, ArrayList<Person> second) {
        ArrayList<Person> newValues = new ArrayList<Person>();
        for (Person tmpPerson : second)
            if (!first.contains(tmpPerson))
                newValues.add(tmpPerson);
        first.addAll(newValues);
        return new ArrayList<Person>(new HashSet<Person>(first));
    }

    public ArrayList<Person> outerJoin(ArrayList<Person> first, ArrayList<Person> second) {
        ArrayList<Person> toDelete = new ArrayList<Person>();
        for (Person tmpPerson : first)
            if (second.contains(tmpPerson))
                toDelete.add(tmpPerson);
        first.removeAll(toDelete);
        second.removeAll(toDelete);
        first.addAll(second);
        return new ArrayList<Person>(new HashSet<Person>(first));
    }

    public ArrayList<Person> innerJoin(ArrayList<Person> first, ArrayList<Person> second) {
        ArrayList<Person> commonValues = new ArrayList<Person>();
        for (Person tmpPerson : second)
            if (first.contains(tmpPerson))
                commonValues.add(tmpPerson);
        return new ArrayList<Person>(new HashSet<Person>(commonValues));
    }
}
