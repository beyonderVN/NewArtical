package com.longngohoang.news.appcore.presentation.viewmodel;




/**
 * Created by Long on 10/5/2016.
 */

public interface NYTimesMViewTypeFactory {
    int getType(DocVM docVM);


    int getType(LoadingMoreVM loadingMoreVM);

    int getType(NoMoreItemVM noMoreItemVM);

    int getType(DocNoImageVM docNoImageVM);
}
