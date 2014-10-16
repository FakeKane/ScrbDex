package com.scrubcity.app.scrbdex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
		
		final String[] actions = {
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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
        	@Override
        	public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
        	{
        		String selected = hubListAdapter.getItem(position);
        		if (selected.equals(actions[0]))
        		{
        			Intent displayIntent = new Intent(getActivity(), ViewActivity.class);
        			startActivity(displayIntent);		
        		}
        		if (selected.equals(actions[3])){
        			Intent displayIntent = new Intent(getActivity(), VoteActivity.class);
        			startActivity(displayIntent);
        		}
        	}
		});
        
		return rootView;
	}
}