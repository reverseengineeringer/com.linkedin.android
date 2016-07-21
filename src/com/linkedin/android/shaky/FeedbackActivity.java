package com.linkedin.android.shaky;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.FileProvider;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;

public class FeedbackActivity
  extends AppCompatActivity
{
  private static final String EXTRA_ATTACHMENTS = "ExtraAttachments";
  private static final String EXTRA_DEBUG_INFO = "ExtraDebugInfo";
  private static final String EXTRA_RECIPIENTS = "ExtraRecipients";
  private static final String EXTRA_SCREENSHOT_URI = "ExtraScreenshotUri";
  private ArrayList<Uri> attachments;
  private String debugInfo;
  private Uri imageUri;
  private final BroadcastReceiver receiver = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      int i;
      if ("ActionFeedbackTypeSelected".equals(paramAnonymousIntent.getAction()))
      {
        i = paramAnonymousIntent.getIntExtra("ExtraFeedbackType", 2);
        if ((imageUri != null) && (i == 0)) {
          FeedbackActivity.this.startDrawFragment();
        }
      }
      do
      {
        return;
        FeedbackActivity.this.startFormFragment(i);
        return;
        if ("ActionDrawingComplete".equals(paramAnonymousIntent.getAction()))
        {
          FeedbackActivity.this.startFormFragment(0);
          return;
        }
      } while (!"ActionSubmitFeedback".equals(paramAnonymousIntent.getAction()));
      FeedbackActivity.this.submitFeedbackIntent(paramAnonymousIntent.getStringExtra("ExtraUserMessage"));
    }
  };
  private String[] recipientEmails;
  
  private void changeToFragment(Fragment paramFragment)
  {
    getSupportFragmentManager().beginTransaction().setTransition$9d93138().replace(R.id.fragment_container, paramFragment).addToBackStack(null).commit();
  }
  
  private static String generateFeedbackId()
  {
    return Long.toString(Calendar.getInstance().getTimeInMillis());
  }
  
  private static Uri getProviderUri(Context paramContext, File paramFile)
  {
    return FileProvider.getUriForFile(paramContext, paramContext.getPackageName() + ".fileprovider", paramFile);
  }
  
  public static Intent newIntent(Context paramContext, String[] paramArrayOfString, Uri paramUri, String paramString, ArrayList<Uri> paramArrayList)
  {
    paramContext = new Intent(paramContext, FeedbackActivity.class);
    paramContext.putExtra("ExtraRecipients", paramArrayOfString);
    paramContext.putExtra("ExtraScreenshotUri", paramUri);
    paramContext.putExtra("ExtraDebugInfo", paramString);
    paramContext.putExtra("ExtraAttachments", paramArrayList);
    return paramContext;
  }
  
  private void startDrawFragment()
  {
    changeToFragment(DrawFragment.newInstance(imageUri));
  }
  
  private void startFormFragment(int paramInt)
  {
    changeToFragment(FormFragment.newInstance(imageUri, paramInt));
  }
  
  private void submitFeedbackIntent(String paramString)
  {
    Intent localIntent = new Intent("android.intent.action.SEND_MULTIPLE");
    localIntent.setType("plain/text");
    localIntent.putExtra("android.intent.extra.EMAIL", recipientEmails);
    localIntent.putExtra("android.intent.extra.SUBJECT", "Android Feedback " + generateFeedbackId());
    Object localObject = new StringBuilder();
    if (paramString != null)
    {
      localIntent.putExtra("android.intent.extra.TEXT", paramString + "\n\n----------\n\n" + debugInfo);
      localObject = new ArrayList(attachments);
      if (imageUri == null) {
        break label173;
      }
    }
    label173:
    for (paramString = imageUri.getPath();; paramString = null)
    {
      if (paramString != null) {
        ((ArrayList)localObject).add(getProviderUri(this, new File(paramString)));
      }
      localIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", (ArrayList)localObject);
      localIntent.putExtra("android.intent.extra.TITLE", "Send feedback");
      startActivity(localIntent);
      finish();
      return;
      paramString = "";
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.shaky_feedback);
    imageUri = ((Uri)getIntent().getParcelableExtra("ExtraScreenshotUri"));
    debugInfo = getIntent().getStringExtra("ExtraDebugInfo");
    recipientEmails = getIntent().getStringArrayExtra("ExtraRecipients");
    attachments = getIntent().getParcelableArrayListExtra("ExtraAttachments");
    if (paramBundle == null) {
      getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, new SelectFragment()).commit();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
  }
  
  protected void onResumeFragments()
  {
    super.onResumeFragments();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("ActionFeedbackTypeSelected");
    localIntentFilter.addAction("ActionDrawingComplete");
    localIntentFilter.addAction("ActionSubmitFeedback");
    LocalBroadcastManager.getInstance(this).registerReceiver(receiver, localIntentFilter);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.shaky.FeedbackActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */