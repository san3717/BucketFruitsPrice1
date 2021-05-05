package com.basketFruits;

import java.math.BigDecimal;

public class PriceValidator {
	
    public static void validate(BigDecimal price) {
        if (isNegative(price)) {
            throw new IllegalArgumentException("Allowed only positive value");
        }
    }

    public static boolean isNegative(BigDecimal price) {
        return price.signum() == -1;
    }
}
