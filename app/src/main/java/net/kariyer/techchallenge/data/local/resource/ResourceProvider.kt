package net.kariyer.techchallenge.data.local.resource

import android.content.Context
import android.content.res.Resources

class ResourceProvider(private val mContext: Context) {

    private val resources: Resources
        get() = mContext.resources

    fun getString(resId: Int): String {
        return mContext.getString(resId)
    }

    fun getString(resId: Int, value: String): String {
        return mContext.getString(resId, value)
    }

    fun getStringArray(resId: Int): Array<String> {
        return resources.getStringArray(resId)
    }


}