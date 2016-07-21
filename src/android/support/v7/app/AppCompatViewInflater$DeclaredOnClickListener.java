package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class AppCompatViewInflater$DeclaredOnClickListener
  implements View.OnClickListener
{
  private final View mHostView;
  private final String mMethodName;
  private Context mResolvedContext;
  private Method mResolvedMethod;
  
  public AppCompatViewInflater$DeclaredOnClickListener(View paramView, String paramString)
  {
    mHostView = paramView;
    mMethodName = paramString;
  }
  
  public final void onClick(View paramView)
  {
    Context localContext;
    if (mResolvedMethod == null) {
      localContext = mHostView.getContext();
    }
    while (localContext != null) {
      try
      {
        if (!localContext.isRestricted())
        {
          Method localMethod = localContext.getClass().getMethod(mMethodName, new Class[] { View.class });
          if (localMethod != null)
          {
            mResolvedMethod = localMethod;
            mResolvedContext = localContext;
          }
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        try
        {
          mResolvedMethod.invoke(mResolvedContext, new Object[] { paramView });
          return;
        }
        catch (IllegalAccessException paramView)
        {
          int i;
          throw new IllegalStateException("Could not execute non-public method for android:onClick", paramView);
        }
        catch (InvocationTargetException paramView)
        {
          throw new IllegalStateException("Could not execute method for android:onClick", paramView);
        }
        localNoSuchMethodException = localNoSuchMethodException;
        if ((localContext instanceof ContextWrapper)) {
          localContext = ((ContextWrapper)localContext).getBaseContext();
        } else {
          localContext = null;
        }
      }
    }
    i = mHostView.getId();
    if (i == -1) {}
    for (paramView = "";; paramView = " with id '" + mHostView.getContext().getResources().getResourceEntryName(i) + "'") {
      throw new IllegalStateException("Could not find method " + mMethodName + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + mHostView.getClass() + paramView);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.AppCompatViewInflater.DeclaredOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */