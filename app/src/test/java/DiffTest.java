import hexlet.code.Diff;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class DiffTest {
    public static final String FILE1_JSON_FILEPATH1 =
            "src/test/resources/JSONfiles/file1J.json";
    public static final String FILE2_JSON_FILEPATH2 =
            "src/test/resources/JSONfiles/file2J.json";
    public static final String FILE1_YAML_FILEPATH1 =
            "src/test/resources/YAMLfiles/file1Y.yaml";
    public static final String FILE2_YAML_FILEPATH2 =
            "src/test/resources/YAMLfiles/file2Y.yaml";
    private static final String DEFAULT_CORRECT_RESULT = """
            {
                chars1: [a, b, c]
              - chars2: [d, e, f]
              + chars2: false
              - checked: false
              + checked: true
              - default: null
              + default: [value1, value2]
              - id: 45
              + id: null
              - key1: value1
              + key2: value2
                numbers1: [1, 2, 3, 4]
              - numbers2: [2, 3, 4, 5]
              + numbers2: [22, 33, 44, 55]
              - numbers3: [3, 4, 5]
              + numbers4: [4, 5, 6]
              + obj1: {nestedKey=value, isNested=true}
              - setting1: Some value
              + setting1: Another value
              - setting2: 200
              + setting2: 300
              - setting3: true
              + setting3: none
            }""";

    @Test
        public void testRightComparisonJSON() throws Exception {
        String result = Diff.generate(FILE1_JSON_FILEPATH1, FILE2_JSON_FILEPATH2);
        assertThat(result).isEqualTo(DEFAULT_CORRECT_RESULT);
    }

    @Test
    public void testRightComparisonYAML() throws Exception {
        String result = Diff.generate(FILE1_YAML_FILEPATH1, FILE2_YAML_FILEPATH2);
        assertThat(result).isEqualTo(DEFAULT_CORRECT_RESULT);
    }
}
