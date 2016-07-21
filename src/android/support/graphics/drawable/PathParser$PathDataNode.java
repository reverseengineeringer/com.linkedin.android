package android.support.graphics.drawable;

import android.graphics.Path;
import android.util.Log;

public final class PathParser$PathDataNode
{
  float[] params;
  char type;
  
  private PathParser$PathDataNode(char paramChar, float[] paramArrayOfFloat)
  {
    type = paramChar;
    params = paramArrayOfFloat;
  }
  
  private PathParser$PathDataNode(PathDataNode paramPathDataNode)
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

/* Location:
 * Qualified Name:     android.support.graphics.drawable.PathParser.PathDataNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */