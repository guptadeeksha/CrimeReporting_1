package com.example.crimereporting.Data;

import android.provider.BaseColumns;

public class ComplaintContract  {

    private ComplaintContract(){}

    public static final class userTable implements BaseColumns{

        public static final String TABLE_NAME = "USERS";

        public static final String E_MAIL = "EMAIL";
        public static final String NAME= "NAME";
        public static final String PASSWORD = "PASSWORD";
    }

    public static final class complainTable implements BaseColumns{

        public static final String TABLE_NAME = "COMPLAIN";

        public static final String _ID = BaseColumns._ID;
        public static final String E_MAIL = "EMAIL";
        public static final String VICTIM_NAME= "VICTIM_NAME";
        public static final String CRIME_TYPE = "CRIME_TYPE";
        public static final String POLICE_STATION = "POLICE_STATION";
        public static final String DESCRIPTION = "DESCRIPTION";
    }
}
