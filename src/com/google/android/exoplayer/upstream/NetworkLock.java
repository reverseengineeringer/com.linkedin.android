package com.google.android.exoplayer.upstream;

import java.util.PriorityQueue;

public final class NetworkLock
{
  public static final NetworkLock instance = new NetworkLock();
  public int highestPriority = Integer.MAX_VALUE;
  public final Object lock = new Object();
  public final PriorityQueue<Integer> queue = new PriorityQueue();
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.upstream.NetworkLock
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */