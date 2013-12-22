package com.sokhan.abstractvalidators.domain;

/**
 * Created by Berke Sokhan
 * Date: 12/4/13
 * Time: 1:58 AM
 */
public class Merchant {

    private String merchantName;

    public String getMerchantName() {
        return this.merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }


    private long merchantId;

    public long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(long merchantId) {
        this.merchantId = merchantId;
    }


    private int numberOfOffices;

    public int getNumberOfOffices() {
        return numberOfOffices;
    }

    public void setNumberOfOffices(int numberOfOffices) {
        this.numberOfOffices = numberOfOffices;
    }

}
