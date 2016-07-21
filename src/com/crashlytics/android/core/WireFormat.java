package com.crashlytics.android.core;

final class WireFormat
{
  static final int MESSAGE_SET_ITEM_END_TAG;
  static final int MESSAGE_SET_ITEM_TAG = 11;
  static final int MESSAGE_SET_MESSAGE_TAG = 26;
  static final int MESSAGE_SET_TYPE_ID_TAG;
  
  static
  {
    MESSAGE_SET_ITEM_END_TAG = 12;
    MESSAGE_SET_TYPE_ID_TAG = 16;
  }
  
  static int makeTag(int paramInt1, int paramInt2)
  {
    return paramInt1 << 3 | paramInt2;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.WireFormat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */