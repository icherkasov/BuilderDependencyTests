package starter;

import personActions.Person;
import utils.ArrayUtils;
import utilsWrappers.ResultsHandler;

import java.util.Arrays;


public class Main {
    public static void main(String[] argc) {

        int[] first = {1, 5, 4, 1, 23, 5, 65, 1, 32, 3, 4, 78};
        int[] second = {3, 5, 24, 54, 1, 2, 34, 45, 32};


        Person[] person1 = new Person[7];
        person1[0] = new Person.Builder().name("Ben").secondName("Brown").age(21).build();
        person1[1] = new Person.Builder().name("Ben").secondName("Brown").age(21).build();
        person1[2] = new Person.Builder().name("Ben").secondName("Green").age(18).build();
        person1[3] = new Person.Builder().name("Ava").secondName("Black").age(35).build();
        person1[4] = new Person.Builder().name("Ben").secondName("Brown").age(7).build();
        person1[5] = new Person.Builder().name("Ben").secondName("Brown1").age(21).build();

        Person[] person2 = new Person[5];
        person2[0] = new Person.Builder().name("Ben").secondName("Brown1").age(21).build();
        person2[1] = new Person.Builder().name("Alex").secondName("Green").age(41).build();
        person2[2] = new Person.Builder().name("Eva").secondName("Green").age(18).build();
        person2[3] = new Person.Builder().name("Ava").secondName("Black").age(35).build();
        person2[4] = new Person.Builder().name("Rox").secondName("Yellow").age(7).build();


        ResultsHandler handler = new ResultsHandler(new ArrayUtils());


        System.out.println("First person: \n" + Arrays.toString(person1) + "\n");
        System.out.println("Second person: \n" + Arrays.toString(person2) + "\n");
        handler.merge(person1, person2);
        handler.innerJoin(person1, person2);
        handler.outerJoin(person1, person2);

        System.out.println("First array: \t\t\t" + Arrays.toString(first));
        System.out.println("Second array: \t\t\t" + Arrays.toString(second) + "\n");
        handler.merge(first, second);
        handler.innerJoin(first, second);
        handler.outerJoin(first, second);

    }
}
