import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {
        int numero;
        String agencia;
        String nomeCliente;
        double saldo;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número da conta");
        numero = scanner.nextInt();

        scanner.nextLine();

        System.out.println("Digite o número da agência");
        agencia = scanner.nextLine();

        System.out.println("Digite o nome do cliente");
        nomeCliente = scanner.nextLine();

        System.out.println("Digite o saldo");
        saldo = scanner.nextDouble();

        scanner.close();

        System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é "
                + agencia + ", conta " + numero + " e seu saldo " + saldo + " já está disponível para saque.");
    }
}
