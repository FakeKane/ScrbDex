package com.scrubcity.app.scrbdex;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new ViewFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class ViewFragment extends Fragment {

		private ArrayAdapter<String> viewAdapter;
		
		public ViewFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_view, container,
					false);
			List<String> scrubs = new ArrayList<String>();
			scrubs.add("New Scrub");
			viewAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_scrubs, R.id.list_item_scrubs, scrubs);
			ListView listView = (ListView) rootView.findViewById(R.id.list_item_scrubs);
			listView.setAdapter(viewAdapter);
			listView.setOnItemClickListener(new AdapterView.OnItemClickListener() 
			{
				@Override
				public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
				{
					String scrubName = viewAdapter.getItem(position);
					Intent detailIntent = new Intent(getActivity(), DetailActivity.class).putExtra(Intent.EXTRA_TEXT, scrubName);
					startActivity(detailIntent);
				}
			});
			
			return rootView;
		}
	}
}
