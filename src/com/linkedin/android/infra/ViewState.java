package com.linkedin.android.infra;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.inject.Inject;

public class ViewState
  implements Parcelable
{
  public static final Parcelable.Creator<ViewState> CREATOR = new ViewState.1();
  public final Bundle bundle;
  
  @Inject
  public ViewState()
  {
    this(null);
  }
  
  public ViewState(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    bundle = localBundle;
    bundle.setClassLoader(getClass().getClassLoader());
  }
  
  public int describeContents()
  {
    return bundle.describeContents();
  }
  
  public final ViewState getState(String paramString)
  {
    ViewState localViewState2 = (ViewState)bundle.getParcelable(paramString);
    ViewState localViewState1 = localViewState2;
    if (localViewState2 == null)
    {
      localViewState1 = new ViewState();
      bundle.putParcelable(paramString, localViewState1);
    }
    return localViewState1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    bundle.writeToParcel(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.ViewState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */