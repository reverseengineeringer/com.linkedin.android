package com.linkedin.android.infra.network;

import com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorFilters;
import com.linkedin.android.pegasus.gen.voyager.common.MediaProcessorSize;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.inject.Inject;

public final class ImageQualityManager
{
  final Comparator<MediaProcessorSize> comparator;
  MediaProcessorFilters filters;
  SortedMap<Float, SortedSet<MediaProcessorSize>> ratioToSizes;
  
  @Inject
  public ImageQualityManager(MediaProcessorSizeComparator paramMediaProcessorSizeComparator)
  {
    comparator = paramMediaProcessorSizeComparator;
  }
  
  static String buildFallbackUri(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("https://media.licdn.com/media{+id}");
    int i = localStringBuilder.indexOf("{+id}");
    localStringBuilder.replace(i, i + 5, paramString);
    return localStringBuilder.toString();
  }
  
  public final String buildOriginalUri(String paramString)
  {
    if (filters == null) {
      return buildFallbackUri(paramString);
    }
    StringBuilder localStringBuilder = new StringBuilder(filters.original);
    int i = localStringBuilder.indexOf("{+id}");
    localStringBuilder.replace(i, i + 5, paramString);
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.network.ImageQualityManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */