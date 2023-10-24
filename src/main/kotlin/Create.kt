package exemples

import java.sql.DriverManager

fun create(){
    val url = "jdbc:sqlite:identifier.sqlitejdbc:sqlite:ruta_del_fitxer_sqlite"

    val	con = DriverManager.getConnection(url)

    val st = con.createStatement ()
    st.executeUpdate("CREATE TABLE if not exists USUARIO " +
            "(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Nombre varchar(15)," +
            "User varchar(15)," +
            "Password varchar(10)," +
            "Telefono numeric," +
            "Email varchar(50))")
    st.close()

    con.close()
}