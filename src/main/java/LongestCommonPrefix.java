import java.util.Vector;

public class LongestCommonPrefix {

    public static String findLongestCommonPrefix(Vector<String> exampleVector) {
        String prefix = "";

        int prefixIndex = 0;
        int vectorSize = exampleVector.size();

        int smallestStringSize = exampleVector.firstElement().length();
        int vectorIndex = 1;
        while(vectorIndex < vectorSize) {
            if(exampleVector.get(vectorIndex).length() < smallestStringSize) {
                smallestStringSize = exampleVector.get(vectorIndex).length();
            }
            vectorIndex++;
        }

        prefixIndex = smallestStringSize;
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
}
