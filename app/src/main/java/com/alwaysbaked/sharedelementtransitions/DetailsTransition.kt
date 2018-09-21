package com.alwaysbaked.sharedelementtransitions

import android.transition.ChangeImageTransform
import android.transition.ChangeTransform
import android.transition.ChangeBounds
import android.transition.TransitionSet.ORDERING_TOGETHER
import android.transition.TransitionSet
import android.os.Build
import android.annotation.TargetApi
import android.content.Context
import android.util.AttributeSet


/**
 * Transition that performs almost exactly like [android.transition.AutoTransition], but has an
 * added [ChangeImageTransform] to support properly scaling up our gorgeous kittens.
 *
 * @author bherbst
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
class DetailsTransition : TransitionSet {
    constructor() {
        init()
    }

    /**
     * This constructor allows us to use this transition in XML
     */
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    private fun init() {
        ordering = ORDERING_TOGETHER
        addTransition(ChangeBounds()).addTransition(ChangeTransform()).addTransition(ChangeImageTransform())
    }
}