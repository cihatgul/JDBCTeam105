import java.sql.*;

public class JDBC01_Query02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yeniyeni?serverTimezone=UTC", "root", "1234");
        Statement st = con.createStatement();
        ResultSet veri = st.executeQuery("SELECT * FROM calisanlar");


        System.out.println("\n========== ORNEK 2 ==========");
        /*=======================================================================
            ORNEK2: Ankara'da yasayan calisanlarin isim ve maaslarini , maas ters
             sirali olarak listeleyiniz.
       ========================================================================*/

        while (veri.next()){
            System.out.println(veri.getString("isim")+" "+veri.getInt("maas"));
        }


        System.out.println("\n========== ORNEK 3 ==========");
         /*======================================================================
          ORNEK3: Maasi en yuksek 3 kisinin adini, yasadigi sehri ve maasini
           isim sirali listeyiniz.
        ========================================================================*/

        String sorgu="select isim, sehir, maas from calisanlar order by maas desc limit 3";

        ResultSet veri2= st.executeQuery(sorgu);

        while (veri2.next()){
            System.out.println(veri2.getString("isim") +" "+ veri2.getString("sehir")+" "
                    + veri2.getInt("maas"));
        }


        // NOT1 : Sorgulama icin get ile istenirse sütun (field) ismini yazabilecegimiz gibi sutun index
        // (field olusturulma sirasina gore) yazilabilir.

        // NOT2 : Sorgumuzda SELECT'ten sonra sadece belli fieldlari dondurmesini istiyorsak
        // get ile cagirdigimiz field indexleri sorguda belirttigimiz sirayla ifade etmemiz gerekiyor


        con.close();
        st.close();
        veri.close();
    }
}


// String dropTable="drop table isciler"; // buraya silecegimiz satiri yazdik

// st.execute(dropTable); // bunu calistigimizda isciler tablosunu siler. bu 1. yontem
