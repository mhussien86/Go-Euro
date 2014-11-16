package com.goeuro.searchform.ui.activities;

import com.dd.processbutton.iml.ActionProcessButton;
import com.goeuro.searchform.R;
import com.goeuro.searchform.common.util.ProgressGenerator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;


public class SearchFormActivity extends Activity implements ProgressGenerator.OnCompleteListener {

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_form);
		initUI();
		
	}
	
	
	public void initUI(){
		
		final ProgressGenerator progressGenerator = new ProgressGenerator(this);
		final ActionProcessButton btnSignIn = (ActionProcessButton) findViewById(R.id.search_btn);
		btnSignIn.setMode(ActionProcessButton.Mode.PROGRESS);
		btnSignIn.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				progressGenerator.start(btnSignIn);
				btnSignIn.setEnabled(false);

			}
		});
	}


	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		
		
		
	}
	
	
	
}
