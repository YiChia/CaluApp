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
	int A=0; //�x�s��J�ƭ�
	int B=0; //�x�s�W����J�ƭ�
	int C=0; //�W����J�ƭȻP������J�ƭ�
	String S="";
	//save �`���O
	SharedPreferences saveInt;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cost_xml);
		
		//save data
		
		
		//Ū��
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
                 //�⦡
				 C=A+B;
				 B=C;
				 A=0;
			//	A+=dollar;
				
				//show
				TextView result=(TextView) findViewById(R.id.result);
				result.setText("�����b��"+String.valueOf(dollar)+"��");
				
				//�M����J�檺�Ʀr
				Money.setText(null);
				
				//�x�s���n�]�w
				
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
				
				//�N���B�ഫ���r��
				S+=String.valueOf(C);
				
				
				Intent intent = new Intent();
			//	intent.setClass(Calu.this, MainActivity.class);
				intent.setClass(Calu.this, Total.class);
				
				//�ǭ�
				
				Bundle bundle=new Bundle();
				bundle.putString("S", S);
				intent.putExtras(bundle);
			
				
				
				startActivity(intent);
				Calu.this.finish();
				

				
			}
			
			
			
		});
		
	}


}
