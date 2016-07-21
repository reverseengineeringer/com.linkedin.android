package android.support.v7.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class StaggeredGridLayoutManager$LazySpanLookup
{
  int[] mData;
  List<FullSpanItem> mFullSpanItems;
  
  public final void addFullSpanItem(FullSpanItem paramFullSpanItem)
  {
    if (mFullSpanItems == null) {
      mFullSpanItems = new ArrayList();
    }
    int j = mFullSpanItems.size();
    int i = 0;
    while (i < j)
    {
      FullSpanItem localFullSpanItem = (FullSpanItem)mFullSpanItems.get(i);
      if (mPosition == mPosition) {
        mFullSpanItems.remove(i);
      }
      if (mPosition >= mPosition)
      {
        mFullSpanItems.add(i, paramFullSpanItem);
        return;
      }
      i += 1;
    }
    mFullSpanItems.add(paramFullSpanItem);
  }
  
  final void clear()
  {
    if (mData != null) {
      Arrays.fill(mData, -1);
    }
    mFullSpanItems = null;
  }
  
  final void ensureSize(int paramInt)
  {
    if (mData == null)
    {
      mData = new int[Math.max(paramInt, 10) + 1];
      Arrays.fill(mData, -1);
    }
    while (paramInt < mData.length) {
      return;
    }
    int[] arrayOfInt = mData;
    int i = mData.length;
    while (i <= paramInt) {
      i *= 2;
    }
    mData = new int[i];
    System.arraycopy(arrayOfInt, 0, mData, 0, arrayOfInt.length);
    Arrays.fill(mData, arrayOfInt.length, mData.length, -1);
  }
  
  final int forceInvalidateAfter(int paramInt)
  {
    if (mFullSpanItems != null)
    {
      int i = mFullSpanItems.size() - 1;
      while (i >= 0)
      {
        if (mFullSpanItems.get(i)).mPosition >= paramInt) {
          mFullSpanItems.remove(i);
        }
        i -= 1;
      }
    }
    return invalidateAfter(paramInt);
  }
  
  public final FullSpanItem getFirstFullSpanItemInRange$7b524a3(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject;
    if (mFullSpanItems == null)
    {
      localObject = null;
      return (FullSpanItem)localObject;
    }
    int j = mFullSpanItems.size();
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label112;
      }
      FullSpanItem localFullSpanItem = (FullSpanItem)mFullSpanItems.get(i);
      if (mPosition >= paramInt2) {
        return null;
      }
      if (mPosition >= paramInt1)
      {
        localObject = localFullSpanItem;
        if (paramInt3 == 0) {
          break;
        }
        localObject = localFullSpanItem;
        if (mGapDir == paramInt3) {
          break;
        }
        localObject = localFullSpanItem;
        if (mHasUnwantedGapAfter) {
          break;
        }
      }
      i += 1;
    }
    label112:
    return null;
  }
  
  public final FullSpanItem getFullSpanItem(int paramInt)
  {
    Object localObject;
    if (mFullSpanItems == null)
    {
      localObject = null;
      return (FullSpanItem)localObject;
    }
    int i = mFullSpanItems.size() - 1;
    for (;;)
    {
      if (i < 0) {
        break label61;
      }
      FullSpanItem localFullSpanItem = (FullSpanItem)mFullSpanItems.get(i);
      localObject = localFullSpanItem;
      if (mPosition == paramInt) {
        break;
      }
      i -= 1;
    }
    label61:
    return null;
  }
  
  final int invalidateAfter(int paramInt)
  {
    if (mData == null) {
      return -1;
    }
    if (paramInt >= mData.length) {
      return -1;
    }
    FullSpanItem localFullSpanItem;
    int i;
    if (mFullSpanItems != null)
    {
      localFullSpanItem = getFullSpanItem(paramInt);
      if (localFullSpanItem != null) {
        mFullSpanItems.remove(localFullSpanItem);
      }
      int j = mFullSpanItems.size();
      i = 0;
      if (i >= j) {
        break label178;
      }
      if (mFullSpanItems.get(i)).mPosition < paramInt) {}
    }
    for (;;)
    {
      if (i != -1)
      {
        localFullSpanItem = (FullSpanItem)mFullSpanItems.get(i);
        mFullSpanItems.remove(i);
      }
      for (i = mPosition;; i = -1)
      {
        if (i != -1) {
          break label162;
        }
        Arrays.fill(mData, paramInt, mData.length, -1);
        return mData.length;
        i += 1;
        break;
      }
      label162:
      Arrays.fill(mData, paramInt, i + 1, -1);
      return i + 1;
      label178:
      i = -1;
    }
  }
  
  final void offsetForAddition(int paramInt1, int paramInt2)
  {
    if ((mData == null) || (paramInt1 >= mData.length)) {}
    for (;;)
    {
      return;
      ensureSize(paramInt1 + paramInt2);
      System.arraycopy(mData, paramInt1, mData, paramInt1 + paramInt2, mData.length - paramInt1 - paramInt2);
      Arrays.fill(mData, paramInt1, paramInt1 + paramInt2, -1);
      if (mFullSpanItems != null)
      {
        int i = mFullSpanItems.size() - 1;
        while (i >= 0)
        {
          FullSpanItem localFullSpanItem = (FullSpanItem)mFullSpanItems.get(i);
          if (mPosition >= paramInt1) {
            mPosition += paramInt2;
          }
          i -= 1;
        }
      }
    }
  }
  
  final void offsetForRemoval(int paramInt1, int paramInt2)
  {
    if ((mData == null) || (paramInt1 >= mData.length)) {}
    do
    {
      return;
      ensureSize(paramInt1 + paramInt2);
      System.arraycopy(mData, paramInt1 + paramInt2, mData, paramInt1, mData.length - paramInt1 - paramInt2);
      Arrays.fill(mData, mData.length - paramInt2, mData.length, -1);
    } while (mFullSpanItems == null);
    int i = mFullSpanItems.size() - 1;
    label87:
    FullSpanItem localFullSpanItem;
    if (i >= 0)
    {
      localFullSpanItem = (FullSpanItem)mFullSpanItems.get(i);
      if (mPosition >= paramInt1)
      {
        if (mPosition >= paramInt1 + paramInt2) {
          break label144;
        }
        mFullSpanItems.remove(i);
      }
    }
    for (;;)
    {
      i -= 1;
      break label87;
      break;
      label144:
      mPosition -= paramInt2;
    }
  }
  
  static class FullSpanItem
    implements Parcelable
  {
    public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator() {};
    int mGapDir;
    int[] mGapPerSpan;
    boolean mHasUnwantedGapAfter;
    int mPosition;
    
    public FullSpanItem() {}
    
    public FullSpanItem(Parcel paramParcel)
    {
      mPosition = paramParcel.readInt();
      mGapDir = paramParcel.readInt();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        mHasUnwantedGapAfter = bool;
        int i = paramParcel.readInt();
        if (i > 0)
        {
          mGapPerSpan = new int[i];
          paramParcel.readIntArray(mGapPerSpan);
        }
        return;
        bool = false;
      }
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    final int getGapForSpan(int paramInt)
    {
      if (mGapPerSpan == null) {
        return 0;
      }
      return mGapPerSpan[paramInt];
    }
    
    public String toString()
    {
      return "FullSpanItem{mPosition=" + mPosition + ", mGapDir=" + mGapDir + ", mHasUnwantedGapAfter=" + mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(mGapPerSpan) + '}';
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(mPosition);
      paramParcel.writeInt(mGapDir);
      if (mHasUnwantedGapAfter) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        if ((mGapPerSpan == null) || (mGapPerSpan.length <= 0)) {
          break;
        }
        paramParcel.writeInt(mGapPerSpan.length);
        paramParcel.writeIntArray(mGapPerSpan);
        return;
      }
      paramParcel.writeInt(0);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */