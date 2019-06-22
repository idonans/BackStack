package com.idonans.backstack;

import android.view.View;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import io.reactivex.disposables.Disposable;

public class ViewUtil {

    private ViewUtil() {
    }

    public static Disposable onClick(View view, final View.OnClickListener listener) {
        return onClick(view, 1000, listener);
    }

    public static Disposable onClick(View view, long timeMs, View.OnClickListener listener) {
        return RxView.clicks(view)
                .throttleFirst(timeMs, TimeUnit.MILLISECONDS)
                .subscribe(o -> listener.onClick(view));
    }

}
