package net.kariyer.techchallenge.ui.orders

import android.content.Context
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.Module
import dagger.Provides

@Module
class MyOrdersFragmentModule {

    @Provides
    internal fun provideOrderArrayAdapter(): OrderArrayAdapter {
        return OrderArrayAdapter()
    }

    @Provides
    internal fun provideLinearLayoutManager(context: Context): LinearLayoutManager {
        return LinearLayoutManager(context)
    }

    @Provides
    internal fun provideDividerItemDecoration(context: Context): DividerItemDecoration {
        return DividerItemDecoration(context, LinearLayoutManager.VERTICAL)
    }
}
