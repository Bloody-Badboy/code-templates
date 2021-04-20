#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME}#end

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ${NAME} : RecyclerView.Adapter<${NAME}.ViewHolder>() {

    var data: MutableList<${Model}> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.${Item_Layout_ID}, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount() = data.size

    class ${Model}ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: ${Model}) = with(itemView) {
            // TODO: Bind the data with View
        }
    }
}
