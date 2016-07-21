package com.linkedin.android.feed.endor.datamodel.transformer.service;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TransformerExecutor
  extends ThreadPoolExecutor
{
  public TransformerExecutor()
  {
    super(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new PriorityThreadFactory(TransformerExecutor.class.getSimpleName()));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.transformer.service.TransformerExecutor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */