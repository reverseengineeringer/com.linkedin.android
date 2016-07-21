package com.linkedin.android.datamanager.multiplex;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

final class IndividualResponseBuilder$ByteArraySection
  implements IndividualResponseBuilder.Section
{
  public final int end;
  public final int length;
  public final byte[] sourceArray;
  public final int start;
  
  public IndividualResponseBuilder$ByteArraySection(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    sourceArray = paramArrayOfByte;
    start = paramInt1;
    length = paramInt2;
    end = (paramInt1 + paramInt2);
  }
  
  public final InputStream inputStream()
    throws IOException
  {
    return new ByteArrayInputStream(sourceArray, start, length);
  }
  
  public final int length()
  {
    return length;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.datamanager.multiplex.IndividualResponseBuilder.ByteArraySection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */