package ObjectClassAndItsMethods.task1Yandex;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Post {
    private String title; // заголовок
    private String content; // содержание
    private String[] tags; // теги
    private ArrayList<PostComment> comments; //комментарии

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public void setComments(ArrayList<PostComment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName() + "{");
        sb.append("title='");
        sb.append((title == null) ? ("null'") : (title + "', ")    );
        sb.append("content.length='");
        sb.append((content.isEmpty()) ? ("null'") : (content.length() + "', ")     );
        sb.append("tags=");
        sb.append((tags == null) ? ("null") : Arrays.toString(tags) + ", ");
        sb.append("comments=");
        sb.append((comments == null) ? ("null") : comments);
        sb.append("}");
        return sb.toString();
    }

    //Alt + Ins -> "hashCode() and equals()"
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title) && Objects.equals(content, post.content) && Objects.deepEquals(tags, post.tags) && Objects.equals(comments, post.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, Arrays.hashCode(tags), comments);
    }
}