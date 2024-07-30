package org.designpatterns;

// Bir sınıfın Runtime da yalnızca 1 nesnesinin olmasını sağlayan bir pattern.

// Ne zaman kullanılır?
// Genelde bir programda diğer sınıflar tarafından ortak kullanılan kofigurasyonların tutulduğu bir sınıf veya Veritabanı bağlantılarının bulunduğu classlar için kullanılbilir.
// Programda Ortak kullanılan  bu tarz kaynakların paylaştırılması dağıtabilmesi için kullanılır.

public class Singleton {

    private static Singleton INSTANCE;
     private String info = "Initial  value";

     private Singleton() { } //private olarak oluşturduğumuz için farklı bir classdan çağırılamaz.


    public static Singleton getInstance(){
         if( INSTANCE == null ){
             INSTANCE = new Singleton();
         }

         return INSTANCE;
    }


    public String getInfo() {
         return info;
    }

    public void setInfo(String info){
         this.info = info;
    }
}


class SingletonMain {
    public static void main ( String[] args ){
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton1.getInfo());

        Singleton singleton2 = Singleton.getInstance();
        singleton2.setInfo("Changed value");  // Burda info değerini değiştirdiğimizde her iki nesne için de değer değişmiş oldu.
        // Bütün nesneler Singleton classında üretilen tekbir, yalnız nesne ile aynı olduğu için değer değiştirildiğinde Singletoın classında üretilen tek nesnenin değeri değişmiş oldu

        System.out.println(singleton2.getInfo());
        System.out.println(singleton1.getInfo());
    }
}
