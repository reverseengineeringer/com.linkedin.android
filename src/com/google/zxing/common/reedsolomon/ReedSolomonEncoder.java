package com.google.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

public final class ReedSolomonEncoder
{
  private final List<GenericGFPoly> cachedGenerators;
  public final GenericGF field;
  
  public ReedSolomonEncoder(GenericGF paramGenericGF)
  {
    field = paramGenericGF;
    cachedGenerators = new ArrayList();
    cachedGenerators.add(new GenericGFPoly(paramGenericGF, new int[] { 1 }));
  }
  
  public final GenericGFPoly buildGenerator(int paramInt)
  {
    if (paramInt >= cachedGenerators.size())
    {
      GenericGFPoly localGenericGFPoly = (GenericGFPoly)cachedGenerators.get(cachedGenerators.size() - 1);
      int i = cachedGenerators.size();
      if (i <= paramInt)
      {
        Object localObject = new GenericGFPoly(field, new int[] { 1, field.exp(i - 1 + field.generatorBase) });
        if (!field.equals(field)) {
          throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
        }
        if ((localGenericGFPoly.isZero()) || (((GenericGFPoly)localObject).isZero())) {}
        int[] arrayOfInt2;
        for (localGenericGFPoly = field.getZero();; localGenericGFPoly = new GenericGFPoly(field, arrayOfInt2))
        {
          cachedGenerators.add(localGenericGFPoly);
          i += 1;
          break;
          int[] arrayOfInt1 = coefficients;
          int m = arrayOfInt1.length;
          localObject = coefficients;
          int n = localObject.length;
          arrayOfInt2 = new int[m + n - 1];
          int j = 0;
          while (j < m)
          {
            int i1 = arrayOfInt1[j];
            int k = 0;
            while (k < n)
            {
              arrayOfInt2[(j + k)] = GenericGF.addOrSubtract(arrayOfInt2[(j + k)], field.multiply(i1, localObject[k]));
              k += 1;
            }
            j += 1;
          }
        }
      }
    }
    return (GenericGFPoly)cachedGenerators.get(paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.zxing.common.reedsolomon.ReedSolomonEncoder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */