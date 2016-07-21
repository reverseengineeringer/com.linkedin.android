package uk.co.chrisjenx.calligraphy;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;

public final class CalligraphyContextWrapper
  extends ContextWrapper
{
  private final int mAttributeId = getmAttrId;
  private CalligraphyLayoutInflater mInflater;
  
  public CalligraphyContextWrapper(Context paramContext)
  {
    super(paramContext);
  }
  
  public final Object getSystemService(String paramString)
  {
    if ("layout_inflater".equals(paramString))
    {
      if (mInflater == null) {
        mInflater = new CalligraphyLayoutInflater(LayoutInflater.from(getBaseContext()), this, mAttributeId, false);
      }
      return mInflater;
    }
    return super.getSystemService(paramString);
  }
}

/* Location:
 * Qualified Name:     uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */