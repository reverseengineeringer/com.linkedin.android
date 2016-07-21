package com.google.zxing.qrcode.decoder;

public final class Version$ECBlocks
{
  final Version.ECB[] ecBlocks;
  final int ecCodewordsPerBlock;
  
  Version$ECBlocks(int paramInt, Version.ECB... paramVarArgs)
  {
    ecCodewordsPerBlock = paramInt;
    ecBlocks = paramVarArgs;
  }
  
  public final int getNumBlocks()
  {
    int j = 0;
    Version.ECB[] arrayOfECB = ecBlocks;
    int k = arrayOfECB.length;
    int i = 0;
    while (i < k)
    {
      j += count;
      i += 1;
    }
    return j;
  }
  
  public final int getTotalECCodewords()
  {
    return ecCodewordsPerBlock * getNumBlocks();
  }
}

/* Location:
 * Qualified Name:     com.google.zxing.qrcode.decoder.Version.ECBlocks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */