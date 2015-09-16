package in.ac.srmuniv.broadcastreciver;

import in.ac.srmuniv.broadcastreciver.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;


import android.widget.Toast;

public class WallPaperNotificationReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		sendNotification(context, "You have changed Wallpaper");
    }
    private void sendNotification(Context ctx, String message)
    {
    	//Get the notification manager
    	//String ns = Context.NOTIFICATION_SERVICE;
    	NotificationManager nm = 
    		(NotificationManager)ctx.getSystemService(Context.NOTIFICATION_SERVICE);
    	
    	//Create Notification Object
		int icon = R.drawable.ic_launcher;
		CharSequence tickerText = "Hello";
		long when = System.currentTimeMillis();
		
		Notification notification = 
			new Notification(icon, tickerText, when);

		//Set ContentView using setLatestEvenInfo
	    Intent intent = new Intent(Intent.ACTION_VIEW);
	    intent.setData(Uri.parse("http://www.srmuniv.ac.in"));
	    PendingIntent pi = PendingIntent.getActivity(ctx, 0, intent, 0);
	    notification.setLatestEventInfo(ctx, "Intimation", message, pi);
	  		
	    //Send notification
		nm.notify(1, notification);
		Toast.makeText(ctx,message,Toast.LENGTH_LONG).show();
    }

}
