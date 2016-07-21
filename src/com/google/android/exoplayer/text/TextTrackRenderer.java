package com.google.android.exoplayer.text;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer.ExoPlaybackException;
import com.google.android.exoplayer.MediaFormatHolder;
import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.SampleSource;
import com.google.android.exoplayer.SampleSource.SampleSourceReader;
import com.google.android.exoplayer.TrackInfo;
import com.google.android.exoplayer.TrackRenderer;
import com.google.android.exoplayer.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@TargetApi(16)
public final class TextTrackRenderer
  extends TrackRenderer
  implements Handler.Callback
{
  private static final List<Class<? extends SubtitleParser>> DEFAULT_PARSER_CLASSES = new ArrayList();
  private final MediaFormatHolder formatHolder;
  private boolean inputStreamEnded;
  private Subtitle nextSubtitle;
  private int nextSubtitleEventIndex;
  private SubtitleParserHelper parserHelper;
  private int parserIndex;
  private HandlerThread parserThread;
  private final SampleSource.SampleSourceReader source;
  private Subtitle subtitle;
  private final SubtitleParser[] subtitleParsers;
  private final TextRenderer textRenderer;
  private final Handler textRendererHandler;
  private int trackIndex;
  
  static
  {
    try
    {
      DEFAULT_PARSER_CLASSES.add(Class.forName("com.google.android.exoplayer.text.webvtt.WebvttParser").asSubclass(SubtitleParser.class));
      try
      {
        DEFAULT_PARSER_CLASSES.add(Class.forName("com.google.android.exoplayer.text.ttml.TtmlParser").asSubclass(SubtitleParser.class));
        try
        {
          DEFAULT_PARSER_CLASSES.add(Class.forName("com.google.android.exoplayer.text.subrip.SubripParser").asSubclass(SubtitleParser.class));
          try
          {
            DEFAULT_PARSER_CLASSES.add(Class.forName("com.google.android.exoplayer.text.tx3g.Tx3gParser").asSubclass(SubtitleParser.class));
            return;
          }
          catch (ClassNotFoundException localClassNotFoundException1) {}
        }
        catch (ClassNotFoundException localClassNotFoundException2)
        {
          for (;;) {}
        }
      }
      catch (ClassNotFoundException localClassNotFoundException3)
      {
        for (;;) {}
      }
    }
    catch (ClassNotFoundException localClassNotFoundException4)
    {
      for (;;) {}
    }
  }
  
  public TextTrackRenderer(SampleSource paramSampleSource, TextRenderer paramTextRenderer, Looper paramLooper, SubtitleParser... paramVarArgs)
  {
    source = paramSampleSource.register();
    textRenderer = ((TextRenderer)Assertions.checkNotNull(paramTextRenderer));
    if (paramLooper == null) {}
    for (paramSampleSource = null;; paramSampleSource = new Handler(paramLooper, this))
    {
      textRendererHandler = paramSampleSource;
      subtitleParsers = paramVarArgs;
      formatHolder = new MediaFormatHolder();
      return;
    }
  }
  
  private long getNextEventTime()
  {
    if ((nextSubtitleEventIndex == -1) || (nextSubtitleEventIndex >= subtitle.getEventTimeCount())) {
      return Long.MAX_VALUE;
    }
    return subtitle.getEventTime(nextSubtitleEventIndex);
  }
  
  private void invokeRendererInternalCues(List<Cue> paramList)
  {
    textRenderer.onCues(paramList);
  }
  
  private void seekToInternal()
  {
    inputStreamEnded = false;
    subtitle = null;
    nextSubtitle = null;
    parserHelper.flush();
    updateTextRenderer(Collections.emptyList());
  }
  
  private void updateTextRenderer(List<Cue> paramList)
  {
    if (textRendererHandler != null)
    {
      textRendererHandler.obtainMessage(0, paramList).sendToTarget();
      return;
    }
    invokeRendererInternalCues(paramList);
  }
  
  protected final int doPrepare(long paramLong)
  {
    if (!source.prepare(paramLong)) {
      return 0;
    }
    int k = source.getTrackCount();
    int i = 0;
    while (i < subtitleParsers.length)
    {
      int j = 0;
      while (j < k)
      {
        if (subtitleParsers[i].canParse(source.getTrackInfo(j).mimeType))
        {
          parserIndex = i;
          trackIndex = j;
          return 1;
        }
        j += 1;
      }
      i += 1;
    }
    return -1;
  }
  
  protected final void doSomeWork(long paramLong1, long paramLong2)
    throws ExoPlaybackException
  {
    source.continueBuffering(trackIndex, paramLong1);
    if (nextSubtitle == null) {}
    int i;
    do
    {
      do
      {
        try
        {
          nextSubtitle = parserHelper.getAndClearResult();
          if (state != 3) {
            return;
          }
        }
        catch (IOException localIOException)
        {
          throw new ExoPlaybackException(localIOException);
        }
        i = 0;
        int j = 0;
        long l = Long.MAX_VALUE;
        if (subtitle != null)
        {
          paramLong2 = getNextEventTime();
          for (i = j;; i = 1)
          {
            l = paramLong2;
            if (paramLong2 > paramLong1) {
              break;
            }
            nextSubtitleEventIndex += 1;
            paramLong2 = getNextEventTime();
          }
        }
        j = i;
        if (l == Long.MAX_VALUE)
        {
          j = i;
          if (nextSubtitle != null)
          {
            j = i;
            if (nextSubtitle.getStartTime() <= paramLong1)
            {
              subtitle = nextSubtitle;
              nextSubtitle = null;
              nextSubtitleEventIndex = subtitle.getNextEventTimeIndex(paramLong1);
              j = 1;
            }
          }
        }
        if (j != 0) {
          updateTextRenderer(subtitle.getCues(paramLong1));
        }
      } while ((inputStreamEnded) || (nextSubtitle != null) || (parserHelper.isParsing()));
      SampleHolder localSampleHolder = parserHelper.getSampleHolder();
      localSampleHolder.clearData();
      i = source.readData(trackIndex, paramLong1, formatHolder, localSampleHolder, false);
      if (i == -3)
      {
        parserHelper.startParseOperation();
        return;
      }
    } while (i != -1);
    inputStreamEnded = true;
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
    invokeRendererInternalCues((List)obj);
    return true;
  }
  
  protected final boolean isEnded()
  {
    return (inputStreamEnded) && ((subtitle == null) || (getNextEventTime() == Long.MAX_VALUE));
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
    subtitle = null;
    nextSubtitle = null;
    parserThread.quit();
    parserThread = null;
    parserHelper = null;
    updateTextRenderer(Collections.emptyList());
    source.disable(trackIndex);
  }
  
  protected final void onEnabled(long paramLong, boolean paramBoolean)
  {
    source.enable(trackIndex, paramLong);
    parserThread = new HandlerThread("textParser");
    parserThread.start();
    parserHelper = new SubtitleParserHelper(parserThread.getLooper(), subtitleParsers[parserIndex]);
    seekToInternal();
  }
  
  protected final void onReleased()
  {
    source.release();
  }
  
  protected final void seekTo(long paramLong)
  {
    source.seekToUs(paramLong);
    seekToInternal();
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.text.TextTrackRenderer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */