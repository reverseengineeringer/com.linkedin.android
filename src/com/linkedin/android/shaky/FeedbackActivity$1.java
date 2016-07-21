package com.linkedin.android.shaky;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class FeedbackActivity$1
  extends BroadcastReceiver
{
  FeedbackActivity$1(FeedbackActivity paramFeedbackActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i;
    if ("ActionFeedbackTypeSelected".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("ExtraFeedbackType", 2);
      if ((FeedbackActivity.access$000(this$0) != null) && (i == 0)) {
        FeedbackActivity.access$100(this$0);
      }
    }
    do
    {
      return;
      FeedbackActivity.access$200(this$0, i);
      return;
      if ("ActionDrawingComplete".equals(paramIntent.getAction()))
      {
        FeedbackActivity.access$200(this$0, 0);
        return;
      }
    } while (!"ActionSubmitFeedback".equals(paramIntent.getAction()));
    FeedbackActivity.access$300(this$0, paramIntent.getStringExtra("ExtraUserMessage"));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.shaky.FeedbackActivity.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */