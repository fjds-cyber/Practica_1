package Practica_3_2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Funtions {

    private static String pin;
    private static double balance_1 = 200.50;
    private static double balance_2 = 559.70;
    private static int condition = 0;

    private static final DecimalFormat form = new DecimalFormat("#.##");

    public void pin_entrance () {
        Funtions object_pin_entrance_0 = new Funtions();
        Scanner scan_pin_entrance_0 = new Scanner(System.in);

        System.out.println("Introduza o novo PIN de quatro digitos:");
        pin = scan_pin_entrance_0.nextLine();
        object_pin_entrance_0.pin_check();
    }

    public void pin_check () {
        Scanner scan_pin_check_0 = new Scanner(System.in);
        Funtions object_pin_check_0 = new Funtions();

        char zero = '0';
        char one = '1';
        char two = '2';
        char three = '3';
        char four = '4';
        char five = '5';
        char six = '6';
        char seven = '7';
        char eight = '8';
        char nine = '9';

        int wrong_chars = 0;

        // Verificar longitude do PIN.
        int pin_length = pin.length();

        if (pin_length != 4) {
            System.out.println("O PIN não contém quatro digitos.");
            object_pin_check_0.pin_entrance();
        }

        // Verificar que os digitos são números.
        for (int i = 0; i < pin.length(); i++) {
            char c = pin.charAt(i);
            if (c != zero && c != one && c != two && c != three
                    && c != four && c != five && c != six
                    && c != seven && c != eight && c != nine) {
                wrong_chars = wrong_chars + 1;
            }
        }

        if (wrong_chars > 0) {
            System.out.println("O PIN contém algum caracter que não é um número.");
            object_pin_check_0.pin_entrance();
        }

        //Digitar confirmação do PIN.
        else {
            System.out.println("Confirme PIN:");
            String pin_confirmation = scan_pin_check_0.nextLine();

            //Verificar que ambos têm a mesma longitude.
            int pin_confirmation_length = pin_confirmation.length();

            if (pin_length == pin_confirmation_length) {
                object_pin_check_0.pin_confirmation_0(pin_confirmation);
            }
            else {
                System.out.println("Os PINS não coincidem.");
                object_pin_check_0.pin_entrance();
            }
        }
    }

    public boolean pin_comparator (String b) {

        int original_length = pin.length();
        int confirmation_length = b.length();

        char[] pin_1 = new char[original_length];
        pin.getChars(0, original_length, pin_1, 0);

        char[] pin_c_1 = new char[confirmation_length];
        b.getChars(0, confirmation_length, pin_c_1, 0);

        return pin_1[0] == pin_c_1[0] && pin_1[1] == pin_c_1[1]
                && pin_1[2] == pin_c_1[2] && pin_1[3] == pin_c_1[3];
    }

    public void pin_confirmation_0 (String b) {
        Funtions object_pin_confirmation_1 = new Funtions();

        if (object_pin_confirmation_1.pin_comparator(b)) {
            System.out.println("PIN aceite.");
            object_pin_confirmation_1.action_select_account();
        }
        else {
            System.out.println("Os PINS não coincidem.");
            object_pin_confirmation_1.pin_entrance();
        }
    }

    public void action_select_account () {
        Scanner scan_action_select_account_0 = new Scanner(System.in);
        Funtions object_action_select_account_0 = new Funtions();

        System.out.println("""
                Escolha a conta que pretende accesar:
                                
                1. PT50 ************* 4567833.
                2. PT50 ************* 3456789.
                                
                0. Saiba qual conta contém mais dinheiro.""");

        condition = scan_action_select_account_0.nextInt();

        if (condition == 1) {
            System.out.println("Conta seleccionada: PT50 ************* 4567833.");
            object_action_select_account_0.action_select_operation();
        }
        else if (condition == 2) {
            System.out.println("Conta seleccionada: PT50 ************* 3456789.");
            object_action_select_account_0.action_select_operation();
        } else {
            object_action_select_account_0.compare_account_balance();
        }
    }

    public void action_select_operation () {
        Funtions object_select_operation_0 = new Funtions();
        Scanner scan_select_operation_0 = new Scanner(System.in);

        System.out.println("""
                       
                Escolha o que deseja fazer:
                                
                1. Ver IBAN.
                2. Consultar saldo.
                3. Depositar dinheiro.
                4. Retirar dinheiro.
                0. Escolher outra conta.""");
        int condition_1 = scan_select_operation_0.nextInt();

        switch (condition_1) {
            case 1:
                object_select_operation_0.action_account_0_see_iban();
            case 2:
                object_select_operation_0.action_account_check_balance();
            case 3:
                object_select_operation_0.action_account_0_deposit();
            case 4:
                object_select_operation_0.action_account_0_withdraw();
            case 0:
                object_select_operation_0.action_select_account();
        }

    }

    public void compare_account_balance () {
        Funtions object_compare_account_balance_0 = new Funtions();
        Scanner scan_compare_account_balance = new Scanner(System.in);

        int condition_2;
        int condition_3;

        if (balance_1 > balance_2) {
            System.out.println("""
            A conta PT50 ************* 4567833 contém mais dinheiro.
            
            Escolha o que fazer a seguir:
            
            1. Seleccionar uma conta.
            2. Finalizar operação.""");

            condition_2 = scan_compare_account_balance.nextInt();

            if (condition_2 == 1) {
                object_compare_account_balance_0.action_select_account();
            }
            else if (condition_2 == 0) {
                System.exit(0);
            }

        }

        else {
            System.out.println("""
                    A conta PT50 ************* 3456789 contém mais dinheiro.
                    
                    Escolha o que fazer a seguir:
                    
                    1. Seleccionar uma conta.
                    2. Finalizar operação.""");

            condition_3 = scan_compare_account_balance.nextInt();

            if (condition_3 == 1) {
                object_compare_account_balance_0.action_select_account();
            }
            else if (condition_3 == 0) {
                System.exit(0);
            }
        }

    }

    public void action_account_0_see_iban () {
        Scanner scan_action_account_0_see_iban = new Scanner(System.in);
        Funtions object_action_account_0_see_iban = new Funtions();

        String iban_1 = "PT50002700000001234567833.";
        String iban_2 = "PT50005000997603123456789.";

        System.out.println("Introduza o PIN:");
        String pin_confirmation_iban = scan_action_account_0_see_iban.nextLine();

        switch (condition) {
            case 1:
                if (object_action_account_0_see_iban.pin_comparator(pin_confirmation_iban)) {
                    System.out.println("O IBAN é " + iban_1);
                    object_action_account_0_see_iban.other_operations_account_0();
                }
                else {
                    System.out.println("Os PINS não coincidem.");
                    object_action_account_0_see_iban.action_account_0_see_iban();
                }
            break;

            case 2:
                if (object_action_account_0_see_iban.pin_comparator(pin_confirmation_iban)) {
                    System.out.println("O IBAN é " + iban_2);
                    object_action_account_0_see_iban.other_operations_account_0();
                }
                else {
                    System.out.println("Os PINS não coincidem.");
                    object_action_account_0_see_iban.action_account_0_see_iban();
                }
            break;
        }
    }

    public void action_account_0_deposit () {
        Funtions object_action_account_0_deposit = new Funtions();
        Scanner scan_action_account_0_deposit = new Scanner(System.in);

        System.out.println("Insira a quantidade de dinheiro a depositar:");
        double deposit_amount_1 = scan_action_account_0_deposit.nextDouble();

        switch (condition) {
            case 1 -> {
                balance_1 = balance_1 + deposit_amount_1;
                System.out.println("Agora o saldo é " + balance_1);
                object_action_account_0_deposit.other_operations_account_0();
            }
            case 2 -> {
                balance_2 = balance_2 + deposit_amount_1;
                System.out.println("Agora o saldo é " + balance_2);
                object_action_account_0_deposit.other_operations_account_0();
            }
        }
    }

    public void action_account_0_withdraw () {
        Scanner action_account_0_withdraw = new Scanner(System.in);
        Funtions object_account_0_withdraw = new Funtions();

        System.out.println("Introduza o PIN:");
        String pin_confirmation_withdraw = action_account_0_withdraw.nextLine();

        if (object_account_0_withdraw.pin_comparator(pin_confirmation_withdraw)) {
            object_account_0_withdraw.action_account_1_withdraw();
        }
        else {
            System.out.println("Os PINS não coincidem.");
            object_account_0_withdraw.action_account_0_withdraw();
        }
    }

    public void action_account_1_withdraw () {
        Scanner scan_action_account_1_withdraw_0 = new Scanner(System.in);
        Funtions object_action_account_1_withdraw = new Funtions();

        double withdraw_value_1 = 20;
        double withdraw_value_2 = 50;
        double withdraw_value_3 = 100;
        double withdraw_another_value;

        System.out.println("""
                           Escolha a quantidade que deseja retirar:
                           
                           1. 20 €.
                           2. 50 €.
                           3. 100 €.
                           4. Outra quantidade.
                           """);
        int withdraw_value = scan_action_account_1_withdraw_0.nextInt();


        switch (condition) {
            case 1:
                if (withdraw_value_1 > balance_1 || withdraw_value_2 > balance_1
                        || withdraw_value_3 > balance_1) {
                    System.out.println("Saldo insuficiente.");
                    object_action_account_1_withdraw.other_operations_account_0();
                }
                else if (withdraw_value == 1) {
                    balance_1 = balance_1 - withdraw_value_1;
                    System.out.println("Não esqueça retirar as notas.\nAgora o seu saldo é: "
                            + form.format((balance_1)) + " €.");
                    object_action_account_1_withdraw.other_operations_account_0();
                }
                else if (withdraw_value == 2) {
                    balance_1 = balance_1 - withdraw_value_2;
                    System.out.println("Não esqueça retirar as notas.\nAgora o seu saldo é "
                                + form.format((balance_1)) + " €.");
                        object_action_account_1_withdraw.other_operations_account_0();
                }
                else if (withdraw_value == 3) {
                    balance_1 = balance_1 - withdraw_value_3;
                    System.out.println("Não esqueça retirar as notas.\nAgora o seu saldo é "
                            + form.format((balance_1)) + " €.");
                    object_action_account_1_withdraw.other_operations_account_0();
                }
                else if (withdraw_value == 4) {
                    System.out.println("Insira a quantida de dinheiro a retirar:");
                    withdraw_another_value = scan_action_account_1_withdraw_0.nextDouble();
                    if (withdraw_another_value > balance_1) {
                        System.out.println("Saldo insuficiente.");
                        object_action_account_1_withdraw.other_operations_account_0();
                    }
                    else {
                        balance_1 = balance_1 - withdraw_another_value;
                        System.out.println("Não esqueça retirar as notas.\nAgora o seu saldo é "
                                + form.format(balance_1) + " €.");
                        object_action_account_1_withdraw.other_operations_account_0();
                    }


            }
                break;

            case 2:
                if (withdraw_value_1 > balance_2 || withdraw_value_2 > balance_2
                        || withdraw_value_3 > balance_2) {
                    System.out.println("Saldo insuficiente.");
                    object_action_account_1_withdraw.other_operations_account_0();
                }
                else if (withdraw_value == 1) {
                    balance_2 = balance_2 - withdraw_value_1;
                    System.out.println("Não esqueça retirar as notas.\nAgora o seu saldo é "
                            + form.format((balance_2)) + " €.");
                    object_action_account_1_withdraw.other_operations_account_0();
                }
                else if (withdraw_value == 2) {
                    balance_2 = balance_2 - withdraw_value_2;
                    System.out.println("Não esqueça retirar as notas.\nAgora o seu saldo é "
                            + form.format((balance_2)) + " €.");
                    object_action_account_1_withdraw.other_operations_account_0();
                }
                else if (withdraw_value == 3) {
                    balance_2 = balance_2 - withdraw_value_3;
                    System.out.println("Não esqueça retirar as notas.\nAgora o seu saldo é "
                            + form.format((balance_2)) + " €.");
                    object_action_account_1_withdraw.other_operations_account_0();
                }
                else if (withdraw_value == 4) {
                    System.out.println("Insira a quantida de dinheiro a retirar:");
                    withdraw_another_value = scan_action_account_1_withdraw_0.nextDouble();
                    if (withdraw_another_value > balance_2) {
                        System.out.println("Saldo insuficiente.");
                        object_action_account_1_withdraw.other_operations_account_0();
                    }
                    else {
                        balance_2 = balance_2 - withdraw_another_value;
                        System.out.println("Não esqueça retirar as notas.\nAgora o seu saldo é "
                                + form.format(balance_2) + " €.");
                        object_action_account_1_withdraw.other_operations_account_0();
                    }
                }
                break;
        }
    }

    public void action_account_check_balance () {
        Funtions object_action_account_0_check_balance = new Funtions();

        switch (condition) {
            case 1 -> {
                System.out.println("O seu saldo atual é " + form.format(balance_1) + " €.");
                object_action_account_0_check_balance.other_operations_account_0();
            }
            case 2 -> {
                System.out.println("O seu saldo atual é " + form.format(balance_2) + " €.");
                object_action_account_0_check_balance.other_operations_account_0();
            }
        }
    }

    public void other_operations_account_0 () {
        Funtions object_other_operations_account_0 = new Funtions();
        Scanner scan_other_operations_account_0 = new Scanner(System.in);

        System.out.println("""
                
                Escolha o que deseja fazer a seguir:
                
                1. Outras operações nesta conta.
                2. Selecionar outra conta.
                0. Finalizar operação.""");

        int condition_2 = scan_other_operations_account_0.nextInt();

        switch (condition_2) {
            case 1:
                object_other_operations_account_0.action_select_operation();
            case 2:
                object_other_operations_account_0.action_select_account();
            case 0:
                System.exit(0);
        }
    }
}
