package com.goeuro.searchform.ui.adapters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.goeuro.searchform.R;
import com.goeuro.searchform.common.network.SearchRequest;
import com.goeuro.searchform.models.dto.Trip;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

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
 
    static class ViewHolder {
        public TextView autocompleteTextView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	 View row = convertView;
         ViewHolder holder = new ViewHolder();
         if (row == null) {
             row = LayoutInflater.from(mContext).inflate(R.layout.autocomplete_list_item,parent, false);
     
        if (position != (resultList.size() - 1)) {
            holder.autocompleteTextView = (TextView) row.findViewById(R.id.autocompleteText);
            holder.autocompleteTextView.setText(resultList.get(position).getFullName());
        }
         } else {
             holder = (ViewHolder) row.getTag();
         }
     
         row.setTag(holder);
         return row;
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
//                	Collections.sort(results.values, new CustomComparator());

                    notifyDataSetChanged();
                }
                else {
//                	Collections.sort(results.values, new CustomComparator());
                    notifyDataSetInvalidated();
                }
            }
        };
 
        return filter;
    }

//    public class CustomComparator implements Comparator<YOUROBJECTCLASSNAME> {
//        @Override
//        public int compare(YOUROBJECTCLASSNAME o1, YOUROBJECTCLASSNAME o2) {
//            return Double.compare(o1.getdistance,o2.getdistance);
//        }
//    } 
}