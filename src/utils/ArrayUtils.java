package utils;

import java.util.Arrays;

import personActions.Person;

public  class ArrayUtils {

    public Person[] outerJoin(Person[] firstPerson, Person[] secondPerson) {
        Person[] tmpResult = new Person[firstPerson.length + secondPerson.length];
        boolean check = true;
        int resultArrayPosition = 0;
        for (Person personInFirstPerson : firstPerson) {
            for (Person personInSecondPerson : secondPerson) {
                if (personInFirstPerson.equals(personInSecondPerson)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                tmpResult[resultArrayPosition] = personInFirstPerson;
                resultArrayPosition++;
            }

            check = true;
        }
        for (Person personInSecondPerson : secondPerson) {
            for (Person personInFirstPerson : firstPerson) {
                if (personInSecondPerson.equals(personInFirstPerson)) {
                    check = false;
                    break;
                }
            }
            if (check) {
                tmpResult[resultArrayPosition] = personInSecondPerson;
                resultArrayPosition++;
            }
            check = true;
        }
        return removeDublicates(Arrays.copyOf(tmpResult, resultArrayPosition));
    }

    public int[] outerJoin(int[] first, int[] second) {
        if (first.length == 0 || second.length == 0)
            return new int[0];
        int[] tmpResult = new int[first.length + second.length];
        boolean check = true;
        int resultArrayPosition = 0;
        for (int personInFirstPerson : first) {
            for (int aSecond : second) {
                if (personInFirstPerson == aSecond) {
                    check = false;
                    break;
                }
            }
            if (check) {
                tmpResult[resultArrayPosition] = personInFirstPerson;
                resultArrayPosition++;
            }
            check = true;
        }
        for (int aSecond : second) {
            for (int aFirst : first) {
                if (aSecond == aFirst) {
                    check = false;
                    break;
                }
            }
            if (check) {
                tmpResult[resultArrayPosition] = aSecond;
                resultArrayPosition++;
            }
            check = true;
        }
        return removeDublicates(Arrays.copyOf(tmpResult, resultArrayPosition));
    }

    public int[] innerJoin(int[] first, int[] second) {
        int[] tmpResult = new int[first.length >= second.length ? first.length : second.length];
        int resultArrayPosition = 0;
        for (int intInFirstArray : first) {
            for (int intInSecondArray : second) {
                if (intInFirstArray == intInSecondArray) {
                    tmpResult[resultArrayPosition] = intInFirstArray;
                    resultArrayPosition++;
                    break;
                }
            }
        }
        return removeDublicates(Arrays.copyOf(tmpResult, resultArrayPosition));
    }

    public Person[] innerJoin(Person[] person1, Person[] person2) {
        Person[] tmpResult = new Person[person1.length >= person2.length ? person1.length : person2.length];
        int resultArrayPosition = 0;
        for (Person personInFirstPersonArray : person1) {
            for (Person personInSecondPersonArray : person2) {
                if (personInFirstPersonArray.equals(personInSecondPersonArray)) {
                    tmpResult[resultArrayPosition] = personInFirstPersonArray;
                    resultArrayPosition++;
                    break;
                }
            }
        }
        return removeDublicates(Arrays.copyOf(tmpResult, resultArrayPosition));
    }

    public int[] merge(int[] first, int[] second) {
        int[] tmpResult = Arrays.copyOf(first, first.length + second.length);
        boolean check = true;
        int resultArrayPosition = first.length;
        for (int intInSecondArray : second) {
            for (int intInFirstArray : first)
                if (intInFirstArray == intInSecondArray) {
                    check = false;
                    break;
                }
            if (check) {
                tmpResult[resultArrayPosition] = intInSecondArray;
                resultArrayPosition++;
            }
            check = true;
        }
        return removeDublicates(Arrays.copyOf(tmpResult, resultArrayPosition));
    }

    public Person[] merge(Person[] person1, Person[] person2) {
        Person[] tmpResult = Arrays.copyOf(person1, person1.length + person2.length);
        boolean check = true;
        int resultArrayPosition = person1.length;
        for (Person personInSecondPersonArray : person2) {

            for (Person personInFirstPersonArray : person1)
                if (personInFirstPersonArray.equals(personInSecondPersonArray)) {
                    check = false;
                    break;
                }
            if (check) {
                tmpResult[resultArrayPosition] = personInSecondPersonArray;
                resultArrayPosition++;
            }
            check = true;
        }
        return removeDublicates(Arrays.copyOf(tmpResult, resultArrayPosition));
    }



    public int[] removeDublicates(int[] first) {
        boolean check = true;
        int resultArrayPosition = 0;
        int[] tmpRes = new int[first.length];
        for (int i = 0; i < first.length; i++) {
            for (int j = i + 1; j < first.length; j++)
                if (first[i] == first[j]) {
                    check = false;
                    break;
                }
            if (check) {
                tmpRes[resultArrayPosition] = first[i];
                resultArrayPosition++;
            }
            //local code review (vtegza): do not do any resets - this is side effect, that could cause serious issues later @ 21.12.14
            check = true;
        }
        int [] result = Arrays.copyOf(tmpRes, resultArrayPosition);
        Arrays.sort(result);
        return result;
    }

    public Person[] removeDublicates(Person[] first) {
        boolean check = true;
        int resultArrayPosition = 0;
        Person[] tmpRes = new Person[first.length];
        for (int i = 0; i < first.length; i++) {
            for (int j = i + 1; j < first.length; j++)
                if (first[i].equals(first[j])) {
                    check = false;
                    break;
                }
            if (check) {
                tmpRes[resultArrayPosition] = first[i];
                resultArrayPosition++;
            }
            //local code review (vtegza): do not do any resets - this is side effect, that could cause serious issues later @ 21.12.14
            check = true;
        }
        return Arrays.copyOf(tmpRes, resultArrayPosition);
    }


}
