package com.goeuro.searchform.ui.activities;


import com.dd.processbutton.iml.ActionProcessButton;
import com.goeuro.searchform.R;
import com.goeuro.searchform.common.util.ProgressGenerator;
import com.goeuro.searchform.models.dto.Trip;
import com.goeuro.searchform.ui.adapters.SearchResultAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;


public class SearchFormActivity extends Activity implements ProgressGenerator.OnCompleteListener {

	AutoCompleteTextView fromEditText , toEditText ; 
	private static String TAG = SearchFormActivity.class.getSimpleName();
	 
//	private SearchResultAdapter mAdapter;
//	HandlerThread mHandlerThread;
//	Handler mThreadHandler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_form);
		initUI();
		
	}
	

	public void initUI(){
		
		fromEditText = (AutoCompleteTextView)findViewById(R.id.edit_txt_start_location);
		toEditText   = (AutoCompleteTextView)findViewById(R.id.edit_txt_end_location);

		SearchResultAdapter firstAdapter = new SearchResultAdapter(getApplicationContext(), R.layout.autocomplete_list_item);
		fromEditText.setAdapter(firstAdapter);

		fromEditText.setOnItemClickListener(new OnItemClickListener() {
		    @Override
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		        // Get data associated with the specified position

		        Trip country = (Trip) parent.getItemAtPosition(position);		        
		        String name = country.getFullName();
		        fromEditText.setText(name);
		        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
		    }
		});
		SearchResultAdapter secondAdapter = new SearchResultAdapter(getApplicationContext(), R.layout.autocomplete_list_item);
		toEditText.setAdapter(secondAdapter);
		toEditText.setOnItemClickListener(new OnItemClickListener() {
		    @Override
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		        // Get data associated with the specified position
		        // in the list (AdapterView)
		    	
		        Trip country = (Trip) parent.getItemAtPosition(position);
		        String name = country.getFullName();
		        toEditText.setText(name);
		        Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
		    }
		});
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
