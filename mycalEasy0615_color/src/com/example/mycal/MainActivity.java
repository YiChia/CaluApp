package com.example.mycal;

import java.util.Calendar;






import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.CalendarView.OnDateChangeListener;
//import android.app.AlertDialog.Builder;
//import android.widget.Toast;

public class MainActivity extends Activity {
	private CalendarView cv;
	private TextView tv;
    int Myear,Mmonth,Mday;
    int cost;
    int B=0;
    String MM="";
    String a;
   
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv=(TextView)findViewById(R.id.tv);
		init();		
		cv=(CalendarView)findViewById(R.id.cv);		
		cv.setOnDateChangeListener(listener);
		
		/*
		//read cost Dollars
		Bundle bunC=this.getIntent().getExtras();
		String MM=bunC.getString("S");
		a+=MM;
		*/
		Button toGi=(Button) findViewById(R.id.main_btn);
		
		toGi.setOnClickListener(new Button.OnClickListener(){
			
			
			
			

			@Override
			public void onClick(View v) {
				
				
				Intent inte=new Intent();
				
				inte.setClass(MainActivity.this, Total.class);
				
				//傳值給total
				/*
                Bundle toT=new Bundle();
             //   toT.putInt("Total", B);
                toT.putString("otal",a );
				intent.putExtras(toT);
				*/
				startActivity(inte);
				MainActivity.this.finish();
				
				
				
				
			}

		
			
			
		} );
		
		
		
	}
	
	public void init()
	{
		Calendar c=Calendar.getInstance();
		int year=c.get(Calendar.YEAR);
		int Mmonth=c.get(Calendar.MONTH);
		int Mday=c.get(Calendar.DATE);
		tv.setText(new StringBuilder().append(year)
				 .append("-").append(Mmonth + 1).append("-").append(Mday));
	}
	
OnDateChangeListener listener=new OnDateChangeListener() {
		
		@Override
		public void onSelectedDayChange(CalendarView view, int year, int month,
				int dayOfMonth) {
			// TODO Auto-generated method stub			
			 Myear = year;
			 Mmonth = month + 1;
			 Mday = dayOfMonth;
			 tv.setText(new StringBuilder().append(Myear)
					 .append("-").append(Mmonth).append("-").append(Mday));
			 
			 String date = Myear + "年" + Mmonth + "月" + Mday + "日" ;
			 //Toast.makeText(getApplicationContext(), date, 0 ).show();
			 
			 AlertDialog.Builder addDi = new AlertDialog.Builder(MainActivity.this);
			 addDi.setMessage(date);
			 
			 DialogInterface.OnClickListener OkClick = new DialogInterface.OnClickListener()
			 {
			 public void onClick(DialogInterface dialog, int which) {
				 
				 Intent intent=new Intent();
				 intent.setClass(MainActivity.this, Calu.class);
				 startActivity(intent);
				 MainActivity.this.finish();
				 
				 
				 
			 }
			 };
			 addDi.setNeutralButton("開始記帳",OkClick );
			 addDi.show();
			 
			 //addDi.show();
			 
		}
		
		
	};
	
	
	
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
