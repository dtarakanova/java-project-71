import hexlet.code.Diff;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class DiffTest {
    public static final String FILE1_JSON_FILEPATH1 =
            "src/test/resources/JSONfiles/file1J.json";
    public static final String FILE2_JSON_FILEPATH2 =
            "src/test/resources/JSONfiles/file2J.json";

    public static final String EMPTYFILE_JSON_PATH =
            "src/test/resources/JSONfiles/emptyfile.json";
    private static final String DEFAULT_CORRECT_RESULT = "{\n"
            + "- age : 18"
            + "+ faculty : computer science"
            + "- internship : false"
            + "+ internship : true"
            + "  lastname: petrova"
            + "  name: sasha"
            + "- student : true"
            + "}";
    private static final String EMPTY_FILE_COMPARISON_RESULT = "{\n"
            + "+ age : 18"
            + "+ internship : false"
            + "+ lastname: petrova"
            + "+ name: sasha"
            + "+ student : true"
            + "}";


    @Test
        public void testRightComparison() throws Exception {
        String result = Diff.generate(FILE1_JSON_FILEPATH1, FILE2_JSON_FILEPATH2);
        var testResult = assertThat(result).isEqualTo(DEFAULT_CORRECT_RESULT);
        System.out.println(testResult);
    }

    @Test
        public void emptyFile() throws Exception {
        String result = Diff.generate(FILE1_JSON_FILEPATH1, EMPTYFILE_JSON_PATH);
        var testResult = assertThat(result).isEqualTo(EMPTY_FILE_COMPARISON_RESULT);
        System.out.println(testResult);
    }
}
