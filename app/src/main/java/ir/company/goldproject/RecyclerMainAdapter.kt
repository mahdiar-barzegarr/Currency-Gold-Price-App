package ir.company.goldproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ir.company.goldproject.databinding.RecyclerMainItemBinding
import ir.company.goldproject.remote.GoldModel.ContentModel

class RecyclerMainAdapter(
    private val allData: ArrayList<ContentModel>
): RecyclerView.Adapter<RecyclerMainAdapter.MainViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val view = MainViewHolder(RecyclerMainItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
        return view

    }

    override fun getItemCount(): Int = allData.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.setData(allData[position])
    }
    inner class MainViewHolder(
        private val binding:RecyclerMainItemBinding
    ): ViewHolder(binding.root){

        fun setData(data: ContentModel) {
            binding.txtLable.text = data.label
            binding.txtPrice.text = String.format("%,d", (data.price / 10))
        }

    }


}