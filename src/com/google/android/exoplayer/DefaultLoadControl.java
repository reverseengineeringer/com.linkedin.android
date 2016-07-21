package com.google.android.exoplayer;

import android.os.Handler;
import com.google.android.exoplayer.upstream.Allocator;
import com.google.android.exoplayer.upstream.NetworkLock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public final class DefaultLoadControl
  implements LoadControl
{
  private final Allocator allocator;
  private int bufferState;
  private final Handler eventHandler;
  private final EventListener eventListener;
  private boolean fillingBuffers;
  private final float highBufferLoad;
  private final long highWatermarkUs;
  private final HashMap<Object, LoaderState> loaderStates;
  private final List<Object> loaders;
  private final float lowBufferLoad;
  private final long lowWatermarkUs;
  private long maxLoadStartPositionUs;
  private boolean streamingPrioritySet;
  private int targetBufferSize;
  
  public DefaultLoadControl(Allocator paramAllocator)
  {
    this(paramAllocator, (byte)0);
  }
  
  private DefaultLoadControl(Allocator paramAllocator, byte paramByte)
  {
    this(paramAllocator, '\000');
  }
  
  private DefaultLoadControl(Allocator paramAllocator, char paramChar)
  {
    allocator = paramAllocator;
    eventHandler = null;
    eventListener = null;
    loaders = new ArrayList();
    loaderStates = new HashMap();
    lowWatermarkUs = 15000000L;
    highWatermarkUs = 30000000L;
    lowBufferLoad = 0.2F;
    highBufferLoad = 0.8F;
  }
  
  private void notifyLoadingChanged(final boolean paramBoolean)
  {
    if ((eventHandler != null) && (eventListener != null)) {
      eventHandler.post(new Runnable()
      {
        public final void run() {}
      });
    }
  }
  
  private void updateControlState()
  {
    int m = 0;
    int k = 0;
    int j = bufferState;
    int i = 0;
    if (i < loaders.size())
    {
      ??? = (LoaderState)loaderStates.get(loaders.get(i));
      boolean bool1 = m | loading;
      if (nextLoadPositionUs != -1L) {}
      for (m = 1;; m = 0)
      {
        k |= m;
        j = Math.max(j, bufferState);
        i += 1;
        m = bool1;
        break;
      }
    }
    boolean bool2;
    NetworkLock localNetworkLock1;
    if ((!loaders.isEmpty()) && ((m != 0) || (k != 0)) && ((j == 2) || ((j == 1) && (fillingBuffers))))
    {
      bool2 = true;
      fillingBuffers = bool2;
      if ((!fillingBuffers) || (streamingPrioritySet)) {
        break label335;
      }
      localNetworkLock1 = NetworkLock.instance;
    }
    for (;;)
    {
      synchronized (lock)
      {
        queue.add(Integer.valueOf(0));
        highestPriority = Math.min(highestPriority, 0);
        streamingPrioritySet = true;
        notifyLoadingChanged(true);
        maxLoadStartPositionUs = -1L;
        if (!fillingBuffers) {
          break;
        }
        i = 0;
        if (i >= loaders.size()) {
          break;
        }
        ??? = loaders.get(i);
        long l = loaderStates.get(???)).nextLoadPositionUs;
        if ((l != -1L) && ((maxLoadStartPositionUs == -1L) || (l < maxLoadStartPositionUs))) {
          maxLoadStartPositionUs = l;
        }
        i += 1;
        continue;
        bool2 = false;
      }
      label335:
      if ((!fillingBuffers) && (streamingPrioritySet) && (m == 0))
      {
        NetworkLock localNetworkLock2 = NetworkLock.instance;
        synchronized (lock)
        {
          queue.remove(Integer.valueOf(0));
          if (queue.isEmpty())
          {
            i = Integer.MAX_VALUE;
            highestPriority = i;
            lock.notifyAll();
            streamingPrioritySet = false;
            notifyLoadingChanged(false);
          }
          else
          {
            i = ((Integer)queue.peek()).intValue();
          }
        }
      }
    }
  }
  
  public final Allocator getAllocator()
  {
    return allocator;
  }
  
  public final void register(Object paramObject, int paramInt)
  {
    loaders.add(paramObject);
    loaderStates.put(paramObject, new LoaderState(paramInt));
    targetBufferSize += paramInt;
  }
  
  public final void trimAllocator()
  {
    allocator.trim(targetBufferSize);
  }
  
  public final void unregister(Object paramObject)
  {
    loaders.remove(paramObject);
    paramObject = (LoaderState)loaderStates.remove(paramObject);
    targetBufferSize -= bufferSizeContribution;
    updateControlState();
  }
  
  public final boolean update(Object paramObject, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    int i;
    int j;
    label55:
    int m;
    float f;
    if (paramLong2 == -1L)
    {
      i = 0;
      paramObject = (LoaderState)loaderStates.get(paramObject);
      if ((bufferState == i) && (nextLoadPositionUs == paramLong2) && (loading == paramBoolean)) {
        break label221;
      }
      j = 1;
      if (j != 0)
      {
        bufferState = i;
        nextLoadPositionUs = paramLong2;
        loading = paramBoolean;
      }
      m = allocator.getTotalBytesAllocated();
      f = m / targetBufferSize;
      if (f <= highBufferLoad) {
        break label227;
      }
      i = 0;
      label113:
      if (bufferState == i) {
        break label249;
      }
    }
    label221:
    label227:
    label249:
    for (int k = 1;; k = 0)
    {
      if (k != 0) {
        bufferState = i;
      }
      if ((j != 0) || (k != 0)) {
        updateControlState();
      }
      if ((m >= targetBufferSize) || (paramLong2 == -1L) || (paramLong2 > maxLoadStartPositionUs)) {
        break label255;
      }
      return true;
      paramLong1 = paramLong2 - paramLong1;
      if (paramLong1 > highWatermarkUs)
      {
        i = 0;
        break;
      }
      if (paramLong1 < lowWatermarkUs)
      {
        i = 2;
        break;
      }
      i = 1;
      break;
      j = 0;
      break label55;
      if (f < lowBufferLoad)
      {
        i = 2;
        break label113;
      }
      i = 1;
      break label113;
    }
    label255:
    return false;
  }
  
  public static abstract interface EventListener {}
  
  private static final class LoaderState
  {
    public final int bufferSizeContribution;
    public int bufferState;
    public boolean loading;
    public long nextLoadPositionUs;
    
    public LoaderState(int paramInt)
    {
      bufferSizeContribution = paramInt;
      bufferState = 0;
      loading = false;
      nextLoadPositionUs = -1L;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.DefaultLoadControl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */