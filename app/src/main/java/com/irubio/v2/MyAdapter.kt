import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.irubio.v2.R
import java.lang.Math.ceil

class MyAdapter(private val data: List<Int>):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image1: ImageView = itemView.findViewById<ImageView>(R.id.image1)
        val image2: ImageView = itemView.findViewById<ImageView>(R.id.image2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemlist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image1 = data[position * 2]
        val image2 = if (position * 2 + 1 < data.size) data[position * 2 + 1] else null

        holder.image1.setImageResource(image1)

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Haz clic en la imagen $position", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int = ceil(data.size.toDouble() / 2).toInt()
}