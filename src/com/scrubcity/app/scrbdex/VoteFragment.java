package com.scrubcity.app.scrbdex;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class VoteFragment extends Fragment {
	
	int count = 0;
	TextView textView;

	public VoteFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_vote, container,
				false);
		
		textView = (TextView) rootView.findViewById(R.id.vote_count);
		textView.setOnClickListener(voteClick);
		
		return rootView;
	}
	View.OnClickListener voteClick = new View.OnClickListener() {
	    public void onClick(View v) {
	      count++;
	      textView.setText(Integer.toString(count));
	    }
	  };
}