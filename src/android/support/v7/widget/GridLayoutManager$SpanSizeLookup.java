package android.support.v7.widget;

import android.util.SparseIntArray;

public abstract class GridLayoutManager$SpanSizeLookup
{
  private boolean mCacheSpanIndices = false;
  final SparseIntArray mSpanIndexCache = new SparseIntArray();
  
  public static int getSpanGroupIndex(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 0;
    int m = 0;
    if (m < paramInt1)
    {
      int n = i + 1;
      int k;
      if (n == paramInt2)
      {
        i = 0;
        k = j + 1;
      }
      for (;;)
      {
        m += 1;
        j = k;
        break;
        k = j;
        i = n;
        if (n > paramInt2)
        {
          i = 1;
          k = j + 1;
        }
      }
    }
    paramInt1 = j;
    if (i + 1 > paramInt2) {
      paramInt1 = j + 1;
    }
    return paramInt1;
  }
  
  final int getCachedSpanIndex(int paramInt1, int paramInt2)
  {
    int i;
    if (!mCacheSpanIndices) {
      i = getSpanIndex(paramInt1, paramInt2);
    }
    int j;
    do
    {
      return i;
      j = mSpanIndexCache.get(paramInt1, -1);
      i = j;
    } while (j != -1);
    paramInt2 = getSpanIndex(paramInt1, paramInt2);
    mSpanIndexCache.put(paramInt1, paramInt2);
    return paramInt2;
  }
  
  public int getSpanIndex(int paramInt1, int paramInt2)
  {
    if (1 == paramInt2) {
      paramInt1 = 0;
    }
    int i;
    label162:
    label190:
    do
    {
      return paramInt1;
      int m = 0;
      int n = 0;
      i = m;
      int j = n;
      int k;
      if (mCacheSpanIndices)
      {
        i = m;
        j = n;
        if (mSpanIndexCache.size() > 0)
        {
          j = mSpanIndexCache.size() - 1;
          i = 0;
          while (i <= j)
          {
            k = i + j >>> 1;
            if (mSpanIndexCache.keyAt(k) < paramInt1) {
              i = k + 1;
            } else {
              j = k - 1;
            }
          }
          i -= 1;
          if ((i < 0) || (i >= mSpanIndexCache.size())) {
            break label190;
          }
          k = mSpanIndexCache.keyAt(i);
          i = m;
          j = n;
          if (k >= 0)
          {
            i = mSpanIndexCache.get(k) + 1;
            j = k + 1;
          }
        }
      }
      if (j < paramInt1)
      {
        k = i + 1;
        if (k == paramInt2) {
          i = 0;
        }
        for (;;)
        {
          j += 1;
          break label162;
          k = -1;
          break;
          i = k;
          if (k > paramInt2) {
            i = 1;
          }
        }
      }
      paramInt1 = i;
    } while (i + 1 <= paramInt2);
    return 0;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.GridLayoutManager.SpanSizeLookup
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */