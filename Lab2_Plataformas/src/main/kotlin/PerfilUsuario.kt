class PerfilUsuario(
    val ID: Int,
    val nombres: String,
    val apellidos: String,
    val urlPhoto: String?,
    val edad: Int,
    val correo: String,
    val biografía: String?,
    var estado: String,
    val hobbies: MutableList<Hobby> = mutableListOf()
) {
    fun agregarHobby(hobby: Hobby) {
        hobbies.add(hobby)
    }
}