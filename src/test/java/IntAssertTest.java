import io.github.ingmargoudt.veritas.Veritas;
import io.github.ingmargoudt.veritas.assertions.IntAssertion;
import org.junit.jupiter.api.Test;

import static io.github.ingmargoudt.veritas.Veritas.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntAssertTest {

    @Test
    public void Integer_isEqualTo() {
        assertThat(3).isEqualTo(3);
    }

    @Test
    public void Integer_isNotEqualTo() {
       assertThrows(AssertionError.class, () -> assertThat(3).isNotEqualTo(3));
    }

    @Test
    public void Integer_not_equals() {
        assertThrows(AssertionError.class, () ->
        {
            assertThat(3).isEqualTo(4);
        });
    }

    @Test
    public void Integer_customMessage() {
        Veritas.LOG_PASSED = true;
        IntAssertion success = assertThat(3).onSucces("success");
        assertEquals("success", success.getCustomPassMessage());
        success.isEqualTo(3);
    }

    @Test
    public void Integer_isEven() {
        assertThat(2).isEven();
    }

    @Test
    public void Integer_isNotEven() {
        assertThrows(AssertionError.class, () -> assertThat(3).isEven());
    }

    @Test
    public void Integer_isOdd() {
        assertThat(3).isOdd();
    }

    @Test
    public void Integer_isNotOdd() {
        assertThrows(AssertionError.class, () -> assertThat(4).isOdd());
    }

    @Test
    public void isSmallerThan() {
        assertThat(3).isSmallerThan(4);
    }

    @Test
    public void isNotSmallerThan(){
        assertThrows(AssertionError.class, () -> assertThat(3).isSmallerThan(2));
    }

    @Test
    public void isSmallerEqualTo() {
        assertThat(3).isSmallerThanOrEqual(3);
        assertThat(3).isSmallerThanOrEqual(4);
    }

    @Test
    public void isNotSmallerEqualTo() {
        assertThrows(AssertionError.class, () -> assertThat(4).isSmallerThanOrEqual(3));
    }

    @Test
    public void isGreaterThan() {
        assertThat(4).isGreaterThan(3);
    }

    @Test
    public void isNotGreaterThan() {
        assertThrows(AssertionError.class, () -> assertThat(4).isGreaterThan(4));
    }

    @Test
    public void isGreaterThanEqualTo() {
        assertThat(4).isGreaterThanOrEqual(4);
        assertThat(5).isGreaterThanOrEqual(4);
    }

    @Test
    public void isNotGreaterOrEqualTo() {
        assertThrows(AssertionError.class, () -> assertThat(3).isGreaterThanOrEqual(4));
    }

    @Test
    public void isBetween() {
        assertThat(4).isBetween(3, 5);
    }

    @Test
    public void isNotBetween() {
        assertThrows(AssertionError.class, () -> assertThat(3).isBetween(4, 5));
    }

    @Test
    public void isMultipleOf() {
        assertThat(15).isMultipleOf(3);
    }

    @Test
    public void isNotMultipleOf() {
      assertThrows(AssertionError.class, () -> assertThat(15).isMultipleOf(4));
    }


    @Test
    public void testNull() {
        assertThrows(NullPointerException.class, () -> assertThat(15).isMultipleOf(null));
    }


}
