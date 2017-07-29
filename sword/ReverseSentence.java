package sword;

/**
 * Created by cshuo on 2017/7/23
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class ReverseSentence {
    public String ReverseSentence(String str) {
        if(str.length() < 1) return str;
        String[] words = str.split("\\s+");
        if(words.length < 1) return str;
        StringBuilder sb = new StringBuilder();
        for(int i=words.length-1; i>-1; i--) {
            sb.append(words[i]);
            if(i != 0) sb.append(" ");
        }
        return sb.toString();
    }
}
