package cl.ubiobio.nicolas.mark50;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;



public class MainActivity extends AppCompatActivity {

    GridLayout mainGrid;

    TextView tv;
    Calendar mCurrentDate;
    int day, month, year;
    static String auxfecha;
    String numero="";
    int numeroAux1=0;

    String enero="01-01-2018";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCurrentDate = Calendar.getInstance();
        day=mCurrentDate.get(Calendar.DAY_OF_MONTH);
        month=mCurrentDate.get(Calendar.MONTH);
        year=mCurrentDate.get(Calendar.YEAR);

        tv =(TextView) findViewById(R.id.textView11);

        tv.setText("Ingrese su fecha de nacimiento");





        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfyear, int dayOfMonth) {
                        monthOfyear=monthOfyear+1;

                        if(dayOfMonth<10&&monthOfyear<10){
                            tv.setText("0"+dayOfMonth+"0"+monthOfyear+""+year);
                            auxfecha=("0"+dayOfMonth+"0"+monthOfyear+""+year);
                            numeroAux1=Integer.parseInt(auxfecha);
                        }
                        if (dayOfMonth<10&&monthOfyear>=10){
                            tv.setText("0"+dayOfMonth+""+monthOfyear+""+year);
                            auxfecha=("0"+dayOfMonth+""+monthOfyear+""+year);
                            numeroAux1=Integer.parseInt(auxfecha);
                        }
                        if(dayOfMonth>=10&&monthOfyear<10){
                            tv.setText(dayOfMonth+"0"+monthOfyear+""+year);
                            auxfecha=(dayOfMonth+"0"+monthOfyear+""+year);
                            numeroAux1=Integer.parseInt(auxfecha);
                        }
                        if(dayOfMonth>10&&monthOfyear>10){
                            tv.setText(dayOfMonth+""+monthOfyear+""+year);
                            auxfecha=(dayOfMonth+""+monthOfyear+""+year);
                            numeroAux1=Integer.parseInt(auxfecha);
                        }

                        if(dayOfMonth>=21&&monthOfyear==3||dayOfMonth<=20&&monthOfyear==4){
                            Intent horoscopo = new Intent(MainActivity.this, Aries.class);
                            startActivity(horoscopo);
                        }
                        if(dayOfMonth>=21&&monthOfyear==4||dayOfMonth<=20&&monthOfyear==5){
                            Intent horoscopo = new Intent(MainActivity.this, Tauro.class);
                            startActivity(horoscopo);
                        }
                        if(dayOfMonth>=21&&monthOfyear==5||dayOfMonth<=21&&monthOfyear==6){
                            Intent horoscopo = new Intent(MainActivity.this, Geminis.class);
                            startActivity(horoscopo);
                        }
                        if(dayOfMonth>=22&&monthOfyear==6||dayOfMonth<=22&&monthOfyear==7){
                            Intent horoscopo = new Intent(MainActivity.this, Cancer.class);
                            startActivity(horoscopo);
                        }
                        if(dayOfMonth>=23&&monthOfyear==7||dayOfMonth<=23&&monthOfyear==8){
                            Intent horoscopo = new Intent(MainActivity.this, Leo.class);
                            startActivity(horoscopo);
                        }
                        if(dayOfMonth>=24&&monthOfyear==8||dayOfMonth<=23&&monthOfyear==9){
                            Intent horoscopo = new Intent(MainActivity.this, Virgo.class);
                            startActivity(horoscopo);
                        }
                        if(dayOfMonth>=24&&monthOfyear==9||dayOfMonth<=22&&monthOfyear==10){
                            Intent horoscopo = new Intent(MainActivity.this, Libra.class);
                            startActivity(horoscopo);
                        }
                        if(dayOfMonth>=23&&monthOfyear==10||dayOfMonth<=22&&monthOfyear==11){
                            Intent horoscopo = new Intent(MainActivity.this, Escorpion.class);
                            startActivity(horoscopo);
                        }
                        if(dayOfMonth>=23&&monthOfyear==11||dayOfMonth<=21&&monthOfyear==12){
                            Intent horoscopo = new Intent(MainActivity.this, Sagitario.class);
                            startActivity(horoscopo);
                        }
                        if(dayOfMonth>=22&&monthOfyear==12||dayOfMonth<=19&&monthOfyear==1){
                            Intent horoscopo = new Intent(MainActivity.this, Capricornio.class);
                            startActivity(horoscopo);
                        }
                        if(dayOfMonth>=20&&monthOfyear==1||dayOfMonth<=19&&monthOfyear==2){
                            Intent horoscopo = new Intent(MainActivity.this, Acuario.class);
                            startActivity(horoscopo);
                        }
                        if(dayOfMonth>=20&&monthOfyear==2||dayOfMonth<=20&&monthOfyear==3){
                            Intent horoscopo = new Intent(MainActivity.this, Piscis.class);
                            startActivity(horoscopo);
                        }
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        /*mainGrid = (GridLayout)findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);*/
    }




    /*private void setSingleEvent(GridLayout mainGrid) {

        for (int i = 0; i <mainGrid.getChildCount(); i++)
        {
            CardView cardView = (CardView)mainGrid.getChildAt(i);
            final int finalI = i;

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (finalI ==1){

                        if(month==7){
                            Intent horoscopo = new Intent(MainActivity.this, Leo.class);
                            startActivity(horoscopo);
                            }
                        if(month==6){
                            Intent horoscopo = new Intent(MainActivity.this, Cancer.class);
                            startActivity(horoscopo);
                            }
                        if(month==5){
                            Intent horoscopo = new Intent(MainActivity.this, Geminis.class);
                            startActivity(horoscopo);
                        }


                    }

                     }
            });
           }

        }*/

}
