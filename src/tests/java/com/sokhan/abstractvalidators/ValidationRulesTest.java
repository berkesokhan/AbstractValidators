// Copyright (c) Berke Sokhan
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
// The latest version of this file can be found at http://github.com/berkesokhan/abstractvalidators


package com.sokhan.abstractvalidators;


import com.sokhan.abstractvalidators.domain.Merchant;
import com.sokhan.abstractvalidators.domain.MerchantValidationRules;
import com.sokhan.abstractvalidators.rules.IntegerRule;
import com.sokhan.abstractvalidators.rules.LongRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class ValidationRulesTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void CheckCanBeCalledOnInteger() {

        MerchantValidationRules rules = new MerchantValidationRules();

        Merchant validatedType = new Merchant();
        validatedType.setMerchantId(12345567);
        validatedType.setNumberOfOffices(12);
        validatedType.setMerchantName("Damage Inc.");

        ValidationResult validate = rules.validate(validatedType);

    }

    @Test
    public void CheckLongCreatesLongRuleWithCorrectValue() {

        long anyLongNumber = 13L;

        Merchant merchant = new Merchant();
        merchant.setMerchantId(anyLongNumber);

        LongRule longRule = (new MerchantValidationRules()).check(merchant.getMerchantId());

        assertEquals(anyLongNumber, longRule.getPropertyValue());
    }

    @Test
    public void CheckLongAddsLongRuleToItsRules() {

        long anyLongNumber = 13L;

        Merchant merchant = new Merchant();
        merchant.setMerchantId(anyLongNumber);

        MerchantValidationRules merchantValidationRules = new MerchantValidationRules();
        LongRule longRule = merchantValidationRules.check(merchant.getMerchantId());

        assertNotNull(merchantValidationRules.getRulesList());
        assertEquals(1, merchantValidationRules.getRulesList().size());
        assertSame(longRule, merchantValidationRules.getRulesList().get(0));
    }

    @Test
    public void CheckIntegerCreatesLongRuleWithCorrectValue() {

        int anyIntegerNumber = 13;

        Merchant merchant = new Merchant();
        merchant.setNumberOfOffices(anyIntegerNumber);

        IntegerRule integerRule = (new MerchantValidationRules()).check(merchant.getNumberOfOffices());

        assertEquals(anyIntegerNumber, integerRule .getPropertyValue());
    }

    @Test
    public void CheckIntegerAddsLongRuleToItsRules() {

        int anyIntegerNumber = 13;

        Merchant merchant = new Merchant();
        merchant.setNumberOfOffices(anyIntegerNumber);

        MerchantValidationRules merchantValidationRules = new MerchantValidationRules();
        IntegerRule integerRule = merchantValidationRules.check(merchant.getNumberOfOffices());

        assertNotNull(merchantValidationRules.getRulesList());
        assertEquals(1, merchantValidationRules.getRulesList().size());
        assertSame(integerRule, merchantValidationRules.getRulesList().get(0));
    }


}
