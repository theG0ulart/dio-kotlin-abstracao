enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome")
    }
}

fun main() {
    // Criando conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Kotlin Básico")
    val conteudo2 = ConteudoEducacional("Kotlin Intermediário", 90)
    val conteudo3 = ConteudoEducacional("Kotlin Avançado", 120)

    // Criando formações
    val formacao1 = Formacao("Formação Kotlin Developer", listOf(conteudo1, conteudo2, conteudo3))

    // Criando usuários
    val usuario1 = Usuario("Alice")
    val usuario2 = Usuario("Bob")

    // Matriculando usuários
    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)

    // Listando os inscritos na formação
    println("Inscritos na formação ${formacao1.nome}:")
    formacao1.inscritos.forEach { println(it.nome) }
}
