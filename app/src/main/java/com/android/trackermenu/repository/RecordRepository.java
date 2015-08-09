package com.android.trackermenu.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.android.trackermenu.datamodel.allowanceDetails;
import com.android.trackermenu.datamodel.family;
import com.android.trackermenu.datamodel.familyDetails;
import com.android.trackermenu.datamodel.visit;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by raihan on 8/9/15.
 */
public class RecordRepository extends SQLiteOpenHelper{

    private String family_sql = "CREATE TABLE family(id INTEGER PRIMARY KEY AUTOINCREMENT, UserID VARCHAR, FamilyID VARCHAR, " +
            "NameHH VARCHAR, IDHH VARCHAR, AgeHH VARCHAR, GenderHH VARCHAR, CivilStatus VARCHAR, NumberOfChildren VARCHAR, longitude VARCHAR, lattitude VARCHAR)";

    private String familyDetails_sql = "CREATE TABLE familyDetails(id INTEGER PRIMARY KEY AUTOINCREMENT, mealsPerDay VARCHAR, FamilyID VARCHAR, " +
            "TypeOfToilet VARCHAR, OwnershipOFAssets VARCHAR)";

    private String allowanceDetails_sql = "CREATE TABLE allowanceDetails(id INTEGER PRIMARY KEY AUTOINCREMENT, FamilyId VARCHAR, type_of_allowance VARCHAR, " +
            "product VARCHAR, status VARCHAR, deliverydate VARCHAR, units VARCHAR)";

    private String visit_sql = "CREATE TABLE visits(id INTEGER PRIMARY KEY AUTOINCREMENT, FamilyId VARCHAR, type_of_visit VARCHAR,userid VARCHAR,date VARCHAR)";


    public RecordRepository(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(family_sql);
        sqLiteDatabase.execSQL(familyDetails_sql);
        sqLiteDatabase.execSQL(allowanceDetails_sql);
        sqLiteDatabase.execSQL(visit_sql);
    }

    public void insertTOTable(String tablename,ContentValues cv){
        super.getWritableDatabase().insert(tablename, null, cv);
    }

    public ContentValues createContentValuesForfamily(family Family){
        ContentValues values = new ContentValues();
        values.put("UserID", Family.getUserID());
        values.put("FamilyID", Family.getFamilyID());
        values.put("NameHH",Family.getNameHH());
        values.put("IDHH", Family.getIDHH());
        values.put("AgeHH", Family.getAgeHH());
        values.put("GenderHH",Family.getGenderHH());
        values.put("CivilStatus", Family.getCivilStatus());
        values.put("NumberOfChildren",Family.getNumberOfChildren());
        values.put("longitude",Family.getLongitude() );
        values.put("lattitude", Family.getLattitude());
        return values;
    }

    public ContentValues createContentValuesForfamilyDetails(familyDetails FamilyDetails){
        ContentValues values = new ContentValues();
        values.put("mealsPerDay", FamilyDetails.mealsPerDay);
        values.put("FamilyID", FamilyDetails.FamilyID);
        values.put("TypeOfToilet",FamilyDetails.TypeOfToilet);
        values.put("OwnershipOFAssets", FamilyDetails.OwnershipOFAssets);
        return values;
    }

    public ContentValues createContentValuesForAllowanceDetails(allowanceDetails allowanceDetails){
        ContentValues values = new ContentValues();
        values.put("FamilyId", allowanceDetails.FamilyId);
        values.put("type_of_allowance", allowanceDetails.type_of_allowance);
        values.put("product",allowanceDetails.product);
        values.put("status", allowanceDetails.status);
        values.put("deliverydate", allowanceDetails.deliverydate);
        values.put("units", allowanceDetails.units);
        return values;
    }

    public ContentValues createContentValuesForVisit(visit Visit){
        ContentValues values = new ContentValues();
        values.put("FamilyId", Visit.familyid);
        switch (Visit.type_of_visit){
            case lastvisit:
                values.put("type_of_visit", "lastvisit");
                break;
            case nextvisit:
                values.put("type_of_visit", "nextvisit");
                break;
        }
        values.put("userid", Visit.getUserid());
        values.put("date",Visit.date);
        return values;
    }

    public ArrayList<family> getallfamilies(){
        ArrayList<family> families = new ArrayList<family>();
        SQLiteDatabase database = super.getReadableDatabase();
        Cursor cursor = database.query("family", null, null ,null, null, null, null, null);
        while (!cursor.isAfterLast()) {
            family Family = new family(cursor.getString(1), cursor.getString(2), cursor.getString(3),
                    cursor.getString(4), cursor.getString(5), cursor.getString(6),
                   cursor.getString(7),cursor.getString(8),"");

            families.add(Family);
            cursor.moveToNext();
        }
        return families;
    }
    public familyDetails getfamilyDetailByID(String familyID){
       familyDetails FamilyDetails = null;
        SQLiteDatabase database = super.getReadableDatabase();
        Cursor cursor = database.query("familyDetails", null, "FamilyID" +" = ?", new String[]{familyID}, null, null, null, null);
        while (!cursor.isAfterLast()){
            FamilyDetails = new familyDetails(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
            cursor.moveToNext();
        }
        return FamilyDetails;
    }
    public allowanceDetails getAllowanceDetailByfamilyID(String familyID){
        allowanceDetails AllowanceDetail = null;
        SQLiteDatabase database = super.getReadableDatabase();
        Cursor cursor = database.query("allowanceDetails", null, "FamilyID" +" = ?", new String[]{familyID}, null, null, null, null);
        while(!cursor.isAfterLast()){
            AllowanceDetail = new allowanceDetails(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6));
            cursor.moveToNext();
        }
        return AllowanceDetail;
    }
    public ArrayList <visit> getVisitsByfamilyID(String familyID){
        ArrayList <visit> visits = new ArrayList<visit>();
        SQLiteDatabase database = super.getReadableDatabase();
        Cursor cursor = database.query("visits", null, "FamilyID" +" = ?", new String[]{familyID}, null, null, null, null);
        while(!cursor.isAfterLast()){;
            visit Visit ;
            if(cursor.getString(2).equalsIgnoreCase("lastvisit")) {
                Visit = new visit(cursor.getString(1),visit.visittype.lastvisit, cursor.getString(3), cursor.getString(4));
            }else{
                Visit = new visit(cursor.getString(1),visit.visittype.nextvisit, cursor.getString(3), cursor.getString(4));
            }

            visits.add(Visit);
            cursor.moveToNext();
        }
        return visits;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
