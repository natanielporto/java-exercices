import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Java");
        curso1.setDescricao("Curso de Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("JavaScript");
        curso2.setDescricao("Curso de JavaScript");
        curso2.setCargaHoraria(12);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descrição da mentoria");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        System.out.println(devCamila.getConteudosInscritos());
        devCamila.inscreverBootcamp(bootcamp);
        devCamila.progredir();
        System.out.println(devCamila.getConteudosInscritos());
        System.out.println(devCamila.getConteudosConcluidos());
        System.out.println(devCamila.calcularTotalXp());

        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        System.out.println(devJoao.getConteudosInscritos());
        devJoao.inscreverBootcamp(bootcamp);
        devJoao.progredir();
        System.out.println(devJoao.getConteudosInscritos());
        System.out.println(devJoao.getConteudosConcluidos());
        System.out.println(devJoao.calcularTotalXp());
    }
}