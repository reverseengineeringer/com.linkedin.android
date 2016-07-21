package android.support.graphics.drawable;

import android.graphics.Path;
import android.util.Log;
import java.util.ArrayList;

final class PathParser
{
  private static void addNode(ArrayList<PathDataNode> paramArrayList, char paramChar, float[] paramArrayOfFloat)
  {
    paramArrayList.add(new PathDataNode(paramChar, paramArrayOfFloat, (byte)0));
  }
  
  static float[] copyOfRange$7b60297f(float[] paramArrayOfFloat, int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException();
    }
    int i = paramArrayOfFloat.length;
    if (i < 0) {
      throw new ArrayIndexOutOfBoundsException();
    }
    paramInt += 0;
    i = Math.min(paramInt, i + 0);
    float[] arrayOfFloat = new float[paramInt];
    System.arraycopy(paramArrayOfFloat, 0, arrayOfFloat, 0, i);
    return arrayOfFloat;
  }
  
  public static PathDataNode[] createNodesFromPathData(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int i = 0;
    int j = 1;
    ArrayList localArrayList = new ArrayList();
    while (j < paramString.length())
    {
      j = nextStart(paramString, j);
      String str = paramString.substring(i, j).trim();
      if (str.length() > 0)
      {
        float[] arrayOfFloat = getFloats(str);
        addNode(localArrayList, str.charAt(0), arrayOfFloat);
      }
      i = j;
      j += 1;
    }
    if ((j - i == 1) && (i < paramString.length())) {
      addNode(localArrayList, paramString.charAt(i), new float[0]);
    }
    return (PathDataNode[])localArrayList.toArray(new PathDataNode[localArrayList.size()]);
  }
  
  public static PathDataNode[] deepCopyNodes(PathDataNode[] paramArrayOfPathDataNode)
  {
    Object localObject;
    if (paramArrayOfPathDataNode == null)
    {
      localObject = null;
      return (PathDataNode[])localObject;
    }
    PathDataNode[] arrayOfPathDataNode = new PathDataNode[paramArrayOfPathDataNode.length];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfPathDataNode;
      if (i >= paramArrayOfPathDataNode.length) {
        break;
      }
      arrayOfPathDataNode[i] = new PathDataNode(paramArrayOfPathDataNode[i], 0);
      i += 1;
    }
  }
  
  private static float[] getFloats(String paramString)
  {
    int i;
    if (paramString.charAt(0) == 'z')
    {
      i = 1;
      if (paramString.charAt(0) != 'Z') {
        break label39;
      }
    }
    label39:
    for (int j = 1;; j = 0)
    {
      if ((i | j) == 0) {
        break label44;
      }
      return new float[0];
      i = 0;
      break;
    }
    for (;;)
    {
      label44:
      ExtractFloatResult localExtractFloatResult;
      int i2;
      int i1;
      int i4;
      int n;
      int i5;
      int m;
      int i3;
      int k;
      try
      {
        float[] arrayOfFloat1 = new float[paramString.length()];
        j = 1;
        localExtractFloatResult = new ExtractFloatResult((byte)0);
        int i6 = paramString.length();
        i = 0;
        if (j >= i6) {
          break label346;
        }
        i2 = 0;
        mEndWithNegOrDot = false;
        i1 = 0;
        i4 = 0;
        n = j;
        if (n >= paramString.length()) {
          break label294;
        }
        i5 = 0;
        switch (paramString.charAt(n))
        {
        case '-': 
          m = i5;
          i3 = i1;
          k = i2;
          if (n == j) {
            break label371;
          }
          m = i5;
          i3 = i1;
          k = i2;
          if (i4 != 0) {
            break label371;
          }
          k = 1;
          mEndWithNegOrDot = true;
          m = i5;
          i3 = i1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new RuntimeException("error in parsing \"" + paramString + "\"", localNumberFormatException);
      }
      if (i1 == 0)
      {
        i3 = 1;
        m = i5;
        k = i2;
      }
      else
      {
        k = 1;
        mEndWithNegOrDot = true;
        m = i5;
        i3 = i1;
      }
      label294:
      label346:
      label371:
      label419:
      for (;;)
      {
        mEndPosition = n;
        k = mEndPosition;
        if (j < k)
        {
          m = i + 1;
          localNumberFormatException[i] = Float.parseFloat(paramString.substring(j, k));
          i = m;
        }
        for (;;)
        {
          if (!mEndWithNegOrDot) {
            break label421;
          }
          j = k;
          break;
          float[] arrayOfFloat2 = copyOfRange$7b60297f(localNumberFormatException, i);
          return arrayOfFloat2;
        }
        k = i2;
        i3 = i1;
        m = i5;
        for (;;)
        {
          if (k != 0) {
            break label419;
          }
          n += 1;
          i1 = i3;
          i2 = k;
          i4 = m;
          break;
          k = 1;
          m = i5;
          i3 = i1;
          continue;
          m = 1;
          i3 = i1;
          k = i2;
        }
      }
      label421:
      j = k + 1;
    }
  }
  
  private static int nextStart(String paramString, int paramInt)
  {
    for (;;)
    {
      if (paramInt < paramString.length())
      {
        int i = paramString.charAt(paramInt);
        if ((((i - 65) * (i - 90) > 0) && ((i - 97) * (i - 122) > 0)) || (i == 101) || (i == 69)) {}
      }
      else
      {
        return paramInt;
      }
      paramInt += 1;
    }
  }
  
  private static final class ExtractFloatResult
  {
    int mEndPosition;
    boolean mEndWithNegOrDot;
  }
  
  public static final class PathDataNode
  {
    float[] params;
    char type;
    
    private PathDataNode(char paramChar, float[] paramArrayOfFloat)
    {
      type = paramChar;
      params = paramArrayOfFloat;
    }
    
    private PathDataNode(PathDataNode paramPathDataNode)
    {
      type = type;
      params = PathParser.copyOfRange$7b60297f(params, params.length);
    }
    
    private static void arcToBezier(Path paramPath, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9)
    {
      int j = (int)Math.ceil(Math.abs(4.0D * paramDouble9 / 3.141592653589793D));
      double d1 = paramDouble8;
      double d6 = Math.cos(paramDouble7);
      double d7 = Math.sin(paramDouble7);
      paramDouble7 = Math.cos(d1);
      paramDouble8 = Math.sin(d1);
      double d2 = -paramDouble3 * d6 * paramDouble8 - paramDouble4 * d7 * paramDouble7;
      double d3 = -paramDouble3 * d7 * paramDouble8 + paramDouble4 * d6 * paramDouble7;
      double d8 = paramDouble9 / j;
      int i = 0;
      paramDouble8 = paramDouble6;
      paramDouble7 = paramDouble5;
      paramDouble9 = d1;
      paramDouble6 = d3;
      paramDouble5 = d2;
      while (i < j)
      {
        double d5 = paramDouble9 + d8;
        d3 = Math.sin(d5);
        double d9 = Math.cos(d5);
        double d4 = paramDouble3 * d6 * d9 + paramDouble1 - paramDouble4 * d7 * d3;
        d2 = paramDouble3 * d7 * d9 + paramDouble2 + paramDouble4 * d6 * d3;
        d1 = -paramDouble3 * d6 * d3 - paramDouble4 * d7 * d9;
        d3 = -paramDouble3 * d7 * d3 + paramDouble4 * d6 * d9;
        d9 = Math.tan((d5 - paramDouble9) / 2.0D);
        paramDouble9 = Math.sin(d5 - paramDouble9) * (Math.sqrt(4.0D + 3.0D * d9 * d9) - 1.0D) / 3.0D;
        paramPath.cubicTo((float)(paramDouble7 + paramDouble9 * paramDouble5), (float)(paramDouble8 + paramDouble9 * paramDouble6), (float)(d4 - paramDouble9 * d1), (float)(d2 - paramDouble9 * d3), (float)d4, (float)d2);
        paramDouble9 = d5;
        paramDouble7 = d4;
        paramDouble8 = d2;
        paramDouble5 = d1;
        paramDouble6 = d3;
        i += 1;
      }
    }
    
    static void drawArc(Path paramPath, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, boolean paramBoolean1, boolean paramBoolean2)
    {
      double d5;
      double d6;
      double d7;
      double d8;
      double d9;
      double d4;
      double d3;
      double d2;
      double d13;
      for (;;)
      {
        d5 = Math.toRadians(paramFloat7);
        d6 = Math.cos(d5);
        d7 = Math.sin(d5);
        d8 = (paramFloat1 * d6 + paramFloat2 * d7) / paramFloat5;
        d9 = (-paramFloat1 * d7 + paramFloat2 * d6) / paramFloat6;
        d1 = (paramFloat3 * d6 + paramFloat4 * d7) / paramFloat5;
        d4 = (-paramFloat3 * d7 + paramFloat4 * d6) / paramFloat6;
        d11 = d8 - d1;
        d10 = d9 - d4;
        d3 = (d8 + d1) / 2.0D;
        d2 = (d9 + d4) / 2.0D;
        d12 = d11 * d11 + d10 * d10;
        if (d12 == 0.0D)
        {
          Log.w("PathParser", " Points are coincident");
          return;
        }
        d13 = 1.0D / d12 - 0.25D;
        if (d13 >= 0.0D) {
          break;
        }
        Log.w("PathParser", "Points are too far apart " + d12);
        float f = (float)(Math.sqrt(d12) / 1.99999D);
        paramFloat5 *= f;
        paramFloat6 *= f;
      }
      double d12 = Math.sqrt(d13);
      double d11 = d12 * d11;
      double d10 = d12 * d10;
      if (paramBoolean1 == paramBoolean2)
      {
        d3 -= d10;
        d2 += d11;
        d8 = Math.atan2(d9 - d2, d8 - d3);
        d4 = Math.atan2(d4 - d2, d1 - d3) - d8;
        if (d4 < 0.0D) {
          break label415;
        }
        paramBoolean1 = true;
        label313:
        d1 = d4;
        if (paramBoolean2 != paramBoolean1) {
          if (d4 <= 0.0D) {
            break label421;
          }
        }
      }
      label415:
      label421:
      for (double d1 = d4 - 6.283185307179586D;; d1 = d4 + 6.283185307179586D)
      {
        d3 *= paramFloat5;
        d2 *= paramFloat6;
        arcToBezier(paramPath, d3 * d6 - d2 * d7, d3 * d7 + d2 * d6, paramFloat5, paramFloat6, paramFloat1, paramFloat2, d5, d8, d1);
        return;
        d3 += d10;
        d2 -= d11;
        break;
        paramBoolean1 = false;
        break label313;
      }
    }
  }
}

/* Location:
 * Qualified Name:     android.support.graphics.drawable.PathParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */