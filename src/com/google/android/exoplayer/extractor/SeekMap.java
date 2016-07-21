package com.google.android.exoplayer.extractor;

public abstract interface SeekMap
{
  public static final SeekMap UNSEEKABLE = new SeekMap()
  {
    public final long getPosition(long paramAnonymousLong)
    {
      return 0L;
    }
    
    public final boolean isSeekable()
    {
      return false;
    }
  };
  
  public abstract long getPosition(long paramLong);
  
  public abstract boolean isSeekable();
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.SeekMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */