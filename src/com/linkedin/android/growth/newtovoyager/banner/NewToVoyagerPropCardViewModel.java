package com.linkedin.android.growth.newtovoyager.banner;

import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.PropType;
import com.linkedin.android.relationships.home.AbstractPropViewModel;

public final class NewToVoyagerPropCardViewModel
  extends AbstractPropViewModel<NewToVoyagerPropCardViewHolder>
{
  public final String heading;
  public final NewToVoyagerPropCardViewListener listener;
  public final String subheading;
  
  public NewToVoyagerPropCardViewModel(String paramString1, String paramString2, String paramString3, NewToVoyagerPropCardViewListener paramNewToVoyagerPropCardViewListener)
  {
    super(paramString1, PropType.NEW_TO_VOYAGER);
    heading = paramString2;
    subheading = paramString3;
    listener = paramNewToVoyagerPropCardViewListener;
  }
  
  public final boolean alwaysDismiss()
  {
    return true;
  }
  
  public final ViewHolderCreator<NewToVoyagerPropCardViewHolder> getCreator()
  {
    return NewToVoyagerPropCardViewHolder.CREATOR;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.banner.NewToVoyagerPropCardViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */