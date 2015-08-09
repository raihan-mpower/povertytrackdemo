package com.android.trackermenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
//import android.support.v4.app.Fragment;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MyFamilies extends Fragment {
	
	public MyFamilies(){}
	
	String[] listContent = {
			 
            "Rahim",
 
            "Rumman",
 
            "Roni",
 
            "Robin",
 
            "Asif",
 
            "Karim",
 
            "Jobbar",
 
            "Kuddus",
 
            "Morjina",
 
            "Jorina",
 
            "Agdum",
 
            "Bagdum"
 
    };
	 
	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        final View rootView = inflater.inflate(R.layout.fragment_myfamilies, container, false);
        
        ListView listView = (ListView) rootView.findViewById(R.id.mylist); 
       
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_list_item_1,listContent);
//
//
        UsersAdapter uad = new UsersAdapter(rootView.getContext());
        listView.setAdapter(uad);

        uad.notifyDataSetChanged();
        return rootView;
    }
    public class UsersAdapter extends ArrayAdapter {
        public UsersAdapter(Context context) {
            super(context, R.layout.item_user);
        }
        @Override
         public int getCount(){
            return 5;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position

            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, null, false);
            }
            convertView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getActivity(),PersonDetails.class));
                }
            });
            // Lookup view for data population
//            TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
//            TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
//            // Populate the data into the template view using the data object
//            tvName.setText(user.name);
//            tvHome.setText(user.hometown);
            // Return the completed view to render on screen
            return convertView;
        }
    }

}
