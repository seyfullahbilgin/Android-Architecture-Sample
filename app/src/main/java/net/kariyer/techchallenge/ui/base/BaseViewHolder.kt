package net.kariyer.techchallenge.ui.base

import android.content.Context
import android.view.View

import androidx.recyclerview.widget.RecyclerView

//Base class for all view holders
abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val context: Context = itemView.context

    abstract fun bind(item: Any)
}
