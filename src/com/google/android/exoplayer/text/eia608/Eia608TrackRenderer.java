package com.google.android.exoplayer.text.eia608;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer.ExoPlaybackException;
import com.google.android.exoplayer.MediaFormatHolder;
import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.SampleSource;
import com.google.android.exoplayer.SampleSource.SampleSourceReader;
import com.google.android.exoplayer.TrackInfo;
import com.google.android.exoplayer.TrackRenderer;
import com.google.android.exoplayer.text.Cue;
import com.google.android.exoplayer.text.TextRenderer;
import com.google.android.exoplayer.util.Assertions;
import com.google.android.exoplayer.util.Util;
import java.io.IOException;
import java.util.Collections;
import java.util.TreeSet;

public final class Eia608TrackRenderer
  extends TrackRenderer
  implements Handler.Callback
{
  private String caption;
  private int captionMode;
  private int captionRowCount;
  private final StringBuilder captionStringBuilder;
  private final Eia608Parser eia608Parser;
  private final MediaFormatHolder formatHolder;
  private boolean inputStreamEnded;
  private String lastRenderedCaption;
  private final TreeSet<ClosedCaptionList> pendingCaptionLists;
  private final SampleHolder sampleHolder;
  private final SampleSource.SampleSourceReader source;
  private final TextRenderer textRenderer;
  private final Handler textRendererHandler;
  private int trackIndex;
  
  public Eia608TrackRenderer(SampleSource paramSampleSource, TextRenderer paramTextRenderer, Looper paramLooper)
  {
    source = paramSampleSource.register();
    textRenderer = ((TextRenderer)Assertions.checkNotNull(paramTextRenderer));
    if (paramLooper == null) {}
    for (paramSampleSource = null;; paramSampleSource = new Handler(paramLooper, this))
    {
      textRendererHandler = paramSampleSource;
      eia608Parser = new Eia608Parser();
      formatHolder = new MediaFormatHolder();
      sampleHolder = new SampleHolder(1);
      captionStringBuilder = new StringBuilder();
      pendingCaptionLists = new TreeSet();
      return;
    }
  }
  
  private void clearPendingSample()
  {
    sampleHolder.timeUs = -1L;
    sampleHolder.clearData();
  }
  
  private String getDisplayCaption()
  {
    int j = captionStringBuilder.length();
    if (j == 0) {
      return null;
    }
    if (captionStringBuilder.charAt(j - 1) == '\n')
    {
      i = 1;
      label31:
      if ((j == 1) && (i != 0)) {
        break label69;
      }
      if (i == 0) {
        break label71;
      }
    }
    label69:
    label71:
    for (int i = j - 1;; i = j)
    {
      if (captionMode == 1) {
        break label76;
      }
      return captionStringBuilder.substring(0, i);
      i = 0;
      break label31;
      break;
    }
    label76:
    int m = 0;
    j = i;
    int k = 0;
    while ((k < captionRowCount) && (j != -1))
    {
      j = captionStringBuilder.lastIndexOf("\n", j - 1);
      k += 1;
    }
    k = m;
    if (j != -1) {
      k = j + 1;
    }
    captionStringBuilder.delete(0, k);
    return captionStringBuilder.substring(0, i - k);
  }
  
  private void invokeRenderer(String paramString)
  {
    if (Util.areEqual(lastRenderedCaption, paramString)) {
      return;
    }
    lastRenderedCaption = paramString;
    if (textRendererHandler != null)
    {
      textRendererHandler.obtainMessage(0, paramString).sendToTarget();
      return;
    }
    invokeRendererInternal(paramString);
  }
  
  private void invokeRendererInternal(String paramString)
  {
    if (paramString == null)
    {
      textRenderer.onCues(Collections.emptyList());
      return;
    }
    textRenderer.onCues(Collections.singletonList(new Cue(paramString)));
  }
  
  private boolean isSamplePending()
  {
    return sampleHolder.timeUs != -1L;
  }
  
  private void maybeAppendNewline()
  {
    int i = captionStringBuilder.length();
    if ((i > 0) && (captionStringBuilder.charAt(i - 1) != '\n')) {
      captionStringBuilder.append('\n');
    }
  }
  
  private void maybeParsePendingSample(long paramLong)
  {
    if (sampleHolder.timeUs > 5000000L + paramLong) {}
    ClosedCaptionList localClosedCaptionList;
    do
    {
      return;
      localClosedCaptionList = eia608Parser.parse(sampleHolder);
      clearPendingSample();
    } while (localClosedCaptionList == null);
    pendingCaptionLists.add(localClosedCaptionList);
  }
  
  private void seekToInternal()
  {
    inputStreamEnded = false;
    pendingCaptionLists.clear();
    clearPendingSample();
    captionRowCount = 4;
    setCaptionMode(0);
    invokeRenderer(null);
  }
  
  private void setCaptionMode(int paramInt)
  {
    if (captionMode == paramInt) {}
    do
    {
      return;
      captionMode = paramInt;
      captionStringBuilder.setLength(0);
    } while ((paramInt != 1) && (paramInt != 0));
    caption = null;
  }
  
  protected final int doPrepare(long paramLong)
  {
    if (!source.prepare(paramLong)) {
      return 0;
    }
    int j = source.getTrackCount();
    int i = 0;
    while (i < j)
    {
      if (Eia608Parser.canParse(source.getTrackInfo(i).mimeType))
      {
        trackIndex = i;
        return 1;
      }
      i += 1;
    }
    return -1;
  }
  
  protected final void doSomeWork(long paramLong1, long paramLong2)
    throws ExoPlaybackException
  {
    source.continueBuffering(trackIndex, paramLong1);
    if (isSamplePending()) {
      maybeParsePendingSample(paramLong1);
    }
    int i;
    if (inputStreamEnded) {
      i = -1;
    }
    int j;
    while ((!isSamplePending()) && (i == -3))
    {
      j = source.readData(trackIndex, paramLong1, formatHolder, sampleHolder, false);
      if (j == -3)
      {
        maybeParsePendingSample(paramLong1);
        i = j;
        continue;
        i = -3;
      }
      else
      {
        i = j;
        if (j == -1)
        {
          inputStreamEnded = true;
          i = j;
        }
      }
    }
    ClosedCaptionList localClosedCaptionList;
    int k;
    do
    {
      if ((captionMode == 1) || (captionMode == 3)) {
        caption = getDisplayCaption();
      }
      do
      {
        if (!decodeOnly) {
          invokeRenderer(caption);
        }
        if ((pendingCaptionLists.isEmpty()) || (pendingCaptionLists.first()).timeUs > paramLong1)) {
          return;
        }
        localClosedCaptionList = (ClosedCaptionList)pendingCaptionLists.pollFirst();
        k = captions.length;
      } while (k == 0);
      i = 0;
    } while (i >= k);
    Object localObject = captions[i];
    if (type == 0)
    {
      localObject = (ClosedCaptionCtrl)localObject;
      if (((cc1 == 20) || (cc1 == 28)) && (cc2 >= 32) && (cc2 <= 47))
      {
        j = 1;
        label296:
        if (j == 0) {
          break label592;
        }
        switch (cc2)
        {
        case 33: 
        case 34: 
        case 35: 
        case 36: 
        case 40: 
        default: 
          if (captionMode != 0) {
            switch (cc2)
            {
            }
          }
          break;
        }
      }
    }
    for (;;)
    {
      i += 1;
      break;
      j = 0;
      break label296;
      captionRowCount = 2;
      setCaptionMode(1);
      continue;
      captionRowCount = 3;
      setCaptionMode(1);
      continue;
      captionRowCount = 4;
      setCaptionMode(1);
      continue;
      setCaptionMode(2);
      continue;
      setCaptionMode(3);
      continue;
      caption = null;
      if ((captionMode == 1) || (captionMode == 3))
      {
        captionStringBuilder.setLength(0);
        continue;
        captionStringBuilder.setLength(0);
        continue;
        caption = getDisplayCaption();
        captionStringBuilder.setLength(0);
        continue;
        maybeAppendNewline();
        continue;
        if (captionStringBuilder.length() > 0)
        {
          captionStringBuilder.setLength(captionStringBuilder.length() - 1);
          continue;
          label592:
          if ((cc1 >= 16) && (cc1 <= 31) && (cc2 >= 64) && (cc2 <= Byte.MAX_VALUE)) {}
          for (j = 1;; j = 0)
          {
            if (j == 0) {
              break label651;
            }
            maybeAppendNewline();
            break;
          }
          label651:
          continue;
          localObject = (ClosedCaptionText)localObject;
          if (captionMode != 0) {
            captionStringBuilder.append(text);
          }
        }
      }
    }
  }
  
  protected final long getBufferedPositionUs()
  {
    return -3L;
  }
  
  protected final long getDurationUs()
  {
    return source.getTrackInfo(trackIndex).durationUs;
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    switch (what)
    {
    default: 
      return false;
    }
    invokeRendererInternal((String)obj);
    return true;
  }
  
  protected final boolean isEnded()
  {
    return inputStreamEnded;
  }
  
  protected final boolean isReady()
  {
    return true;
  }
  
  protected final void maybeThrowError()
    throws ExoPlaybackException
  {
    try
    {
      source.maybeThrowError();
      return;
    }
    catch (IOException localIOException)
    {
      throw new ExoPlaybackException(localIOException);
    }
  }
  
  protected final void onDisabled()
  {
    source.disable(trackIndex);
  }
  
  protected final void onEnabled(long paramLong, boolean paramBoolean)
  {
    source.enable(trackIndex, paramLong);
    seekToInternal();
  }
  
  protected final void seekTo(long paramLong)
    throws ExoPlaybackException
  {
    source.seekToUs(paramLong);
    seekToInternal();
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.text.eia608.Eia608TrackRenderer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */