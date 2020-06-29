package com.example.mineralwaterstore.home

import com.example.mineralwaterstore.BasePresenter
import com.example.mineralwaterstore.BaseView

/**
 * Created by hanilozmen on 8/24/2019.
 */
interface HomeContract{
    interface Presenter: BasePresenter {
        fun onViewCreated()
        fun addFragment()
    }

    interface View: BaseView<Presenter> {
        fun showToast(str: String)
    }
}