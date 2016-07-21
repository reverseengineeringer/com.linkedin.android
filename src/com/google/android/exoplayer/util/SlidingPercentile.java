package com.google.android.exoplayer.util;

import java.util.ArrayList;
import java.util.Comparator;

public final class SlidingPercentile
{
  public static final Comparator<Sample> INDEX_COMPARATOR = new Comparator() {};
  public static final Comparator<Sample> VALUE_COMPARATOR = new Comparator() {};
  public int currentSortOrder = -1;
  public final int maxWeight = 2000;
  public int nextSampleIndex;
  public int recycledSampleCount;
  public final Sample[] recycledSamples = new Sample[5];
  public final ArrayList<Sample> samples = new ArrayList();
  public int totalWeight;
  
  private static final class Sample
  {
    public int index;
    public float value;
    public int weight;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.util.SlidingPercentile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */