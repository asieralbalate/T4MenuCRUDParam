package exemples

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.system.exitProcess

fun main() {
    showMenu()
}

fun showMenu() {
    selectAll()
    val s = "Opciones"
    println(" ")
    println(s)
    println("-".repeat(s.length))
    println("0- Exit")
    println("1- Create")
    println("2- Select")
    println("3- Update")
    println("4- Insert")
    println("5- Delete")
    println("6- DeleteAll")

    introduceNumber()
}

private fun introduceNumber() {
    println(" ")
    println("Introdueix un numero (0 per acabar): ")
    val input = BufferedReader(InputStreamReader(System.`in`)).readLine()
    val num = input.toIntOrNull()
    if (num != null) {
        loopNumbers(num)
    } else {
        println("Entrada no valida. Introduix un numero válid.")
        println("")
        showMenu()
    }
}

fun readUpdateData(){
    println(" ")
    println("Introduce en orden nuevo nombre, nueva contraseña y el nombre antiguo: ")
    val input = BufferedReader(InputStreamReader(System.`in`)).readLine()
    val nombre = input.toString()
    val contraseña = input.toString()
    val nombreAntiguo = input.toString()
    if (!nombre.equals(null) && !contraseña.equals(null)) {
        update(nombre,contraseña, nombreAntiguo)
    } else {
        println("Entrada no valida. Introduix un numero válid.")
        println("")
    }
}

fun readInsertData(){
    println(" ")
    println("Introduce nombre, usuario, contraseña, telefono y email: ")
    val input = BufferedReader(InputStreamReader(System.`in`)).readLine()
    val nombre = input.toString()
    val usuario = input.toString()
    val contraseña = input.toString()
    val telefono = input.toDouble()
    val email = input.toString()
    if (!nombre.equals(null) && !contraseña.equals(null)) {
        insert(nombre,usuario,contraseña, telefono, email)
    } else {
        println("Entrada no valida. Introduix un numero válid.")
        println("")
    }
}

fun readDeleteData(){
    println(" ")
    println("Introduce el id de una fila para eliminarla: ")
    val input = BufferedReader(InputStreamReader(System.`in`)).readLine()
    val id = input.toInt()
    if (id != null) {
        delete(id)
    } else {
        println("Entrada no valida. Introduix un numero válid.")
        println("")
    }
}

fun loopNumbers(number: Int) {
    when (number) {
        0 -> {
            exitProcess(0)
        }
        1 -> {
            create()
            showMenu()
        }
        2 -> {
            select()
            showMenu()
        }
        3 -> {
            readUpdateData()
            showMenu()
        }
        4 -> {
            readInsertData()
            showMenu()
        }
        5 -> {
            readDeleteData()
            showMenu()
        }
        6 -> {
            deleteAll()
            showMenu()
        }
        else -> {
            println("Numero incorrecto")
            showMenu()
        }
    }
}