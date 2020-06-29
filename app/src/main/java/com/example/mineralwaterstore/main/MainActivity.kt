package com.example.mineralwaterstore.main

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.mineralwaterstore.BaseActivity
import com.example.mineralwaterstore.R
import com.example.mineralwaterstore.home.HomePresenter
import com.example.mineralwaterstore.profile.ProfilePresenter
import com.example.mineralwaterstore.settings.SettingsPresenter
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main_2.*

class MainActivity : BaseActivity(), MainContract.View {

    private var mPresenter: MainContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_2)

        attachPresenter(MainPresenter(this))
        mPresenter?.onViewCreated(savedInstanceState != null)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mPresenter?.onSaveInstanceState(outState)

        // Static variables are dangerous :)
        outState.putInt("ProfilePresenter.mFragmentCount", ProfilePresenter.mFragmentCount)
        outState.putInt("HomePresenter.mFragmentCount", HomePresenter.mFragmentCount)
        outState.putInt("SettingsPresenter.mFragmentCount", SettingsPresenter.mFragmentCount)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        mPresenter?.onRestoreInstanceState(savedInstanceState)

        // Static variables are dangerous :)
        ProfilePresenter.mFragmentCount = savedInstanceState.getInt("ProfilePresenter.mFragmentCount")
        HomePresenter.mFragmentCount = savedInstanceState.getInt("HomePresenter.mFragmentCount")
        SettingsPresenter.mFragmentCount = savedInstanceState.getInt("SettingsPresenter.mFragmentCount")
    }

    override fun onDestroy() {
        detachPresenter()
        super.onDestroy()
    }

    override fun onBackPressed() {
        mPresenter?.onBackPressed()
    }

    override fun attachPresenter(presenter: MainContract.Presenter) {
        mPresenter = presenter
    }

    override fun detachPresenter() {
        mPresenter?.onDestroy()
        mPresenter = null
    }

    override fun finishActivity() {
        finish()
    }

    override fun getMainFragmentManager(): FragmentManager = supportFragmentManager

    override fun getFragmentHolderId(): Int = R.id.container_main

    override fun getBottomNavigation(): BottomNavigationView = view_navigation

    override fun showProgress() {}

    override fun hideProgress() {}


}
