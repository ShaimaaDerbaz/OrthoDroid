package com.example.shaimaaderbaz.orthoclinic.views;

import com.example.shaimaaderbaz.orthoclinic.models.MediaItem;

import java.util.List;

/**
 * Created by Shaimaa Derbaz on 7/25/2018.
 */

public interface EditOperationsView {

    void setOperationsUpdateSucessfull();
    void setOperationsUpdateFailure();
    void setOperationMediaSuccess();
    void setOperationMediaFailure();
    void setItemDeleteSuccessful();
    void setItemDeleteFailure();
    void showImages(List<MediaItem> mediaItems);
    void showVedios(List <MediaItem> mediaItems);
}
