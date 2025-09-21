package org.example;

/*
2. Búsqueda de carácteres

Haz un programa que dado un fichero y un carácter cuente el número de ocurrencias de ese carácter en el fichero. Variante: dado un fichero encuentre el carácter más usado.
 */

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe una letra y un archivo separado por espacio: ");
        String comando = sc.nextLine();
        String[] comandos = comando.split(" ");

        if (comandos.length == 2) {
            characterSearch(comandos[0].charAt(0), Path.of(comandos[1]) );
        } else if (comandos.length == 1) {
            maxCharacter(Path.of(comandos[0]));
        } else  {
            System.out.print("Comando invalido");
        }
    }


    static void characterSearch(Character character,Path file) throws IOException {
        int cantidad = 0;
        String fileString = Files.readString(file);

        for (Character c : fileString.toCharArray()) {
            if (c.equals(character)) {
                cantidad++;
            }
        }
        System.out.print("El carácter " + character + " aparece " + cantidad + " veces.");

    }

    static void maxCharacter(Path file) throws IOException {
        int count = 0;
        HashMap<Character, Integer> mapCharCount = new HashMap<>();
        String fileString = Files.readString(file);
        for (Character c : fileString.toCharArray()) {
            for (Character character : fileString.toCharArray()) {
                if (c.equals(character)) {
                    count++;
                }
            }
        mapCharCount.put(c, mapCharCount.getOrDefault(c, 0) + count);

        }
        searchMaxCharacter(mapCharCount);
    }


    static void searchMaxCharacter(HashMap<Character, Integer> map) throws IOException {
        Character maxLetter = null;
        int maxCount = 0;
        for (Map.Entry<Character, Integer> chars : map.entrySet()) {
            if (chars.getValue() > maxCount) {
                maxLetter = chars.getKey();
                maxCount = chars.getValue();
            }
        }
        System.out.print("La letra más repetida es la " + maxLetter);

    }




}