package collectionitemselector;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class MainController implements Initializable, CollectionItemSelectorListener {
  @FXML
  private CollectionItemSelectorController explosivesItemSelectorController;
  
  @FXML
  private Label explosiveLabel;

  List<String> explosiveList = new ArrayList<>();
  ListItemSelector listItemSelector = new ListItemSelector(explosiveList);
  
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    explosiveList.add("Dynamite");
    explosiveList.add("TNT");
    explosiveList.add("Nuke");
    
    listItemSelector.addCollectionItemSelectorListener(this);
    explosivesItemSelectorController.setCollectionItemSelector(listItemSelector);
    
    listItemSelector.setCurrentIndex(1);
  }

  @Override
  public void currentIndexChanged() {
    explosiveLabel.setText(explosiveList.get(listItemSelector.getCurrentIndex() - 1));
  }
}
