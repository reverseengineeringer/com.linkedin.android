package com.conviva.platforms.android;

import com.conviva.api.system.ITimeInterface;
import java.util.Date;

public final class AndroidTimeInterface
  implements ITimeInterface
{
  public final double getEpochTimeMs()
  {
    return new Date().getTime();
  }
}

/* Location:
 * Qualified Name:     com.conviva.platforms.android.AndroidTimeInterface
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */