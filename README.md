Aşağıda, bu proje için örnek bir README dosyası bulabilirsiniz:

---

# Travel Book

**Travel Book**, kullanıcıların dünya çapındaki simgesel yapıları keşfetmesini sağlayan basit bir Android uygulamasıdır. Uygulama, modern Android geliştirme teknikleri (View Binding, RecyclerView, Parcelable ve Singleton tasarım deseni) kullanılarak geliştirilmiştir.

## Özellikler

- **Dinamik Liste Görüntüleme:**  
  Landmark (simge yapı) verileri, RecyclerView kullanılarak listelenir.

- **Detay Sayfası:**  
  Listede yer alan her landmark’a tıklanıldığında detay sayfası açılır ve seçilen landmark’ın bilgileri gösterilir.

- **Veri Aktarımı:**  
  Landmark nesneleri, Parcelable arayüzü sayesinde Activity’ler arasında güvenli bir şekilde aktarılır. Ayrıca, seçilen landmark bilgisi singleton yapı aracılığıyla yönetilir.

- **Modern Android Teknikleri:**  
  - **View Binding:** `findViewById` kullanımından kurtulup, tip güvenli ve okunabilir erişim sağlanır.  
  - **RecyclerView & Adapter:** Dinamik listeleme ve kullanıcı etkileşimleri için kullanılır.

## Teknolojiler

- Kotlin
- Android SDK (Min API 21+)
- RecyclerView
- View Binding
- Parcelable
- Singleton Tasarım Deseni

## Gereksinimler

- **Android Studio:** En güncel sürüm önerilir.
- **Min SDK:** API 21 veya üzeri.
- **Gradle:** Projeyi derlemek için uygun yapılandırmaya sahip olmalıdır.

## Kurulum

1. **Projeyi Klonlayın:**

   ```bash
   git clone https://github.com/kullaniciadi/TravelBook.git
   ```

2. **Projeyi Android Studio’da Açın:**

   - Android Studio’yu başlatın.
   - "Open an existing project" seçeneğini kullanarak klonladığınız proje klasörünü seçin.

3. **Projeyi Derleyin ve Çalıştırın:**

   - Android Studio içerisindeki `Run` butonuna basarak emülatör veya bağlı bir cihaz üzerinde çalıştırabilirsiniz.

## Kullanım

- **Liste Görüntüleme:**  
  Uygulama açıldığında, RecyclerView yardımıyla landmark’lar listelenir. Her liste elemanı, landmark’ın adını içerir.

- **Detay Sayfası:**  
  Listede yer alan herhangi bir landmark’a tıkladığınızda, ilgili detay sayfası açılır. Bu sayfada landmark’ın adı, ülkesinin bilgisi ve görseli görüntülenir.

- **Veri Aktarımı & Singleton Kullanımı:**  
  Landmark verileri, Parcelable arayüzü ile diğer Activity’e aktarılır. Ek olarak, `mysingleton` aracılığıyla tıklanan landmark global olarak erişilebilir hale getirilir.

## Proje Yapısı

```
TravelBook/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/tayyipgunay/travelbook/
│   │   │   │   ├── MainActivity.kt       // Landmark listesini ve RecyclerView işlemlerini içerir.
│   │   │   │   ├── ActivityDetails.kt    // Seçilen landmark’ın detaylarını gösterir.
│   │   │   │   ├── Landmark.kt           // Landmark veri sınıfı, Parcelable implementasyonu ile.
│   │   │   │   ├── LandMarkAdapter.kt      // RecyclerView adapter sınıfı.
│   │   │   │   └── mysingleton.kt          // Seçilen landmark bilgisini saklayan singleton yapı.
│   │   │   ├── res/                      // Layout dosyaları, drawable kaynakları vb.
│   │   ├── AndroidManifest.xml
```

## Açıklamalar

- **View Binding:**  
  Projede, XML’de tanımlı view’lere tip güvenli erişim sağlamak amacıyla View Binding kullanılmıştır. Bu sayede `findViewById` kullanımına gerek kalmamıştır.

- **RecyclerView & Adapter:**  
  Landmark listesi dinamik olarak RecyclerView ile gösterilir. Her öğe için oluşturulan adapter, kullanıcı tıklamalarını dinleyerek ilgili detay sayfasına geçişi sağlar.

- **Veri Aktarımı:**  
  Landmark nesneleri, Parcelable arayüzü sayesinde Intent aracılığıyla aktarılır. API 33 ve üzeri için güvenli tip dönüşümü kullanılırken, daha düşük API seviyelerinde alternatif yöntem uygulanır.

- **Singleton Yapı:**  
  `mysingleton` isimli yapı, seçilen landmark bilgisini global olarak saklayarak detay sayfasına aktarımda yardımcı olur.

## Katkıda Bulunma

Projeye katkıda bulunmak, hata bildirmek veya geliştirmeler önermek için GitHub üzerinden issue açabilir veya pull request gönderebilirsiniz.

## Lisans

Bu proje, [MIT Lisansı](https://opensource.org/licenses/MIT) kapsamında lisanslanmıştır. (Proje gereksinimlerine göre farklı bir lisans da tercih edebilirsiniz.)

---

![WhatsApp Görsel 2025-02-26 saat 15 16 21_93f145e9](https://github.com/user-attachments/assets/ddf2af27-d379-41ec-a27e-42935bf2b483)   ![WhatsApp Görsel 2025-02-26 saat 15 16 20_0c44bdfe](https://github.com/user-attachments/assets/da21c632-322f-4d44-9675-e233c62708e6)

