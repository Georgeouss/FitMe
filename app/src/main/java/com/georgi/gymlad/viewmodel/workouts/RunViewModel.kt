package com.georgi.gymlad.viewmodel.workouts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.georgi.gymlad.R
import com.georgi.gymlad.data.SingleLiveEvent
import com.georgi.gymlad.util.RxRunTracker
import com.github.debop.kodatimes.secondDuration
import com.snakydesign.livedataextensions.map
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import org.joda.time.Period
import org.joda.time.format.PeriodFormatterBuilder
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.math.roundToInt

class RunViewModel
@Inject constructor(private val rxRunTracker: RxRunTracker) : ViewModel() {
    companion object {
        const val START_TIME = 0L
        const val END_TIME = Long.MAX_VALUE
        const val INITIAL_DELAY = 0L
        const val PERIOD = 1L
    }

    private val isStarted = MutableLiveData(false)
    private val distanceValue = MutableLiveData(0f)
    private val compositeDisposable = CompositeDisposable()

    val startEvent = SingleLiveEvent<Unit>()
    val speed = MutableLiveData("-")
    val timePassed = MutableLiveData("-")

    val distance = distanceValue.map {
        "${it.roundToInt()} m"
    }

    val buttonText = isStarted.map {
        if (it) R.string.end_button_label else R.string.start_button_label
    }

    fun onButtonClick() {
        if (isStarted.value == true) {
            finish()
        } else {
            startEvent.call()
        }
        isStarted.value?.let {
            isStarted.value = !it
        }
    }

    fun start() {
        Flowable.intervalRange(START_TIME, END_TIME, INITIAL_DELAY, PERIOD, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe {
                timePassed.value = formatDuration(it.secondDuration().toPeriod())
            }
            .addTo(compositeDisposable)
        rxRunTracker.observe().subscribe { runData ->
            distanceValue.value = distanceValue.value?.plus(runData.distance)
            speed.value = formatSpeed(runData.speed)

        }.addTo(compositeDisposable)
    }

    private fun formatDuration(period: Period): String {
        val formatter = PeriodFormatterBuilder()
            .minimumPrintedDigits(2)
            .appendHours()
            .appendSuffix(":")
            .minimumPrintedDigits(2)
            .printZeroAlways()
            .appendMinutes()
            .appendSuffix(":")
            .minimumPrintedDigits(2)
            .appendSeconds()
            .toFormatter()
        return formatter.print(period.normalizedStandard())
    }

    private fun formatSpeed(speed: Float) = "${speed.roundToInt()} m/s"

    private fun finish() {
        compositeDisposable.dispose()
    }
}