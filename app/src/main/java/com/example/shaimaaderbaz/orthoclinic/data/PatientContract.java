package com.example.shaimaaderbaz.orthoclinic.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Shaimaa Derbaz on 10/2/2018.
 */

public final class PatientContract {

    private PatientContract() {}

    public static class PatientEntry implements BaseColumns {
        public static final String TABLE_NAME = "patients";



        public static final String _ID= BaseColumns._ID;
        public static final String COLUMN_p_serv_id="pServId";
        public static final String COLUMN_p_id="p_id";
        public static final String COLUMN_patientName="patientName" ;
        public static final String COLUMN_occup ="occup";
        public static final String COLUMN_info="info";
        public static final String COLUMN_created_date="created_date";
        public static final String COLUMN_updated_date="updated_date";
        public static final String COLUMN_age ="age";
        public static final String COLUMN_weight ="weight";
        public static final String COLUMN_flag ="flag";


        public static final String CONTENT_AUTHORITY = "com.example.shaimaaderbaz.orthoclinic.patient";
        public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);//the basic to use and mke append to it
        public static final String PATH_PRODUCTS = "patients";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PRODUCTS);

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contact";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact";
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCTS;




    }
    }
