package com.linkedin.android.growth.newtovoyager.transactional;

import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.viewmodel.ViewModel;

public final class NewToVoyagerIntroViewModel
  extends ViewModel<NewToVoyagerIntroViewHolder>
{
  public View.OnClickListener okayButtonOnClickListener;
  public String title;
  
  public final ViewHolderCreator<NewToVoyagerIntroViewHolder> getCreator()
  {
    return NewToVoyagerIntroViewHolder.CREATOR;
  }
  
  public final void onBindViewHolder$5e7e9a38(NewToVoyagerIntroViewHolder paramNewToVoyagerIntroViewHolder)
  {
    if (title != null) {
      titleView.setText(title);
    }
    if (okayButtonOnClickListener != null) {
      okayButton.setOnClickListener(okayButtonOnClickListener);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.transactional.NewToVoyagerIntroViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */