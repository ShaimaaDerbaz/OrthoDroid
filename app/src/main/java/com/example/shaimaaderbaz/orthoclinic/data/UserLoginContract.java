package com.example.shaimaaderbaz.orthoclinic.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Shaimaa Derbaz on 10/22/2018.
 */

public final class UserLoginContract {

    private UserLoginContract() {}

    public static class  UserLoginEntry implements BaseColumns {
        public static final String TABLE_NAME = "userlogin";



        public static final String _ID= BaseColumns._ID;
        public static final String COLUMN_Username="username";
        public static final String COLUMN_Password="Password";


        public static final String CONTENT_AUTHORITY = "com.example.shaimaaderbaz.orthoclinic.userlogin";
        public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);//the basic to use and mke append to it
        public static final String PATH_PRODUCTS = "userlogin";
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PRODUCTS);

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/contact";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/contact";
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PRODUCTS;




    }
    }
