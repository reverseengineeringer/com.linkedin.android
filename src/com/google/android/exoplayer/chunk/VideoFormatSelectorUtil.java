package com.google.android.exoplayer.chunk;

import android.graphics.Point;
import com.google.android.exoplayer.MediaCodecUtil;
import com.google.android.exoplayer.MediaCodecUtil.DecoderQueryException;
import com.google.android.exoplayer.util.Util;
import java.util.ArrayList;
import java.util.List;

public final class VideoFormatSelectorUtil
{
  public static int[] selectVideoFormats$f05a4ab$638cba57(List<? extends FormatWrapper> paramList, int paramInt1, int paramInt2)
    throws MediaCodecUtil.DecoderQueryException
  {
    int i = Integer.MAX_VALUE;
    ArrayList localArrayList = new ArrayList();
    int n = MediaCodecUtil.maxH264DecodableFrameSize();
    int i1 = paramList.size();
    int j = 0;
    Format localFormat;
    label88:
    int k;
    int i2;
    int i3;
    if (j < i1)
    {
      localFormat = ((FormatWrapper)paramList.get(j)).getFormat();
      if ((width > 0) && (height > 0) && (width * height > n))
      {
        m = 0;
        k = i;
        if (m != 0)
        {
          localArrayList.add(Integer.valueOf(j));
          k = i;
          if (width > 0)
          {
            k = i;
            if (height > 0)
            {
              i2 = width;
              i3 = height;
              if (i2 <= i3) {
                break label294;
              }
              k = 1;
              label153:
              if (paramInt1 <= paramInt2) {
                break label300;
              }
              m = 1;
              label161:
              if (k == m) {
                break label410;
              }
              k = paramInt1;
            }
          }
        }
      }
    }
    for (int m = paramInt2;; m = paramInt1)
    {
      if (i2 * k >= i3 * m) {}
      for (Object localObject = new Point(m, Util.ceilDivide(m * i3, i2));; localObject = new Point(Util.ceilDivide(k * i2, i3), k))
      {
        m = width * height;
        k = i;
        if (width >= (int)(x * 0.98F))
        {
          k = i;
          if (height >= (int)(y * 0.98F))
          {
            k = i;
            if (m < i) {
              k = m;
            }
          }
        }
        j += 1;
        i = k;
        break;
        m = 1;
        break label88;
        label294:
        k = 0;
        break label153;
        label300:
        m = 0;
        break label161;
      }
      paramInt1 = localArrayList.size() - 1;
      while (paramInt1 >= 0)
      {
        localObject = ((FormatWrapper)paramList.get(paramInt1)).getFormat();
        if ((width > 0) && (height > 0) && (width * height > i)) {
          localArrayList.remove(paramInt1);
        }
        paramInt1 -= 1;
      }
      return Util.toArray(localArrayList);
      label410:
      k = paramInt2;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.chunk.VideoFormatSelectorUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */