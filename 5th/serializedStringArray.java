public class serializedStringArray {
    public String serializeStringArray(String[] A) {
        StringBuilder serialized = new StringBuilder();
        for (String str : A) {
            int length = str.length();
            serialized.append(str).append(length).append("~");
        }
        return serialized.toString();
    }

    public static void main(String[] args) {
        serializedStringArray solution = new serializedStringArray();

        // Example input
        String[] input1 = {"scaler", "academy"};
        String[] input2 = {"interviewbit"};

        // Example output
        String output1 = solution.serializeStringArray(input1);
        String output2 = solution.serializeStringArray(input2);

        // Print outputs
        System.out.println("Output 1: " + output1);
        System.out.println("Output 2: " + output2);
    }
}
