package com.linkedin.android.fission.interfaces;

import java.io.IOException;
import java.nio.ByteBuffer;

public abstract interface FissionAdapter
{
  public abstract FissionTransaction createTransaction(boolean paramBoolean)
    throws IOException;
  
  public abstract ByteBuffer getBuffer(int paramInt);
  
  public abstract ByteBuffer readFromCache(String paramString, FissionTransaction paramFissionTransaction)
    throws IOException;
  
  public abstract String readString(ByteBuffer paramByteBuffer)
    throws IOException;
  
  public abstract int readUnsignedShort(ByteBuffer paramByteBuffer)
    throws IOException;
  
  public abstract void recycle(ByteBuffer paramByteBuffer);
  
  public abstract void willWriteModel$30d0b508(FissileModel paramFissileModel, boolean paramBoolean);
  
  public abstract void writeString(ByteBuffer paramByteBuffer, String paramString)
    throws IOException;
  
  public abstract void writeToCache(String paramString, ByteBuffer paramByteBuffer, int paramInt, FissionTransaction paramFissionTransaction)
    throws IOException;
  
  public abstract void writeUnsignedShort(ByteBuffer paramByteBuffer, int paramInt)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.linkedin.android.fission.interfaces.FissionAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */