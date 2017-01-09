package com.lou.kings.hellorxjava.fragment;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.lou.kings.hellorxjava.R;

import butterknife.Bind;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by YiMuTian on 2017/1/5.
 */

public class RxJavaFragment extends BaseFragment {


    @Bind(R.id.rxjavatext)
    TextView textView;
    @Override
    public int getContentViewID() {
        return R.layout.fragment_rxjava;
    }

    @Override
    public void initData() {
        super.initData();
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                // 发送一个 Hello World 事件
                subscriber.onNext("Hello");

                // 事件发送完成
                subscriber.onCompleted();
            }
        });

        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.e("onCompleted","完成");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.e("onNext",s);
                textView.setText(s);
            }
        };
        observable.subscribe(subscriber);
    }

    @Override
    public void initView(View view) {
        super.initView(view);

    }
}
