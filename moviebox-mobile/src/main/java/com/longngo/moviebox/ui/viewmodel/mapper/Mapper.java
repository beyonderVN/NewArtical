package com.longngo.moviebox.ui.viewmodel.mapper;

import com.longngo.moviebox.data.model.Movie;
import com.longngo.moviebox.ui.viewmodel.BaseVM;
import com.longngo.moviebox.ui.viewmodel.MovieVM;
import com.longngo.moviebox.ui.viewmodel.TrailerMovieVM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Long on 10/5/2016.
 */

public class Mapper {
    public static BaseVM tranToMovieVM(Movie movie){
        return new MovieVM(movie);
    }
    public static BaseVM tranToMovieTrailerVM(Movie movie){
        TrailerMovieVM trailerMovieVM = new TrailerMovieVM(movie);
        trailerMovieVM.setFullSpan(true);
        return trailerMovieVM;
    }

    public static List<BaseVM> tranToVM(List<Movie> movieList){
        List<BaseVM> list = new ArrayList<>();

        for (Movie item :movieList) {
//            list.add(item.getVoteAverage()>5?tranToMovieTrailerVM(item):tranToMovieVM(item));

            if (item.getVoteAverage()>5){
                list.add(tranToMovieTrailerVM(item));

            }else {
                list.add(tranToMovieVM(item));

            }
        }
        return list;
    }




}