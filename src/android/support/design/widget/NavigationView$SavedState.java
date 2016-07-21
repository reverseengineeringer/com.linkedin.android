package android.support.design.widget;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.view.View.BaseSavedState;

public class NavigationView$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks()
  {
    public final NavigationView.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
    {
      return new NavigationView.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
    }
    
    public final NavigationView.SavedState[] newArray(int paramAnonymousInt)
    {
      return new NavigationView.SavedState[paramAnonymousInt];
    }
  });
  public Bundle menuState;
  
  public NavigationView$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel);
    menuState = paramParcel.readBundle(paramClassLoader);
  }
  
  public NavigationView$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeBundle(menuState);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.NavigationView.SavedState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */