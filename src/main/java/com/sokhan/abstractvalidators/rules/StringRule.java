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

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.regex.Pattern;

public class StringRule extends Rule {

    private String propertyValue;

    public StringRule(String propertyValue) {

        this.propertyValue = propertyValue;

    }

    @Override
    public boolean validateUnit() {

        return this.basicResult;

    }


    public StringRule isNumeric() {

        NumberFormat numberFormat = NumberFormat.getInstance();
        ParsePosition parsePosition = new ParsePosition(0);
        numberFormat.parse(this.propertyValue, parsePosition);
        this.basicResult = this.propertyValue.length() == parsePosition.getIndex();

        return this;

    }

    public StringRule shorterOrHasEqualLengthThan(int length) {

        this.basicResult = this.propertyValue.length() <= length;

        return this;
    }

    public StringRule lengthIsBetweenInclusive(int minLength, int maxLength) {

        this.basicResult = (this.propertyValue.length() >= minLength) && (this.propertyValue.length() <= maxLength);

        return this;

    }

    public StringRule isNotNullOrEmpty() {

        this.basicResult = (this.propertyValue != null) && (this.propertyValue.length() > 0);

        return this;
    }

    public StringRule matchesRegex(String regex) {

        // TODO: Design a better performing implementation!
        this.basicResult = Pattern.compile(regex, Pattern.UNICODE_CASE).matcher(this.propertyValue).find();

        return this;

    }
}
