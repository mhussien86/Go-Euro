package com.goeuro.searchform.common.network;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import com.goeuro.searchform.common.constants.AppConstants;
import com.goeuro.searchform.common.util.LocaleUtility;
import com.goeuro.searchform.models.dto.Trip;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SearchRequest {


	private static final String TAG = SearchRequest.class.getSimpleName();

	    public ArrayList<Trip> autocomplete (Context mContext,String input) {
	        ArrayList<Trip> resultList = null;
	 
	        HttpURLConnection conn = null;
	        StringBuilder jsonResults = new StringBuilder();
	 
	        try {
	            StringBuilder sb = new StringBuilder(AppConstants.WEB_SERVICES_BASE_URL +LocaleUtility.getLocale(mContext) +"/"+ input);
	            URL url = new URL(sb.toString());
	            conn = (HttpURLConnection) url.openConnection();
	            InputStreamReader in = new InputStreamReader(conn.getInputStream());
	 
	            // Load the results into a StringBuilder
	            int read;
	            char[] buff = new char[1024];
	            while ((read = in.read(buff)) != -1) {
	                jsonResults.append(buff, 0, read);
	            }
	        } catch (MalformedURLException e) {
	            Log.e(TAG, "Error processing Places API URL", e);
	            return resultList;
	        } catch (IOException e) {
	            Log.e(TAG, "Error connecting to Places API", e);
	            return resultList;
	        } finally {
	            if (conn != null) {
	                conn.disconnect();
	            }
	        }
	 
	        Log.d(TAG, jsonResults.toString());
 
			 Gson gson = new Gson();          
			 Type listOfTestObject = new TypeToken<List<Trip>>(){}.getType();
			 resultList = gson.fromJson(jsonResults.toString(), listOfTestObject);

	        return resultList;
	    }
	
	
	
//	private void makeSearchReq(String locale, String term) {
//        
//		
//		
//        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, AppConstants.WEB_SERVICES_BASE_URL+locale+"/"+term, null,
//                new Response.Listener<JSONObject>() {
//
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.d("Response", response.toString());
//                        Gson gson = new Gson();
////                        Products products = gson.fromJson(response.toString(), Products.class);
//
////                        updateUI(products);
//                    }
//                }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                VolleyLog.d("Error", "Error: " + error.getMessage());
//
//            }
//        }) {
//
//        };
//
//        // Adding request to request queue
//        AppController.getInstance().addToRequestQueue(jsonObjReq,
//                tag_json_obj);
//
//	}
}
