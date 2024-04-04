import java.util.ArrayList;
import java.util.List;

//Given an array of words and a length of L, format the text such that each line
// has exactly L characters and is fully (left and right) justified. You should pack
// your words in a greedy approach; that is, pack as many words as you can in each line.
public class TextJustification {
    public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<>();
        int start = 0;

        while (start < words.length) {
            int end = findEndIndex(words, start, L);
            result.add(justifyLine(words, start, end, L));
            start = end + 1;
        }

        return result;
    }

    private int findEndIndex(String[] words, int start, int L) {
        int end = start;
        int len = words[start].length();

        while (end + 1 < words.length && len + words[end + 1].length() + (end + 1 - start) <= L) {
            len += words[end + 1].length();
            end++;
        }

        return end;
    }

    private String justifyLine(String[] words, int start, int end, int L) {
        StringBuilder sb = new StringBuilder();
        if (start == end || end == words.length - 1) { // Left justify if it's the last line or only one word
            for (int i = start; i <= end; i++) {
                sb.append(words[i]);
                if (i < end) sb.append(" ");
            }
            for (int i = sb.length(); i < L; i++) {
                sb.append(" ");
            }
        } else {
            int totalSpaces = L;
            for (int i = start; i <= end; i++) {
                totalSpaces -= words[i].length();
            }
            int gaps = end - start;
            int extraSpaces = totalSpaces % gaps;
            int spacesPerGap = totalSpaces / gaps;
            for (int i = start; i <= end; i++) {
                sb.append(words[i]);
                if (i < end) {
                    for (int j = 0; j < spacesPerGap; j++) {
                        sb.append(" ");
                    }
                    if (extraSpaces > 0) {
                        sb.append(" ");
                        extraSpaces--;
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TextJustification textJustification = new TextJustification();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int L = 16;
        List<String> result = textJustification.fullJustify(words, L);
        for (String line : result) {
            System.out.println(line);
        }
    }
}
