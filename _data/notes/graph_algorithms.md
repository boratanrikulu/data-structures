## Minimum Spanning Trees

Kapsayan ağaçlar bağlı ve yönsüz bir çizgede bütün düğümleri birbirine bağlayan ağaç yapısındaki bir alt çizgedir. Minimum kapsayan ağaç(minimum spanning tree, MST) kapsayan ağaçlar içinde toplam ağırlığı en az olan ağaçtır.

Minimum kapsayan ağaç V − 1 tane kenar içerir.

<p align="center"> 
	<img src="_img/week_10_0.jpg" width="400px">
</p>

#### Kurskal's MST algorithm

- Edge'leri ağırlıklara göre sırala  
- Eğer seçilen edge çizildiğinde döngü oluşmuyor ise çizimi yap
- V-1 tane olasaya kadar adım 2'yi tekrarla

<p align="center"> 
	<img src="_img/week_10_1.jpg" width="700px">
</p>

<p align="center"> 
	<img src="_img/week_10_2.jpg" width="700px">
</p>

#### Prim's MST algorithm

Bir yer seçilir. Döngü olmayacak şekilde küçükler ekleye ekleye gidilir.

Anlatması zor, aşağıdaki videoda güzel açıklanmış:

<p align="center"><a href="https://www.youtube.com/watch?v=cplfcGZmX7I ">https://www.youtube.com/watch?v=cplfcGZmX7I</a></p>

#### Dijkstra's algorithm

<p align="center"><a href="https://www.youtube.com/watch?v=jT3c45XkPTg">https://www.youtube.com/watch?v=jT3c45XkPTg</a></p>

<p align="center"><a href="https://www.youtube.com/watch?v=eVV6p0axFYc">https://www.youtube.com/watch?v=eVV6p0axFYc</a></p>
