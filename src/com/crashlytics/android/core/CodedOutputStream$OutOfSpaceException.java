package com.crashlytics.android.core;

import java.io.IOException;

final class CodedOutputStream$OutOfSpaceException
  extends IOException
{
  CodedOutputStream$OutOfSpaceException()
  {
    super("CodedOutputStream was writing to a flat byte array and ran out of space.");
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CodedOutputStream.OutOfSpaceException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */