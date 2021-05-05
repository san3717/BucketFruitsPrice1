import static com.basketFruits.PriceValidator.isNegative;
import static com.basketFruits.PriceValidator.validate;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.rules.ExpectedException.none;

import java.math.BigDecimal;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PriceValidatorTest {

    @Rule
    public ExpectedException exception = none();

    @Test
    public void validatesPrice() {
        BigDecimal price = BigDecimal.valueOf(1.31);

        validate(price);
    }

    @Test
    public void throwsExceptionIfPriceIsNegative() {

        BigDecimal negativePrice = BigDecimal.valueOf(-1.21);

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Allowed only positive value");

        validate(negativePrice);
    }

    @Test
    public void checksIfBigDecimalIsNegative() {
        BigDecimal positiveNumber = BigDecimal.valueOf(1.32);
        BigDecimal negativeNumber = BigDecimal.valueOf(-2.31);
        BigDecimal zero = BigDecimal.ZERO;

        assertThat(isNegative(positiveNumber), is(false));
        assertThat(isNegative(negativeNumber), is(true));
        assertThat(isNegative(zero), is(false));
    }

}