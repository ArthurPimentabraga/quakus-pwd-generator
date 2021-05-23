package src.service;

import dto.PwdInfosDTO;
import lombok.extern.java.Log;

import javax.enterprise.context.ApplicationScoped;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Log
@ApplicationScoped
public class GeneratorService {

    private static final String uAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String lAlphabet = "abcdefghijklmnopqrstuvwxyz";
    private static final String sNumbers = "1234567890";
    private static final String sSymbols = "!@#$%&*+_-<>";
    private final Random r = new Random();
    private final Random r2 = new Random();

    public String generator(PwdInfosDTO dto) {
        try {
            int num;
            String password = "";

            char[] pwd = new char[dto.getNumberOfCharacters()];
            Integer[] local = new Integer[dto.getNumberOfCharacters()];

            int varRandom;
            int count = 0;
            while (count < dto.getNumberOfCharacters()){
                if (count < dto.getNumberOfCharacters())
                {
                    if (dto.isUppercase())
                    {
                        varRandom = r2.nextInt(dto.getNumberOfCharacters());

                        List<Integer> list = Arrays.asList(local);
                        while (list.contains(varRandom)){
                            varRandom = r2.nextInt(dto.getNumberOfCharacters());
                        }

                        num = r.nextInt(uAlphabet.length());
                        pwd[varRandom] = uAlphabet.charAt(num);
                        local[count] = varRandom;
                        count++;
                    }
                }
                if (count < dto.getNumberOfCharacters())
                {
                    if (dto.isLowercase())
                    {
                        varRandom = r2.nextInt(dto.getNumberOfCharacters());

                        List<Integer> list = Arrays.asList(local);
                        while (list.contains(varRandom)){
                            varRandom = r2.nextInt(dto.getNumberOfCharacters());
                        }

                        num = r.nextInt(lAlphabet.length());
                        pwd[varRandom] = lAlphabet.charAt(num);
                        local[count] = varRandom;
                        count++;
                    }
                }
                if (count < dto.getNumberOfCharacters())
                {
                    if (dto.isNumbers())
                    {
                        varRandom = r2.nextInt(dto.getNumberOfCharacters());

                        List<Integer> list = Arrays.asList(local);
                        while (list.contains(varRandom)){
                            varRandom = r2.nextInt(dto.getNumberOfCharacters());
                        }

                        num = r.nextInt(sNumbers.length());
                        pwd[varRandom] = sNumbers.charAt(num);
                        local[count] = varRandom;
                        count++;
                    }
                }
                if (count < dto.getNumberOfCharacters())
                {
                    if (dto.isSymbols())
                    {
                        varRandom = r2.nextInt(dto.getNumberOfCharacters());

                        List<Integer> list = Arrays.asList(local);
                        while (list.contains(varRandom)){
                            varRandom = r2.nextInt(dto.getNumberOfCharacters());
                        }

                        num = r.nextInt(sSymbols.length());
                        pwd[varRandom] = sSymbols.charAt(num);
                        local[count] = varRandom;
                        count++;
                    }
                }
            }

            for (int i=0; i < pwd.length; i++){
                password += pwd[i];
            }

            return password;
        } catch (Exception ex) {
            log.severe(ex.getMessage());
            return "";
        }
    }

}

