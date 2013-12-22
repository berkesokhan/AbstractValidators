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

public class IntegerRule extends Rule {

    private int propertyValue;

    public long getPropertyValue() {
        return propertyValue;
    }

    public IntegerRule(int propertyValue) {
        this.propertyValue = propertyValue;
    }

    @Override
    public boolean validateUnit() {
        return false;
    }

    public IntegerRule isGreaterThanZero() {
        this.basicResult = this.propertyValue > 0;
        return this;
    }

}
