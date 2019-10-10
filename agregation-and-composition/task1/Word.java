/*
 * 4.Simple Classes
 * Task 1
 *
 * Создать объект класса Текст, используя классы Предложение,
 * Слово. Методы: дополнить текст, вывести на консоль текст, заголовок текста.
 *
 * Artsiom Barodka
 *
 */
package programming_with_classes.agregation_and_composition.Task1;

import java.util.Objects;

public class Word {

    private String word;

    public Word() {
        word = "";
    }

    public Word(String word) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if(!Character.isWhitespace(word.charAt(i))){
                s.append(word.charAt(i));
            }
        }
        this.word = s.toString();
    }


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if(!Character.isWhitespace(word.charAt(i))){
                s.append(word.charAt(i));
            }
        }
        this.word = s.toString();
    }

    @Override
    public String toString() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return word.equals(word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }
}
