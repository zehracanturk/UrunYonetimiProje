# UrunYonetimiProje
Proje Hakkında
Java Spring Boot ile geliştirilmiş basit bir ürün yönetimi (CRUD) API’sidir.
Kullanıcılar,
Yeni ürünler ekleyebilir (POST),
Var olan ürünleri güncelleyebilir (PUT),
Mevcut ürünleri listeleyebilir (GET),
Ürünleri silebilir (DELETE),
Ayrıca ürünleri fiyata veya stok miktarına göre sıralayabilir ya da filtreleyebilir.
Uygulama, test amaçlı H2 bellek içi veritabanı kullanır ve ürün verilerini anlık olarak işler. API, RESTful mimariye uygun şekilde yapılandırılmıştır. Tüm istekler JSON formatında yapılır ve yanıtlar da JSON döner.

Kullanım Senaryoları
1)E-ticaret sistemlerinde ürün envanterini yönetmek
2)CRUD işlemleri öğrenmek ve test etmek
3)Spring Boot ile API geliştirme pratiği yapmak
4)H2 veritabanı, Repository, Service ve Controller yapısını uygulamalı öğrenmek

## Kullanılan Teknolojiler

- Java 17  
- Spring Boot 3.5  
- Spring Boot Starter Web (REST API geliştirme)  
- Spring Data JPA (Veritabanı işlemleri için)  
- H2 Veritabanı (Bellekte çalışan test veritabanı)  
- Maven (Proje yönetimi ve bağımlılık yönetimi)  
- Postman (API testleri için)
  
## API Endpointleri
GenericService<T, ID> ile temel CRUD operasyonları
1. Ürün Listeleme
  ![tumurunlerilistele](https://github.com/user-attachments/assets/192694a7-ca74-4d78-9147-13e2fac48416)
    
2. Ürün Ekleme
  ![urunekle](https://github.com/user-attachments/assets/ea58fc57-7b5b-4718-b4a6-ba4623ba07e1)

3.Ürün Silme
![id2olanurunusil](https://github.com/user-attachments/assets/9bcafaac-fafb-4c86-a8f3-81c08f0e8ce5)
![id2olanurunusill](https://github.com/user-attachments/assets/32eed539-dd19-4685-b1b3-c5ecd9f8f0bb)
Açıklama: Belirtilen ID’ye sahip ürünü siler.

4. Ürün Güncelleme
![urunguncelleme](https://github.com/user-attachments/assets/1f20ba39-7073-4d47-96a4-d526ed1a1a23)

5.Asenkron Loglama (Opsiyonel)
![loglamaislemi](https://github.com/user-attachments/assets/f0c8bda1-fc20-4ded-9633-31cee76338e2)
Açıklama: Ürün listesini arka planda loglayan @Async destekli örnek endpoint.
Multithread kullanılarak ürünler arka planda loglanır.

6.Bubble sort ile fiyata göre sıralama
![fiatagoresirala](https://github.com/user-attachments/assets/468d9074-ee48-4a6f-a261-c97e766ca017)
Açıklama:Java ile ürün fiyatlarını sıralamak için kullanılan basit Bubble Sort algoritması

7.Java Stream ile ada göre sıralama
![adagoresiralama](https://github.com/user-attachments/assets/47820d9e-7554-415e-b2c2-c5f0c181c8a4)

8. İçinde kitap yazan ürünleri getir 
![icindekitapyazanurunlerigetir](https://github.com/user-attachments/assets/e08f1b38-6673-476b-8911-ebe47b7ed40a)

9. Kategori ve fiyata göre ürünleri sırala
![kategorivefiyatsartinagoreurungetir](https://github.com/user-attachments/assets/2b173a7f-cb98-4683-af42-5c89b3ccb165)

10. Stok miktari en az 10 olan ürünleri getir
![stokmiktarienaz10olanurunugetir](https://github.com/user-attachments/assets/5c6afc86-0c84-45ee-989f-f86850d3a1c0)

Test
Testler Postman ile yapılmıştır.
Her endpoint için GET/POST/PUT/DELETE test edilmiştir.
API endpointlerini Postman ile test ettim.  

Ek Özellikler

1)Basit Bubble Sort algoritması (sıralama için)

2)Generic bir servis sınıfı

3)Multithread/@Async ile loglama örneği

4)H2 kullanıldığı için veri bellekte tutulur (her çalıştırmada sıfırlanır)

## DEPLOY İŞlEMİ
![deploy](https://github.com/user-attachments/assets/fee36962-afd4-4070-beb3-bbae145646c6)

1) deploy postman test
![deploypostmantest](https://github.com/user-attachments/assets/2ac4b037-3ca7-4e9b-8ba2-e09ad59c7251)

2)Ürün eklenmiyor
![uruneklenmiyor](https://github.com/user-attachments/assets/1e483748-ff63-4beb-8590-ac1099b89f37)




