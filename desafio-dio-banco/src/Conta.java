public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 0001;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if(this.saldo < valor) {
            System.out.println("Saldo insuficiente para saque.");
        } else {
            this.saldo -= valor;
        }
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(this.saldo < valor) {
            System.out.println("Saldo insuficiente para transferencia.");
        } else {
            this.sacar(valor);
            contaDestino.depositar(valor);
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.printf("Titular: %s", this.cliente.getNome());
        System.out.printf("Agencia: %d", this.agencia);
        System.out.printf("Numero: %d%n", this.numero);
        System.out.printf("Saldo: %.2f%n", this.saldo);
    }

    protected void apagarConta(int numero, Cliente cliente) {

    }

    public void imprimirDadosConta() {
        System.out.printf("Titular: %s", this.cliente.getNome());
        System.out.printf("Agencia: %d", this.agencia);
        System.out.printf("Numero: %d%n", this.numero);
    }
}
