package com.example.martoraneca.newcalculator;

import android.view.View;

/**
 * Created by martoraneca on 31-Oct-17.
 */

public interface ICalculations  {

    void numberClicked(View view);
    void percentClicked(View view);
    void operationClicked(View view);
    void equalsClick(View view);
    void clearResult(View view);
    void plusMinusClicked(View view);
    void pointClicked(View view);

}
