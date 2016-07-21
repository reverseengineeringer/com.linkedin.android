package com.linkedin.android.growth.heathrow;

import com.linkedin.gen.avro2pegasus.events.relevance.ErrorType;

final class HeathrowRoutingFragment$1
  implements Runnable
{
  HeathrowRoutingFragment$1(HeathrowRoutingFragment paramHeathrowRoutingFragment) {}
  
  public final void run()
  {
    if ((!HeathrowRoutingFragment.access$000(this$0)) && (this$0.isAdded()))
    {
      HeathrowRoutingFragment.access$002$2dceeb40(this$0);
      HeathrowRoutingFragment.access$100(this$0, ErrorType.TIMED_OUT);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.heathrow.HeathrowRoutingFragment.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */