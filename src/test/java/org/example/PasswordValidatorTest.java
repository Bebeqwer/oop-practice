package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PasswordValidatorTest {

    @DisplayName("비밀번호가 최소 8자 이상 , 12자 이하면 예외가 발생하지 않는다 .")
    @Test
    void validatePasswordTest(){
        assertThatCode(() ->PasswordValidator.validate("aaaabbaa"))
                .doesNotThrowAnyException();

    }

    @DisplayName("비밀번호가 8자 미난 또는 12자 초과하는 경우 IllegalArgumentException 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"aaaabbb","aaabbbcccddde"})
    void validatePasswordTest2(){

        assertThatCode(()->PasswordValidator.validate("aabb"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여햐 한다.");
    }
}
