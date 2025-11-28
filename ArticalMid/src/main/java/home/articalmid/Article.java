package home.articalmid;

import java.time.LocalDate;

public class Article {
    private String title, author, articleType;
    private LocalDate publicationDate;

    public Article(String title, String author, String articleType, LocalDate publicationDate) {
        this.title = title;
        this.author = author;
        this.articleType = articleType;
        this.publicationDate = publicationDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }
    // only year ar jono
    public int getPublicationYear () {

        return this.publicationDate.getYear(); // some change
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", articleType='" + articleType + '\'' +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
