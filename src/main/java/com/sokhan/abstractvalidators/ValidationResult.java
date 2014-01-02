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

import java.util.List;

public class ValidationResult {

    private boolean hasErrors;
    private List<RuleValidationResult> ruleValidationResults;

    public boolean getHasErrors() {
        return hasErrors;
    }

    public List<RuleValidationResult> getRuleValidationResults() {
        return ruleValidationResults;
    }

    public ValidationResult(boolean hasErrors, List<RuleValidationResult> ruleValidationResults) {
        this.hasErrors = hasErrors;
        this.ruleValidationResults = ruleValidationResults;
    }

}
