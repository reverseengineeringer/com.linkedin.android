package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.support.v4.util.LruCache;

final class AppCompatDrawableManager$ColorFilterLruCache
  extends LruCache<Integer, PorterDuffColorFilter>
{
  public AppCompatDrawableManager$ColorFilterLruCache()
  {
    super(6);
  }
  
  static int generateCacheKey(int paramInt, PorterDuff.Mode paramMode)
  {
    return (paramInt + 31) * 31 + paramMode.hashCode();
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.AppCompatDrawableManager.ColorFilterLruCache
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */