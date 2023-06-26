package com.example.first;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;

public class FebActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    public static final String SHARED_PREFS1 = "sharedPrefs1";
    public static final String TEXT1 = "text1";
    public static final String SUM = "sum";
    private String text1;

    Button addBtn,return1;
    EditText editDate,editAmount;
    TextView tv,totalAmountView,dateView;
    ArrayList<ModelClass> arrayList;
    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        dateView = findViewById(R.id.dateView);
        tv = findViewById(R.id.vieww);
        editDate = findViewById(R.id.showSelected);
        editAmount = findViewById(R.id.editAmount);
        totalAmountView = findViewById(R.id.totalAmountView);
        addBtn = findViewById(R.id.addBtn);
        return1 = findViewById(R.id.return1);
        loadData();
        updateDateView();
        return1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FebActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData(editDate.getText().toString(),editAmount.getText().toString(),dateView.getText().toString());
            }
        });
    }
    private void loadData() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("DATA2",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("dates2", null);

        Type type = new TypeToken<ArrayList<ModelClass>>(){}.getType();
        arrayList = gson.fromJson(json,type);
        if(arrayList==null){
            arrayList=new ArrayList<>();
            tv.setText(""+0);
        }else{
            for(int i=0;i<arrayList.size();i++){
                tv.setText(tv.getText().toString()+"\n"+arrayList.get(i).data+"   "+arrayList.get(i).date +"  "+arrayList.get(i).amount);
            }
        }
    }
    public void saveData(String date, String amount,String data) {

        SharedPreferences sharedPreferences1 =getSharedPreferences(SHARED_PREFS1,MODE_PRIVATE);
        text1 = sharedPreferences1.getString(TEXT1,"0");
        int i = Integer.parseInt(amount);
        sum = Integer.parseInt(text1);
        sum = sum + i;
        totalAmountView.setText(String.valueOf(sum));

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("DATA2",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        SharedPreferences.Editor editor1 = sharedPreferences1.edit();
        editor1.putString(TEXT1, String.valueOf(sum));
        editor1.apply();
        Gson gson = new Gson();
        arrayList.add(new ModelClass(date, Integer.parseInt(amount),data));
        String json = gson.toJson(arrayList);
        editor.putString("dates2",json);
        editor.apply();
        tv.setText("List Data \n");
        loadData();
    }
    public void showPopup(View view) {
        PopupMenu popup = new PopupMenu(this,view);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.food:
                editDate.setText("Food");
                return true;
            case R.id.clothes:
                editDate.setText("Clothes");
                return true;
            case R.id.entertainment:
                editDate.setText("Entertainment");
                return true;
            case R.id.electronics:
                editDate.setText("Electronics");
                return true;
            case R.id.transport:
                editDate.setText("Transport");
                return true;
            case R.id.misc:
                editDate.setText("Miscellaneous");
                return true;
            default:
                return false;
        }
    }
    final Calendar c = Calendar.getInstance();



    private void updateDateView(){
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        dateView.setText(new StringBuilder().append(mDay).append("/").append(mMonth+1).append("/").append(mYear));


    }
}
