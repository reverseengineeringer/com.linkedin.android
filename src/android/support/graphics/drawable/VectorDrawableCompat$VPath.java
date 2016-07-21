package android.support.graphics.drawable;

import android.graphics.Path;

class VectorDrawableCompat$VPath
{
  int mChangingConfigurations;
  protected PathParser.PathDataNode[] mNodes = null;
  String mPathName;
  
  public VectorDrawableCompat$VPath() {}
  
  public VectorDrawableCompat$VPath(VPath paramVPath)
  {
    mPathName = mPathName;
    mChangingConfigurations = mChangingConfigurations;
    mNodes = PathParser.deepCopyNodes(mNodes);
  }
  
  public boolean isClipPath()
  {
    return false;
  }
  
  public final void toPath(Path paramPath)
  {
    paramPath.reset();
    PathParser.PathDataNode[] arrayOfPathDataNode;
    float[] arrayOfFloat1;
    int k;
    int j;
    float[] arrayOfFloat2;
    float f4;
    float f3;
    float f6;
    float f1;
    float f2;
    int m;
    float f7;
    float f8;
    label290:
    label482:
    float f9;
    if (mNodes != null)
    {
      arrayOfPathDataNode = mNodes;
      arrayOfFloat1 = new float[6];
      k = 0;
      j = 109;
      if (k < arrayOfPathDataNode.length)
      {
        int n = type;
        arrayOfFloat2 = params;
        f4 = arrayOfFloat1[0];
        f3 = arrayOfFloat1[1];
        f6 = arrayOfFloat1[2];
        f5 = arrayOfFloat1[3];
        f1 = arrayOfFloat1[4];
        f2 = arrayOfFloat1[5];
        int i;
        switch (n)
        {
        default: 
          i = 2;
          m = 0;
          f7 = f3;
          f3 = f4;
          f4 = f7;
          f7 = f6;
          f8 = f5;
          if (m < arrayOfFloat2.length) {
            switch (n)
            {
            default: 
              f5 = f2;
              f2 = f4;
              f4 = f3;
              f3 = f2;
              f2 = f1;
              f6 = f7;
              f1 = f5;
              f5 = f8;
            }
          }
          break;
        case 90: 
        case 122: 
        case 76: 
        case 77: 
        case 84: 
        case 108: 
        case 109: 
        case 116: 
        case 72: 
        case 86: 
        case 104: 
        case 118: 
        case 67: 
        case 99: 
        case 81: 
        case 83: 
        case 113: 
        case 115: 
        case 65: 
        case 97: 
          for (;;)
          {
            m += i;
            f9 = f2;
            float f10 = f4;
            j = n;
            f8 = f5;
            f7 = f6;
            f2 = f1;
            f1 = f9;
            f4 = f3;
            f3 = f10;
            break label290;
            paramPath.close();
            paramPath.moveTo(f1, f2);
            f5 = f2;
            f6 = f1;
            f3 = f2;
            f4 = f1;
            i = 2;
            break;
            i = 2;
            break;
            i = 1;
            break;
            i = 6;
            break;
            i = 4;
            break;
            i = 7;
            break;
            f3 += arrayOfFloat2[(m + 0)];
            f4 += arrayOfFloat2[(m + 1)];
            if (m > 0)
            {
              paramPath.rLineTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)]);
              f9 = f3;
              f3 = f2;
              f2 = f1;
              f5 = f8;
              f1 = f3;
              f6 = f7;
              f3 = f4;
              f4 = f9;
            }
            else
            {
              paramPath.rMoveTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)]);
              f10 = f4;
              f9 = f3;
              f5 = f8;
              f1 = f4;
              f6 = f7;
              f2 = f3;
              f3 = f10;
              f4 = f9;
              continue;
              f3 = arrayOfFloat2[(m + 0)];
              f4 = arrayOfFloat2[(m + 1)];
              if (m > 0)
              {
                paramPath.lineTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)]);
                f9 = f3;
                f3 = f2;
                f2 = f1;
                f5 = f8;
                f1 = f3;
                f6 = f7;
                f3 = f4;
                f4 = f9;
              }
              else
              {
                paramPath.moveTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)]);
                f10 = f4;
                f9 = f3;
                f5 = f8;
                f1 = f4;
                f6 = f7;
                f2 = f3;
                f3 = f10;
                f4 = f9;
                continue;
                paramPath.rLineTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)]);
                f5 = arrayOfFloat2[(m + 0)];
                f4 += arrayOfFloat2[(m + 1)];
                f9 = f3 + f5;
                f3 = f2;
                f2 = f1;
                f5 = f8;
                f1 = f3;
                f6 = f7;
                f3 = f4;
                f4 = f9;
                continue;
                paramPath.lineTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)]);
                f4 = arrayOfFloat2[(m + 0)];
                f9 = arrayOfFloat2[(m + 1)];
                f3 = f2;
                f2 = f1;
                f5 = f8;
                f1 = f3;
                f6 = f7;
                f3 = f9;
                continue;
                paramPath.rLineTo(arrayOfFloat2[(m + 0)], 0.0F);
                f5 = arrayOfFloat2[(m + 0)];
                f9 = f3 + f5;
                f3 = f1;
                f5 = f8;
                f1 = f2;
                f6 = f7;
                f2 = f3;
                f3 = f4;
                f4 = f9;
                continue;
                paramPath.lineTo(arrayOfFloat2[(m + 0)], f4);
                f5 = arrayOfFloat2[(m + 0)];
                f3 = f4;
                f4 = f5;
                f9 = f1;
                f5 = f8;
                f1 = f2;
                f6 = f7;
                f2 = f9;
                continue;
                paramPath.rLineTo(0.0F, arrayOfFloat2[(m + 0)]);
                f5 = arrayOfFloat2[(m + 0)];
                f9 = f1;
                f10 = f4 + f5;
                f4 = f3;
                f1 = f2;
                f5 = f8;
                f6 = f7;
                f2 = f9;
                f3 = f10;
                continue;
                paramPath.lineTo(f3, arrayOfFloat2[(m + 0)]);
                f9 = arrayOfFloat2[(m + 0)];
                f4 = f1;
                f10 = f3;
                f1 = f2;
                f5 = f8;
                f6 = f7;
                f2 = f4;
                f3 = f9;
                f4 = f10;
                continue;
                paramPath.rCubicTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)], arrayOfFloat2[(m + 2)], arrayOfFloat2[(m + 3)], arrayOfFloat2[(m + 4)], arrayOfFloat2[(m + 5)]);
                f6 = f3 + arrayOfFloat2[(m + 2)];
                f5 = f4 + arrayOfFloat2[(m + 3)];
                f7 = arrayOfFloat2[(m + 4)];
                f4 += arrayOfFloat2[(m + 5)];
                f7 = f3 + f7;
                f3 = f2;
                f2 = f1;
                f1 = f3;
                f3 = f4;
                f4 = f7;
                continue;
                paramPath.cubicTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)], arrayOfFloat2[(m + 2)], arrayOfFloat2[(m + 3)], arrayOfFloat2[(m + 4)], arrayOfFloat2[(m + 5)]);
                f4 = arrayOfFloat2[(m + 4)];
                f3 = arrayOfFloat2[(m + 5)];
                f7 = arrayOfFloat2[(m + 2)];
                f5 = arrayOfFloat2[(m + 3)];
                f6 = f2;
                f2 = f1;
                f1 = f6;
                f6 = f7;
              }
            }
          }
          f6 = 0.0F;
          if ((j == 99) || (j == 115) || (j == 67) || (j == 83)) {
            f6 = f4 - f8;
          }
          break;
        }
      }
    }
    for (float f5 = f3 - f7;; f5 = 0.0F)
    {
      paramPath.rCubicTo(f5, f6, arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)], arrayOfFloat2[(m + 2)], arrayOfFloat2[(m + 3)]);
      f6 = f3 + arrayOfFloat2[(m + 0)];
      f5 = f4 + arrayOfFloat2[(m + 1)];
      f7 = arrayOfFloat2[(m + 2)];
      f4 += arrayOfFloat2[(m + 3)];
      f7 = f3 + f7;
      f3 = f2;
      f2 = f1;
      f1 = f3;
      f3 = f4;
      f4 = f7;
      break label482;
      if ((j == 99) || (j == 115) || (j == 67) || (j == 83))
      {
        f4 = 2.0F * f4 - f8;
        f3 = 2.0F * f3 - f7;
      }
      for (;;)
      {
        paramPath.cubicTo(f3, f4, arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)], arrayOfFloat2[(m + 2)], arrayOfFloat2[(m + 3)]);
        f6 = arrayOfFloat2[(m + 0)];
        f5 = arrayOfFloat2[(m + 1)];
        f4 = arrayOfFloat2[(m + 2)];
        f7 = arrayOfFloat2[(m + 3)];
        f3 = f2;
        f2 = f1;
        f1 = f3;
        f3 = f7;
        break label482;
        paramPath.rQuadTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)], arrayOfFloat2[(m + 2)], arrayOfFloat2[(m + 3)]);
        f6 = f3 + arrayOfFloat2[(m + 0)];
        f5 = f4 + arrayOfFloat2[(m + 1)];
        f7 = arrayOfFloat2[(m + 2)];
        f4 += arrayOfFloat2[(m + 3)];
        f7 = f3 + f7;
        f3 = f2;
        f2 = f1;
        f1 = f3;
        f3 = f4;
        f4 = f7;
        break label482;
        paramPath.quadTo(arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)], arrayOfFloat2[(m + 2)], arrayOfFloat2[(m + 3)]);
        f6 = arrayOfFloat2[(m + 0)];
        f5 = arrayOfFloat2[(m + 1)];
        f4 = arrayOfFloat2[(m + 2)];
        f7 = arrayOfFloat2[(m + 3)];
        f3 = f2;
        f2 = f1;
        f1 = f3;
        f3 = f7;
        break label482;
        if ((j == 113) || (j == 116) || (j == 81) || (j == 84)) {
          f5 = f4 - f8;
        }
        for (f6 = f3 - f7;; f6 = 0.0F)
        {
          paramPath.rQuadTo(f6, f5, arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)]);
          f6 = f3 + f6;
          f5 = f4 + f5;
          f7 = arrayOfFloat2[(m + 0)];
          f4 += arrayOfFloat2[(m + 1)];
          f7 = f3 + f7;
          f3 = f2;
          f2 = f1;
          f1 = f3;
          f3 = f4;
          f4 = f7;
          break label482;
          if ((j != 113) && (j != 116) && (j != 81))
          {
            f6 = f4;
            f5 = f3;
            if (j != 84) {}
          }
          else
          {
            f5 = 2.0F * f3 - f7;
            f6 = 2.0F * f4 - f8;
          }
          paramPath.quadTo(f5, f6, arrayOfFloat2[(m + 0)], arrayOfFloat2[(m + 1)]);
          f4 = arrayOfFloat2[(m + 0)];
          f3 = arrayOfFloat2[(m + 1)];
          f7 = f6;
          f6 = f5;
          f8 = f2;
          f2 = f1;
          f5 = f7;
          f1 = f8;
          break label482;
          f5 = arrayOfFloat2[(m + 5)];
          f6 = arrayOfFloat2[(m + 6)];
          f7 = arrayOfFloat2[(m + 0)];
          f8 = arrayOfFloat2[(m + 1)];
          f9 = arrayOfFloat2[(m + 2)];
          boolean bool1;
          if (arrayOfFloat2[(m + 3)] != 0.0F)
          {
            bool1 = true;
            label2168:
            if (arrayOfFloat2[(m + 4)] == 0.0F) {
              break label2261;
            }
          }
          label2261:
          for (boolean bool2 = true;; bool2 = false)
          {
            PathParser.PathDataNode.drawArc(paramPath, f3, f4, f5 + f3, f6 + f4, f7, f8, f9, bool1, bool2);
            f6 = f3 + arrayOfFloat2[(m + 5)];
            f5 = f4 + arrayOfFloat2[(m + 6)];
            f7 = f2;
            f2 = f1;
            f3 = f5;
            f4 = f6;
            f1 = f7;
            break;
            bool1 = false;
            break label2168;
          }
          f5 = arrayOfFloat2[(m + 5)];
          f6 = arrayOfFloat2[(m + 6)];
          f7 = arrayOfFloat2[(m + 0)];
          f8 = arrayOfFloat2[(m + 1)];
          f9 = arrayOfFloat2[(m + 2)];
          if (arrayOfFloat2[(m + 3)] != 0.0F)
          {
            bool1 = true;
            label2328:
            if (arrayOfFloat2[(m + 4)] == 0.0F) {
              break label2409;
            }
          }
          label2409:
          for (bool2 = true;; bool2 = false)
          {
            PathParser.PathDataNode.drawArc(paramPath, f3, f4, f5, f6, f7, f8, f9, bool1, bool2);
            f6 = arrayOfFloat2[(m + 5)];
            f5 = arrayOfFloat2[(m + 6)];
            f7 = f2;
            f2 = f1;
            f3 = f5;
            f4 = f6;
            f1 = f7;
            break;
            bool1 = false;
            break label2328;
          }
          arrayOfFloat1[0] = f3;
          arrayOfFloat1[1] = f4;
          arrayOfFloat1[2] = f7;
          arrayOfFloat1[3] = f8;
          arrayOfFloat1[4] = f1;
          arrayOfFloat1[5] = f2;
          j = type;
          k += 1;
          break;
          return;
          f5 = 0.0F;
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     android.support.graphics.drawable.VectorDrawableCompat.VPath
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */