package com.example.customlistview_bloodgroup;

public class PersonConstants {


    public static final String DB_NAME = "Person.db";
    public static final String DB_TABLE = "Person_table";
    public final int DATABASE_VERSION=1;

    //COLUMNS
    public static final String ID = "ID";
    public static final String NAME = "NAME";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String BLOOD = "BLOOD_GRP";
    public static final String URL = "URL";

    public static final String CREATE_TABLE= "CREATE TABLE "+DB_TABLE+"( "+
            NAME +" TEXT,"+
            DESCRIPTION + " TEXT,"+
            BLOOD + " TEXT, "+
            URL + " TEXT "+
            ")"
            ;

}
