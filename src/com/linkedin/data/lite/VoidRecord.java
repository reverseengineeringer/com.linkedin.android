package com.linkedin.data.lite;

public final class VoidRecord
  implements RecordTemplate<VoidRecord>
{
  public static final VoidRecord INSTANCE = new VoidRecord();
  
  public final String id()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.data.lite.VoidRecord
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */