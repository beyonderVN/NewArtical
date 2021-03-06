package com.longngohoang.news.appcore.interactor;


import com.longngohoang.news.appcore.data.model.Doc;
import com.longngohoang.news.appcore.data.model.SearchRequest;

import java.util.List;

import rx.Observable;

/**
 * Created by Long on 10/6/2016.
 */

public interface ArticleRepository {


    Observable<List<Doc>> getNews(SearchRequest searchRequest);

    void saveCompetition(Doc competition);
}
