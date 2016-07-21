package com.linkedin.android.imageloader;

import java.util.ArrayList;
import java.util.List;

final class GifDecoder$GifHeader
{
  int bgColor;
  int bgIndex;
  GifDecoder.GifFrame currentFrame;
  int frameCount = 0;
  List<GifDecoder.GifFrame> frames = new ArrayList();
  int[] gct = null;
  boolean gctFlag;
  int gctSize;
  int height;
  int loopCount;
  int pixelAspect;
  int status = 0;
  int width;
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.GifDecoder.GifHeader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */