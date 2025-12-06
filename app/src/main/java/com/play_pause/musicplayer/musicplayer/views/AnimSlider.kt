package com.play_pause.musicplayer.musicplayer.views

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.addListener
import com.google.android.material.slider.Slider
import com.play_pause.musicplayer.R

class AnimSlider @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = com.google.android.material.R.attr.sliderStyle) :
    Slider(context, attrs, defStyleAttr) {

    private var progressAnimator: Animator? = null
    private var isAnimatingToValue = Float.NaN

    var isDragging: Boolean = false
        private set

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        addOnSliderTouchListener(onSliderTouchListener)
    }

    override fun onDetachedFromWindow() {
        removeOnSliderTouchListener(onSliderTouchListener)
        super.onDetachedFromWindow()
    }

    override fun setValueFrom(valueFrom: Float) {
        cancelAnimation()
        super.setValueFrom(valueFrom)
    }

    override fun setValueTo(valueTo: Float) {
        cancelAnimation()
        super.setValueTo(valueTo)
    }

    fun setValueAnimated(progress: Float) {
        if (isAnimatingToValue.isNaN() || isAnimatingToValue != progress) {
            cancelAnimation()

            val fromProcess = value.coerceIn(valueFrom, valueTo)
            val toProgress = progress.coerceIn(valueFrom, valueTo)
            if (fromProcess == toProgress) {
                value = toProgress
            } else {
                progressAnimator = ObjectAnimator.ofFloat(this, "value", fromProcess, toProgress).apply {
                    duration = resources.getInteger(android.R.integer.config_mediumAnimTime).toLong()
                    interpolator = DecelerateInterpolator()

                    addListener(
                        onEnd = {
                            isAnimatingToValue = Float.NaN
                        },
                        onCancel = {
                            isAnimatingToValue = Float.NaN
                        }
                    )
                }.also { animator ->
                    animator.start()
                }
            }
        }
    }

    private fun cancelAnimation() {
        progressAnimator?.cancel()
        progressAnimator = null
    }

    private val onSliderTouchListener = object : OnSliderTouchListener {
        override fun onStartTrackingTouch(slider: Slider) {
            isDragging = true
            cancelAnimation()
        }

        override fun onStopTrackingTouch(slider: Slider) {
            isDragging = false
        }
    }
}