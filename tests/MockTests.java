import personActions.Person;
import personActions.PersonValidator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import  utils.CollectionUtils;
import utilsWrappers.ResultsHandler;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class MockTests {
    ArrayList<Person> first;
    ArrayList<Person> second;
    PersonValidator validator;
    CollectionUtils utils;

    @Before
    public void setup() {
        first = new ArrayList<Person>();
        second = new ArrayList<Person>();

        validator = mock(PersonValidator.class);

    }

    @After
    public void tearDown() {
        first = null;
        second = null;
    }

    @Test
    public void testMockPositiveValidation() throws Exception {
        ArrayList<Person> expectedResult = new ArrayList<Person>();
        expectedResult.add(new Person.Builder().name("Ben").secondName("Brown1").age(21).build());

        utils = mock(CollectionUtils.class);
        when(utils.merge(first, second)).thenReturn(expectedResult);

        Person personBenBrown = new Person.Builder().name("Ben").secondName("Brown").age(21).build();
        Person personBenGreen = new Person.Builder().name("Ben").secondName("Green").age(18).build();
        Person personAva = new Person.Builder().name("Ava").secondName("Black").age(35).build();
        Person personBenBrownSeven = new Person.Builder().name("Ben").secondName("Brown").age(7).build();
        Person personBenBrown1 = new Person.Builder().name("Ben").secondName("Brown1").age(21).build();
        Person personAlex = new Person.Builder().name("Alex").secondName("Green").age(41).build();
        Person personEva = new Person.Builder().name("Eva").secondName("Green").age(18).build();
        Person personRox = new Person.Builder().name("Rox").secondName("Yellow").age(7).build();

        first.add(personBenBrown);
        first.add(personBenGreen);
        first.add(personAva);
        first.add(personBenBrownSeven);
        first.add(personBenBrown1);

        second.add(personBenBrown1);
        second.add(personAlex);
        second.add(personEva);
        second.add(personAva);
        second.add(personRox);

        // all persons should pass validation
        when(validator.validate(personBenBrown)).thenReturn(true);
        when(validator.validate(personBenGreen)).thenReturn(true);
        when(validator.validate(personAva)).thenReturn(true);
        when(validator.validate(personBenBrownSeven)).thenReturn(true);
        when(validator.validate(personBenBrown1)).thenReturn(true);
        when(validator.validate(personAlex)).thenReturn(true);
        when(validator.validate(personEva)).thenReturn(true);
        when(validator.validate(personRox)).thenReturn(true);

        ResultsHandler delegate = new ResultsHandler(utils, validator);
        ArrayList<Person> actualResult = delegate.mergeCollectionWithPersonValidation(first, second);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMockNegativeValidation() throws Exception {
        Person personBenBrown = new Person.Builder().name("Ben").secondName("Brown").age(21).build();
        Person personBenGreen = new Person.Builder().name("Ben").secondName("Green").age(18).build();
        Person personAva = new Person.Builder().name("Ava").secondName("Black").age(35).build();
        Person personBenBrownSeven = new Person.Builder().name("Ben").secondName("Brown").age(7).build();
        Person personBenBrown1 = new Person.Builder().name("Ben").secondName("Brown1").age(21).build();
        Person personAlex = new Person.Builder().name("Alex").secondName("Green").age(41).build();
        Person personEva = new Person.Builder().name("Eva").secondName("Green").age(18).build();
        Person personRox = new Person.Builder().name("Rox").secondName("Yellow").age(7).build();

        first.add(personBenBrown);
        first.add(personBenGreen);
        first.add(personAva);
        first.add(personBenBrownSeven);
        first.add(personBenBrown1);

        second.add(personBenBrown1);
        second.add(personAlex);
        second.add(personEva);
        second.add(personAva);
        second.add(personRox);

        //correct result for validated persons
        ArrayList<Person> expectedResult = new ArrayList<Person>();
        expectedResult.add(personBenBrown);
        expectedResult.add(personBenGreen);
        expectedResult.add(personAva);
        expectedResult.add(personBenBrownSeven);
        expectedResult.add(personBenBrown1);
        expectedResult.add(personAlex);
        expectedResult.add(personEva);
        expectedResult.add(personRox);

        //one person will fail validation
        when(validator.validate(personBenBrown)).thenReturn(true);
        when(validator.validate(personBenGreen)).thenReturn(true);
        when(validator.validate(personAva)).thenReturn(true);
        when(validator.validate(personBenBrownSeven)).thenReturn(false);
        when(validator.validate(personBenBrown1)).thenReturn(true);
        when(validator.validate(personAlex)).thenReturn(true);
        when(validator.validate(personEva)).thenReturn(true);
        when(validator.validate(personRox)).thenReturn(true);

        //no mock for utils.CollectionUtils cause I wanted to see if merge works fine after validation
        ResultsHandler delegate = new ResultsHandler(new CollectionUtils(), validator);
        ArrayList<Person> actualResult = delegate.mergeCollectionWithPersonValidation(first, second);

        assertNotEquals(expectedResult, actualResult);

    }
}
