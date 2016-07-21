package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.view.View.BaseSavedState;

public class AppBarLayout$Behavior$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks()
  {
    public final AppBarLayout.Behavior.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
    {
      return new AppBarLayout.Behavior.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
    }
    
    public final AppBarLayout.Behavior.SavedState[] newArray(int paramAnonymousInt)
    {
      return new AppBarLayout.Behavior.SavedState[paramAnonymousInt];
    }
  });
  boolean firstVisibileChildAtMinimumHeight;
  float firstVisibileChildPercentageShown;
  int firstVisibleChildIndex;
  
  public AppBarLayout$Behavior$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel);
    firstVisibleChildIndex = paramParcel.readInt();
    firstVisibileChildPercentageShown = paramParcel.readFloat();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      firstVisibileChildAtMinimumHeight = bool;
      return;
    }
  }
  
  public AppBarLayout$Behavior$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(firstVisibleChildIndex);
    paramParcel.writeFloat(firstVisibileChildPercentageShown);
    if (firstVisibileChildAtMinimumHeight) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.AppBarLayout.Behavior.SavedState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */