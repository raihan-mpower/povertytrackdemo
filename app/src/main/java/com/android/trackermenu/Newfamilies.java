package com.android.trackermenu;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.trackermenu.datamodel.family;
import com.android.trackermenu.repository.RecordRepository;

public class Newfamilies extends Fragment {
    public EditText hhname,hhid,hhage,number_of_children,children_in_between;
	public RadioGroup hhgender,hhcivil_status;
    public Button save;
    public static String UserID;
    public Newfamilies(){

    }


	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.newfamilies, container, false);

        hhname = (EditText)rootView.findViewById(R.id.hhname);
        hhid = (EditText)rootView.findViewById(R.id.hhid);
        hhage = (EditText)rootView.findViewById(R.id.hhage);
        number_of_children = (EditText)rootView.findViewById(R.id.number_of_children);
        children_in_between = (EditText)rootView.findViewById(R.id.children_in_between);
        hhgender = (RadioGroup)rootView.findViewById(R.id.hhgender);
        hhcivil_status = (RadioGroup)rootView.findViewById(R.id.hhcivilstatus);
        final String civil_status = ((RadioButton)rootView.findViewById(hhcivil_status.getCheckedRadioButtonId())).getText().toString();
        final String gender=  ((RadioButton)rootView.findViewById(hhgender.getCheckedRadioButtonId())).getText().toString();
        Button save = (Button)rootView.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                family Family = new family(UserID,"",hhname.getEditableText().toString(),hhid.getEditableText().toString(),hhage.getEditableText().toString(),gender,civil_status,number_of_children.getEditableText().toString(),children_in_between.getEditableText().toString());
                RecordRepository records = new RecordRepository(getActivity());
                records.insertTOTable("family", records.createContentValuesForfamily(Family));
                Intent I = new Intent(getActivity(), MainActivity.class);
                startActivity(I);
            }
        });
     
         
        return rootView;
    }
}
