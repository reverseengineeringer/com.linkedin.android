package android.support.v7.widget;

final class AdapterHelper$UpdateOp
{
  int cmd;
  int itemCount;
  Object payload;
  int positionStart;
  
  AdapterHelper$UpdateOp(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    cmd = paramInt1;
    positionStart = paramInt2;
    itemCount = paramInt3;
    payload = paramObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        do
        {
          return true;
          if ((paramObject == null) || (getClass() != paramObject.getClass())) {
            return false;
          }
          paramObject = (UpdateOp)paramObject;
          if (cmd != cmd) {
            return false;
          }
        } while ((cmd == 8) && (Math.abs(itemCount - positionStart) == 1) && (itemCount == positionStart) && (positionStart == itemCount));
        if (itemCount != itemCount) {
          return false;
        }
        if (positionStart != positionStart) {
          return false;
        }
        if (payload == null) {
          break;
        }
      } while (payload.equals(payload));
      return false;
    } while (payload == null);
    return false;
  }
  
  public final int hashCode()
  {
    return (cmd * 31 + positionStart) * 31 + itemCount;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(Integer.toHexString(System.identityHashCode(this))).append("[");
    String str;
    switch (cmd)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      str = "??";
    }
    for (;;)
    {
      return str + ",s:" + positionStart + "c:" + itemCount + ",p:" + payload + "]";
      str = "add";
      continue;
      str = "rm";
      continue;
      str = "up";
      continue;
      str = "mv";
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.AdapterHelper.UpdateOp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */