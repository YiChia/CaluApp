package com.example.mycal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Total extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.total_xml);
		
		//gotMoney
		
		Bundle Money=this.getIntent().getExtras();
		//int tal=Money.getInt("Total");
		String c=Money.getString("S");
		
		//show
		
		//show
		TextView MoneyS=(TextView) findViewById(R.id.total_txtnum);
		MoneyS.setText(c+"¤¸");

		Button totalback = (Button) findViewById(R.id.toatlbtn_back);

		totalback.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent ToMain = new Intent();
				ToMain.setClass(Total.this, MainActivity.class);
				startActivity(ToMain);
				Total.this.finish();

			}

		});

	}

}
