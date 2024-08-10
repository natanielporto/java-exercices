//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("Teste");
        Cliente nataniel = new Cliente("Nataniel");

        Conta cc = new ContaCorrente(nataniel);
        cc.depositar(100);

        banco.adicionarCliente(nataniel, cc);
        banco.imprimirClientes();

        Conta poupanca = new ContaPoupanca(nataniel);
        cc.transferir(100, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}