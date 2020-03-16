package com.example.truckpadteste.activity

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.truckpadteste.R
import com.example.truckpadteste.model.RouteResult
import com.example.truckpadteste.util.showToastMessage
import com.example.truckpadteste.util.toggleVisibility
import com.example.truckpadteste.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mainProgressBar : ProgressBar
    private lateinit var tryAgainButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        val mainViewModel: MainViewModel by viewModel()

        with(mainViewModel) {

            startApiCall()
            toggleProgressBarVisibility()

            observableRouteResultLiveData.observe(this@MainActivity, Observer {
                setRouteInfoTexts(it)
                toggleProgressBarVisibility()
            })

            observableErrorLiveData.observe(this@MainActivity, Observer {
                showToastMessage(it)
                toggleProgressBarVisibility()
                toggleTryAgainButtonVisibility()
            })
        }

        tryAgainButton.setOnClickListener {
            mainViewModel.startApiCall()
            toggleProgressBarVisibility()
            toggleTryAgainButtonVisibility()
        }
    }

    private fun toggleTryAgainButtonVisibility() {
        tryAgainButton.toggleVisibility()
    }

    private fun toggleProgressBarVisibility() {
        mainProgressBar.toggleVisibility()
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

    private fun initViews() {
        mainProgressBar = findViewById(R.id.mainProgressBar)
        tryAgainButton = findViewById(R.id.tryAgainButton)
    }
}
