package id.dicoding.mirel.dts_ujianpraktek;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {

    public  static String DATABAE_NAME = "mahasuiswa.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_STUDENT = "mahasiswa";
    private static final String KEY_ID ="id";
    private static final String KEY_NAME = "name";

    private static final String CREATE_TABLE_STUDENT =" CREATE TABLE " + TABLE_STUDENT + "(" + KEY_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+
            KEY_NAME+" TEXT);";

    public DbHelper(Context context){
        super(context,DATABAE_NAME,null,DATABASE_VERSION);
        Log.d("table ",CREATE_TABLE_STUDENT);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUDENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '"+ TABLE_STUDENT + "'");
        onCreate(db);
    }
    public long adddetail(String student){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,student);
        long insert = db.insert(TABLE_STUDENT, null,values);

        return insert;
    }

    public ArrayList<String> getStudent(){
        ArrayList<String> studentArrayList = new ArrayList<String>();
        String name ;
        String selectQuery = " SELECT * FROM " + TABLE_STUDENT;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery,null);

        if(c.moveToFirst()){
            do{
                name = c.getString(c.getColumnIndex(KEY_NAME));
                studentArrayList.add(name);
            }while (c.moveToNext());
            Log.d("array", studentArrayList.toString());


        }
        return  studentArrayList;
    }
}