package exemples

import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.ResultSet

fun insert(nombreMenu: String,usuarioMenu: String,contrasenaMenu: String, telefonoMenu: Double, emailMenu: String){
    val url = "jdbc:sqlite:identifier.sqlitejdbc:sqlite:ruta_del_fitxer_sqlite"
    val con = DriverManager.getConnection(url)
    val st = con.createStatement()
    var pstmt: PreparedStatement

    val existsQuery = "SELECT COUNT(*) FROM USUARIO WHERE Nombre = ? AND User = ?"
    val existsPstmt: PreparedStatement = con.prepareStatement(existsQuery)
    existsPstmt.setString(1, nombreMenu)
    existsPstmt.setString(2, usuarioMenu)
    val resultSet: ResultSet = existsPstmt.executeQuery()

    if (resultSet.next() && resultSet.getInt(1) > 0) {
        println("Ya existe un registro con los mismos valores.")
    } else {
        val insertQuery = "INSERT INTO USUARIO (Nombre, User, Password, Telefono, Email) VALUES (?, ?, ?, ?, ?)"
        pstmt = con.prepareStatement(insertQuery)

        pstmt.setString(1, nombreMenu)
        pstmt.setString(2, usuarioMenu)
        pstmt.setString(3, contrasenaMenu)
        pstmt.setDouble(4, telefonoMenu)
        pstmt.setString(5, emailMenu)

        pstmt.executeUpdate()

        pstmt.close()
    }
    st.close()
    con.close()
}