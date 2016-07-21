package com.fasterxml.jackson.core.sym;

public final class NameN
  extends Name
{
  private final int[] q;
  private final int q1;
  private final int q2;
  private final int q3;
  private final int q4;
  private final int qlen;
  
  NameN(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt, int paramInt6)
  {
    super(paramString, paramInt1);
    q1 = paramInt2;
    q2 = paramInt3;
    q3 = paramInt4;
    q4 = paramInt5;
    q = paramArrayOfInt;
    qlen = paramInt6;
  }
  
  public final boolean equals(int paramInt)
  {
    return false;
  }
  
  public final boolean equals(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public final boolean equals(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt != qlen) {}
    label119:
    do
    {
      do
      {
        return false;
      } while ((paramArrayOfInt[0] != q1) || (paramArrayOfInt[1] != q2) || (paramArrayOfInt[2] != q3) || (paramArrayOfInt[3] != q4));
      switch (paramInt)
      {
      default: 
        int i = qlen;
        paramInt = 0;
        for (;;)
        {
          if (paramInt >= i - 4) {
            break label119;
          }
          if (paramArrayOfInt[(paramInt + 4)] != q[paramInt]) {
            break;
          }
          paramInt += 1;
        }
        return true;
      }
    } while ((paramArrayOfInt[7] != q[3]) || (paramArrayOfInt[6] != q[2]) || (paramArrayOfInt[5] != q[1]) || (paramArrayOfInt[4] != q[0]));
    return true;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.sym.NameN
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */