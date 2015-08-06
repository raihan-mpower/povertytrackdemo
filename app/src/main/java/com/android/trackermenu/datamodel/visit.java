package com.android.trackermenu.datamodel;

/**
 * Created by raihan on 8/6/15.
 */
public class visit {
public enum visittype {
    lastvisit,nextvisit;
}

    public visit(visittype type_of_visit, String id, String familyid, String userid) {
        this.type_of_visit = type_of_visit;
        this.id = id;
        this.familyid = familyid;
        this.userid = userid;
    }

    public visittype type_of_visit;
    public String id,familyid,userid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFamilyid() {
        return familyid;
    }

    public void setFamilyid(String familyid) {
        this.familyid = familyid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
