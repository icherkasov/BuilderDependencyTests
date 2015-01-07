import personActions.Person;
import personActions.SortedPerson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.CollectionUtils;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CollectionUtilsTests {
    CollectionUtils collectionUtils;

    ArrayList<Person> first;
    ArrayList<Person> second;

    @Before
    public void setup() {
        collectionUtils = new CollectionUtils();
        first = new ArrayList<Person>();
        second = new ArrayList<Person>();

        first.add(new Person.Builder().name("Ben").secondName("Brown").age(21).build());
        first.add(new Person.Builder().name("Ben").secondName("Brown").age(21).build());
        first.add(new Person.Builder().name("Ben").secondName("Green").age(18).build());
        first.add(new Person.Builder().name("Ava").secondName("Black").age(35).build());
        first.add(new Person.Builder().name("Ben").secondName("Brown").age(7).build());
        first.add(new Person.Builder().name("Ben").secondName("Brown1").age(21).build());

        second.add(new Person.Builder().name("Ben").secondName("Brown1").age(21).build());
        second.add(new Person.Builder().name("Alex").secondName("Green").age(41).build());
        second.add(new Person.Builder().name("Eva").secondName("Green").age(18).build());
        second.add(new Person.Builder().name("Ava").secondName("Black").age(35).build());
        second.add(new Person.Builder().name("Rox").secondName("Yellow").age(7).build());


    }

    @Test
    public void testMerge() throws Exception {
        ArrayList<Person> expectedResult = new ArrayList<Person>();
        expectedResult.add(new Person.Builder().name("Ben").secondName("Brown").age(21).build());
        expectedResult.add(new Person.Builder().name("Ben").secondName("Green").age(18).build());
        expectedResult.add(new Person.Builder().name("Ava").secondName("Black").age(35).build());
        expectedResult.add(new Person.Builder().name("Ben").secondName("Brown").age(7).build());
        expectedResult.add(new Person.Builder().name("Ben").secondName("Brown1").age(21).build());
        expectedResult.add(new Person.Builder().name("Alex").secondName("Green").age(41).build());
        expectedResult.add(new Person.Builder().name("Eva").secondName("Green").age(18).build());
        expectedResult.add(new Person.Builder().name("Rox").secondName("Yellow").age(7).build());
        ArrayList<Person> actualResult = collectionUtils.merge(first, second);
        actualResult.sort(new SortedPerson());
        expectedResult.sort(new SortedPerson());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testInnerJoin() throws Exception {
        ArrayList<Person> expectedResult = new ArrayList<Person>();
        expectedResult.add(new Person.Builder().name("Ava").secondName("Black").age(35).build());
        expectedResult.add(new Person.Builder().name("Ben").secondName("Brown1").age(21).build());
        ArrayList<Person> actualResult = collectionUtils.innerJoin(first, second);
        expectedResult.sort(new SortedPerson());
        actualResult.sort(new SortedPerson());
        assertEquals(expectedResult, actualResult);
    }

   @Test
   public void testOuterJoin() throws Exception{
       ArrayList<Person> expectedResult = new ArrayList<Person>();
       expectedResult.add(new Person.Builder().name("Ben").secondName("Brown").age(21).build());
       expectedResult.add(new Person.Builder().name("Ben").secondName("Green").age(18).build());
       expectedResult.add(new Person.Builder().name("Ben").secondName("Brown").age(7).build());
       expectedResult.add(new Person.Builder().name("Alex").secondName("Green").age(41).build());
       expectedResult.add(new Person.Builder().name("Eva").secondName("Green").age(18).build());
       expectedResult.add(new Person.Builder().name("Rox").secondName("Yellow").age(7).build());
       ArrayList<Person> actualResult = collectionUtils.outerJoin(first, second);
       expectedResult.sort(new SortedPerson());
       actualResult.sort(new SortedPerson());
       assertEquals(expectedResult, actualResult);
   }

    @After
    public void tearDown() {
        first = null;
        second = null;
    }
}
