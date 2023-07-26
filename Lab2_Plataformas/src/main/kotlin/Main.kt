
fun main() {
    // Lista precargada de perfiles
    val listaPerfiles = mutableListOf(
        PerfilUsuario(
            1,
            "Juan",
            "Pérez",
            "https://example.com/juan.jpg",
            30,
            "juan@elpro.com",
            "Amante de la naturaleza",
            "Activo"
        ),
        PerfilUsuario(
            2,
            "María",
            "DelosAngeles",
            null,
            25,
            "maria@gmail.com",
            null,
            "Pendiente"
        )

    )

    var option: Int

    do {
        println("MENU:")
        println("1. Crear perfil")
        println("2. Buscar perfil de usuario(s)")
        println("3. Eliminar perfil")
        println("4. Agregar Hobby")
        println("0. Salir")

        print("Ingrese la opción deseada: ")
        option = readLine()?.toIntOrNull() ?: 0

        when (option) {
            1 -> {
                // Crear perfil
                val nuevoPerfil = crearPerfilDesdeConsola()
                listaPerfiles.add(nuevoPerfil)
                println("Perfil creado exitosamente.")
            }
            2 -> {
                // Buscar perfil de usuario(s)
                println("ingrese el numero de id:")
                buscarPerfilDesdeConsola(listaPerfiles)
            }
            3 -> {
                // Eliminar perfil
                eliminarPerfilDesdeConsola(listaPerfiles)
            }
            4 -> {
                // Agregar Hobby
                agregarHobbyDesdeConsola(listaPerfiles)
            }
            0 -> println("Hasta luego.")
            else -> println("Opción inválida. Inténtelo nuevamente.")
        }

        println()
    } while (option != 0)
}

fun crearPerfilDesdeConsola(): PerfilUsuario {



    return PerfilUsuario(
        ID = 3,
        nombres = "Jose",
        apellidos = "Juarez",
        urlPhoto = "https://scontent.jpg",
        edad = 28,
        correo = "josejj@gmail.com",
        biografía = "perro jugador ",
        estado = "Activo"
    )
}

fun buscarPerfilDesdeConsola(listaPerfiles: List<PerfilUsuario>) {

    val idBusquedaStr = readLine()
    val idBusqueda = idBusquedaStr?.toIntOrNull()

    if (idBusqueda == null) {
        println("Entrada inválida. Debe ingresar un número de ID válido.")
        return
    }

    val perfilEncontrado = listaPerfiles.find { it.ID == idBusqueda }

    if (perfilEncontrado != null) {
        println("Perfil encontrado:")
        mostrarInformacionPerfil(perfilEncontrado)
    } else {
        println("Perfil no encontrado.")
    }
}


fun eliminarPerfilDesdeConsola(listaPerfiles: MutableList<PerfilUsuario>) {

    val idEliminacion = 2
    val perfilEliminado = listaPerfiles.removeAll { it.ID == idEliminacion }

    if (perfilEliminado) {
        println("Perfil eliminado exitosamente.")
    } else {
        println("No se encontró un perfil con el ID proporcionado.")
    }
}

fun agregarHobbyDesdeConsola(listaPerfiles: MutableList<PerfilUsuario>) {
    // Código para buscar un perfil por ID o nombres

    //  búsqueda y agregación por ID
    val idBusqueda = 1
    val perfilEncontrado = listaPerfiles.find { it.ID == idBusqueda }

    if (perfilEncontrado != null) {
        val nuevoHobby = Hobby("Cocina", "Disfruto preparando platillos deliciosos", null)
        perfilEncontrado.agregarHobby(nuevoHobby)
        println("Hobby agregado exitosamente.")
    } else {
        println("Perfil no encontrado.")
    }
}

fun mostrarInformacionPerfil(perfil: PerfilUsuario) {
    // Código para mostrar la información del perfil ya con sus hobbies
    println("ID: ${perfil.ID}")
    println("Nombres: ${perfil.nombres}")
    println("Apellidos: ${perfil.apellidos}")
    println("URL de foto de perfil: ${perfil.urlPhoto ?: "N/A"}")
    println("Edad: ${perfil.edad}")
    println("Correo: ${perfil.correo}")
    println("Biografía: ${perfil.biografía ?: "N/A"}")
    println("Estado: ${perfil.estado}")

    if (perfil.hobbies.isNotEmpty()) {
        println("Hobbies:")
        for (hobby in perfil.hobbies) {
            println("- Título: ${hobby.título}")
            println("  Descripción: ${hobby.descripción}")
            println("  URL de foto asociada: ${hobby.urlPhoto ?: "N/A"}")
        }
    } else {
        println("No se encontraron hobbies para este perfil.")
    }
}
