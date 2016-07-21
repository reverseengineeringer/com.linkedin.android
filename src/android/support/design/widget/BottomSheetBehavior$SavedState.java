package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

public class BottomSheetBehavior$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
  {
    public final BottomSheetBehavior.SavedState createFromParcel(Parcel paramAnonymousParcel)
    {
      return new BottomSheetBehavior.SavedState(paramAnonymousParcel);
    }
    
    public final BottomSheetBehavior.SavedState[] newArray(int paramAnonymousInt)
    {
      return new BottomSheetBehavior.SavedState[paramAnonymousInt];
    }
  };
  final int state;
  
  public BottomSheetBehavior$SavedState(Parcel paramParcel)
  {
    super(paramParcel);
    state = paramParcel.readInt();
  }
  
  public BottomSheetBehavior$SavedState(Parcelable paramParcelable, int paramInt)
  {
    super(paramParcelable);
    state = paramInt;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(state);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.BottomSheetBehavior.SavedState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */