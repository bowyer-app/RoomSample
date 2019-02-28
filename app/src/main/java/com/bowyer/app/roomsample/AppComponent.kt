package com.bowyer.app.roomsample

import com.bowyer.app.roomsample.ui.activity.AdviceRegisterActivity
import com.bowyer.app.roomsample.ui.fragment.AdviceListFragment
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RoomModule::class]
)

interface AppComponent : AndroidInjector<RoomApplication> {

    fun inject(activity: AdviceRegisterActivity)

    fun inject(fragment: AdviceListFragment)
}