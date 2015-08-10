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
import android.widget.Button;
import android.widget.ListView;
//import android.support.v4.app.Fragment;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.android.trackermenu.datamodel.family;
import com.android.trackermenu.repository.RecordRepository;

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

        UsersAdapter uad = new UsersAdapter(rootView.getContext(),new RecordRepository(getActivity()).getallfamilies());
        listView.setAdapter(uad);

        uad.notifyDataSetChanged();
        ((Button)rootView.findViewById(R.id.visitmap)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),mapactivity.class));
            }
        });
        return rootView;
    }
    public class UsersAdapter extends ArrayAdapter {
        ArrayList <family> families;
        public UsersAdapter(Context context,ArrayList<family> families) {
             super(context, R.layout.item_user);
            this.families = families;

        }
        @Override
         public int getCount(){
            return families.size() ;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // Get the data item for this position

            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, null, false);
            }
            convertView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    PersonDetails.Family = families.get(position);
                    startActivity(new Intent(getActivity(),PersonDetails.class));
                }
            });
            // Lookup view for data population
            TextView hhname = (TextView) convertView.findViewById(R.id.hhname);
            TextView visit = (TextView) convertView.findViewById(R.id.hh_astvisit);
//            // Populate the data into the template view using the data object
            hhname.setText(families.get(position).getNameHH());
            visit.setText("last visited 10/09/2015");
            // Return the completed view to render on screen
            return convertView;
        }
    }

}
