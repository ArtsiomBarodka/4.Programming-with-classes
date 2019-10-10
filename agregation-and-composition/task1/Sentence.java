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

import java.util.ArrayList;
import java.util.Objects;

public class Sentence {

    private ArrayList<Word> words;

    public Sentence() {
        words = new ArrayList<>();
    }

    public Sentence(ArrayList<Word> words) {
        this.words = words;
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public void setWords(ArrayList<Word> words) {
        this.words.addAll(words);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Word w : words) {
            result.append(w.toString()).append(" ");
        }
        result.deleteCharAt(result.lastIndexOf(" "));
        result.append(". ");
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (Word w:words) {
            s1.append(w);
        }
        for (Word w:sentence.words) {
            s2.append(w);
        }

        return s1.toString().equals(s2.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(words);
    }
}
