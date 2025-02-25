package com.tayyipgunay.travelbook

import android.os.Build

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tayyipgunay.travelbook.databinding.ActivityDetailsBinding

class ActivityDetails : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var selectedLandmark: Landmark? = null


        binding = ActivityDetailsBinding.inflate(layoutInflater)
        // val view = binding.root
        setContentView(binding.root)


        /*  if(Build.VERSION.SDK_INT>=33) {
       selectedLandmark=intent.getSerializableExtra("landmark",Landmark::class.java)
   Otomatik , Bu yöntemde, selectedLandmark değişkeni otomatik olarak nullable (Landmark?) olarak kabul edilir.
      Bunun nedeni, getSerializableExtra metodunun döndüreceği değerin null olma olasılığıdır.
       Bu yüzden Kotlin, otomatik olarak bu değeri nullable olarak işler.
 Eğer bu değerin null olmadığından eminseniz ve null kontrolü yapmadan kullanmak istiyorsanız,
 bu durumda selectedLandmark'ın nullable olmasını istemeyebilirsiniz. Bu durumda, !!
 operatörünü kullanarak null olmadığını belirtmeniz gerekebilir.

       }


       else{
           selectedLandmark= intent.getSerializableExtra("landmark")as Landmark
        API 33'ten Düşük İçin: Bu satır, Serializable nesneyi eski yöntemle alır ve manuel olarak Landmark sınıfına dönüştürür.
Manuel Tür Dönüştürme
 Bu satırda, getSerializableExtra metodunun döndürdüğü değeri Landmark
olarak dönüştürmek için as anahtar kelimesi kullanılır.Eğer dönüşüm başarısız olursa, yani dönen değer Landmark
değilse, bu satır ClassCastException hatası verebilir.
 selectedLandmark direkt olarak Landmark türünde bir değişken olur. Ancak, dönüşüm başarısız olursa uygulama hata verebilir.

     }*/


        /*    Neden Parcelable Daha Hızlı?
        Parcelable, Serializable'dan daha hızlıdır çünkü:

        Bellek Yönetimi:

        Parcelable doğrudan bellek üzerinde işlem yapar ve Android'in bellek yönetim sistemine optimize edilmiştir.
        Serializable ise Java'nın genel serileştirme mekanizmasını kullanır ve daha fazla bellek kullanır.
        Özelleştirilmiş Yapı:

        Parcelable özel olarak Android için tasarlanmıştır ve nesnelerin yazılması ve okunması sırasında optimize edilmiştir.
        Serializable daha genel amaçlıdır ve her türlü Java nesnesini serileştirmek için kullanılır.
        Daha Az Overhead:

        Parcelable daha az işlem overhead'i ile çalışır, çünkü serileştirme işlemi sırasında gereksiz bilgileri saklamaz.
        Serializable nesne serileştirme sırasında daha fazla meta bilgi saklar.*/
        // Belirtilen türün gerçekten Landmark olup olmadığını kontrol eder.
        //Tür uyuşmazlığı durumunda null döner ve bu sayede ClassCastException hatası önlenir.
        if (Build.VERSION.SDK_INT >= 33) {
            selectedLandmark = intent.getParcelableExtra("landmark", Landmark::class.java)
        }
        /*Açıklama: Parcelable arayüzünü uygulayan Landmark sınıfından bir nesneyi Intent'ten güvenli bir
            şekilde almak için kullanılır. getParcelableExtra() yöntemi, iki parametre alır: anahtar ("landmark")
             ve döndürülecek nesnenin sınıf tipi (Landmark::class.java). Bu yöntem,
           tür güvenliğini sağlar, yani yanlış türde bir veri döndürülmez.
           Sonuç: Uygulamanız çökmez, sadece selectedLandmark null olur. Bu durumda, null kontrolü yaparak uygun bir işlem
           (örneğin, kullanıcıya bir hata mesajı göstermek) gerçekleştirebilirsiniz.
            */
        else {
            selectedLandmark = intent.getParcelableExtra<Landmark>("landmark")


            //}
            /*Ne Olur?: Bu yöntemde, tür güvenliği sağlanmadığı için aldığınız veri Landmark değilse, uygulama çalışırken bir hata
          (ClassCastException) fırlatılır. Yani, veri yanlış türdeyse uygulamanız büyük ihtimalle çöker.
            Uygulamanız, ClassCastException hatası alır ve büyük ihtimalle çöker. Kullanıcı, uygulamanızın aniden durduğunu görebilir.*/


            //  val intent = intent singleton ile gerek yok
            // ve parcelable ve seriziable gerek yok.
            //pozisyon numarası direkt choosenlandmark içinde çünkü.


            /*binding.Countryname.text = selectedLandmark?.name//mysingleton.choosenlandmark?.name

        binding.imageView.setImageResource(selectedLandmark?.image ?: 0)

        binding.countryIcon.text = selectedLandmark?.country*/

            binding.Countryname.text = mysingleton.choosenlandmark?.name

            mysingleton.choosenlandmark?.let {
                binding.imageView.setImageResource(it.image)
                /* setImageResource: Her zaman geçerli bir resim kaynağı (örneğin, R.drawable.image) almak zorundadır. null değer gönderilemez.
            ?.let: Bu yapı, yalnızca choosenlandmark null değilse işlemi güvenli bir şekilde gerçekleştirmemizi sağlar.*/
            }

            binding.countryIcon.text = mysingleton.choosenlandmark?.country

        }
    }
}