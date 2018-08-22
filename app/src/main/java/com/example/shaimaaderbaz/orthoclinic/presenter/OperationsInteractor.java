

package com.example.shaimaaderbaz.orthoclinic.presenter;

import android.content.Context;

public interface OperationsInteractor {

    interface OnAddOperationsFinishedListener {
        void onOperationsCreateSucessfull(Context context);
        void onOperationsCreateFailure(Context context);

          }


}
