package com.linkedin.android.fission.interfaces;

import java.io.IOException;
import java.nio.ByteBuffer;

public abstract interface FissileModelBuilder<T extends FissileModel>
{
  public abstract T readFromFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, FissionTransaction paramFissionTransaction)
    throws IOException;
}

/* Location:
 * Qualified Name:     com.linkedin.android.fission.interfaces.FissileModelBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */