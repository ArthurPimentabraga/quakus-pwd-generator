package dto;

import lombok.Data;

@Data
public class PwdInfosDTO {

    private int numberOfCharacters;
    private boolean uppercase;
    private boolean lowercase;
    private boolean numbers;
    private boolean symbols;

    public PwdInfosDTO(int numberOfCharacters, boolean uppercase, boolean lowercase, boolean numbers, boolean symbols) {
        this.numberOfCharacters = numberOfCharacters;
        this.uppercase = uppercase;
        this.lowercase = lowercase;
        this.numbers = numbers;
        this.symbols = symbols;
    }
}