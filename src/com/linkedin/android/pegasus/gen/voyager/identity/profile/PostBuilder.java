package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.HashStringKeyStore;
import com.linkedin.data.lite.JsonKeyStore;

public final class PostBuilder
  implements FissileDataModelBuilder<Post>, DataTemplateBuilder<Post>
{
  public static final PostBuilder INSTANCE = new PostBuilder();
  private static final JsonKeyStore JSON_KEY_STORE;
  
  static
  {
    HashStringKeyStore localHashStringKeyStore = new HashStringKeyStore();
    JSON_KEY_STORE = localHashStringKeyStore;
    localHashStringKeyStore.put("entityUrn");
    JSON_KEY_STORE.put("title");
    JSON_KEY_STORE.put("permaLink");
    JSON_KEY_STORE.put("image");
    JSON_KEY_STORE.put("createdDate");
    JSON_KEY_STORE.put("postedDate");
    JSON_KEY_STORE.put("numLikes");
    JSON_KEY_STORE.put("numViews");
    JSON_KEY_STORE.put("numComments");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.PostBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */