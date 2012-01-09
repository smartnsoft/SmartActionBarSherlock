package com.actionbarsherlock.internal.nineoldandroids.view.animation;

import android.graphics.Matrix;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class AnimatorProxy extends Animation {
    public static AnimatorProxy wrap(View view) {
        return new AnimatorProxy(view);
    }

    private final View mView;

	private float mAlpha = 1f;
    private float mTranslationY = 0f;

    private AnimatorProxy(View view) {
        super();
        setDuration(0); //perform transformation immediately
        setFillAfter(true); //persist transformation beyond duration
        view.setAnimation(this);
        mView = view;
    }

    public float getAlpha() {
        return mAlpha;
    }
    public void setAlpha(float alpha) {
        if (mAlpha != alpha) {
            mAlpha = alpha;
            invalidateParent();
    	}
    }
    public float getTranslationY() {
        return mTranslationY;
    }
    public void setTranslationY(float translationY) {
        if (mTranslationY != translationY) {
            mTranslationY = translationY;
            invalidateParent();
        }
    }

    private void invalidateParent() {
        //TODO only invalidate what we need to change
        ((View)mView.getParent()).invalidate();
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        t.setAlpha(mAlpha);

        final Matrix m = t.getMatrix();
        m.setTranslate(0, mTranslationY);
    }
}