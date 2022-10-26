package com.example.wizelineproject.modules

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.wizelineproject.screens.AsksFragment
import com.example.wizelineproject.screens.BidsFragment
import com.example.wizelineproject.screens.CoinsFragment
import com.example.wizelineproject.screens.adapters.ViewPagerAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext

@Module(includes = [ViewsModule.ViewPagerAdapterBuilderModule::class])
@InstallIn(ActivityComponent::class)
abstract class ViewsModule {

    @Module
    @InstallIn(ActivityComponent::class)
    internal class ViewPagerAdapterBuilderModule {

        tailrec fun Context?.activity(): Activity? = this as? Activity
            ?: (this as? ContextWrapper)?.baseContext?.activity()

        @Provides
        fun provideViewPagerAdapter(
            @ActivityContext context: Context,
            asksFragment: AsksFragment,
            bidsFragment: BidsFragment,
            coinsFragment: CoinsFragment
        ): ViewPagerAdapter {
            val activity = context.activity() as AppCompatActivity
            val viewPagerAdapter = ViewPagerAdapter(activity.supportFragmentManager)
            viewPagerAdapter.addfragment(coinsFragment as Fragment, "Coins")
            viewPagerAdapter.addfragment(asksFragment as Fragment, "Asks")
            viewPagerAdapter.addfragment(bidsFragment as Fragment, "Bids")
            return viewPagerAdapter
        }
    }
}
