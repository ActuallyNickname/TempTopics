package ObjectClassAndItsMethods.task1Yandex;

import java.util.Arrays;
import java.util.Objects;

public class PostComment {
    private String text; // содержание комментария
    private String[] whoLiked; // кто поддержал


    public void setText(String text) {
        this.text = text;
    }

    public void setWhoLiked(String[] whoLiked) {
        this.whoLiked = whoLiked;
    }

    //Alt + Ins -> "hashCode() and equals()"
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostComment anotherPostCommentObj = (PostComment) o;
        return Objects.equals(text, anotherPostCommentObj.text)
                && Objects.deepEquals(whoLiked, anotherPostCommentObj.whoLiked);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, Arrays.hashCode(whoLiked));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName() + "{");
        sb.append("text='");
        sb.append((text == null) ? ("null'") : (text + "', ")    );
        sb.append("whoLiked=");
        sb.append((whoLiked == null) ? ("null") : Arrays.toString(whoLiked));
        sb.append("}");
        return sb.toString();
    }
}