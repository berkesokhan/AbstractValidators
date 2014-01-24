# Abstract Validators   [![Build Status](https://travis-ci.org/berkesokhan/AbstractValidators.png?branch=master)](https://travis-ci.org/berkesokhan/AbstractValidators)

## Introduction
Abstract Validators project is a business object validation framework in Java with a more fluent approach then the prevailing JSR-303 Bean Validation standard. 

## Why?
I was originally a .NET/C#/F# stack developer but somehow exposed to Java and OSS projects around Java technology. At the time of writing this project, I was in the process of converting more to JVM based technologies such as Java, Scala and Clojure. 

While writing Java projects, I noticed that the frameworks build around JSR-303 have some shortcomings:

 - Setting a rule for one ~~property~~ field against other ~~properties~~ fields (e.g. Cell phone is required if home phone is null).
 - Application of different sets of validation rules for different object states (this is arguable, but sometimes necessary).
 - Decoupling validation rules from object definition, successfully achieving a ~~POCO~~ POJO.

 So I want to explore a more fluent approach to solve these shortcomings much like [FluentValidation](http://fluentvalidation.codeplex.com/wikipage?title=CreatingAValidator&referringTitle=Documentation&ANCHOR#Chaining) and [SpecExpress](http://specexpress.codeplex.com/wikipage?title=Specifications&referringTitle=Documentation) projects but in Java.

## Build  
At the root of the project enter

    gradle build

at the command line for building.
 
## Usage  

There will be two usage scenarios for AbstractValidators. Creating a validation class or using an InlineValidator instance.

### Creating a validation class  
Suppose that we have a Merchant business object;

	public class Merchant {

    	private String merchantName;

    	public String getMerchantName() {
        	return this.merchantName;
    	}

    	public void setMerchantName(String merchantName) {
        	this.merchantName = merchantName;
    	}
    	
    	    private int numberOfOffices;

    	public int getNumberOfOffices() {
        	return numberOfOffices;
    	}

    	public void setNumberOfOffices(int numberOfOffices) {
        	this.numberOfOffices = numberOfOffices;
    	}

	}

We define the rules in a MerchantValidation class which extends from ValidationRules of Merchant;

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

and finally validate an instance of Merchant object;

		
        Merchant validatedType = new Merchant();
        validatedType.setMerchantId(12345567);
        validatedType.setNumberOfOffices(12);
        validatedType.setMerchantName("Damage Inc.");

		MerchantValidationRules rules = new MerchantValidationRules();
        ValidationResult validate = rules.validate(validatedType);


### Using an InlineValidator
  
TODO: Need to develop further for this sample.