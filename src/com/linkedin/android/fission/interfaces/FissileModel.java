package com.linkedin.android.fission.interfaces;

import java.io.IOException;
import java.nio.ByteBuffer;

public abstract interface FissileModel
{
  public abstract int getSerializedSize();
  
  public abstract String id();
  
  public abstract void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.linkedin.android.fission.interfaces.FissileModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */