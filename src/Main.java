import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random=new Random();
        Scanner scanner=new Scanner(System.in);
        Charmander charmander=new Charmander();
        Salandit salandit=new Salandit();
        Moltres moltres=new Moltres();

        Pichu pikachu=new Pichu();
        Blitzle blitzle=new Blitzle();
        Electabuzz electabuzz=new Electabuzz();

        Pokemon [] arrayPokemon={charmander,salandit,moltres,pikachu,blitzle,electabuzz};
        int pokemon1=random.nextInt(0,5);
        int pokemon2=random.nextInt(0,5);
        Pokemon pokemonUser1=arrayPokemon[pokemon1];
        Pokemon pokemonUser2=arrayPokemon[pokemon1];

        System.out.println("Welcome to the Pokemon game");
        System.out.println("First player, your Pokemon:");
        System.out.println( arrayPokemon[pokemon1] +"\n");
        System.out.println("Second player, your Pokemon:");
        System.out.println( arrayPokemon[pokemon2]+"\n");
        boolean checkTurn1=false;
        boolean checkEndGame=false;
        do {
            do {
                System.out.println("First player, your turn, choose the option you prefer" + "\n" + "1.Making an attack." + "\n" + "2.Waiting." + "\n" + "3.Evolution." + "\n" + "4.Special action.");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        int attackPoint = pokemonUser1.attack();
                        if (attackPoint == -1) {
                            checkTurn1 = false;
                        } else {
                            pokemonUser2.downHp(attackPoint);
                            checkTurn1 = true;
                        }
                    }
                    case 2 -> {
                        pokemonUser1.waiting();
                        checkTurn1 = true;
                    }
                    case 3 -> {
                        checkTurn1 = pokemonUser1.levelUp();
                    }
                    case 4 -> {
                        checkTurn1 = pokemonUser1.specialAction(pokemonUser2);
                    }
                }
            } while (!checkTurn1);
            pokemonUser1.newTurn();
            checkEndGame = checkWinner(pokemonUser1, pokemonUser2);
            System.out.println("First player, your Pokemon:");
            System.out.println( arrayPokemon[pokemon1] +"\n");
            System.out.println("Second player, your Pokemon:");
            System.out.println( arrayPokemon[pokemon2]+"\n");
            if (!checkEndGame) {
                boolean checkTurn2 = false;
                do {
                    System.out.println("Second player, your turn, choose the option you prefer" + "\n" + "1.Making an attack." + "\n" + "2.Waiting." + "\n" + "3.Evolution." + "\n" + "4.Special action.");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1 -> {
                            int attackPoint = pokemonUser2.attack();
                            if (attackPoint == -1) {
                                checkTurn2 = false;
                            } else {
                                pokemonUser1.downHp(attackPoint);
                                checkTurn2 = true;
                            }
                        }
                        case 2 -> {
                            pokemonUser2.waiting();
                            checkTurn2 = true;
                        }
                        case 3 -> {
                            checkTurn2 = pokemonUser2.levelUp();
                        }
                        case 4 -> {
                            checkTurn2 = pokemonUser2.specialAction(pokemonUser2);
                        }
                    }
                } while (!checkTurn2);
                pokemonUser2.newTurn();
                checkEndGame = checkWinner(pokemonUser1, pokemonUser2);
                System.out.println("First player, your Pokemon:");
                System.out.println( arrayPokemon[pokemon1] +"\n");
                System.out.println("Second player, your Pokemon:");
                System.out.println( arrayPokemon[pokemon2]+"\n");
            }


        }while (!checkEndGame);
    }

    public static boolean checkWinner(Pokemon pokemomUser1, Pokemon pokemomUser2){
        boolean check=false;
        if (pokemomUser1.getHp()<=0 && pokemomUser2.getHp()>0){
            System.out.println("The winner in battle is Second player");
            check=true;
        } else if( pokemomUser2.getHp()<=0 && pokemomUser1.getHp()>0){
            System.out.println("The winner in battle is First player");
            check=true;
        }else if(pokemomUser2.getHp()<=0 && pokemomUser1.getHp()<=0){
            System.out.println("The battle ended in a draw");
            check=true;
        }
        return check;

    }
}