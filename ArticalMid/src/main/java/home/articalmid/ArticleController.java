package home.articalmid;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class ArticleController
{
    @javafx.fxml.FXML
    private TextField titleTextField;
    @javafx.fxml.FXML
    private TableColumn <Article, String> typeCol;
    @javafx.fxml.FXML
    private TableColumn <Article, String> titleCol;
    @javafx.fxml.FXML
    private ComboBox <String> typeComboBox;
    @javafx.fxml.FXML
    private TableColumn <Article, Integer> yearCol;  // if full date thats time localDate but only year then Integer
    @javafx.fxml.FXML
    private TableView <Article>contentTable;
    @javafx.fxml.FXML
    private DatePicker datePickerField;
    @javafx.fxml.FXML
    private TextField authorTextField;
    @javafx.fxml.FXML
    private Label outputLabel;

    List<Article> articleList = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
    typeComboBox.getItems().addAll("Review", "Book", "Case");

    titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
    typeCol.setCellValueFactory(new PropertyValueFactory<>("articleType"));
    yearCol.setCellValueFactory(new PropertyValueFactory<>("publicationYear"));
    }

    @javafx.fxml.FXML
    public void addArticleOnClick(ActionEvent actionEvent) {
        String title = titleTextField.getText();
        String author = authorTextField.getText();
        String type = typeComboBox.getValue();
        LocalDate date = datePickerField.getValue();
        // blank validitation
        if(title.isBlank() || author.isBlank() || title == null || date == null) {
            outputLabel.setText("Please enter all information");
            return;
        }
        // date validutation
        if (date.isAfter(LocalDate.now())){
            outputLabel.setText("Date cannot in the future");
        }

        // filtering
        // filter based on 1 criterion
        // filter based on another criterion
        // filter based on bothe criterion

        // reset filter

        // aggregation like sum, min, max, average, count.



        Article article = new Article(title, author, type, date);
        articleList.add(article);
        contentTable.getItems().add(Article);
    }
}