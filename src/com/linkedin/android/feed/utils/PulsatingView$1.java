package com.linkedin.android.feed.utils;

import com.linkedin.android.infra.RepeatingRunnable;
import com.linkedin.android.infra.events.DelayedExecution;

final class PulsatingView$1
  extends RepeatingRunnable
{
  PulsatingView$1(PulsatingView paramPulsatingView, DelayedExecution paramDelayedExecution)
  {
    super(paramDelayedExecution, 5L);
  }
  
  public final void doRun()
  {
    if ((!PulsatingView.access$000(this$0)) && (PulsatingView.access$100(this$0))) {
      return;
    }
    PulsatingView.access$102(this$0, false);
    long l = System.currentTimeMillis();
    float f2 = PulsatingView.access$200(this$0) * 0.529411F - PulsatingView.access$200(this$0) * 0.1176F / 2.0F;
    float f3 = PulsatingView.access$200(this$0);
    float f4 = PulsatingView.access$200(this$0);
    float f5 = PulsatingView.access$200(this$0) * 0.529411F - PulsatingView.access$200(this$0) * 0.17647F / 2.0F;
    float f6 = PulsatingView.access$200(this$0);
    float f1;
    label131:
    PulsatingView localPulsatingView;
    if (PulsatingView.access$000(this$0))
    {
      f1 = PulsatingView.access$200(this$0) * 0.7647F;
      PulsatingView.access$302(this$0, PulsatingView.access$500$2f3956fd(PulsatingView.access$400(this$0), l, f2, f3 * 0.941176F));
      PulsatingView.access$602(this$0, PulsatingView.access$500$2f3956fd(PulsatingView.access$400(this$0), l - 300L, f5, f6 * 0.7647F));
      PulsatingView.access$702(this$0, PulsatingView.access$800$27f00386(PulsatingView.access$400(this$0), l, 1000));
      PulsatingView.access$902(this$0, PulsatingView.access$800$27f00386(PulsatingView.access$400(this$0), l - 300L, 800));
      PulsatingView.access$1002(this$0, PulsatingView.access$500$2f3956fd(PulsatingView.access$400(this$0), l - 800L, f2, f4 * 0.941176F));
      PulsatingView.access$1102(this$0, PulsatingView.access$500$2f3956fd(PulsatingView.access$400(this$0), l - 1100L, f5, f1));
      localPulsatingView = this$0;
      if (!PulsatingView.access$000(this$0)) {
        break label451;
      }
      f2 = PulsatingView.access$500$2f3956fd(PulsatingView.access$400(this$0), l - 800L, 16.0F, 0.0F);
      label335:
      PulsatingView.access$1202(localPulsatingView, (int)f2);
      localPulsatingView = this$0;
      if (!PulsatingView.access$000(this$0)) {
        break label457;
      }
    }
    label451:
    label457:
    for (f2 = PulsatingView.access$500$2f3956fd(PulsatingView.access$400(this$0), l - 1100L, 16.0F, 0.0F);; f2 = 12.0F)
    {
      PulsatingView.access$1302(localPulsatingView, (int)f2);
      this$0.invalidate();
      if (Math.abs(PulsatingView.access$1100(this$0) - f1) >= 1.0F) {
        break;
      }
      PulsatingView.access$102(this$0, true);
      PulsatingView.access$402(this$0, System.currentTimeMillis() + 300L);
      return;
      f1 = PulsatingView.access$200(this$0) * 0.705882F;
      break label131;
      f2 = 8.0F;
      break label335;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.PulsatingView.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */