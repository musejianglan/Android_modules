package com.promise.bluetoothdemo;

import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.ParcelUuid;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BlueToothAdapter extends BaseAdapter {

	Context context;
	List<BluetoothDevice> devices;

	public BlueToothAdapter(Context context, List<BluetoothDevice> devices) {
		this.context = context;
		this.devices = devices;
	}

	public void setDevices(List<BluetoothDevice> devices) {
		this.devices = devices;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return devices.size();
	}

	@Override
	public BluetoothDevice getItem(int i) {
		return devices.get(i);
	}

	@Override
	public long getItemId(int i) {
		return i;
	}

	@Override
	public View getView(int i, View view, ViewGroup viewGroup) {
		ViewHolder viewHolder;
		if (view == null) {
			view = LayoutInflater.from(context).inflate(R.layout.item_bluetooth_device_info,null);
			viewHolder = new ViewHolder(view);
			view.setTag(viewHolder);
		}else{
			viewHolder = (ViewHolder) view.getTag();
		}

		BluetoothDevice bluetoothDevice = devices.get(i);

		viewHolder.name.setText(bluetoothDevice.getName());
		viewHolder.mac.setText(bluetoothDevice.getAddress());
		ParcelUuid[] uuids = bluetoothDevice.getUuids();
		if (uuids!= null && uuids.length > 0) {
			viewHolder.uuid.setVisibility(View.VISIBLE);
			viewHolder.uuid.setText(uuids.toString());
		}else {
			viewHolder.uuid.setVisibility(View.GONE);
		}



		return view;
	}

	class ViewHolder{

		View view;
//		@BindView(R.id.tv_name)
		TextView name;
//		@BindView(R.id.tv_mac)
		TextView mac;
//		@BindView(R.id.tv_uuid)
		TextView uuid;

		public ViewHolder(View view) {
			this.view = view;
//			ButterKnife.bind(view);
			name = view.findViewById(R.id.tv_name);
			mac = view.findViewById(R.id.tv_mac);
			uuid = view.findViewById(R.id.tv_uuid);
		}
	}
}
