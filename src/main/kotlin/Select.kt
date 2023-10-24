package exemples

import java.sql.DriverManager

fun select(){
    val url = "jdbc:sqlite:identifier.sqlitejdbc:sqlite:ruta_del_fitxer_sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    val sentenciaSQL = "SELECT * FROM USUARIO"
    val rs = st.executeQuery(sentenciaSQL)

    System.out.println("ID. \tNombre \tUser \tPassword \tTelefono \tEmail")
    System.out.println("---------------------------------------------------------")

    while (rs.next()) {
        print("" + rs.getInt(1) + "\t")
        print(rs.getString(2) + "\t")
        print(rs.getString(3) + "\t")
        print(rs.getString(4) + "\t")
        print("" + rs.getDouble(5) + "\t")
        println(rs.getString(6))
    }
    val count = st.executeQuery("SELECT COUNT(*) FROM USUARIO")
    println("El numero de registros es: $count")
    rs.close()
    st.close()
    con.close()
}