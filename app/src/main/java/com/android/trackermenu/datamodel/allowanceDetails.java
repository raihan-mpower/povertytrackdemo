package com.android.trackermenu.datamodel;

/**
 * Created by raihan on 8/6/15.
 */
public class allowanceDetails {
    public String FamilyId,type_of_allowance,product,status,deliverydate,units;

    public allowanceDetails(String familyId, String type_of_allowance, String product, String status,String deliverydate, String units) {
        FamilyId = familyId;
        this.type_of_allowance = type_of_allowance;
        this.product = product;
        this.status = status;
        this.units = units;
        this.deliverydate = deliverydate;
    }
}
