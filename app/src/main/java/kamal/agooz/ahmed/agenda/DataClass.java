package kamal.agooz.ahmed.agenda;

public class DataClass {
    String book_title,author_name,image_url,publisher,description,date;

    public DataClass(String book_title, String author_name, String image_url, String publisher, String description, String date) {
        this.book_title = book_title;
        this.author_name = author_name;
        this.image_url = image_url;
        this.publisher = publisher;
        this.description = description;
        this.date = date;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}