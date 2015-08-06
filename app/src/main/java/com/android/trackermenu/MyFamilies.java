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
       
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_list_item_1,listContent);
      
      
     
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {

            	
            	
            	Intent i = new Intent(rootView.getContext(), PersonDetails.class);
            	startActivity(i);

            }

        });
        return rootView;
    }


}
