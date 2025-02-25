package com.tayyipgunay.travelbook

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.internal.NavigationMenu
import com.tayyipgunay.travelbook.databinding.ActivityMainBinding
/*fun getApiLevel(): Int {
            return Build.VERSION.SDK_INT
        }
        println("api level"+getApiLevel())//api level 29*/


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
   // private lateinit var landmarkAdapter: LandMarkAdapter
    private lateinit var landmarkList: ArrayList<Landmark>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        landmarkList = ArrayList<Landmark>()

        val pisa = Landmark("Pisa", "Italy", R.drawable.pisa)
        val colosseum = Landmark("Colloseum", "Italy", R.drawable.collesium)
        val eiffel = Landmark("Eyfel", "France", R.drawable.eyfel)
        val londonBridge = Landmark("London Bridge", "UK", R.drawable.tower)

        landmarkList.add(pisa)
        landmarkList.add(colosseum)
        landmarkList.add(eiffel)
        landmarkList.add(londonBridge)

        //RecyclerView
        binding.recyclerview.layoutManager = LinearLayoutManager(this)//alt alta mı yan yana mı
        /*val adapter = LandMarkAdapter(landmarkList)
        binding.recyclerview.adapter = adapter*/
        binding.recyclerview.adapter=LandMarkAdapter(landmarkList)


    }
}
    /*
//Adapter: Layout & Data

val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkList.map { landmark -> landmark.name })

binding.listView.adapter = adapter

binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
    val intent = Intent(applicationContext,DetailsActivity::class.java)
    intent.putExtra("landmark",landmarkList[position])
    //MySingleton.selectedLandmark = landmarkList[position]
    startActivity(intent)
}
}



LİSTVİEW
val namesList = ArrayList<String>() // İsimleri saklamak için yeni bir liste oluşturuyoruz.

for (landmark in landmarklist) {
namesList.add(landmark.name) // Her landmark nesnesinin adını yeni listeye ekliyoruz.
}
val adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1,namesList)//isimleri listview aktar


//Adapter:Layout&Data

val adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_1, landmarklist.map { landmark -> landmark.name })//isimleri listview aktar


binding.listView.adapter = adapter
binding.listView.onItemClickListener =
AdapterView.OnItemClickListener { parent, view, position, id ->

val intent = Intent(this@MainActivity, ActivityDetails::class.java)
intent.putExtra("landmark", landmarklist.get(position))//serileştirilebilir oldu.

startActivity(intent)

//landmarklist.get(position)

}*/












