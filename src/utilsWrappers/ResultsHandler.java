package utilsWrappers;

import personActions.Person;
import personActions.PersonValidator;
import personActions.SortedPerson;
import utils.ArrayUtils;
import utils.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;


public class ResultsHandler {
   private ArrayUtils utils = null;
   private  CollectionUtils collectionUtils;
    PersonValidator validator;

    public  ResultsHandler(ArrayUtils utils) {
        this.utils = utils;

    }

    public ResultsHandler(CollectionUtils collectionUtils, PersonValidator validator){
        this.collectionUtils = collectionUtils;
        this.validator = validator;
    }

    public void innerJoin(Person[] firstPerson, Person[] secondPerson) {
        Person[] innerResult = utils.innerJoin(firstPerson, secondPerson);
        Arrays.sort(innerResult, new SortedPerson());
        System.out.println("Inner join results: \n" + Arrays.toString(innerResult) + "\n");
    }

    public void outerJoin(Person[] firstPerson, Person[] secondPerson) {
        Person[] outerResult = utils.outerJoin(firstPerson, secondPerson);
        Arrays.sort(outerResult, new SortedPerson());
        System.out.println("Outer join results: \n" + Arrays.toString(outerResult) + "\n");
    }

    public void merge(Person[] firstPerson, Person[] secondPerson) {
        Person[] mergeResult = utils.merge(firstPerson, secondPerson);
        Arrays.sort(mergeResult, new SortedPerson());
        System.out.println("Merge results: \n" + Arrays.toString(mergeResult) + "\n");
    }

    public void innerJoin(int[] first, int[] second) {
        int[] innerResult = utils.innerJoin(first, second);
        Arrays.sort(innerResult);
        System.out.println("Inner join results: \n" + Arrays.toString(innerResult) + "\n");
    }

    public void outerJoin(int[] first, int[] second) {
        int[] outerResult = utils.outerJoin(first, second);
        Arrays.sort(outerResult);
        System.out.println("Outer join results: \n" + Arrays.toString(outerResult) + "\n");
    }

    public void merge(int[] first, int[] second) {
        int[] mergeResult = utils.merge(first, second);
        Arrays.sort(mergeResult);
        System.out.println("Merge results: \n" + Arrays.toString(mergeResult) + "\n");
    }

    public ArrayList<Person> mergeCollectionWithPersonValidation(ArrayList<Person> firstPerson, ArrayList<Person> secondPerson) {
        ArrayList<Person> mergeResult;
        ArrayList<Person> notValidatedPersons = new ArrayList<Person>();
        for (Person tmpPerson : firstPerson)
            if(!validator.validate(tmpPerson))
                notValidatedPersons.add(tmpPerson);
        firstPerson.removeAll(notValidatedPersons);
        notValidatedPersons.clear();
        for (Person tmpPerson2 : secondPerson)
            if(!validator.validate(tmpPerson2))
                notValidatedPersons.add(tmpPerson2);
        secondPerson.removeAll(notValidatedPersons);
        notValidatedPersons.clear();
        mergeResult = collectionUtils.merge(firstPerson, secondPerson);
        mergeResult.sort(new SortedPerson());
        System.out.println("Merge results: \n" + mergeResult + "\n");
        return mergeResult;
    }
}
