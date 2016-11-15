package development.alberto.com.msm_task.app.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.JsonReader;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 *
 */
public class ConnectionManager {
	private HttpURLConnection httpConnection = null;
	private URL url = null;
	private InputStream is = null;
	private JsonReader jsonReader = null;
	
	private Context context;
	
	
	public ConnectionManager(Context context){
		this.context = context;
	}

	private boolean isNetworkAvailable() {
		ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
		return (networkInfo != null && networkInfo.isConnected());
	}
}
