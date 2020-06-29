package com.example.mineralwaterstore.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mineralwaterstore.R
import com.example.mineralwaterstore.BaseFragment


/**
 * Created by hanilozmen on 8/24/2019.
 */
class HomeFragment: BaseFragment(), HomeContract.View {
    private var mPresenter: HomeContract.Presenter? = null

    private lateinit var mRootView : View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mRootView = inflater.inflate(R.layout.fragment_home, container, false)
        attachPresenter(HomePresenter(this))
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val arg = arguments?.getString(HomePresenter.KEY_TITLE,"")
//        if(arg?.contains("Root") != true) {
//            mRootView.setBackgroundColor(ContextCompat.getColor(mRootView.context, R.color.colorAccent))
//        }
//        text_title.text = arg
//        button_add_fragment.setOnClickListener {
//            mPresenter?.addFragment()
//        }
    }

    override fun onDestroyView() {
        detachPresenter()
        super.onDestroyView()
    }

    override fun showToast(str: String) {
        Toast.makeText(context,str,Toast.LENGTH_LONG)
    }

    override fun attachPresenter(presenter: HomeContract.Presenter) {
        mPresenter = presenter
    }

    override fun detachPresenter() {
        mPresenter?.onDestroy()
        mPresenter = null
    }

    override fun showProgress() {
    }

    override fun hideProgress() {
    }

}