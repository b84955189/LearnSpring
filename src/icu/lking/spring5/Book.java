package icu.lking.spring5;

/**
 * DI（Dependency Injection）依赖注入测试
 * 注入方式归纳
 */
public class Book {
    private String bookName;
    private String author;
    public Book(){

    }
    // 方式二：有参构造方法注入
    public Book(String bookName, String author){
        this.bookName = bookName;
        this.author = author;
    }
    // 方式一：set方法注入
    public void setBookName(String bookName){
        this.bookName = bookName;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    /**
     * 重写toString方法，用于显示属性
     * @return
     */
    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
