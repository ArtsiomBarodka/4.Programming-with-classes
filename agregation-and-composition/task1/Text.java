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

public class Text {

    private ArrayList<Sentence> sentences;
    private Word header;

    public Text() {
        sentences = new ArrayList<>();
        header = new Word();
    }

    public Text(Sentence sentence) {
        sentences = new ArrayList<>();
        sentences.add(sentence);
        header = new Word();
    }

    public Text(ArrayList<Sentence> sentences) {
        this.sentences = sentences;
        header = new Word();
    }

    public Text(Word header) {
        sentences = new ArrayList<>();
        this.header = header;
    }

    public Text(ArrayList<Sentence> sentences, Word header) {
        this.sentences = sentences;
        this.header = header;
    }

    public ArrayList<Sentence> getSentences() {
        return sentences;
    }

    public Word getHeader() {
        return header;
    }

    public void setHeader(Word header) {
        this.header = header;
    }

    public void setSentences(ArrayList<Sentence> sentences) {
        this.sentences.addAll(sentences);
    }

    public void addSentence(Sentence sentence){
        sentences.add(sentence);
    }

    public void deleteSentence(Sentence sentence){
        sentences.remove(sentence);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(header.toString()).append("\n");
        for (Sentence s:sentences) {
            result.append(s.toString()).append("\n");
        }
        return result.toString();
    }
}
