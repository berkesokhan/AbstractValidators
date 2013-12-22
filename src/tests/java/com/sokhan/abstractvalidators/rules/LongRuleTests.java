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

import com.sokhan.abstractvalidators.rules.LongRule;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LongRuleTests {

    @Test
    public void validateUnitShouldReturnTrueForIsGreaterThanZeroWithNegativeValue() {

        long negativeLong = -5;

        LongRule longRule = new LongRule(negativeLong);
        boolean result = longRule.isGreaterThanZero().basicResult;

        assertFalse(result);

    }

    @Test
    public void validateUnitShouldReturnTrueForIsGreaterThanZeroWithPositiveValue() {

        long positiveLong = 5;

        LongRule longRule = new LongRule(positiveLong);
        boolean result = longRule.isGreaterThanZero().validateUnit();

        assertTrue(result);

    }

    @Test
    public void validateUnitShouldReturnTrueForIsBetweenIncludingWithBoundaryValue(){

        long lowBoundaryValue = 2;
        long highBoundaryValue = 8;
        long testingValue = highBoundaryValue;

        LongRule longRule = new LongRule(testingValue);
        boolean result = longRule.isBetweenIncluding(lowBoundaryValue, highBoundaryValue).validateUnit();

        assertTrue(result);

    }

    @Test
    public void validateUnitShouldReturnFalseForIsBetweenExcludingWithBoundaryValue(){

        long lowBoundaryValue = 2;
        long highBoundaryValue = 8;
        long testingValue = highBoundaryValue;

        LongRule longRule = new LongRule(testingValue);
        boolean result = longRule.isBetweenExcluding(lowBoundaryValue, highBoundaryValue).validateUnit();

        assertFalse(result);

    }

    @Test
    public void validateUnitShouldReturnFalseForIsBetweenIncludingWithOutOfBoundValue(){

        long lowBoundaryValue = 2;
        long highBoundaryValue = 8;
        long testingValue = 10;

        LongRule longRule = new LongRule(testingValue);
        boolean result = longRule.isBetweenIncluding(lowBoundaryValue, highBoundaryValue).validateUnit();

        assertFalse(result);

    }

    @Test
    public void validateUnitShouldReturnFalseForIsBetweenExcludingWithOutOfBoundValue(){

        long lowBoundaryValue = 2;
        long highBoundaryValue = 8;
        long testingValue = 10;

        LongRule longRule = new LongRule(testingValue);
        boolean result = longRule.isBetweenExcluding(lowBoundaryValue, highBoundaryValue).validateUnit();

        assertFalse(result);

    }

    @Test
    public void validateUnitShouldReturnTrueForIsBetweenExcludingWithInBoundValue(){

        long lowBoundaryValue = 2;
        long highBoundaryValue = 8;
        long testingValue = 5;

        LongRule longRule = new LongRule(testingValue);
        boolean result = longRule.isBetweenExcluding(lowBoundaryValue, highBoundaryValue).validateUnit();

        assertTrue(result);

    }

    @Test
    public void validateUnitShouldReturnTrueForIsBetweenIncludingWithInBoundValue(){

        long lowBoundaryValue = 2;
        long highBoundaryValue = 8;
        long testingValue = 5;

        LongRule longRule = new LongRule(testingValue);
        boolean result = longRule.isBetweenIncluding(lowBoundaryValue, highBoundaryValue).validateUnit();

        assertTrue(result);

    }

}
