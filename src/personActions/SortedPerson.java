package personActions;

import java.util.Comparator;

public class SortedPerson implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {


        int result = p1.getName().compareTo(p2.getName());
        if (result != 0)
            return result;

        result = p1.getSecondName().compareTo(p2.getSecondName());
        if (result != 0)
            return result;

        result = p1.getAge() - p2.getAge();
        if (result != 0)
            return result / Math.abs(result);
        return 0;

    }
}
