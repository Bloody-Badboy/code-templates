#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME}#end

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ${NAME}(private val onItemClick: (${Model}) -> Unit) :
    RecyclerView.Adapter<${NAME}.${Model}ViewHolder>() {

    var data: List<${Model}> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ${Model}ViewHolder {
        return ${Model}ViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ${Model}ViewHolder, position: Int) {
        holder.bind(data[position], onItemClick)
    }

    override fun getItemCount(): Int = data.size

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
