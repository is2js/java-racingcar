package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import StringCalculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {

    @Test
    @DisplayName("빈 문자열 또는 null 입력시 0 반환 테스트")
    public void splitAndSum_null_or_empty() {
        int result = StringCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나 입력시 변환 후 반환 테스트")
    void splitAndSum_singleNumber() {
        int result = StringCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 2개를 콤마로 구분하여 덧셈 테스트")
    void splitAndSum_twiceNumber() {
        int result = StringCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 2개를 콤마 및 콜론으로 구분하여 덧셈 테스트")
    void splitAndSum_by_commaAndColon() {
        int result = StringCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자를 지정하여 덧셈 테스트")
    void splitAndSum_by_custom_delimiter() {
        int result = StringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수 입력시 예외 발생 테스트")
    void splitAndSum_negative() {
        assertThatThrownBy(() -> StringCalculator.splitAndSum("//;\n-1;2;3"))
                .isInstanceOf(RuntimeException.class);
    }
}
