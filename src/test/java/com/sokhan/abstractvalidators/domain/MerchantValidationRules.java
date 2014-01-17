package com.sokhan.abstractvalidators.domain;

import com.sokhan.abstractvalidators.ValidationRules;

/**
 * Created by Berke Sokhan
 * Date: 12/4/13
 * Time: 2:09 AM
 */
public class MerchantValidationRules extends ValidationRules<Merchant> {

    @Override
    public void setRules(){
        check(validatedObject.getMerchantId()).isGreaterThanZero()
                .when(validatedObject.getNumberOfOffices() > 0)
                .withMessage("Merchant ID should be greater than 0 when number of offices is greater than 0.");

        check(validatedObject.getMerchantId()).isBetweenIncluding(12, 34)
                .when(!validatedObject.getMerchantName().isEmpty())
                .withMessage("Merchant Id should be between 12 and 34");
    }

}
