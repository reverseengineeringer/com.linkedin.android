package com.linkedin.android.premium;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;
import com.linkedin.android.logger.Log;
import com.linkedin.android.paymentslibrary.api.PaymentOfferException;
import com.linkedin.android.paymentslibrary.api.PaymentOfferProblem;
import com.linkedin.android.paymentslibrary.api.UserVisiblePaymentException;
import java.util.Collection;
import java.util.Iterator;

public class PremiumErrorHandler
{
  private static final String TAG = PremiumErrorHandler.class.getName();
  
  public static void handleCheckoutError(Context paramContext, Throwable paramThrowable)
  {
    if ((paramThrowable instanceof UserVisiblePaymentException))
    {
      if (paramThrowable.getCause() != null) {
        Log.e(paramThrowable.getCause().getMessage());
      }
      showError(paramContext, paramThrowable.getMessage());
      return;
    }
    if ((paramThrowable instanceof PaymentOfferException))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramThrowable = problems.iterator();
      while (paramThrowable.hasNext())
      {
        localStringBuilder.append(((PaymentOfferProblem)paramThrowable.next()).getProblem());
        localStringBuilder.append(System.getProperty("line.separator"));
      }
      showError(paramContext, localStringBuilder.toString());
      return;
    }
    Log.e(paramThrowable.getMessage());
    showError(paramContext, 2131230817);
  }
  
  public static void showError(Context paramContext, int paramInt)
  {
    if (paramContext != null)
    {
      Log.e(paramContext.getResources().getString(paramInt));
      Toast.makeText(paramContext, paramInt, 1).show();
    }
  }
  
  public static void showError(Context paramContext, String paramString)
  {
    Log.e(paramString);
    if (paramContext != null) {
      Toast.makeText(paramContext, paramString, 1).show();
    }
  }
  
  public static void showWarning(Context paramContext, String paramString)
  {
    showError(paramContext, paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.premium.PremiumErrorHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */