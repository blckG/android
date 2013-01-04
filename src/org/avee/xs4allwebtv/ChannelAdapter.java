package org.avee.xs4allwebtv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ChannelAdapter extends BaseAdapter {
	private ChannelInfo[] channels;
	Context context;
	
	public ChannelAdapter(Context context, ChannelInfo[] channels) {
		this.channels = channels;
		this.context = context;
	}

	@Override
	public int getCount() {
		return getChannels().length;
	}

	@Override
	public Object getItem(int position) {
		return getChannels()[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View result = convertView;
		if(result == null) {
			LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			result = vi.inflate(R.layout.channel_row, parent, false);
		}
		ChannelInfo channel = getChannels()[position];
		TextView txtName = (TextView) result.findViewById(R.id.txtChannelName);
		txtName.setText(channel.getChannelName());	
		ImageView img = (ImageView) result.findViewById(R.id.imgChannelLogo);
		img.setImageBitmap(channel.getLogoImage());
		TextView txtProgram = (TextView) result.findViewById(R.id.txtCurrentProgram);
		txtProgram.setText(channel.getCurrentProgram());	
		return result;
	}

	public ChannelInfo[] getChannels() {
		return channels;
	}
}