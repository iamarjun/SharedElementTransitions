package com.alwaysbaked.sharedelementtransitions

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeBounds
import android.transition.ChangeImageTransform
import android.transition.Fade
import android.view.View

class MainActivity : AppCompatActivity(), BlankFragment.OnImageClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addBlankFragment()

    }

    private fun addBlankFragment() {
        val blankFragment = BlankFragment()
        blankFragment.setOnImageClickListener(this)

        blankFragment.sharedElementReturnTransition = ChangeImageTransform()
        blankFragment.returnTransition = ChangeBounds()

        supportFragmentManager.beginTransaction()
                .add(R.id.container, blankFragment)
                .addToBackStack("")
                .commit()
    }

    private fun addBlank2fragment(sharedElement: View) {
        val blank2Fragment = Blank2Fragment()

        blank2Fragment.sharedElementEnterTransition = ChangeImageTransform()
        blank2Fragment.enterTransition = ChangeBounds()

        supportFragmentManager.beginTransaction()
                .add(R.id.container, blank2Fragment)
                .addSharedElement(sharedElement, "mmt")
                .addToBackStack("")
                .commit()
    }

    override fun onImageClick(sharedElement: View) {
        addBlank2fragment(sharedElement)
    }



    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0)
            supportFragmentManager.popBackStack()
        else
            super.onBackPressed()

        supportFinishAfterTransition()
    }
}
