#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME}#end

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ${NAME}(private val onItemClick: (${Model}) -> Unit) :
    ListAdapter<${Model}, ${NAME}.${Model}ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<${Model}>() {
            override fun areItemsTheSame(oldItem: ${Model}, newItem: ${Model}): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ${Model}, newItem: ${Model}): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ${Model}ViewHolder {
        return ${Model}ViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ${Model}ViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClick)
    }

    class ${Model}ViewHolder private constructor(val binding: ${ViewBinding}) :
        RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun create(parent: ViewGroup): ${Model}ViewHolder {
                return ${Model}ViewHolder(
                    binding = ${ViewBinding}.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }

        fun bind(item: ${Model}, onItemClick: (${Model}) -> Unit) {
            itemView.setOnClickListener {
                onItemClick(item)
            }
        }
    }
}
