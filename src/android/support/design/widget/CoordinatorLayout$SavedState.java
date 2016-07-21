package android.support.design.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.ParcelableCompat;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.util.SparseArray;
import android.view.View.BaseSavedState;

public class CoordinatorLayout$SavedState
  extends View.BaseSavedState
{
  public static final Parcelable.Creator<SavedState> CREATOR = ParcelableCompat.newCreator(new ParcelableCompatCreatorCallbacks()
  {
    public final CoordinatorLayout.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
    {
      return new CoordinatorLayout.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
    }
    
    public final CoordinatorLayout.SavedState[] newArray(int paramAnonymousInt)
    {
      return new CoordinatorLayout.SavedState[paramAnonymousInt];
    }
  });
  SparseArray<Parcelable> behaviorStates;
  
  public CoordinatorLayout$SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    super(paramParcel);
    int j = paramParcel.readInt();
    int[] arrayOfInt = new int[j];
    paramParcel.readIntArray(arrayOfInt);
    paramParcel = paramParcel.readParcelableArray(paramClassLoader);
    behaviorStates = new SparseArray(j);
    int i = 0;
    while (i < j)
    {
      behaviorStates.append(arrayOfInt[i], paramParcel[i]);
      i += 1;
    }
  }
  
  public CoordinatorLayout$SavedState(Parcelable paramParcelable)
  {
    super(paramParcelable);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    if (behaviorStates != null) {}
    int[] arrayOfInt;
    Parcelable[] arrayOfParcelable;
    for (int i = behaviorStates.size();; i = 0)
    {
      paramParcel.writeInt(i);
      arrayOfInt = new int[i];
      arrayOfParcelable = new Parcelable[i];
      int j = 0;
      while (j < i)
      {
        arrayOfInt[j] = behaviorStates.keyAt(j);
        arrayOfParcelable[j] = ((Parcelable)behaviorStates.valueAt(j));
        j += 1;
      }
    }
    paramParcel.writeIntArray(arrayOfInt);
    paramParcel.writeParcelableArray(arrayOfParcelable, paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.CoordinatorLayout.SavedState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */