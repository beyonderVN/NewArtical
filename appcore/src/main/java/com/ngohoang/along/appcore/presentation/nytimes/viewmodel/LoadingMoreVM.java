package com.ngohoang.along.appcore.presentation.nytimes.viewmodel;


/**
 * Created by Long on 10/5/2016.
 */

public class LoadingMoreVM extends BaseVM {

    @Override
    public int getVMType(NYTimesMViewTypeFactory vmTypeFactory) {
        return vmTypeFactory.getType(this);
    }

}