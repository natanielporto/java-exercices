import telefone.Telefone;

public class App {
    public static void main(String[] args) throws Exception {
        Telefone iPhone = new Telefone();

        iPhone.tocar();
        iPhone.pausar();
        iPhone.selecionarMusica("YYZ");

        iPhone.ligar("1324144412");
        iPhone.atender();
        iPhone.iniciarCorreioVoz();

        iPhone.exibirPagina("www.google.com");
        iPhone.adicionarNovaAba();
        iPhone.atualizarPagina();
    }
}
