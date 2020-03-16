package com.example.truckpadteste.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.example.truckpadteste.R
import com.example.truckpadteste.model.RouteResult
import com.example.truckpadteste.util.showToastMessage
import com.example.truckpadteste.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel: MainViewModel by viewModel()

        with(mainViewModel) {

            startApiCall()
            alternateProgressBarVisibility()

            observableRouteResultLiveData.observe(this@MainActivity, Observer {
                setRouteInfoTexts(it)
                alternateProgressBarVisibility()
            })

            observableErrorLiveData.observe(this@MainActivity, Observer {
                showToastMessage(it)
                alternateProgressBarVisibility()
            })
        }
    }

    private fun alternateProgressBarVisibility() {
        if (mainProgressBar.isVisible)
            mainProgressBar.visibility = View.GONE
        else
            mainProgressBar.visibility = View.VISIBLE
    }

    private fun setRouteInfoTexts(routeResult: RouteResult) {

        with(routeResult) {
            distanceTv.text = distance.toString()
            refrigeratedTv.text = refrigerated.toString()
            generalTv.text = general.toString()
            granelTv.text = granel.toString()
            neogranelTv.text = neogranel.toString()
            hazardousTv.text = hazardous.toString()
        }
    }
}
