package com.example.mycal;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Calu extends Activity {
	
	Button Numsave;
	int A=0; //儲存輸入數值
	int B=0; //儲存上次輸入數值
	int C=0; //上次輸入數值與本次輸入數值
	String S="";
	//save 總消費
	SharedPreferences saveInt;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cost_xml);
		
		//save data
		
		
		//讀取
		SharedPreferences saveInt=getSharedPreferences("PREF_DEMO", 0);
	//	 int getInt (String key, int defValue)
		 B=saveInt.getInt("numB", 0);
		
		Button Numsave =(Button)findViewById(R.id.cost_btn);
		
		Numsave.setOnClickListener(new OnClickListener(){
			

			@Override
			public void onClick(View v) {
				
				//got dollar
				EditText Money=(EditText) findViewById(R.id.calu_edittxt);
				
				
				//count
				int dollar=Integer.parseInt(Money.getText().toString());
				
                 A += dollar;
                 //算式
				 C=A+B;
				 B=C;
				 A=0;
			//	A+=dollar;
				
				//show
				TextView result=(TextView) findViewById(R.id.result);
				result.setText("此次帳目"+String.valueOf(dollar)+"元");
				
				//清除輸入欄的數字
				Money.setText(null);
				
				//儲存偏好設定
				
				SharedPreferences saveInt=getSharedPreferences("PREF_DEMO", 0);
				SharedPreferences.Editor editor=saveInt.edit();
				editor.putInt("numB", B);
				editor.commit();
		
				
			}
			
			
			
		});
		

		
		Button back=(Button) findViewById(R.id.back_Main);
		back.setOnClickListener(new Button.OnClickListener(){
			

			@Override
			public void onClick(View v) {
				
				//將金額轉換為字串
				S+=String.valueOf(C);
				
				
				Intent intent = new Intent();
			//	intent.setClass(Calu.this, MainActivity.class);
				intent.setClass(Calu.this, Total.class);
				
				//傳值
				
				Bundle bundle=new Bundle();
				bundle.putString("S", S);
				intent.putExtras(bundle);
			
				
				
				startActivity(intent);
				Calu.this.finish();
				

				
			}
			
			
			
		});
		
	}


}
