package com.linkedin.android.shaky;

import android.net.Uri;
import java.util.ArrayList;

public class ShakeDelegate
{
  public ArrayList<Uri> collectAttachments()
  {
    return new ArrayList();
  }
  
  public ArrayList<Uri> collectBackgroundAttachments()
  {
    return new ArrayList();
  }
  
  public String collectBackgroundDebugInfo()
  {
    return null;
  }
  
  public String collectDebugInfo()
  {
    return null;
  }
  
  public String[] collectRecipientEmails()
  {
    return new String[0];
  }
  
  public boolean shakeDetectionEnabled()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.shaky.ShakeDelegate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */