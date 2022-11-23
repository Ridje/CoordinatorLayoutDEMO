package com.kis.coordinatorlayoutdemo

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.View.MeasureSpec
import android.widget.Button
import androidx.coordinatorlayout.widget.CoordinatorLayout


class AnotherBehavior @JvmOverloads constructor(
    context: Context, attrs: AttributeSet,
): CoordinatorLayout.Behavior<Button>(context, attrs) {
    private val mMinWidth = 500
    override fun onMeasureChild(
        parent: CoordinatorLayout,
        child: Button,
        parentWidthMeasureSpec: Int,
        widthUsed: Int,
        parentHeightMeasureSpec: Int,
        heightUsed: Int,
    ): Boolean {
        var widthMode = MeasureSpec.getMode(parentWidthMeasureSpec)
        var width = MeasureSpec.getSize(parentWidthMeasureSpec)

        if (widthMode == MeasureSpec.UNSPECIFIED || width < mMinWidth) {

            parent.onMeasureChild(child,
                MeasureSpec.makeMeasureSpec(0, widthMode), widthUsed,
                parentHeightMeasureSpec, heightUsed);
            return true
        }

        return false
    }
}
