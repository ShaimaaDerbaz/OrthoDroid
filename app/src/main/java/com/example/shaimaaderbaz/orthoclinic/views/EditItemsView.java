package com.example.shaimaaderbaz.orthoclinic.views;

import com.example.shaimaaderbaz.orthoclinic.models.MediaItem;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 7/25/2018.
 */

public interface EditItemsView {
    void setItemsUpdateSucessfull();
    void setItemsUpdateFailure();
    void setItemDeleteSuccessful();
    void setItemDeleteFailure();
    void setItemMediaFailure();
    void setItemMediaSuccessful();
    void showImages(List<MediaItem> mediaItems);
}
