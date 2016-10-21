package com.longngo.moviebox.ui.nytimes.adapter.viewholder;

import android.view.View;
import android.widget.TextView;

import com.longngo.moviebox.R;
import com.ngohoang.along.appcore.presentation.nytimes.viewmodel.DocNoImageVM;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Long on 10/5/2016.
 *
 */

public class DocNoImageHolder extends BaseViewHolder<DocNoImageVM> {
    private static final String TAG = "DocHolder";
    @BindView(R.id.tvTitle)
    TextView des;
    public DocNoImageHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public  void bind(DocNoImageVM item) {

        des.setText(item.getDoc().getSnippet());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}