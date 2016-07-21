package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.internal.Backoff;
import java.util.Random;

final class RandomBackoff
  implements Backoff
{
  final Backoff backoff;
  final double jitterPercent;
  final Random random;
  
  public RandomBackoff(Backoff paramBackoff)
  {
    this(paramBackoff, new Random());
  }
  
  private RandomBackoff(Backoff paramBackoff, Random paramRandom)
  {
    if (paramBackoff == null) {
      throw new NullPointerException("backoff must not be null");
    }
    backoff = paramBackoff;
    jitterPercent = 0.1D;
    random = paramRandom;
  }
  
  public final long getDelayMillis(int paramInt)
  {
    double d = 1.0D - jitterPercent;
    return ((d + (jitterPercent + 1.0D - d) * random.nextDouble()) * backoff.getDelayMillis(paramInt));
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.RandomBackoff
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */