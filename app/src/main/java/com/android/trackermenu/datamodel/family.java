package com.android.trackermenu.datamodel;

/**
 * Created by raihan on 8/6/15.
 */
public class family {
    public String UserID,FamilyID,NameHH,IDHH,AgeHH,GenderHH,CivilStatus,NumberOfChildren,NumberOFChildrenBetween;
    public String longitude,lattitude;

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }

    public family(String userID, String familyID, String nameHH, String IDHH, String ageHH, String genderHH, String civilStatus, String numberOfChildren, String numberOFChildrenBetween) {
        UserID = userID;
        FamilyID = familyID;
        NameHH = nameHH;
        this.IDHH = IDHH;
        AgeHH = ageHH;
        CivilStatus = civilStatus;
        GenderHH = genderHH;
        NumberOfChildren = numberOfChildren;
        NumberOFChildrenBetween = numberOFChildrenBetween;
    }

    public String getUserID() {

        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getFamilyID() {
        return FamilyID;
    }

    public void setFamilyID(String familyID) {
        FamilyID = familyID;
    }

    public String getNameHH() {
        return NameHH;
    }

    public void setNameHH(String nameHH) {
        NameHH = nameHH;
    }

    public String getIDHH() {
        return IDHH;
    }

    public void setIDHH(String IDHH) {
        this.IDHH = IDHH;
    }

    public String getAgeHH() {
        return AgeHH;
    }

    public void setAgeHH(String ageHH) {
        AgeHH = ageHH;
    }

    public String getCivilStatus() {
        return CivilStatus;
    }

    public void setCivilStatus(String civilStatus) {
        CivilStatus = civilStatus;
    }

    public String getGenderHH() {
        return GenderHH;
    }

    public void setGenderHH(String genderHH) {
        GenderHH = genderHH;
    }

    public String getNumberOfChildren() {
        return NumberOfChildren;
    }

    public void setNumberOfChildren(String numberOfChildren) {
        NumberOfChildren = numberOfChildren;
    }

    public String getNumberOFChildrenBetween() {
        return NumberOFChildrenBetween;
    }

    public void setNumberOFChildrenBetween(String numberOFChildrenBetween) {
        NumberOFChildrenBetween = numberOFChildrenBetween;
    }
}
