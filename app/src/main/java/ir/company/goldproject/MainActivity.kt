package ir.company.goldproject

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.company.goldproject.databinding.ActivityMainBinding
import ir.company.goldproject.remote.GoldModel.ContentModel
import ir.company.goldproject.remote.GoldModel.GoldModel
import ir.company.goldproject.remote.Golds.GoldApiRepository
import ir.company.goldproject.remote.Golds.GoldRequest
import ir.company.goldproject.remote.Time.TimeApiRepository
import ir.company.goldproject.remote.Time.TimeRequest
import ir.company.goldproject.remote.dataModel.timeModel.DateModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val goldPrice = ArrayList<ContentModel>()
    private val currencyPrice = ArrayList<ContentModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        TimeApiRepository.instance.getTime(
            object : TimeRequest {
                override fun onSuccess(data: DateModel) {
                    val date = data.date
                    val text = "${date.l_value} ${date.j_value} ${date.F_value} ${date.Y_value}"
                    binding.txtTime.text = text


                }

                override fun onNotSuccess(message: String) {
                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()

                }

                override fun onError(error: String) {
                    Toast.makeText(this@MainActivity, error, Toast.LENGTH_SHORT).show()

                }

            }
        )
        getPrice()

        binding.recyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        binding.txtArz.setOnClickListener {

            binding.txtArz.setTextColor(Color.parseColor("#E7C376"))
            binding.txtGold.setTextColor(Color.parseColor("#787879"))

            setData(currencyPrice)

        }

        binding.txtGold.setOnClickListener {

            binding.txtArz.setTextColor(Color.parseColor("#787879"))
            binding.txtGold.setTextColor(Color.parseColor("#E7C376"))

            setData(goldPrice)

        }


    }

    private fun getPrice(){
        GoldApiRepository.instance.getGolds(
            object :GoldRequest{
                override fun onSuccess(data: GoldModel) {

                    goldPrice.addAll(data.data.golds)
                    currencyPrice.addAll(data.data.currencies)
                    setData(goldPrice)

                }

                override fun onNotSuccess(message: String) {

                }

                override fun onError(error: String) {

                }

            }
        )
    }

    private fun setData(data:ArrayList<ContentModel>){

        binding.recyclerView.adapter =
            RecyclerMainAdapter(data)

    }
}