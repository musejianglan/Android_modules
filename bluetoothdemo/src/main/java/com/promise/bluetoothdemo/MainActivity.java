package com.promise.bluetoothdemo;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

	static final String[] PERMISSIONS = new String[]{Manifest.permission.ACCESS_COARSE_LOCATION};

	List<String> mPermissionList = new ArrayList<>();

	private static final int PERMISSION_REQUEST_CODE = 0; // 系统权限管理页面的参数
	public static int OVERLAY_PERMISSION_REQ_CODE = 1000;
	private static final String PACKAGE_URL_SCHEME = "package:"; // 方案;

	/** ----------------------------------------------*/
	BluetoothAdapter mBluetoothAdapter;
	int REQUEST_ENABLE_BT = 2002;
	@BindView(R.id.bluetooth_status)
	TextView bluetooth_status;
	@BindView(R.id.bond_devices_list)
	ListView list_bond_devices;
//	ArrayAdapter arrayAdapter;
	List<BluetoothDevice> devices = new ArrayList<>();
	BlueToothAdapter blueToothAdapter;

	// Create a BroadcastReceiver for ACTION_FOUND
	private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			// When discovery finds a device
			if (BluetoothDevice.ACTION_FOUND.equals(action)) {
				// Get the BluetoothDevice object from the Intent

			}

			if (BluetoothDevice.ACTION_FOUND.equals(action)) {
				BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
				//避免重复添加已经绑定过的设备
				if (device.getBondState() != BluetoothDevice.BOND_BONDED) {
					//此处的adapter是列表的adapter，不是BluetoothAdapter
					// Add the name and address to an array adapter to show in a ListView
//					arrayAdapter.add("新发现的设备="+device.getName() + "的Mac地址=" + device.getAddress());
					devices.add(device);
					blueToothAdapter.setDevices(devices);
				}
			} else if (BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(action)) {
				Toast.makeText(MainActivity.this,"开始搜索",Toast.LENGTH_SHORT).show();
			} else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
				Toast.makeText(MainActivity.this,"搜索完毕",Toast.LENGTH_SHORT).show();
				mBluetoothAdapter.cancelDiscovery();
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		checkPermission();

//		arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1);
		blueToothAdapter = new BlueToothAdapter(MainActivity.this,devices);
		list_bond_devices.setAdapter(blueToothAdapter);

		// Register the BroadcastReceiver
		IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
		registerReceiver(mReceiver, filter); // Don't forget to unregister during onDestroy

		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

		list_bond_devices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
				if (mBluetoothAdapter.isDiscovering()) {
					mBluetoothAdapter.cancelDiscovery();
				}
				BluetoothDevice device = (BluetoothDevice) blueToothAdapter.getItem(i);
				//连接设备
				connectDevice(device);
			}
		});
	}

	private void connectDevice(BluetoothDevice device) {
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(mReceiver);
	}

	public void checkBlueTooth(View view) {


		if (mBluetoothAdapter != null) {//检查是否支持蓝牙功能

			if (mBluetoothAdapter.isEnabled()) {//判断蓝牙是否已经启动

				discoverableThisDevice();
//
				bluetooth_status.setText("该设备已打开蓝牙");
			}else {
				toast("该设备未启用蓝牙功能");
				//两种启动蓝牙的方式，建议第二种，可以通过onActivityResult得知结果，第一种需要系统广播监听开启结果
				// No.1
//				mBluetoothAdapter.enable();
				//No.2
				Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
				startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
			}
		}else {
			bluetooth_status.setText("该设备不支持蓝牙功能");
		}
	}

	private void discoverableThisDevice() {
		Intent discoverableIntent = new
				Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
		discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
		startActivity(discoverableIntent);
	}

	public void selectBondedDevice(View view) {
		devices.clear();
		Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
		// If there are paired devices
		if (pairedDevices.size() > 0) {
			// Loop through paired devices
			for (BluetoothDevice device : pairedDevices) {
				// Add the name and address to an array adapter to show in a ListView
//				arrayAdapter.add("已配对设备="+device.getName() + "的Mac地址=" + device.getAddress());

				devices.add(device);

			}
			blueToothAdapter.setDevices(devices);
		}
	}

	public void discover_new_device(View view) {
		mBluetoothAdapter.startDiscovery();
		devices.clear();
		blueToothAdapter.setDevices(devices);
	}


	public void otherBlueTooth(View view) {
		startActivity(new Intent(MainActivity.this,BluetoothActivity.class));
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == REQUEST_ENABLE_BT){

			switch (resultCode) {
				case RESULT_OK:
					bluetooth_status.setText("该设备打开蓝牙功能");
					discoverableThisDevice();
					break;
				case RESULT_CANCELED:
					bluetooth_status.setText("该设备禁止打开蓝牙");
					break;
			}

		}
	}

	//---------------------------------------------------------------

	private void checkPermission() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			mPermissionList.clear();
			//检查是否已获取权限
			for (int i = 0; i < PERMISSIONS.length; i++) {
				if (ContextCompat.checkSelfPermission(this, PERMISSIONS[i]) != PackageManager.PERMISSION_GRANTED) {
					mPermissionList.add(PERMISSIONS[i]);
				}
			}

			if (!mPermissionList.isEmpty()) {//获取权限
				String[] permissions = mPermissionList.toArray(new String[mPermissionList.size()]);//将List转为数组
				ActivityCompat.requestPermissions(MainActivity.this, permissions, PERMISSION_REQUEST_CODE);
			} else {
				toast("所需权限已全部获取");
			}

		}else {

			toast("Android版本小于23，获取动态获取权限");

		}
	}


	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);

		if (requestCode == PERMISSION_REQUEST_CODE) {
			for (int i = 0; i < grantResults.length; i++) {

				int grantResult = grantResults[i];
				if (grantResult != PackageManager.PERMISSION_GRANTED) {
					boolean showRequestPermission = ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, permissions[i]);
					if (showRequestPermission) {//
						judgePermission(i);//重新申请权限
						return;
					} else {
						showMissingPermissionDialog();//已经禁止
					}
				}
			}
		}else if (requestCode == OVERLAY_PERMISSION_REQ_CODE) {
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {
				toast("权限授予失败，无法开启悬浮窗");
			} else {
				toast("权限授予成功！");
			}

		}
	}

	// 显示缺失权限提示
	private void showMissingPermissionDialog() {
		android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(MainActivity.this);
		builder.setTitle(R.string.help);
		builder.setMessage(R.string.string_help_text);

		// 拒绝, 退出应用
		builder.setNegativeButton(R.string.quit, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();
			}
		});

		builder.setPositiveButton(R.string.settings, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				startAppSettings();
			}
		});

		builder.setCancelable(false);

		builder.show();
	}

	// 启动应用的设置
	private void startAppSettings() {
		Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
		intent.setData(Uri.parse(PACKAGE_URL_SCHEME + getPackageName()));
		startActivity(intent);
	}

	private void judgePermission(int i) {
		ActivityCompat.requestPermissions(MainActivity.this, new String[]{mPermissionList.get(i)}, PERMISSION_REQUEST_CODE);
	}
	private void toast(String msg) {
		Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
	}



}
