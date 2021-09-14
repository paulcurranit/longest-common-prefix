import java.util.OptionalInt;
import java.util.Vector;

public class LongestCommonPrefix {

    public static String findLongestCommonPrefix(Vector<String> exampleVector) {
        int vectorSize = exampleVector.size();

        int smallestStringSize = exampleVector.firstElement().length();
        int vectorIndex = 1;
        while(vectorIndex < vectorSize) {
            if(exampleVector.get(vectorIndex).length() < smallestStringSize) {
                smallestStringSize = exampleVector.get(vectorIndex).length();
            }
            vectorIndex++;
        }

        int prefixIndex = smallestStringSize;
        boolean prefixCommon = false;
        while(!prefixCommon && prefixIndex > 0) {
            String testPrefix = exampleVector.get(0).substring(0,prefixIndex);

            vectorIndex = 1;
            prefixCommon = true;
            while(prefixCommon && vectorIndex < exampleVector.size()) {
                if(!exampleVector.get(vectorIndex).substring(0, prefixIndex).equals(testPrefix)) {
                    prefixCommon = false;
                }
                vectorIndex++;
            }

            if(!prefixCommon) {
                prefixIndex--;
            }
        }

        if(prefixCommon) {
            return exampleVector.get(0).substring(0,prefixIndex);
        }
        return "";
    }

    public static String findLongestCommonPrefixUsingStream(Vector<String> exampleVector) {

        OptionalInt smallestStringSize = exampleVector
                .stream()
                .mapToInt(String::length)
                .min();

        int endPrefixIndex = 1;
        String commonPrefix = "";

        if (smallestStringSize.isPresent()) {
            while (endPrefixIndex < smallestStringSize.getAsInt()) {
                String testPrefix = exampleVector.get(0).substring(0, endPrefixIndex);

                if (isPrefixCommon(exampleVector, testPrefix)) {
                    endPrefixIndex++;
                    commonPrefix = testPrefix;
                } else {
                    endPrefixIndex = smallestStringSize.getAsInt();
                }
            }
        }

        return commonPrefix ;
    }

    private static boolean isPrefixCommon(Vector<String> vector, String testPrefix) {
        return vector
                    .stream()
                    .allMatch(s -> s.startsWith(testPrefix));
    }
}
