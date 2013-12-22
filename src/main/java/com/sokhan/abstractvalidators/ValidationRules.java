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

import com.sokhan.abstractvalidators.rules.IntegerRule;
import com.sokhan.abstractvalidators.rules.LongRule;
import com.sokhan.abstractvalidators.rules.Rule;
import com.sokhan.abstractvalidators.rules.StringRule;

import java.util.ArrayList;
import java.util.List;


public abstract class ValidationRules<TValidatedType> {

    protected TValidatedType validatedObject;

    private List<Rule> rulesList = new ArrayList<Rule>();

    public List<Rule> getRulesList() {
        return rulesList;
    }

    private Rule addRule(Rule rule) {
        this.getRulesList().add(rule);
        return rule;
    }

    /*
     * Different 'check' overloads exists because in Java generics type erasure deletes type info at runtime creating an 'object', effectively
     * rendering useless our any intended type detection algorithms...
     */
    public IntegerRule check(int propertyValue) {
        return (IntegerRule) addRule(new IntegerRule(propertyValue));
    }

    public LongRule check(long propertyValue) {
        return (LongRule) addRule(new LongRule(propertyValue));
    }

    public StringRule check(String propertyValue) {
        return (StringRule) addRule(new StringRule(propertyValue));
    }

    public abstract void setRules();

    public ValidationResult validate(TValidatedType validatedObject) {
        this.validatedObject = validatedObject;
        this.setRules();

        List<RuleValidationResult> ruleValidationResults = new ArrayList<RuleValidationResult>();

        boolean hasErrors = false;

        for (Rule rule : getRulesList()) {
            RuleValidationResult ruleValidationResult = rule.validate();
            ruleValidationResults.add(ruleValidationResult);
            if (ruleValidationResult.getHasErrors()) {
                hasErrors = true;
            }

        }

        return new ValidationResult(hasErrors, ruleValidationResults);
    }


}
