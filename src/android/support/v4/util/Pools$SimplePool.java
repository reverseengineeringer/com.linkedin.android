package android.support.v4.util;

public class Pools$SimplePool<T>
  implements Pools.Pool<T>
{
  private final Object[] mPool;
  private int mPoolSize;
  
  public Pools$SimplePool(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("The max pool size must be > 0");
    }
    mPool = new Object[paramInt];
  }
  
  public T acquire()
  {
    if (mPoolSize > 0)
    {
      int i = mPoolSize - 1;
      Object localObject = mPool[i];
      mPool[i] = null;
      mPoolSize -= 1;
      return (T)localObject;
    }
    return null;
  }
  
  public boolean release(T paramT)
  {
    boolean bool = false;
    int i = 0;
    if (i < mPoolSize) {
      if (mPool[i] != paramT) {}
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label50;
      }
      throw new IllegalStateException("Already in the pool!");
      i += 1;
      break;
    }
    label50:
    if (mPoolSize < mPool.length)
    {
      mPool[mPoolSize] = paramT;
      mPoolSize += 1;
      bool = true;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.util.Pools.SimplePool
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */