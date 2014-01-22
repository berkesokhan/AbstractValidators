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

package com.sokhan.abstractvalidators.rules;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringRuleTests {

    @Test
    public void validateUnitShouldReturnTrueForIsNumericWithNumericValue(){

        String numericStringValue = "12345";

        StringRule stringRule = new StringRule(numericStringValue);
        boolean result = stringRule.isNumeric().validateUnit();

        assertTrue(result);

    }

    @Test
    public void validateUnitShouldReturnTrueForIsNotNullOrEmptyWithNotNullValue(){

        String notNullStringValue = "thisIsNotNull";

        StringRule stringRule = new StringRule(notNullStringValue);
        boolean result = stringRule.isNotNullOrEmpty().validateUnit();

        assertTrue(result);

    }

    @Test
    public void validateUnitShouldReturnTrueForIsNotNullOrEmptyWithNotEmptyValue(){

        String notEmptyStringValue = " ";

        StringRule stringRule = new StringRule(notEmptyStringValue);
        boolean result = stringRule.isNotNullOrEmpty().validateUnit();

        assertTrue(result);

    }

    @Test
    public void validateUnitShouldReturnFalseForIsNotNullOrEmptyWithEmptyValue(){

        String emptyStringValue = "";

        StringRule stringRule = new StringRule(emptyStringValue);
        boolean result = stringRule.isNotNullOrEmpty().validateUnit();

        assertFalse(result);

    }

    @Test
    public void validateUnitShouldReturnFalseForIsNotNullOrEmptyWithNullValue(){

        String nullStringValue = null;

        StringRule stringRule = new StringRule(nullStringValue);
        boolean result = stringRule.isNotNullOrEmpty().validateUnit();

        assertFalse(result);

    }

    @Test
    public void validateUnitShouldReturnTrueForLengthIsBetweenInclusiveWithInBetweenLengthValue(){

        int minLength = 0;
        int maxLength = 16;
        String inBetweenLengthStringValue = "hasValidLength";

        StringRule stringRule = new StringRule(inBetweenLengthStringValue);
        boolean result = stringRule.lengthIsBetweenInclusive(minLength, maxLength).validateUnit();

        assertTrue(result);

    }

    @Test
    public void validateUnitShouldReturnFalseForLengthIsBetweenInclusiveWithNotInBetweenLengthValue(){

        int minLength = 0;
        int maxLength = 10;
        String isLongerThanExpected = "isLongerThanExpected";

        StringRule stringRule = new StringRule(isLongerThanExpected);
        boolean result = stringRule.lengthIsBetweenInclusive(minLength, maxLength).validateUnit();

        assertFalse(result);

    }

    @Test
    public void validateUnitShouldReturnTrueForShorterOrHasEqualLengthThanWithShortLengthValue(){

        int maxLength = 10;
        String hasShortLengthValue = "short";

        StringRule stringRule = new StringRule(hasShortLengthValue);
        boolean result = stringRule.shorterOrHasEqualLengthThan(maxLength).validateUnit();

        assertTrue(result);

    }

    @Test
    public void validateUnitShouldReturnFalseForShorterOrHasEqualLengthThanWithLongLengthValue(){

        int maxLength = 10;
        String hasLongLengthValue = "thisistoolong";

        StringRule stringRule = new StringRule(hasLongLengthValue);
        boolean result = stringRule.shorterOrHasEqualLengthThan(maxLength).validateUnit();

        assertFalse(result);

    }

    @Test
    public void validateUnitShouldReturnTrueForMatchesRegexWithMatchingRegexValue(){

        String regexString = "(your)";
        String matchingRegexString = "All your bases are belong to us!";

        StringRule stringRule = new StringRule(matchingRegexString);
        boolean result = stringRule.matchesRegex(regexString).validateUnit();

        assertTrue(result);

    }

    @Test
    public void validateUnitShouldReturnFalseForMatchesRegexWithNonMatchingRegexValue(){

        String regexString = "(mine)";
        String matchingRegexString = "All your bases are belong to us!";

        StringRule stringRule = new StringRule(matchingRegexString);
        boolean result = stringRule.matchesRegex(regexString).validateUnit();

        assertFalse(result);

    }

}
