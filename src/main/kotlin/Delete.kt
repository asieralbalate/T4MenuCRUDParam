package exemples

import java.sql.DriverManager

fun delete(idMenu: Int){
    val url = "jdbc:sqlite:identifier.sqlitejdbc:sqlite:ruta_del_fitxer_sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()

    val sql = "DELETE FROM USUARIO WHERE ID = ?"
    val pstmt = con.prepareStatement(sql)

    pstmt.setInt(1, idMenu)

    pstmt.executeUpdate()
    pstmt.close()
    st.close()
    con.close()
}