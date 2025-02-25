package com.tayyipgunay.travelbook

// Gerekli Android ve Kotlin sınıflarını içeri aktar.
import android.content.Intent
import android.telecom.Call.Details
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.tayyipgunay.travelbook.databinding.RecyclerRowBinding

// RecyclerView adapter sınıfı tanımlanıyor: LandMarkAdapter.

 class LandMarkAdapter( val landmarklist: ArrayList<Landmark>) : RecyclerView.Adapter<LandMarkAdapter.LandMarkHolder>() {

    class LandMarkHolder(val binding: RecyclerRowBinding) : ViewHolder(binding.root) {//bir viewholder. görünüm istiyor.
//binding.root=bir view

    }

    //  class LandMarkHolder(itemView: View)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandMarkHolder {//
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LandMarkHolder(binding)
//false: Görünüm şişirilir, fakat RecyclerView'a hemen eklenmez.
    //Görünüm oluşturulur (şişirilir) ama arayüze (RecyclerView'a)
    // hemen eklenmez. Adaptör, bu kontrolü daha sonra gerçekleştirir.
    }

    override fun getItemCount(): Int {// boyutunu verir
        return landmarklist.size
    }

    override fun onBindViewHolder(holder: LandMarkHolder, position: Int) { //Görünüm Tutucusuna Veri Bağla
        //onBindViewHolder metodunda holder.binding.RecyclerViewid.text şeklinde yazılmasının sebebi,
        // binding nesnesinin LandMarkHolder sınıfı içerisinde tanımlı olmasıdır.
        // Yani, binding nesnesine erişmek için öncelikle bu nesneyi barındıran holder'ın belirtilmesi gerekmektedir.

        //holder.binding.RecylerViewid.text = landmarklist.get(position).name
        //listeye isimler ekleniyor

        mysingleton.choosenlandmark = landmarklist.get(position)// tıklanan singletona listeyi gönderiyoruz.
        holder.binding.RecylerViewid.text = mysingleton.choosenlandmark?.name//listedeki isimler text alıyoruz




        //singleton heryerde aynı olduğu için



        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ActivityDetails::class.java)
            //yeni sınıf oluşturmayı engelliyor.
            mysingleton.choosenlandmark = landmarklist.get(position)//bunun ile  tıklanan pozisyonu aldık.


            //intent.putExtra("landmark",landmarklist.get(position))

            //ve ortak nesne olan choosenlandmark kaydettik.
            // bu yüzden intent ile  göndermeye gerek kalmadı.




            holder.itemView.context.startActivity(intent)

        }
    }
}



            /*Data Binding:
            Data Bağlama: holder.binding.RecyclerViewid.text = landmarklist.get(position).name kodu,
             landmarklist dizisindeki veriyi RecyclerView'ın her satırına bağlar. Her öğenin name özelliği
             , RecyclerViewid ID'li TextView'e atanır. holder.binding ile RecyclerRowBinding sınıfına erişilir
             ve bu sınıf, XML layout dosyasındaki görünümlere bağlanmayı sağlar.

            Event Handling:
            Olay Yönetimi: holder.itemView.setOnClickListener {...} ile her satıra tıklandığında ne olacağı tanımlanır. Kullanıcı tıkladığında, ActivityDetails sınıfına geçilir ve putExtra metodu ile tıklanan öğenin detayları aktarılır.
            Özet:
            Etkileşim ve Görsellik: Bu kod, RecyclerView'deki her satırın içeriğinin nasıl doldurulacağını
            ve tıklama olaylarına nasıl yanıt verileceğini belirler. Veriler landmarklist dizisinden
            alınır ve kullanıcı etkileşimiyle yeni bir aktivite başlatılır. Bu süreç, kullanıcı arayüzünün
            dinamik ve etkileşimli olmasını sağlar.


        }
    }


}*/


/*class LandMarkAdapter(val landmarklist: ArrayList<Landmark>) : RecyclerView.Adapter<LandMarkAdapter.LandMarkHolder>() {

    // ViewHolder sınıfı tanımlanıyor. Bir ViewHolder, liste öğesi görünümünü temsil eder.
    class LandMarkHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {//yardımcı sınıf

    }

    // RecyclerView yeni bir ViewHolder gerektiğinde bu metot çağrılır. Bu metot, liste öğesi için bir görünüm oluşturur.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LandMarkHolder {
        // Liste öğesinin layout'u şişiriliyor. Şişirme, bir XML layout dosyasını gerçek görünüm nesnelerine dönüştürür.
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LandMarkHolder(binding)
    }

    // Listede kaç öğe olduğunu döndürür. RecyclerView'e listenin boyutunu söyler.
    override fun getItemCount(): Int {
        return landmarklist.size
    }

    // Bu metod, belirli bir pozisyondaki öğenin verilerini ilgili ViewHolder'a bağlar.
    override fun onBindViewHolder(holder: LandMarkHolder, position: Int) {
        // Bir TextView'in (RecylerViewid) metni, bu pozisyondaki landmark'ın adıyla ayarlanıyor.

        holder.binding.RecylerViewid.text = landmarklist.get(position).name
        // ViewHolder'ın öğe görünümüne bir tıklama dinleyicisi ayarlanıyor.
        holder.itemView.setOnClickListener {
            // Öğeye tıklandığında, ActivityDetails aktivitesini başlatmak üzere bir Intent oluşturuluyor.
            val intent = Intent(holder.itemView.context, ActivityDetails::class.java)
            // Intent'e, geçerli pozisyondaki Landmark nesnesi ekstra olarak ekleniyor.
            //  intent.putExtra("landmark", landmarklist.get(position))
            // Görünümün bağlamı kullanılarak aktivite başlatılıyor.
            mysingleton.choosenlandmark = landmarklist.get(position)
            holder.itemView.context.startActivity(intent)

        }
    }
}*/

