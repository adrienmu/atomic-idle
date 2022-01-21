package com.amussio.atomicidle

import android.app.Application
import com.amussio.atomicidle.data.repository.StockRepository
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class AtomicIdleApplication: Application() {
    @Inject
    lateinit var stockRepository: StockRepository
}