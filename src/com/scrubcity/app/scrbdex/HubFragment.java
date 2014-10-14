package com.scrubcity.app.scrbdex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A placeholder fragment containing a simple view.
 */
public class HubFragment extends Fragment {

	public HubFragment() {
	}
	
	private ArrayAdapter<String> hubListAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		String[] actions = {
				"View Scrubs",
				"View Political Campaigns",
				"Run for Mayor",
				"Vote for Yourself"
				};
		List<String> actionList = new ArrayList<String>(Arrays.asList(actions));
		
		hubListAdapter = new ArrayAdapter<String>(
                        getActivity(),
                        R.layout.list_item_hub,
                        R.id.list_item_hub_textview,
                        actionList);
		
		View rootView = inflater.inflate(R.layout.fragment_hub, container,
				false);
		
        ListView listView = (ListView) rootView.findViewById(R.id.listview_hub);
        listView.setAdapter(hubListAdapter);

		return rootView;
	}
}