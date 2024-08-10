import java.util.HashMap;
import java.util.Map;

public class Banco {
    private String nome;
    private final Map<Cliente, Conta> listaContas = new HashMap<>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarCliente(Cliente cliente, Conta conta) {
        this.listaContas.put(cliente, conta);
    }

    public void imprimirClientes() {
        listaContas.forEach((cliente, conta) -> {
            System.out.println("Cliente: " + cliente + ", Conta: " );
            conta.imprimirDadosConta();
                }

        );
    }

    public void removerCliente(Cliente cliente) {
        if(!listaContas.isEmpty()) {
            listaContas.remove(cliente);
        }
    }
}
