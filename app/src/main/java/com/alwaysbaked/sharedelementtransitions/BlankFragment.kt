package com.alwaysbaked.sharedelementtransitions

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_blank.view.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BlankFragment.OnImageClickListener] interface
 * to handle interaction events.
 *
 */
class BlankFragment : Fragment() {
    private var listener: OnImageClickListener? = null
    private lateinit var mView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_blank, container, false)

        mView.sharedElement.setOnClickListener {
            listener!!.onImageClick(mView.sharedElement)
        }

        return mView
    }

    fun setOnImageClickListener(listener: OnImageClickListener) {
        this.listener = listener
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnImageClickListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnImageClickListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnImageClickListener {
        fun onImageClick(sharedElement: View)
    }

}
