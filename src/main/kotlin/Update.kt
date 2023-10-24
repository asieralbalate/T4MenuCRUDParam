package exemples

import java.sql.DriverManager

fun update (nombreMenu: String, contrasenaMenu: String, nombreMenuAntiguo:String){
    val url = "jdbc:sqlite:identifier.sqlitejdbc:sqlite:ruta_del_fitxer_sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    val sql = "UPDATE USUARIO SET Nombre = ?, Password = ? WHERE Nombre = ?"
    val pstmt = con.prepareStatement(sql)

    pstmt.setString(1, nombreMenu)
    pstmt.setString(2, contrasenaMenu)
    pstmt.setString(3, nombreMenuAntiguo)

    pstmt.executeUpdate()
    pstmt.close()
    st.close()
    con.close()
}