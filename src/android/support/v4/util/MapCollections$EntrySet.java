package android.support.v4.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class MapCollections$EntrySet
  implements Set<Map.Entry<K, V>>
{
  MapCollections$EntrySet(MapCollections paramMapCollections) {}
  
  public final boolean addAll(Collection<? extends Map.Entry<K, V>> paramCollection)
  {
    int i = this$0.colGetSize();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramCollection.next();
      this$0.colPut(localEntry.getKey(), localEntry.getValue());
    }
    return i != this$0.colGetSize();
  }
  
  public final void clear()
  {
    this$0.colClear();
  }
  
  public final boolean contains(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {}
    int i;
    do
    {
      return false;
      paramObject = (Map.Entry)paramObject;
      i = this$0.colIndexOfKey(((Map.Entry)paramObject).getKey());
    } while (i < 0);
    return ContainerHelpers.equal(this$0.colGetEntry(i, 1), ((Map.Entry)paramObject).getValue());
  }
  
  public final boolean containsAll(Collection<?> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!contains(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    return MapCollections.equalsSetHelper(this, paramObject);
  }
  
  public final int hashCode()
  {
    int j = 0;
    int i = this$0.colGetSize() - 1;
    if (i >= 0)
    {
      Object localObject1 = this$0.colGetEntry(i, 0);
      Object localObject2 = this$0.colGetEntry(i, 1);
      int k;
      if (localObject1 == null)
      {
        k = 0;
        label45:
        if (localObject2 != null) {
          break label76;
        }
      }
      label76:
      for (int m = 0;; m = localObject2.hashCode())
      {
        j += (m ^ k);
        i -= 1;
        break;
        k = localObject1.hashCode();
        break label45;
      }
    }
    return j;
  }
  
  public final boolean isEmpty()
  {
    return this$0.colGetSize() == 0;
  }
  
  public final Iterator<Map.Entry<K, V>> iterator()
  {
    return new MapCollections.MapIterator(this$0);
  }
  
  public final boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean removeAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean retainAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public final int size()
  {
    return this$0.colGetSize();
  }
  
  public final Object[] toArray()
  {
    throw new UnsupportedOperationException();
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.util.MapCollections.EntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */