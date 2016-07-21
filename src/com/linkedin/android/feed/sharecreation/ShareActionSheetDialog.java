package com.linkedin.android.feed.sharecreation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog.Builder;
import android.util.Log;
import android.util.Pair;
import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata;
import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.content.AnnotatedTextContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.ArticleContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.AttributedTextContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.ContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.ImageContentDataModel;
import com.linkedin.android.feed.endor.datamodel.transformer.UpdateDataModelTransformer;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.page.feed.FeedBundleBuilder;
import com.linkedin.android.feed.shared.SaveImageAsyncTask;
import com.linkedin.android.imageloader.interfaces.ImageListener;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PermissionRequester;
import com.linkedin.android.infra.app.PermissionRequester.PermissionRequestCallback;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.ImageRequest;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.publishing.sharing.ShareBundle;
import com.linkedin.android.publishing.sharing.ShareIntent;
import com.linkedin.android.publishing.sharing.compose.ShareComposeBundle;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingDialogInterfaceOnClickListener;
import java.util.Set;

public class ShareActionSheetDialog
  implements DialogInterface.OnClickListener, PermissionRequester.PermissionRequestCallback
{
  private static final String TAG = ShareActionSheetDialog.class.getSimpleName();
  FragmentComponent fragmentComponent;
  UpdateDataModel updateDataModel;
  
  public ShareActionSheetDialog(FragmentComponent paramFragmentComponent, Update paramUpdate)
  {
    fragmentComponent = paramFragmentComponent;
    updateDataModel = UpdateDataModelTransformer.toDataModel(paramFragmentComponent, paramUpdate, FeedDataModelMetadata.DEFAULT);
  }
  
  private void openShareCreator(boolean paramBoolean)
  {
    BaseActivity localBaseActivity = fragmentComponent.activity();
    Object localObject = ShareBundle.createFeedShare(ShareComposeBundle.createReshare(updateDataModel.urn, updateDataModel.pegasusUpdate.entityUrn, updateDataModel.pegasusUpdate.tracking, paramBoolean));
    localObject = fragmentComponent.intentRegistry().share.newIntent(localBaseActivity, (BundleBuilder)localObject);
    FeedBundleBuilder.saveUpdateToCache(fragmentComponent.dataManager(), updateDataModel.pegasusUpdate);
    localBaseActivity.startActivity((Intent)localObject);
  }
  
  private void saveImageToPicturesDirectory()
  {
    Image localImage = updateDataModel).content).image;
    fragmentComponent.mediaCenter().load(localImage).into(new ImageListener()
    {
      public final Pair<Integer, Integer> getTargetDimensions()
      {
        return null;
      }
      
      public final void onErrorResponse(String paramAnonymousString, Exception paramAnonymousException)
      {
        Log.e(ShareActionSheetDialog.TAG, "Error loading image", paramAnonymousException);
        paramAnonymousString = fragmentComponent.activity();
        paramAnonymousString = new SnackbarUtil(paramAnonymousString).make(paramAnonymousString.getString(2131231252), 0);
        if (paramAnonymousString != null) {
          paramAnonymousString.show();
        }
      }
      
      public final void onResponse(String paramAnonymousString, ManagedBitmap paramAnonymousManagedBitmap, boolean paramAnonymousBoolean)
      {
        paramAnonymousString = paramAnonymousManagedBitmap.getBitmap().getConfig();
        paramAnonymousString = paramAnonymousManagedBitmap.getBitmap().copy(paramAnonymousString, false);
        new SaveImageAsyncTask(fragmentComponent.context(), fragmentComponent.photoUtils(), paramAnonymousString).executeOnExecutor(SaveImageAsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      }
    });
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str;
    Object localObject1;
    Object localObject2;
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      new TrackingDialogInterfaceOnClickListener(fragmentComponent.tracker(), "reshare_actionsheet_share", new TrackingEventBuilder[0]).onClick(paramDialogInterface, paramInt);
      openShareCreator(false);
      return;
    case 1: 
      new TrackingDialogInterfaceOnClickListener(fragmentComponent.tracker(), "reshare_actionsheet_connections", new TrackingEventBuilder[0]).onClick(paramDialogInterface, paramInt);
      openShareCreator(true);
      return;
    case 2: 
      new TrackingDialogInterfaceOnClickListener(fragmentComponent.tracker(), "reshare_actionsheet_email", new TrackingEventBuilder[0]).onClick(paramDialogInterface, paramInt);
      paramDialogInterface = fragmentComponent.context().getString(2131231226);
      str = updateDataModel.permaLink;
      localObject1 = UpdateDataModel.getContentDataModel(updateDataModel);
      if ((localObject1 instanceof ArticleContentDataModel))
      {
        localObject2 = (ArticleContentDataModel)localObject1;
        localObject1 = title;
        paramDialogInterface = title;
        localObject2 = fullUrl;
        paramDialogInterface = fragmentComponent.i18NManager().getString(2131231280, new Object[] { paramDialogInterface, localObject2 });
        label218:
        localObject2 = paramDialogInterface;
      }
      break;
    }
    for (;;)
    {
      paramDialogInterface = fragmentComponent.i18NManager().getString(2131231282, new Object[] { localObject2, str });
      localObject2 = new Intent("android.intent.action.SEND");
      ((Intent)localObject2).setType("message/rfc882");
      ((Intent)localObject2).putExtra("android.intent.extra.SUBJECT", (String)localObject1);
      ((Intent)localObject2).putExtra("android.intent.extra.TEXT", paramDialogInterface);
      if (((Intent)localObject2).resolveActivity(fragmentComponent.activity().getPackageManager()) != null)
      {
        fragmentComponent.context().startActivity((Intent)localObject2);
        return;
        if (!(updateDataModel instanceof SingleUpdateDataModel)) {
          break label588;
        }
        localObject1 = (SingleUpdateDataModel)updateDataModel;
        if (((SingleUpdateDataModel)localObject1).getActorDataModel() == null)
        {
          localObject2 = "";
          localObject1 = paramDialogInterface;
          paramDialogInterface = (DialogInterface)localObject2;
          break label218;
        }
        localObject2 = getActorDataModelname;
        ContentDataModel localContentDataModel = content;
        if ((localContentDataModel instanceof AttributedTextContentDataModel)) {}
        for (localObject1 = ((AttributedTextContentDataModel)localContentDataModel).getText(fragmentComponent.context());; localObject1 = ((AnnotatedTextContentDataModel)localContentDataModel).getSpannableTextFromAnnotatedText$6e69c961(pegasusUpdate, fragmentComponent, false, false))
        {
          localObject2 = fragmentComponent.i18NManager().getString(2131231283, new Object[] { localObject2, localObject1 });
          localObject1 = paramDialogInterface;
          paramDialogInterface = (DialogInterface)localObject2;
          break;
        }
      }
      new AlertDialog.Builder(fragmentComponent.activity()).setMessage(2131231288).setNeutralButton$2cf0b439().show();
      return;
      new TrackingDialogInterfaceOnClickListener(fragmentComponent.tracker(), "reshare_actionsheet_save_image", new TrackingEventBuilder[0]).onClick(paramDialogInterface, paramInt);
      if (PermissionRequester.hasPermission(fragmentComponent.context(), "android.permission.WRITE_EXTERNAL_STORAGE"))
      {
        saveImageToPicturesDirectory();
        return;
      }
      if (!(fragmentComponent.fragment() instanceof BaseFragment)) {
        break;
      }
      paramDialogInterface = (BaseFragment)fragmentComponent.fragment();
      permissionRequestListener = this;
      paramDialogInterface.requestPermission("android.permission.WRITE_EXTERNAL_STORAGE", 2131231238, 2131231237);
      return;
      label588:
      localObject2 = "";
      localObject1 = paramDialogInterface;
    }
  }
  
  public final void permissionsResult(Set<String> paramSet1, Set<String> paramSet2)
  {
    if (paramSet1.contains("android.permission.WRITE_EXTERNAL_STORAGE")) {
      saveImageToPicturesDirectory();
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (!paramSet2.contains("android.permission.WRITE_EXTERNAL_STORAGE"));
        paramSet1 = fragmentComponent.activity();
      } while ((paramSet1 == null) || (!fragmentComponent.fragment().isAdded()));
      paramSet1 = new SnackbarUtil(paramSet1).make(paramSet1.getString(2131231236), 0);
    } while (paramSet1 == null);
    paramSet1.show();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.sharecreation.ShareActionSheetDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */