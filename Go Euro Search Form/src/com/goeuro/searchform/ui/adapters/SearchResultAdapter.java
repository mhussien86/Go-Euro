package com.goeuro.searchform.ui.adapters;

import java.util.ArrayList;
import com.goeuro.searchform.common.network.SearchRequest;
import com.goeuro.searchform.common.util.LocaleUtility;
import com.goeuro.searchform.models.dto.Trip;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;

public class SearchResultAdapter extends ArrayAdapter<Trip> implements Filterable {
 
    public SearchResultAdapter(Context context, int resource) {
		super(context, resource);
		   mContext = context;
	       mResource = resource;
	}

	ArrayList<Trip> resultList;
 
    Context mContext;
    int mResource;
     
    SearchRequest searchRequest = new SearchRequest();
 
 
    @Override
    public int getCount() {
        // Last item will be the footer
        return resultList.size();
    }
 
    @Override
    public Trip getItem(int position) {
        return resultList.get(position);
    }
 
    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint != null) {
                    resultList = searchRequest.autocomplete(mContext, constraint.toString());
                    filterResults.values = resultList;
                    filterResults.count = resultList.size();
                }
 
                return filterResults;
            }
 
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.count > 0) {
                    notifyDataSetChanged();
                }
                else {
                    notifyDataSetInvalidated();
                }
            }
        };
 
        return filter;
    }
}