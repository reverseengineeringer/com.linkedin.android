package com.google.android.exoplayer.upstream;

public abstract interface TransferListener
{
  public abstract void onBytesTransferred(int paramInt);
  
  public abstract void onTransferEnd();
  
  public abstract void onTransferStart();
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.upstream.TransferListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */