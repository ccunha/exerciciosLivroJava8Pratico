package br.com.caelum.exercicioJavaPratico.capitulos;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Capitulo2 {

    public static void main(String ... args){
        Usuario user1 = new Usuario("Carolina Cunha", 150);
        Usuario user2 = new Usuario("Diego Palma", 120);
        Usuario user3 = new Usuario("Pedro Silva", 190);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        //Jeito antigo de fazer
        for(Usuario u: usuarios){
            System.out.println(u.getNome());
        }

        System.out.println("===========================");

        //Sem classe anônima
        Mostrador mostrador = new Mostrador();
        usuarios.forEach(mostrador);

        System.out.println("===========================");

        //Com classe anônima
        Consumer<Usuario> mostradorAnonimo = new Consumer<Usuario>() {
            @Override
            public void accept(Usuario usuario) {
                System.out.println(usuario.getNome());
            }
        };
        usuarios.forEach(mostradorAnonimo);

        System.out.println("===========================");

        //Diminuindo um pouco:
        usuarios.forEach(new Consumer<Usuario>() {
            @Override
            public void accept(Usuario usuario) {
                System.out.println(usuario.getNome());
            }
        });

        Consumer<Usuario> mostradorLambda1 = (Usuario u) -> {System.out.println(u.getNome());};
        Consumer<Usuario> mostradorLambda2 = u -> System.out.println(u.getNome());
        System.out.println("===========================");
        System.out.println("FINALMENTE O PRIMEIRO EXEMPLO COM LAMBDA:");
        usuarios.forEach(u->System.out.println(u.getNome()));
    }

}
