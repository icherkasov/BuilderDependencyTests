import static org.junit.Assert.*;
import org.junit.Test;
import utils.ArrayUtils;

public class ArrayUtilsTest {




    @Test
    public void testOuterJoin() throws Exception {
        int[] leftArr = {1, 2, 3, 4};
        int[] rightArr = {1, 2, 5};
        int[] expectedResult = {3, 4, 5};
        ArrayUtils testClass = new ArrayUtils();
        int[] returnedValue = testClass.outerJoin(leftArr, rightArr);
        assertArrayEquals(expectedResult, returnedValue);
    }

    @Test
    public void testOuterJoinLeftIsEmptyInt() throws Exception {
        int[] leftArr = {};
        int[] rightArr = {1, 2};
        int[] expectedResult = {};
        ArrayUtils testClass = new ArrayUtils();
        int[] returnedValue = testClass.outerJoin(leftArr, rightArr);
        assertArrayEquals(expectedResult, returnedValue);
    }

    @Test
    public void testOuterJoinRightIsEmptyInt() throws Exception {
        int[] rightArr = {};
        int[] leftArr = {1, 2};
        int[] expectedResult = {};
        ArrayUtils testClass = new ArrayUtils();
        int[] returnedValue = testClass.outerJoin(leftArr, rightArr);
        assertArrayEquals(expectedResult, returnedValue);
    }

    @Test
    public void testInnerJoin() throws Exception {
        int[] leftArr = {4, 5, 2, 3, 1};
        int[] rightArr = {1, 2};
        int[] expectedResult = {1, 2};
        ArrayUtils testClass = new ArrayUtils();
        int[] actualResult = testClass.innerJoin(leftArr, rightArr);
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void testInnerJoinLeftIsEmptyInt() throws Exception {
        int[] leftArr = {};
        int[] rightArr = {1, 2};
        int[] expectedResult = {};
        ArrayUtils testClass = new ArrayUtils();
        int[] returnedValue = testClass.innerJoin(leftArr, rightArr);
        assertArrayEquals(expectedResult, returnedValue);
    }

    @Test
    public void testInnerJoinRightIsEmptyInt() throws Exception {
        int[] rightArr  = {};
        int[] leftArr = {1, 2};
        int[] expectedResult = {};
        ArrayUtils testClass = new ArrayUtils();
        int[] returnedValue = testClass.innerJoin(leftArr, rightArr);
        assertArrayEquals(expectedResult, returnedValue);
    }

    @Test
    public void testMergeFirstEmpty() throws Exception {
        int[] leftArr = {};
        int[] rightArr = {1, 2};
        int[] expectedResult = {1,2};
        ArrayUtils testClass = new ArrayUtils();
        int[] returnedValue = testClass.merge(leftArr, rightArr);
        assertArrayEquals(expectedResult, returnedValue);
    }

    @Test
    public void testMerge() throws Exception {
        int[] leftArr = {1, 2, 4, 6, 8};
        int[] rightArr = {1, 2, 6, 7};
        int[] expectedResult = {1, 2, 4,6, 7, 8};
        ArrayUtils testClass = new ArrayUtils();
        int[] returnedValue = testClass.merge(leftArr, rightArr);
        assertArrayEquals(expectedResult, returnedValue);
    }
    @Test
    public void testMergeRightEmpty() throws Exception {
        int[] leftArr = {1, 2, 4, 6, 8};
        int[] rightArr = {};
        int[] expectedResult = {1, 2, 4,6, 8};
        ArrayUtils testClass = new ArrayUtils();
        int[] returnedValue = testClass.merge(leftArr, rightArr);
        assertArrayEquals(expectedResult, returnedValue);
    }

    @Test
    public void testRemoveDublicatesAllSame() throws Exception {
        int[] leftArr = {1, 1, 1, 1, 1, 1};
        int[] expectedResult = {1};
        ArrayUtils testClass = new ArrayUtils();
        int[] returnedValue = testClass.removeDublicates(leftArr);
        assertArrayEquals(expectedResult, returnedValue);

    }

    @Test
    public void testRemoveDublicatesSeveralDublicates() throws Exception {
        int[] leftArr = {1, 1, 2, 1, 2, 1, 3, 4, 5, 1, 2};
        int[] expectedResult = {1, 2, 3, 4, 5};
        ArrayUtils testClass = new ArrayUtils();
        int[] returnedValue = testClass.removeDublicates(leftArr);
        assertArrayEquals(expectedResult, returnedValue);
    }

}