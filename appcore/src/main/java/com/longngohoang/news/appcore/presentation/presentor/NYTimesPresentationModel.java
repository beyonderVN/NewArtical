package com.longngohoang.news.appcore.presentation.presentor;

import android.util.Log;

import com.longngohoang.news.appcore.data.model.SearchRequest;
import com.longngohoang.news.appcore.presentation.BasePresentationModel;
import com.longngohoang.news.appcore.presentation.viewmodel.BaseVM;
import com.longngohoang.news.appcore.presentation.viewmodel.LoadingMoreVM;
import com.longngohoang.news.appcore.presentation.viewmodel.NoMoreItemVM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 06/10/2016.
 */

public class NYTimesPresentationModel extends BasePresentationModel<BaseVM> {
    private static final String TAG = "NYTimesPreModel";
    public NYTimesPresentationModel() {
        super();
    }
    private int column = 1;

    public SearchRequest getSearchRequest() {
        return searchRequest;
    }

    public void setSearchRequest(SearchRequest searchRequest) {
        this.searchRequest = searchRequest;
    }

    SearchRequest searchRequest = new SearchRequest();

    @Override
    public boolean isShouldFetchRepositories() {
        return visitableList==null||visitableList.size()==0;
    }
    public void add(BaseVM baseVM){
        visitableList.add(baseVM);
    }
    int countNonFullSpanItem = 0;
    public void addAndCollapse(BaseVM baseVM){

        if (countNonFullSpanItem%column==0){
//            Log.d(TAG, "countNonFullSpanItem%2 "+countNonFullSpanItem);
            visitableList.add(baseVM);
            if(!baseVM.isFullSpan()){
                countNonFullSpanItem++;
//                Log.d(TAG, "countNonFullSpanItem: "+countNonFullSpanItem);
            }
        }else{
            if(baseVM.isFullSpan()){
                visitableList.add(baseVM);
            }else {
                for (int i = visitableList.size()-1; i >=0; i--) {
                    Log.d(TAG, "i: "+i);
                    Log.d(TAG, "i: "+visitableList.get(i).isFullSpan());
                    if(!visitableList.get(i).isFullSpan()){
                        visitableList.add(i+1,baseVM);
                        countNonFullSpanItem++;
//                        Log.d(TAG, "countNonFullSpanItem: "+countNonFullSpanItem);
                        break;
                    }
                }

            }
        }
    }
    public void addAndCollapse(List<BaseVM> baseVMs){
        for (BaseVM baseVM: baseVMs
             ) {
            addAndCollapse(baseVM);
        }
        searchRequest.setPage(searchRequest.getPage()+1);
    }
    public void add(List<BaseVM> baseVMs){
        visitableList.addAll(baseVMs);
    }
    private boolean loadingMore = false;
    public boolean isLoadingMore() {
        return loadingMore;
    }


    public void setNoMore(boolean noMore) {
        this.noMore = noMore;
        add(new NoMoreItemVM());
    }

    private boolean noMore =false;
    public boolean isNoMore() {
        return noMore;
    }

    public void refresh(int column) {
        getVisitableList().clear();
        searchRequest.setPage(0);
        noMore =false;
        loadingMore =false;
        countNonFullSpanItem=0;
        this.column = column;
    }

    public void startLoadingMore() {
        if (loadingMore) return;
        loadingMore = true;
        add(new LoadingMoreVM());
    }
    public void stopLoadingMore() {
        if (!loadingMore) return;
        if(getVisitableList().size()==0) return;
        getVisitableList().remove(getVisitableList().size() - 1);
        loadingMore = false;
        Log.d(TAG, "stopLoadingMore: "+getVisitableList().size());
    }

    public void fixLayout(int column) {
        this.column = column;
        Log.d(TAG, "column: "+column);
        List<BaseVM> tempBaseVMs= new ArrayList<>();
        tempBaseVMs.addAll(visitableList);
        visitableList.clear();
        countNonFullSpanItem=0;
        addAndCollapse(tempBaseVMs);
    }
}
