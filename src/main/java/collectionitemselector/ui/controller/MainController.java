package collectionitemselector.ui.controller;

import java.net.URL;
import java.util.ResourceBundle;

import collectionitemselector.AbstractCollectionItemSelector;
import collectionitemselector.CollectionItemSelectorListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController implements Initializable, CollectionItemSelectorListener {
	@FXML
	private Label listSummaryLabel;
	
	@FXML
	private TextField itemIndexTextField;
	
	private AbstractCollectionItemSelector collectionItemSelector;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		itemIndexTextField.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (!newValue) {
					itemIndexTextField.setText(String.valueOf(collectionItemSelector.getCurrentIndex()));
				}
			}
		});
		listSummaryLabel.setText("0/0");
	}
	
	public void setCollectionItemSelector(AbstractCollectionItemSelector collectionItemSelector) {
		this.collectionItemSelector = collectionItemSelector;
		collectionItemSelector.addCollectionItemSelectorListener(this);
	}
	
	public void selectIndex() {
		if (collectionItemSelector != null) {
			try {
				int index = Integer.parseInt(itemIndexTextField.getText());
				collectionItemSelector.setCurrentIndex(index);
			} catch (NumberFormatException e) {
				
			}	
		}
	}
	
	public void selectNext() {
		if (collectionItemSelector != null) {
			collectionItemSelector.setNextIndex();	
		}
	}
	
	public void selectPrevious() {
		if (collectionItemSelector != null) {
			collectionItemSelector.setPreviousIndex();	
		}
	}

	@Override
	public void currentIndexChanged() {
		// TODO Auto-generated method stub
		itemIndexTextField.setText(String.valueOf(collectionItemSelector.getCurrentIndex()));
		listSummaryLabel.setText(String.valueOf(collectionItemSelector.getCurrentIndex()) + "/" + collectionItemSelector.getListSize());
	}
}