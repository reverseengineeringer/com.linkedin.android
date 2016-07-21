package com.google.zxing.common.reedsolomon;

public final class GenericGFPoly
{
  public final int[] coefficients;
  final GenericGF field;
  
  public GenericGFPoly(GenericGF paramGenericGF, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length == 0) {
      throw new IllegalArgumentException();
    }
    field = paramGenericGF;
    int j = paramArrayOfInt.length;
    if ((j > 1) && (paramArrayOfInt[0] == 0))
    {
      int i = 1;
      while ((i < j) && (paramArrayOfInt[i] == 0)) {
        i += 1;
      }
      if (i == j)
      {
        coefficients = getZerocoefficients;
        return;
      }
      coefficients = new int[j - i];
      System.arraycopy(paramArrayOfInt, i, coefficients, 0, coefficients.length);
      return;
    }
    coefficients = paramArrayOfInt;
  }
  
  private GenericGFPoly addOrSubtract(GenericGFPoly paramGenericGFPoly)
  {
    if (!field.equals(field)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if (isZero()) {
      return paramGenericGFPoly;
    }
    if (paramGenericGFPoly.isZero()) {
      return this;
    }
    int[] arrayOfInt1 = coefficients;
    int[] arrayOfInt3 = coefficients;
    int[] arrayOfInt2 = arrayOfInt3;
    paramGenericGFPoly = arrayOfInt1;
    if (arrayOfInt1.length > arrayOfInt3.length)
    {
      paramGenericGFPoly = arrayOfInt3;
      arrayOfInt2 = arrayOfInt1;
    }
    arrayOfInt1 = new int[arrayOfInt2.length];
    int j = arrayOfInt2.length - paramGenericGFPoly.length;
    System.arraycopy(arrayOfInt2, 0, arrayOfInt1, 0, j);
    int i = j;
    while (i < arrayOfInt2.length)
    {
      arrayOfInt1[i] = GenericGF.addOrSubtract(paramGenericGFPoly[(i - j)], arrayOfInt2[i]);
      i += 1;
    }
    return new GenericGFPoly(field, arrayOfInt1);
  }
  
  private int getCoefficient(int paramInt)
  {
    return coefficients[(coefficients.length - 1 - paramInt)];
  }
  
  public final GenericGFPoly[] divide(GenericGFPoly paramGenericGFPoly)
  {
    if (!field.equals(field)) {
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    }
    if (paramGenericGFPoly.isZero()) {
      throw new IllegalArgumentException("Divide by 0");
    }
    GenericGFPoly localGenericGFPoly2 = field.getZero();
    GenericGFPoly localGenericGFPoly1 = this;
    int i = paramGenericGFPoly.getCoefficient(coefficients.length - 1);
    i = field.inverse(i);
    while ((coefficients.length - 1 >= coefficients.length - 1) && (!localGenericGFPoly1.isZero()))
    {
      int j = coefficients.length - 1 - (coefficients.length - 1);
      int k = field.multiply(localGenericGFPoly1.getCoefficient(coefficients.length - 1), i);
      GenericGFPoly localGenericGFPoly3 = paramGenericGFPoly.multiplyByMonomial(j, k);
      localGenericGFPoly2 = localGenericGFPoly2.addOrSubtract(field.buildMonomial(j, k));
      localGenericGFPoly1 = localGenericGFPoly1.addOrSubtract(localGenericGFPoly3);
    }
    return new GenericGFPoly[] { localGenericGFPoly2, localGenericGFPoly1 };
  }
  
  final boolean isZero()
  {
    boolean bool = false;
    if (coefficients[0] == 0) {
      bool = true;
    }
    return bool;
  }
  
  public final GenericGFPoly multiplyByMonomial(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IllegalArgumentException();
    }
    if (paramInt2 == 0) {
      return field.getZero();
    }
    int i = coefficients.length;
    int[] arrayOfInt = new int[i + paramInt1];
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      arrayOfInt[paramInt1] = field.multiply(coefficients[paramInt1], paramInt2);
      paramInt1 += 1;
    }
    return new GenericGFPoly(field, arrayOfInt);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder((coefficients.length - 1) * 8);
    int i = coefficients.length - 1;
    if (i >= 0)
    {
      int k = getCoefficient(i);
      int j;
      if (k != 0)
      {
        if (k >= 0) {
          break label110;
        }
        localStringBuilder.append(" - ");
        j = -k;
        label56:
        if ((i == 0) || (j != 1))
        {
          j = field.log(j);
          if (j != 0) {
            break label133;
          }
          localStringBuilder.append('1');
        }
        label86:
        if (i != 0)
        {
          if (i != 1) {
            break label167;
          }
          localStringBuilder.append('x');
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        label110:
        j = k;
        if (localStringBuilder.length() <= 0) {
          break label56;
        }
        localStringBuilder.append(" + ");
        j = k;
        break label56;
        label133:
        if (j == 1)
        {
          localStringBuilder.append('a');
          break label86;
        }
        localStringBuilder.append("a^");
        localStringBuilder.append(j);
        break label86;
        label167:
        localStringBuilder.append("x^");
        localStringBuilder.append(i);
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.google.zxing.common.reedsolomon.GenericGFPoly
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */