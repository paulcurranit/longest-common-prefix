
import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.util.Vector;

public class LongestCommonPrefixTest {

    @Test
    public void testFirstGivenExample() {
        Vector<String> exampleVector = new Vector<String>();
        exampleVector.add("flower");
        exampleVector.add("flow");
        exampleVector.add("flight");

        String result = LongestCommonPrefix.findLongestCommonPrefix(exampleVector);
        assertTrue(result.equals("fl"));
    }

    @Test
    public void testSecondGivenExample() {
        Vector<String> exampleVector = new Vector<String>();
        exampleVector.add("dog");
        exampleVector.add("racecar");
        exampleVector.add("car");

        String result = LongestCommonPrefix.findLongestCommonPrefix(exampleVector);
        assertTrue(result.equals(""));
    }
}
